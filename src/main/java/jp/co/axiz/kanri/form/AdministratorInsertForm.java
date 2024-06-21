package jp.co.axiz.kanri.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;

/*
 * 管理者用社員情報登録画面用フォーム
 */

public class AdministratorInsertForm {

	@NotNull
	private Integer positionId;

	private String positionName;

	@NotBlank(message="名前を入力してください")
	private String empName;

	@Pattern(regexp ="^[ァ-ヶ]+$")
	private String empKana;

	@Pattern(regexp ="\\d\\d\\d\\d\\d\\d\\d\\d")
	@DateTimeFormat(pattern = "yyyyMMdd")
	@NotBlank(message="誕生日を入力してください")
	private String birth;

	@NotNull
	private Integer genderId;


	private String genderName;

	@NotBlank(message="ログインIDを入力してください")
	private String loginId;

	@NotBlank(message="PASSを入力してください")
	private String pass;

	@NotBlank(message="再入力PASSを入力してください")
	private String rePass;

	@Pattern(regexp ="^\\d{3,20}$")
	private String tel;

	@Pattern(regexp = "^([\\w])+([\\w\\._-])*\\@([\\w])+([\\w\\._-])*\\.([a-zA-Z])+$")
	private String mail;

	@Pattern(regexp = "^\\d{7}$")
	private String postCode;

	@NotBlank(message="住所を入力してください")
	private String address;



	public Integer getPositionId() {
		return positionId;
	}

	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
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

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}

	public Integer getGenderId() {
		return genderId;
	}

	public void setGenderId(Integer genderId) {
		this.genderId = genderId;
	}

	public String getGenderName() {
		return genderName;
	}

	public void setGenderName(String genderName) {
		this.genderName = genderName;
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
