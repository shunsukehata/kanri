package jp.co.axiz.kanri.controller;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.axiz.kanri.entity.Employee;


/*
 * トップ画面周りコントローラ
 */
@Controller
public class MenuController {

    /*
     * セッション情報
     */
    @Autowired
    HttpSession session;




    /*
     * todo画面表示
     */
    @RequestMapping("/todo")
	public String todo(Model model) {
		Employee loginUser = (Employee) session.getAttribute("loginUser");

		// ログインしていない場合
		if (loginUser == null) {

			return "login";
		}

		return "todo";
	}

    /*
     * emergencyContact画面表示
     */
    @RequestMapping("/emergencyContact")
	public String emergencyContact(Model model) {
		Employee loginUser = (Employee) session.getAttribute("loginUser");

		// ログインしていない場合
		if (loginUser == null) {

			return "login";
		}

		return "emergencyContact";
	}

}
