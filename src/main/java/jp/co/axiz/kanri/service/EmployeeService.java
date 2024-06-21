package jp.co.axiz.kanri.service;

import java.util.List;

import jp.co.axiz.kanri.entity.Employee;

/*
 * employeeテーブル用サービスインターフェース
 */

public interface EmployeeService {

	public Employee authentication(String loginId, String pass);

	public List<Employee> find(Employee employee);

	public Employee findByLoginId(String loginId);

	public Employee findByEmpId(int EmpId);

	public Employee findByEmpIdforDelete(Integer EmpId);

    public boolean existsUserByLoginId(String loginId);

	public boolean existsUserByLoginIdExcludingEmpId(String loginId,int findByLoginIdExcludingEmpId);

	public void empUpdate(Employee updateEmployee);

	public void delete(Integer empId);

	public void empInsert(Employee insertEmployee);
}
