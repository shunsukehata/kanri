package jp.co.kanri.service;

import java.util.List;

import jp.co.kanri.entity.Gender;

/*
 * genderテーブル用サービスインターフェース
 */

public interface GenderService {

	/**
	 * 全件取得
	 */
	public List<Gender> findAll();



}
