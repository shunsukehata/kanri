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
import jp.co.axiz.kanri.form.EmployeeUpdateForm;
import jp.co.axiz.kanri.service.EmployeeService;

/*
 * 社員情報更新用コントローラ
 */
@Controller
public class EmployeeUpdateController {
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
	 * 更新画面表示
	 */
	@RequestMapping("/employeeUpdate")
	public String update(@ModelAttribute("EmployeeUpdateForm") EmployeeUpdateForm form, Model model) {

		return "employeeUpdate";
	}

	/*
	 * 更新内容入力画面遷移 (更新画面の確認ボタン押下時)
	 */
	@RequestMapping(value = "/employeeUpdateResult", method = RequestMethod.POST)
	public String updateInput(@Validated @ModelAttribute("EmployeeUpdateForm") EmployeeUpdateForm form, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "employeeUpdate";
		}

		//loginしているユーザ情報の取得とセット
		Employee emp = (Employee) session.getAttribute("loginUser");


		// Employオブジェクト生成
		Employee updateEmployee = new Employee();

		/*
		 * 入力した値を更新値としてセット
		 */
		updateEmployee.setEmpId(emp.getEmpId());
		updateEmployee.setEmpName(form.getEmpName());
		updateEmployee.setEmpKana(form.getEmpKana());
		updateEmployee.setBirth(emp.getBirth());
		updateEmployee.setTel(form.getTel());
		updateEmployee.setMail(form.getMail());
		updateEmployee.setPostCode(form.getPostCode());
		updateEmployee.setAddress(form.getAddress());
		updateEmployee.setLoginId(form.getLoginId());
		updateEmployee.setPass(form.getPass());
		updateEmployee.setPositionId(emp.getPositionId());
		updateEmployee.setPositionName(emp.getPositionName());
		updateEmployee.setGenderId(emp.getGenderId());
		updateEmployee.setGenderName(emp.getGenderName());

		String rePass = form.getRePass();

		if (emp.equals(updateEmployee)) {
		// 入力値を変更していない場合
		    String errMsg = messageSource.getMessage("required.change", null, Locale.getDefault());
		    model.addAttribute("errMsg", errMsg);
		    return "employeeUpdate";
		}

		// ID重複チェック
		if (eService.existsUserByLoginIdExcludingEmpId(updateEmployee.getLoginId(), updateEmployee.getEmpId())) {
			// login_idが重複していた場合
			String errMsg = messageSource.getMessage("id.duplicate.error", null, Locale.getDefault());
			model.addAttribute("errMsg", errMsg);
			return "employeeUpdate";
		}

		// パスワードが一致しているかチェック
		if (!updateEmployee.getPass().equals(rePass)) {
			String errMsg = messageSource.getMessage("password.not.match.error", null, Locale.getDefault());
			model.addAttribute("errMsg", errMsg);

			form.setRePass("");

			return "employeeUpdate";
		}

		// 更新処理
		eService.empUpdate(updateEmployee);

		session.setAttribute("loginUser", updateEmployee);

		return "employeeUpdateResult";
	}

}
