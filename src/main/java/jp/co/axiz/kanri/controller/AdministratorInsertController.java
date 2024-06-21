package jp.co.axiz.kanri.controller;

import java.util.List;
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
import jp.co.axiz.kanri.entity.Gender;
import jp.co.axiz.kanri.entity.Position;
import jp.co.axiz.kanri.form.AdministratorInsertForm;
import jp.co.axiz.kanri.service.EmployeeService;
import jp.co.axiz.kanri.util.ParamUtil;

/*
 * 管理者用社員情報登録用コントローラ
 */

@Controller
public class AdministratorInsertController {

	@Autowired
	MessageSource messageSource;

	@Autowired
	HttpSession session;

	@Autowired
	private EmployeeService eService;

	// 登録画面表示
	@RequestMapping("/administratorInsert")
	public String insert(@ModelAttribute("AdministratorInsertForm") AdministratorInsertForm form, Model model) {
		return "administratorInsert";
	}

	// 登録結果画面表示
	@RequestMapping("/administratorInsertResult")
	public String insertResult(@ModelAttribute("AdministratorInsertForm") AdministratorInsertForm form, Model model) {
		return "administratorInsertResult";
	}

	/*
	* 登録処理
	*/
	@RequestMapping(value = "/administratorInsertResult", method = RequestMethod.POST)
	public String insertConfirm(@Validated @ModelAttribute("AdministratorInsertForm") AdministratorInsertForm form,
			BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "administratorInsert";
		}

		//ありえない誕生日入力をほどほどにはじく
		String str = form.getBirth();
		String strYYYY = str.substring(0, 4);
		int YYYY = Integer.parseInt(strYYYY);
		String strMM = str.substring(4, 6);
		int MM = Integer.parseInt(strMM);
		String strDD = str.substring(6, 8);
		int DD = Integer.parseInt(strDD);

		if (YYYY < 1900 || 2021 < YYYY || 12 < MM || MM == 0 || 31 < DD || DD == 0) {
			String errMsg = messageSource.getMessage("id.okasii.date", null, Locale.getDefault());
			model.addAttribute("birthErrMsg", errMsg);
			return "administratorInsert";
		}
		if ((MM == 02 && DD == 29) || (MM == 02 && DD == 30) || (MM == 02 && DD == 31)) {
			String errMsg = messageSource.getMessage("id.okasii.date", null, Locale.getDefault());
			model.addAttribute("birthErrMsg", errMsg);
			return "administratorInsert";
		}

		//できてるか知らんけどbirthをSQL用に書き換えている
		StringBuilder birth = new StringBuilder();
		birth.append(form.getBirth());
		birth.insert(4, "-");
		birth.insert(7, "-");
		String birthOk = birth.toString(); //YYYY-MM-DDになっている予定

		// 入力値をEntityにセット
		Employee createUser = new Employee(
				form.getPositionId(),
				form.getEmpName(),
				form.getEmpKana(),
				birthOk,
				form.getGenderId(),
				form.getLoginId(),
				form.getPass(),
				form.getRePass(),
				form.getTel(),
				form.getMail(),
				form.getPostCode(),
				form.getAddress());

		// 役職IDに対応する役職名を取得
		List<Position> positionList = (List<Position>) session.getAttribute("positionList");

		String positionName = ParamUtil.getPositionNameByPositionId(form.getPositionId(), positionList);

		session.setAttribute("positionName", positionName);

		Employee loginUser = (Employee) session.getAttribute("loginUser");
		double PI = form.getPositionId();
		double PI2 = (PI-0.5);
		if (loginUser.getPositionId() < PI2) {
			String errMsg = messageSource.getMessage("id.not.NG", null, Locale.getDefault());
			model.addAttribute("errMsg", errMsg);
			return "administratorInsert";
		}

		// 性別IDに対応する性別名を取得
		List<Gender> genderList = (List<Gender>) session.getAttribute("genderList");

		String genderName = ParamUtil.getGenderNameByGenderId(form.getGenderId(), genderList);

		session.setAttribute("genderName", genderName);

		// ID重複チェック
		if (eService.existsUserByLoginId(form.getLoginId())) {
			// login_idが重複していた場合
			String errMsg = messageSource.getMessage("id.duplicate.error", null, Locale.getDefault());
			model.addAttribute("errMsg", errMsg);
			return "administratorInsert";
		}

		if (!createUser.getPass().equals(form.getRePass())) {
			// 再入力パスワードが一致しない場合
			String errMsg = messageSource.getMessage("password.not.match.error", null, Locale.getDefault());
			model.addAttribute("errMsg", errMsg);

			form.setRePass("");

			return "administratorInsert";
		}

		// 登録処理
		eService.empInsert(createUser);

		return "administratorInsertResult";
	}

}
