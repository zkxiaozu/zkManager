package com.zkmanager.service.impl;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zkmanager.dao.DrillingRecordDao;
import com.zkmanager.dao.StatisticianDao;
import com.zkmanager.po.DrillingRecord;
import com.zkmanager.po.RoadRecord;
import com.zkmanager.po.Statistician;
import com.zkmanager.service.DrillingRecordService;
import com.zkmanager.service.RoadRecordService;
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

	

}
