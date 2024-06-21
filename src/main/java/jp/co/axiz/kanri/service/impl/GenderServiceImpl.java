package jp.co.axiz.kanri.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.co.axiz.kanri.dao.GenderDao;
import jp.co.axiz.kanri.entity.Gender;
import jp.co.axiz.kanri.service.GenderService;

/*
 * genderテーブル用サービス
 */

@Service
@Transactional
public class GenderServiceImpl implements GenderService {

	@Autowired
    private GenderDao gDao;

    /**
     * 全件取得
     */

	@Override
    public List<Gender> findAll() {
        return gDao.findAll();
    }
}
