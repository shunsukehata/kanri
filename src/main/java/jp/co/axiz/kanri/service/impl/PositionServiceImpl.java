package jp.co.axiz.kanri.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.axiz.kanri.dao.PositionDao;
import jp.co.axiz.kanri.entity.Position;
import jp.co.axiz.kanri.service.PositionService;

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
