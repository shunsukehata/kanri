package jp.co.axiz.kanri.form;

import javax.validation.constraints.NotNull;

public class AdministratorUpdateEmpIdForm {


	@NotNull(message="社員IDを入力してください")
	private Integer empId;


	private Integer positionId;

	private String positionName;

	private String empName;

	private String empKana;

	private String loginId;

	private String pass;

	private String rePass;

	String tel;

	private String mail;

	private String postCode;

	private String address;


	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

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
	}}

