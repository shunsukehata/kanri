package jp.co.axiz.kanri.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.axiz.kanri.dao.EmployeeDao;
import jp.co.axiz.kanri.entity.Employee;
import jp.co.axiz.kanri.service.EmployeeService;

/*
 * employeeテーブル用サービス
 */

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao eDao;

	@Override
	public Employee authentication(String loginId, String pass) {
		return eDao.findByLoginIdAndPass(loginId, pass);
	}


      //条件を指定した検索

    @Override
    public List<Employee> find(Employee employee) {
        return eDao.find(employee);
    }

    //loginIdによる検索
    @Override
	public Employee findByLoginId(String loginId) {
    	return eDao.findByLoginId(loginId);
    };


	//empIdによる検索
	public Employee findByEmpId(int EmpId) {
		return eDao.findByEmpId(EmpId);
	}

	//adminDelete用empIdによる検索
	public Employee findByEmpIdforDelete(Integer EmpId) {
		return eDao.findByEmpIdforDelete(EmpId);
	}

	//ログインIDによるID重複チェック
    @Override
    public boolean existsUserByLoginId(String loginId) {
        return eDao.findByLoginId(loginId) != null;
    }

    //ログインIDとEMPIDでID重複チェック
    @Override
	public boolean existsUserByLoginIdExcludingEmpId(String loginId,int findByLoginIdExcludingEmpId) {
        return eDao.findByLoginIdExcludingEmpId(loginId,findByLoginIdExcludingEmpId) != null;
    };

    //employeeの更新
    @Override
	public void empUpdate(Employee updateEmployee) {
        eDao.empUpdate(updateEmployee);
    };

	//adminの削除
	@Override
    public void delete(Integer empId) {
		eDao.delete(empId);
    }

	//Insert
		@Override
		public void empInsert(Employee insertEmployee) {
			 eDao.empInsert(insertEmployee);

		};
}
