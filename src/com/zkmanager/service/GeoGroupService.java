package com.zkmanager.service;

import java.util.List;

import com.zkmanager.po.GeoGroup;

public interface GeoGroupService {
	public abstract List<GeoGroup> queryGeoGroupsByBigProId(Integer bigProId);
	
	public abstract GeoGroup queryGeoGroupById(Integer id);
}
