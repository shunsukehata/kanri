package jp.co.axiz.kanri.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.axiz.kanri.dao.GenderDao;
import jp.co.axiz.kanri.entity.Gender;

/*
 * genderテーブル用Dao
 */

@Repository

public class PgGenderDao implements GenderDao {
	 @Autowired
	    private NamedParameterJdbcTemplate jdbcTemplate;

	    private static final String SELECT_ALL = "SELECT gender_id, gender_name FROM gender ORDER BY gender_id";

	    /**
	     * 全件取得
	     */
	    @Override
	    public List<Gender> findAll() {
	        List<Gender> resultList = jdbcTemplate.query(SELECT_ALL, new BeanPropertyRowMapper<Gender>(Gender.class));

	        return resultList;
	    }
}
