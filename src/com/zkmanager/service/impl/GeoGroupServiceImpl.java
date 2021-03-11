package com.zkmanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zkmanager.dao.GeoGroupDao;
import com.zkmanager.po.GeoGroup;
import com.zkmanager.service.GeoGroupService;

@Service("geoGroupService")
@Transactional
public class GeoGroupServiceImpl implements GeoGroupService{
	
	@Autowired
	private GeoGroupDao geoGroupDao;
	
	@Override
	public List<GeoGroup> queryGeoGroupsByBigProId(Integer bigProId){
		List<GeoGroup> geoGroupsList = geoGroupDao.queryGeoGroupsByBigProId(bigProId);
		if(geoGroupsList != null) {
			return geoGroupsList;
		}
		return null;
	}
	
	@Override
	public GeoGroup queryGeoGroupById(Integer id) {
		GeoGroup geoGroup = geoGroupDao.queryGeoGroupById(id);
		if(geoGroup != null) {
			return geoGroup;
		}
		return null;
	}
}
