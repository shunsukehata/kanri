package jp.co.axiz.kanri.dao;

import java.util.List;

import jp.co.axiz.kanri.entity.Gender;

/*
 * genderテーブル用Daoインターフェース
 */

public interface GenderDao {

	/**
	 * 全件取得
	 */
	public List<Gender> findAll();

}
