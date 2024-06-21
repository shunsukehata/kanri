package jp.co.axiz.kanri.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.axiz.kanri.dao.EmployeeDao;
import jp.co.axiz.kanri.entity.Employee;

/*
 * employeeテーブル用Dao
 */

@Repository
public class PgEmployeeDao implements EmployeeDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	// ログイン用SQL
	private static final String SELECT_BY_LOGIN_ID_AND_PASS = "SELECT emp_id, emp_name, emp_kana, birth, tel, mail, post_code, address, login_id, pass, p.position_id, p.position_name, g.gender_id, g.gender_name FROM employee e INNER JOIN position p ON e.position_id = p.position_id INNER JOIN gender g ON e.gender_id = g.gender_id WHERE login_id = :loginId AND pass = :pass";

	// 検索用SQL
	private static final String SELECT = "SELECT emp_id, emp_name, emp_kana, birth, tel, mail, post_code, address, login_id, pass, p.position_id, p.position_name, g.gender_id, g.gender_name FROM employee e INNER JOIN position p ON e.position_id = p.position_id INNER JOIN gender g ON e.gender_id = g.gender_id WHERE ";

	//ログインIDによる検索用SQL
	private static final String SELECT_BY_LOGIN_ID = "SELECT emp_id, emp_name, emp_kana, login_id, pass, tel, mail, post_code, address FROM employee WHERE login_id = :loginId";

	//EmpIDによる検索用SQL
	private static final String SELECT_BY_EMP_ID = "SELECT emp_id, emp_name, emp_kana, login_id, pass, p.position_id, tel, mail, post_code, address FROM employee e INNER JOIN position p ON e.position_id = p.position_id WHERE emp_id = :empId";

	//adminDelete用EmpIDによる検索用SQL
	private static final String SELECT_BY_EMP_ID_FD = "SELECT emp_id, emp_name, emp_kana, birth, tel, mail, post_code, address, login_id, pass, p.position_id, p.position_name, g.gender_id, g.gender_name FROM employee e INNER JOIN position p ON e.position_id = p.position_id INNER JOIN gender g ON e.gender_id = g.gender_id WHERE emp_id = :empId";

	//ID重複チェック用SQL
	private static final String SELECT_BY_LOGIN_ID_EXCLUDING_EMP_ID ="SELECT emp_id, emp_name, emp_kana, login_id, pass, tel, mail, post_code, address FROM employee WHERE login_id = :loginId AND emp_id <> :empId";

	//Employee更新用SQL
	private static final String UPDATE = "UPDATE employee SET emp_name = :empName, emp_kana = :empKana, tel = :tel, login_id = :loginId, pass = :pass, mail = :mail, post_code = :postCode, address = :address WHERE emp_id = :empId";

	//admin削除用SQL
	private static final String DELETE = "DELETE FROM employee WHERE emp_id = :empId";

	//検索用SQL
	private static final String ORDER_BY = " ORDER BY e.position_id DESC";

	//登録用SQL
	private static final String INSERT = "INSERT INTO employee (position_id, emp_name, emp_kana, birth, gender_id, login_id, pass, tel, mail, post_code, address) VALUES (:positionId, :empName, :empKana,  to_date(:birth, 'YYYY-MM-DD'), :genderId, :loginId, :pass, :tel, :mail, :postCode, :address)";

	// ログイン用メソッド
	public Employee findByLoginIdAndPass(String loginId, String pass) {
		String sql = SELECT_BY_LOGIN_ID_AND_PASS;

		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("loginId", loginId);
		param.addValue("pass", pass);

		List<Employee> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Employee>(Employee.class));

		return resultList.isEmpty() ? null : resultList.get(0);
	}

	//条件を指定した検索

	@Override
	public List<Employee> find(Employee employee) {

		// 検索条件の有無に応じて、sqlのWHERE句に指定する条件文、
		// Parameterをストックしていく。

		List<String> condition = new ArrayList<String>();
		MapSqlParameterSource param = new MapSqlParameterSource();

		Integer empId = employee.getEmpId();
		String empName = employee.getEmpName();
		String empKana = employee.getEmpKana();
		String tel = employee.getTel();

		if (empId != null) {
			condition.add("emp_id::varchar LIKE :empId");
			param.addValue("empId", "%"+empId+"%");

		}

		if (empName != null && !empName.isEmpty()) {
			condition.add("emp_name LIKE :empName");
			param.addValue("empName", "%"+empName+"%");

		}

		if (empKana != null && !empKana.isEmpty()) {
			condition.add("emp_kana LIKE :empKana");
			param.addValue("empKana", "%"+empKana+"%");

		}

		if (tel != null && !tel.isEmpty()) {
			condition.add("tel LIKE :tel");
			param.addValue("tel", "%"+tel+"%");

		}

		// WHERE句の文字列生成
		String whereString = String.join(" AND ", condition.toArray(new String[] {}));

		// SQL文生成
		String sql = SELECT + whereString + ORDER_BY;

		List<Employee> resultList = jdbcTemplate.query(sql, param, new BeanPropertyRowMapper<Employee>(Employee.class));

		return resultList;
	}

	//loginIdによる検索
	@Override
	public Employee findByLoginId(String loginId) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("loginId", loginId);

		List<Employee> resultList = jdbcTemplate.query(SELECT_BY_LOGIN_ID, param,
				new BeanPropertyRowMapper<Employee>(Employee.class));

		return resultList.isEmpty() ? null : resultList.get(0);
	}

	//ID重複チェック
	@Override
	public Employee findByLoginIdExcludingEmpId(String loginId, int excludingEmpId) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("loginId", loginId);
		param.addValue("empId", excludingEmpId);

		List<Employee> resultList = jdbcTemplate.query(SELECT_BY_LOGIN_ID_EXCLUDING_EMP_ID, param,
				new BeanPropertyRowMapper<Employee>(Employee.class));

		return resultList.isEmpty() ? null : resultList.get(0);
	}

	//empIdによる検索
	public Employee findByEmpId(Integer EmpId) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("empId", EmpId);

		List<Employee> resultList = jdbcTemplate.query(SELECT_BY_EMP_ID, param,
				new BeanPropertyRowMapper<Employee>(Employee.class));

		return resultList.isEmpty() ? null : resultList.get(0);
	}

	//adminDelete用empIdによる検索
	public Employee findByEmpIdforDelete(Integer EmpId) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("empId", EmpId);

		List<Employee> resultList = jdbcTemplate.query(SELECT_BY_EMP_ID_FD, param,
				new BeanPropertyRowMapper<Employee>(Employee.class));

		return resultList.isEmpty() ? null : resultList.get(0);
	}


	//Employeeの更新
	@Override
	public void empUpdate(Employee employee) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("empId", employee.getEmpId());
		param.addValue("empName", employee.getEmpName());
		param.addValue("empKana", employee.getEmpKana());
		param.addValue("loginId", employee.getLoginId());
		param.addValue("pass", employee.getPass());
		param.addValue("tel", employee.getTel());
		param.addValue("mail", employee.getMail());
		param.addValue("postCode", employee.getPostCode());
		param.addValue("address", employee.getAddress());

		jdbcTemplate.update(UPDATE, param);
	}

	//adminの削除
	@Override
	public void delete(Integer EmpId) {
		MapSqlParameterSource param = new MapSqlParameterSource();
		param.addValue("empId", EmpId);

		jdbcTemplate.update(DELETE, param);
	}

	 //Employeeの登録
    @Override
    public void empInsert(Employee employee) {
        MapSqlParameterSource param = new MapSqlParameterSource();
        param.addValue("positionId", employee.getPositionId());
        param.addValue("empName", employee.getEmpName());
        param.addValue("empKana", employee.getEmpKana());
        param.addValue("birth", employee.getBirth());
        param.addValue("genderId", employee.getGenderId());
        param.addValue("loginId", employee.getLoginId());
        param.addValue("pass", employee.getPass());
        param.addValue("rePass", employee.getRePass());
        param.addValue("tel", employee.getTel());
        param.addValue("mail", employee.getMail());
        param.addValue("postCode", employee.getPostCode());
        param.addValue("address", employee.getAddress());

        jdbcTemplate.update(INSERT, param);
    }

}
