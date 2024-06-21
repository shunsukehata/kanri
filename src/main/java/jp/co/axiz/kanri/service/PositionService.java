package jp.co.axiz.kanri.service;

import java.util.List;

import jp.co.axiz.kanri.entity.Position;

/*
 * positionテーブル用サービスインターフェース
 */

public interface PositionService {

	public List<Position> findAll();
}
