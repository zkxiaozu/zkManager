package com.zkmanager.service;

import java.util.List;

import com.zkmanager.po.DrillingUnit;

public interface DrillingUnitService {
	public DrillingUnit findDrillingUnitById(int id);
	
	public List<DrillingUnit> findDrillingUnitByParentId(int parentId);
	
	public Integer findDrillingUnitIdByFullName(String fullname);
	
	public Integer findParentIdByFullName(String fullname);
	
	public Integer findDrillingUnitByFullName(String fullname);
	
	public Boolean insertDrillingUnit(DrillingUnit unit);
	
	public Integer updateDrillingUnit(Double length, Integer id);
	
	public Double findDrillingUnitLengthByid(Integer id);
}
