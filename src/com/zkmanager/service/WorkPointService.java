package com.zkmanager.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zkmanager.po.WorkPoint;

public interface WorkPointService {
	public WorkPoint findWorkPointById(int id);
	
	public List<WorkPoint> findWorkPointByParentId(int parentId);
	
	public Integer findWorkPointIdByFullName(String fullname);
	
	public Boolean insertWorkPoint(WorkPoint workPoint);
	
	public Integer updateWorkPoint(Double length, Integer id);
	
	public Double findWorkPointLengthById(Integer id);
}
