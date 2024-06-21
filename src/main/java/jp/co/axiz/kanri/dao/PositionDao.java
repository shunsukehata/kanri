package jp.co.axiz.kanri.dao;

import java.util.List;

import jp.co.axiz.kanri.entity.Position;

/*
 * positionテーブル用Daoインターフェース
 */

public interface PositionDao {

	public List<Position> findAll();
}
