package com.zkmanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zkmanager.dao.BigProDao;
import com.zkmanager.po.BigPro;
import com.zkmanager.service.BigProService;

@Service("bigProService")
public class BigProServiceImpl implements BigProService {

	@Autowired
	private BigProDao bigProDao;

//	private Boolean isExist(Integer id) {
//		if (queryBigProById(id) != null)
//			return true;
//		return false;
//	}

	@Override
	public List<BigPro> queryBigProsBySuoId(Integer parentId) {
		List<BigPro> bigProsList = bigProDao.queryBigProsBySuoId(parentId);
		if (bigProsList != null) {
			return bigProsList;
		}
		return null;
	}

	@Override
	public BigPro queryBigProById(Integer id) {
		BigPro bigPro = bigProDao.queryBigProById(id);
		if (bigPro != null) {
			return bigPro;
		}
		return null;
	}

}
