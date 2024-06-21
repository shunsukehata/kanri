package jp.co.axiz.kanri.entity;

import java.util.Date;

/*
 * employeeテーブル用エンティティ
 */
public class Employee {

	private Integer empId;

	private String empName;

	private String empKana;

	private String birth;

	private Date birthday;

	private String tel;

	private String mail;

	private String postCode;

	private String address;

	private String loginId;

	private String pass;

	private String rePass;

	private Integer positionId;

	private String positionName;

	private Integer genderId;

	private String genderName;


	// 引数無しコンストラクタ
	public Employee() {

	}


	// ToDo:引数ありコンストラクタ
	//emp_select用コンストラクタ
	public Employee(Integer empId, String empName, String empKana, String tel) {
		this.empId = empId;
		this.empName = empName;
		this.empKana = empKana;
		this.tel = tel;
	}

	//emp_selectResult用コンストラクタ
		public Employee(Integer positionId, String positionName, String empName, String empKana, String birth,
				String genderName, String tel, String mail, String postCode, String address) {
			this.positionId = positionId;
			this.positionName = positionName;
			this.empName = empName;
			this.empKana = empKana;
			this.birth = birth;
			this.genderName = genderName;
			this.tel = tel;
			this.mail = mail;
			this.postCode = postCode;
			this.address = address;
		}

	//emp_update用コンストラクタ
	public Employee(Integer empId, String empName, String empKana, String birth, String tel, String mail, String postCode, String address,String loginId, String pass, Integer positionId, String positionName, Integer genderId, String genderName) {
		this.empId = empId;
		this.empName = empName;
		this.empKana = empKana;
		this.birth = birth;
		this.tel = tel;
		this.mail = mail;
		this.postCode = postCode;
		this.address = address;
		this.loginId = loginId;
		this.pass = pass;
		this.positionId = positionId;
		this.positionName = positionName;
		this.genderId = genderId;
		this.genderName = genderName;
	}

	//admin_insertSelect用とadmin_delete用コンストラクタ
	public Employee(Integer empId) {
		this.empId = empId;
	}

	//admin_insert用コンストラクタ
	public Employee(Integer positionId, String empName, String empKana, String birth, Integer genderId,
						String loginId, String pass, String rePass, String tel, String mail, String postCode, String address) {
		this.positionId = positionId;
		this.empName = empName;
		this.empKana = empKana;
		this.birth = birth;
		this.genderId = genderId;
		this.loginId = loginId;
		this.pass = pass;
		this.rePass = rePass;
		this.tel = tel;
		this.mail = mail;
		this.postCode = postCode;
		this.address = address;
	}

	//admin_update用コンストラクタ
	public Employee(Integer positionId, String positionName,String empName, String empKana, String birth,String loginId,
					String pass, String tel, String mail, String postCode, String address) {
		this.positionId = positionId;
		this.positionName = positionName;
		this.empName = empName;
		this.empKana = empKana;
		this.birth = birth;
		this.loginId = loginId;
		this.pass = pass;
		this.tel = tel;
		this.mail = mail;
		this.postCode = postCode;
		this.address = address;
	}

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

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
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


	public Date getBirthday() {
		return birthday;
	}


	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}


}
