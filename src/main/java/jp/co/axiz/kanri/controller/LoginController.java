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
import jp.co.axiz.kanri.form.LoginForm;
import jp.co.axiz.kanri.service.EmployeeService;
import jp.co.axiz.kanri.service.GenderService;
import jp.co.axiz.kanri.service.PositionService;

/*
 * ログイン用コントローラ
 */

@Controller
public class LoginController {

	@Autowired
	MessageSource messageSource;

	@Autowired
	HttpSession session;

	@Autowired
	private EmployeeService eService;

	@Autowired
	private PositionService pService;

	@Autowired
	private GenderService gService;


	// ログイン画面表示
	@RequestMapping("/login")
	public String login(@ModelAttribute("login") LoginForm form, Model model) {
		return "login";
	}

	@RequestMapping("/contactFormResult")
	public String contact(@ModelAttribute("login") LoginForm form, Model model) {
		return "contactFormResult";
	}



	// ログイン処理
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@Validated @ModelAttribute("login") LoginForm form, BindingResult bindingResult, Model model) {

		// エラーメッセージを変数にセット
		String errMsg = messageSource.getMessage("login.error", null, Locale.getDefault());

		if (bindingResult.hasErrors()) {
			return "login";
		}

		// ログイン処理
		Employee emp = eService.authentication(form.getLoginId(), form.getPass());

		// ログイン失敗
		if (emp == null) {
			model.addAttribute("errMsg", errMsg);
			return "login";
		// ログイン成功
		} else {

			// 役職一覧を取得
			List<Position> positionList = pService.findAll();

			// 性別一覧を取得
			List<Gender> genderList = gService.findAll();

			// ログインユーザの情報をセッションに保存
			session.setAttribute("loginUser", emp);

			// 役職一覧をセッションに保存
			session.setAttribute("positionList", positionList);
			session.setAttribute("genderList", genderList);

			/*
			 *  管理者判定
			 *
			 *  	管理者ならtrue
			 *  	一般ならfalse
			 */
			Integer positionId = emp.getPositionId();

			boolean adminUser = false;

			if (positionId != 1) {
				adminUser = true;
			} else {
				adminUser = false;
			}

			session.setAttribute("adminUser", adminUser);

			return "home";
		}
	}

	/*
	 *  ホーム画面表示
	 *
	 *   (ログインしていない場合はログイン画面を表示)
	 */
	@RequestMapping("/home")
	public String home(Model model) {
		Employee loginUser = (Employee) session.getAttribute("loginUser");

		// ログインしていない場合
		if (loginUser == null) {

			return "login";
		}

		return "home";
	}


	/*
	 *  管理者メニュー画面表示
	 *
	 *   (ログインしていない場合はログイン画面を表示)
	 */
	@RequestMapping("/menu")
	public String menu(Model model) {
		Employee loginUser = (Employee) session.getAttribute("loginUser");

		// ログインしていない場合
		if (loginUser == null) {

			return "login";
		}

		return "menu";
	}



	/*
	 * ログアウト処理
	 */
	@RequestMapping(value="/logout", method=RequestMethod.POST)
	public String logout(Model model) {

		// セッション情報を破棄する
		session.invalidate();
		return "login";
	}


}