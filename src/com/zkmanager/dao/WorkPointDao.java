package com.zkmanager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zkmanager.po.WorkPoint;

public interface WorkPointDao {
	
	public WorkPoint findWorkPointById(@Param("id") int id);
	
	public List<WorkPoint> findWorkPointByParentId(@Param("parentId") int parentId);
	
	public Integer findWorkPointIdByFullName(@Param("fullname") String fullname);
	
	public Boolean insertWorkPoint(@Param("workPoint") WorkPoint workPoint);
	
	public Integer updateWorkPoint(@Param("length") Double length, @Param("id") Integer id);
	
	public Double findWorkPointLengthById(@Param("id") Integer id);
}
