package com.zkmanager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zkmanager.po.DrillingUnit;

public interface DrillingUnitDao {
	
	public DrillingUnit findDrillingUnitById(@Param("id") int id);
	
	public List<DrillingUnit> findDrillingUnitByParentId(@Param("parentId") int parentId);
	
	public Integer findDrillingUnitIdByFullName(@Param("fullname") String fullname);
	
	public Integer findParentIdByFullName(@Param("fullname") String fullname);
	
	public Integer findDrillingUnitByFullName(@Param("fullname") String fullname);
	
	public Boolean insertDrillingUnit(@Param("unit") DrillingUnit unit);
	
	public Integer updateDrillingUnit(@Param("length") Double length,@Param("id") Integer id);
	
	public Double findDrillingUnitLengthByid(@Param("id") Integer id);
}
