package com.zkmanager.service;

import java.util.List;
import java.util.Map;

import com.zkmanager.po.Statistician;

public interface StatisticianService {
	
	public List<Statistician> findAllStatistician();
	
	public Statistician findStatisticianByParentIdAndType(int parentId,String type);
	
	public abstract Map<String, Statistician> queryStatisticianMapByParentId(Integer parentId);
	
	public boolean updateDataById(int id,double zkm
			,double zkmSum,int zkg,int zkgSum,double xlm, double xlmSum);
}
