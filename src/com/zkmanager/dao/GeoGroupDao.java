package com.zkmanager.dao;

import java.util.List;

import com.zkmanager.po.GeoGroup;

public interface GeoGroupDao {
	//从项目级查找所有属于该项目组的地质组
	public abstract List<GeoGroup> queryGeoGroupsByBigProId(Integer bigProId);
	
	//根据id查地质组
	public abstract GeoGroup queryGeoGroupById(Integer id);
}
