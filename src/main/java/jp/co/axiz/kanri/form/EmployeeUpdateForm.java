package jp.co.axiz.kanri.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/*
 * 社員情報変更画面用フォーム
 */

public class EmployeeUpdateForm {


	private Integer empId;

	@NotBlank(message="名前が未入力です")
	private String empName;


	@Pattern(regexp ="^[ァ-ヶ]+$")
	private String empKana;

	@NotBlank(message="ログインIDが未入力です")
	private String loginId;

	@NotBlank(message="PASSが未入力です")
	private String pass;

	@NotBlank(message="再入力PASSが未入力です")
	private String rePass;

	@Pattern(regexp ="^\\d{3,20}$")
	private String tel;

	@Pattern(regexp = "^([\\w])+([\\w\\._-])*\\@([\\w])+([\\w\\._-])*\\.([a-zA-Z])+$")
	private String mail;

	@Pattern(regexp = "^\\d{7}$")
	private String postCode;

	@NotBlank(message="住所が未入力です")
	private String address;


	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpKana() {
		return empKana;
	}

	public void setEmpKana(String empKana) {
		this.empKana = empKana;
	}

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

	public String getRePass() {
		return rePass;
	}

	public void setRePass(String rePass) {
		this.rePass = rePass;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


}
