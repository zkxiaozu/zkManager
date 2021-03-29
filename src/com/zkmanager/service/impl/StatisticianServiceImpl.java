package com.zkmanager.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zkmanager.dao.StatisticianDao;
import com.zkmanager.po.Statistician;
import com.zkmanager.service.StatisticianService;

@Service("statisticianService")
public class StatisticianServiceImpl implements StatisticianService {
	
	@Autowired
	private StatisticianDao statisticianDao;

	@Override
	@Transactional
	public Statistician findStatisticianByParentIdAndType(int parentId, String type) {
		// TODO Auto-generated method stub
		Statistician result = this.statisticianDao.findStatisticianByParentIdAndType(parentId, type);
		if(result != null) {
			return result;
		}
		return null;
	}

	@Override
	public Map<String, Statistician> queryStatisticianMapByParentId(Integer parentId) {
		// TODO Auto-generated method stub
		Map<String, Statistician> statisticianMap = statisticianDao.queryStatisticianMapByParentId(parentId);
		if(statisticianMap != null) {
			return statisticianMap;
		}
		return null;
	}

	@Override
	public List<Statistician> findAllStatistician() {
		// TODO Auto-generated method stub
		List<Statistician> result = statisticianDao.findAllStatistician();
		return result;
	}

	@Override
	public boolean updateDataById(int id, double zkm, double zkmSum, int zkg, int zkgSum, double xlm, double xlmSum) {
		// TODO Auto-generated method stub
		boolean result = this.statisticianDao.updateDataById(id, zkm, zkmSum, zkg, zkgSum, xlm, xlmSum);
		return result;
	}

	

}
