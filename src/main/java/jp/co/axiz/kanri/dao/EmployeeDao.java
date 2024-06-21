package jp.co.axiz.kanri.dao;

import java.util.List;

import jp.co.axiz.kanri.entity.Employee;

/*
 * employeeテーブル用Daoインターフェース
 */

public interface EmployeeDao {

	public Employee findByLoginIdAndPass(String loginId, String pass);

	public List<Employee> find(Employee employee);

	public Employee findByLoginId(String loginId);

	public Employee findByEmpId(Integer EmpId);

	public Employee findByEmpIdforDelete(Integer EmpId);


	public Employee findByLoginIdExcludingEmpId(String loginId,int findByLoginIdExcludingEmpId);

	public void empUpdate(Employee updateEmployee);

	public void delete(Integer EmpId);

	public void empInsert(Employee insertEmployee);
}

