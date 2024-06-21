package jp.co.axiz.kanri.service;

import java.util.List;

import jp.co.axiz.kanri.entity.Gender;

/*
 * genderテーブル用サービスインターフェース
 */

public interface GenderService {

	/**
	 * 全件取得
	 */
	public List<Gender> findAll();



}
