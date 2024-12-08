package jp.co.kanri.dao;

import java.util.List;

import jp.co.kanri.entity.Gender;

/*
 * genderテーブル用Daoインターフェース
 */

public interface GenderDao {

	/**
	 * 全件取得
	 */
	public List<Gender> findAll();

}
