package jp.co.kanri.service.impl;

import java.util.List;

import jp.co.kanri.dao.PositionDao;
import jp.co.kanri.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.kanri.entity.Position;

/*
 * positionテーブル用サービス
 */

@Service
@Transactional
public class PositionServiceImpl implements PositionService {

	@Autowired
	private PositionDao pDao;

	// 全件取得
	public List<Position> findAll() {
		return pDao.findAll();
	}
}
