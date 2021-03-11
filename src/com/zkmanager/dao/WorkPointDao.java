package com.zkmanager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zkmanager.po.WorkPoint;

public interface WorkPointDao {
	
	public WorkPoint findWorkPointById(@Param("id") int id);
	
	public List<WorkPoint> findWorkPointByParentId(@Param("parentId") int parentId);
}
