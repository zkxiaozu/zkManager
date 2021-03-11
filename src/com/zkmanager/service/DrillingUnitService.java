package com.zkmanager.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zkmanager.po.DrillingUnit;

public interface DrillingUnitService {
	public DrillingUnit findDrillingUnitById(int id);
	public List<DrillingUnit> findDrillingUnitByParentId(int parentId);
}
