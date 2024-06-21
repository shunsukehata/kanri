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
import jp.co.axiz.kanri.form.AdministratorDeleteForm;
import jp.co.axiz.kanri.service.EmployeeService;

/*
 * 管理者用社員情報削除用コントローラ
 */

@Controller
public class AdministratorDeleteController {
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
	 * 削除対象者ID一致検索画面表示
	 */
	@RequestMapping("/administratorDelete")
	public String delete(@ModelAttribute("AdministratorDeleteForm") AdministratorDeleteForm form, Model model) {
		return "administratorDelete";
	}

	@RequestMapping(value = "/administratorDeleteConfirm", method = RequestMethod.POST)
	public String administratorDeleteConfirm(
			@Validated @ModelAttribute("AdministratorDeleteForm") AdministratorDeleteForm form,
			BindingResult bindingResult,
			Model model) {

		//IDが入力されていない場合、 削除対象者ID一致検索画面に戻る
		if (bindingResult.hasErrors()) {
			return "administratorDelete";
		}

		// 入力したIDに紐づくユーザを検索
		Employee employee = eService.findByEmpIdforDelete(form.getEmpId());

		if (employee == null) {
			// 該当するデータが存在しない場合
			String errMsg = messageSource.getMessage("id.not.found.error", null, Locale.getDefault());
			model.addAttribute("errMsg", errMsg);
			return "administratorDelete";
		}

		//ログイン情報よりログイン者が対象者を編集可能か精査
		Integer myPositionId = ((Employee) session.getAttribute("loginUser")).getPositionId();
		if (myPositionId < employee.getPositionId()) {
			String errMsg = messageSource.getMessage("id.not.delete.error", null, Locale.getDefault());
			model.addAttribute("errMsg", errMsg);
			return "administratorDelete";
		}

		session.setAttribute("deleteEmploee", employee);

		return "administratorDeleteConfirm";
	}

	/*
	 * 削除処理 (削除確認画面の削除ボタン押下)
	 */
	@RequestMapping(value = "/administratorDeleteResult", method = RequestMethod.POST)
	public String deleteExecute(@Validated @ModelAttribute("AdministratorDeleteForm") AdministratorDeleteForm form,
			Model model) {

		Employee deleteEmployee = (Employee) session.getAttribute("deleteEmploee");

		Integer empId = deleteEmployee.getEmpId();

		// 削除処理
		eService.delete(empId);

		return "administratorDeleteResult";
	}

}
