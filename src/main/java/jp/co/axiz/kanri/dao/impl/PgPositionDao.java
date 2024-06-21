package jp.co.axiz.kanri.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import jp.co.axiz.kanri.dao.PositionDao;
import jp.co.axiz.kanri.entity.Position;

/*
 * positionテーブル用Dao
 */

@Repository
public class PgPositionDao implements PositionDao {

	@Autowired
	private NamedParameterJdbcTemplate jdbcTemplate;

	// positionテーブル全件取得用SQL
	private static final String SELECT_ALL = "SELECT position_id, position_name FROM position ORDER BY position_id DESC";

	// 全件取得用メソッド
	public List<Position> findAll() {
		String sql = SELECT_ALL;
		List<Position> positionList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Position>(Position.class));

		return positionList;
	}
}
