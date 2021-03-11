package com.zkmanager.service;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.zkmanager.po.Statistician;

public interface StatisticianService {
	public Statistician findStatisticianByParentIdAndType(int parentId,String type);
	
	public abstract Map<String, Statistician> queryStatisticianMapByParentId(Integer parentId);
}
