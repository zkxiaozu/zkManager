package com.zkmanager.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zkmanager.po.Hole;

public interface HoleService {
	public Hole findHoleById(int id);
	
	public List<Hole> findHoleByParentId(int parentId);
	
	public List<Hole> findHoleByParentId2(int parentId2);
	
	public boolean updateRailLength(double railLength, int id);
	
	public boolean updateRailDepth(double railDepth, int id);
	
	public boolean updateRailState(String railState,int id);
	
	public boolean updateRailFootage(double railFootage,int id);
	
	public boolean updateDepthAndFootage(double railDepth, double railFootage, int id);
}
