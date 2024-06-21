package jp.co.axiz.kanri.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.axiz.kanri.entity.Employee;
import jp.co.axiz.kanri.form.AdministratorUpdateEmpIdForm;
import jp.co.axiz.kanri.form.AdministratorUpdateForm;
import jp.co.axiz.kanri.service.EmployeeService;

/*
 * 管理者用社員情報更新用コントローラ
 */
@Controller
public class AdministratorUpdateController {
	/*
	 * messages_ja.propertiesのメッセージ取得用
	 */
	@Autowired
	MessageSource messageSource;

	/*
	 * セッション情報
	 */
	@Autowired
	HttpSession session;

	/*
	 * ユーザ情報サービス
	 */
	@Autowired
	private EmployeeService eService;

	/*
	 * 更新対象者検索画面表示
	 */
	@RequestMapping("/administratorInsertSelect")
	public String updatSelect(@ModelAttribute("administratorUpdateForm") AdministratorUpdateEmpIdForm form, Model model) {
		return "administratorInsertSelect";
	}

	/*
	 * 更新内容入力画面遷移 (更新画面の確認ボタン押下時)
	 */
	@RequestMapping(value = "/administratorUpdate", method = RequestMethod.POST)
	public String update(@Validated @ModelAttribute("administratorUpdateForm") AdministratorUpdateEmpIdForm form, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "administratorInsertSelect";
		}

		// 入力したEmpIDに紐づくユーザを検索
		Employee employee = eService.findByEmpId(form.getEmpId());

		if (employee == null) {
			// データが存在しない場合
			String errMsg = messageSource.getMessage("id.not.found.error", null, Locale.getDefault());
			model.addAttribute("errMsg", errMsg);
			return "administratorInsertSelect";
		}

		// ログインユーザの情報を取得
		Employee loginUser = (Employee) session.getAttribute("loginUser");


		if (form.getEmpId().equals(loginUser.getEmpId())) {
            // ログインユーザを指定した場合
            String errMsg = messageSource.getMessage("update.login.user", null, Locale.getDefault());
            model.addAttribute("errMsg", errMsg);
            return "administratorInsertSelect";
        }

//		//ログイン情報よりログイン者が対象者を編集可能か精査
//		Integer myPositionId = loginUser.getPositionId();
//		if (myPositionId < employee.getPositionId()) {
//			String errMsg = messageSource.getMessage("id.not.change.error", null, Locale.getDefault());
//			model.addAttribute("errMsg", errMsg);
//			return "administratorInsertSelect";
//		}
//
		session.setAttribute("employee", employee);

		return "administratorUpdate";
	}

	@RequestMapping(value = "/administratorUpdateResult", method = RequestMethod.POST)
	public String updateInput(@Validated @ModelAttribute("administratorUpdateForm") AdministratorUpdateForm form, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "administratorUpdate";
		}

		Employee employee = (Employee) session.getAttribute("employee");

		// Employオブジェクト生成
		Employee updateEmployee = new Employee();

		/*
		 * 入力した値を更新値としてセット
		 *
		 * 		empIdのみログインユーザから情報を取得
		 */
		updateEmployee.setEmpId(employee.getEmpId());
		updateEmployee.setEmpName(form.getEmpName());
		updateEmployee.setEmpKana(form.getEmpKana());
		updateEmployee.setLoginId(form.getLoginId());
		updateEmployee.setPass(form.getPass());
		updateEmployee.setRePass(form.getRePass());
		updateEmployee.setTel(form.getTel());
		updateEmployee.setMail(form.getMail());
		updateEmployee.setPostCode(form.getPostCode());
		updateEmployee.setAddress(form.getAddress());
		updateEmployee.setPositionId(form.getPositionId());

		if (updateEmployee.equals(employee)) {
			// 入力値を変更していない場合
			String errMsg = messageSource.getMessage("required.change", null, Locale.getDefault());
			model.addAttribute("errMsg", errMsg);
			return "administratorUpdate";
		}

		// ログインユーザの情報を取得
		Employee loginUser = (Employee) session.getAttribute("loginUser");

		//ログイン情報よりログイン者が対象者を編集可能か精査
		Integer myPositionId = loginUser.getPositionId();
		if (myPositionId < form.getPositionId()) {
			String errMsg = messageSource.getMessage("id.not.change.error", null, Locale.getDefault());
			model.addAttribute("errMsg", errMsg);
			return "administratorUpdate";
		}


		// ID重複チェック
		if (eService.existsUserByLoginIdExcludingEmpId(updateEmployee.getLoginId(), updateEmployee.getEmpId())) {
			// login_idが重複していた場合
			String errMsg = messageSource.getMessage("id.duplicate.error", null, Locale.getDefault());
			model.addAttribute("errMsg", errMsg);
			return "administratorUpdate";
		}

		// パスワードが一致しているかチェック
		if (!updateEmployee.getPass().equals(updateEmployee.getRePass())) {
			String errMsg = messageSource.getMessage("password.not.match.error", null, Locale.getDefault());
			model.addAttribute("errMsg", errMsg);

			form.setRePass("");

			return "administratorUpdate";
		}

		// 更新処理
		eService.empUpdate(updateEmployee);

		return "administratorUpdateResult";
	}

}
