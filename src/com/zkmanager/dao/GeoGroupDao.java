package com.zkmanager.dao;

import java.util.List;

import com.zkmanager.po.GeoGroup;

public interface GeoGroupDao {
	//����Ŀ�������������ڸ���Ŀ��ĵ�����
	public abstract List<GeoGroup> queryGeoGroupsByBigProId(Integer bigProId);
	
	//����id�������
	public abstract GeoGroup queryGeoGroupById(Integer id);
}
