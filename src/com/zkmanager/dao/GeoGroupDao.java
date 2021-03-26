package com.zkmanager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zkmanager.po.GeoGroup;

public interface GeoGroupDao {
	//����Ŀ�������������ڸ���Ŀ��ĵ�����
	public abstract List<GeoGroup> queryGeoGroupsByBigProId(Integer bigProId);
	
	//����id�������
	public abstract GeoGroup queryGeoGroupById(Integer id);
	
	public Integer findGeoGroupIdByContactorId(@Param("contactorId") Integer contactorId);
}
