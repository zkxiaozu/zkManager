package com.zkmanager.dao;

import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.zkmanager.po.DrillingUnit;
import com.zkmanager.po.Statistician;

public interface StatisticianDao {
	
	public Statistician findStatisticianByParentIdAndType(@Param("parentId") int parentId
			,@Param("type") String type);
	
	@MapKey("type")
	public abstract Map<String, Statistician> queryStatisticianMapByParentId(Integer parentId);
}
