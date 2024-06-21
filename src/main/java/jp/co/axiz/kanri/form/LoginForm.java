package jp.co.axiz.kanri.form;

import javax.validation.constraints.NotBlank;

/*
 * ログイン画面用フォーム
 */

public class LoginForm {

	@NotBlank(message="ログインIDを入力してください")
	private String loginId;

	@NotBlank(message="PASSを入力してください")
	private String pass;


	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
