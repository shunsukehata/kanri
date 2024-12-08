package jp.co.kanri.dao;

import java.util.List;

import jp.co.kanri.entity.Position;

/*
 * positionテーブル用Daoインターフェース
 */

public interface PositionDao {

	public List<Position> findAll();
}
