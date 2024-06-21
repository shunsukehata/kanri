package jp.co.axiz.kanri.form;

/*
 * 社員情報検索画面用フォーム
 */

public class EmployeeSelectForm {

	private Integer empId;

	private String empName;

	private String empKana;

	private String tel;



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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
}
