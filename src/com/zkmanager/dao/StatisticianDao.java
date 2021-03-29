package com.zkmanager.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.zkmanager.po.Statistician;

public interface StatisticianDao {
	
	public List<Statistician> findAllStatistician();
	
	public Statistician findStatisticianByParentIdAndType(@Param("parentId") int parentId
			,@Param("type") String type);
	
	@MapKey("type")
	public abstract Map<String, Statistician> queryStatisticianMapByParentId(Integer parentId);
	
	public boolean updateDataById(@Param("id") int id,@Param("zkm") double zkm
			,@Param("zkmSum") double zkmSum,@Param("zkg") int zkg
			,@Param("zkgSum") int zkgSum,@Param("xlm") double xlm,@Param("xlmSum") double xlmSum);
}
