package jp.co.kanri.service;

import java.util.List;

import jp.co.kanri.entity.Position;

/*
 * positionテーブル用サービスインターフェース
 */

public interface PositionService {

	public List<Position> findAll();
}
