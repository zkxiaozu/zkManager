package com.zkmanager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zkmanager.po.DrillingUnit;

public interface DrillingUnitDao {
	
	public DrillingUnit findDrillingUnitById(@Param("id") int id);
	
	public List<DrillingUnit> findDrillingUnitByParentId(@Param("parentId") int parentId);
}
