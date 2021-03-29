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
	
	public boolean insertHoles(List<Hole> holeList);
	
public double countZkm(int parentId, String type);
	
	public double countZkmSum(int parentId, String type);
	
	public Integer countZkg(int parentId, String type);
	
	public int countZkgSum(int parentId, String type);
	
	public double countXlm(int parentId, String type);
	
	public double countXlmSum(int parentId, String type);
	
	
	public double countZkmPoint(int parentId2, String type);
	
	public double countZkmSumPoint(int parentId2, String type);
	
	public Integer countZkgPoint(int parentId2, String type);
	
	public int countZkgSumPoint(int parentId2, String type);
	
	public double countXlmPoint(int parentId2, String type);
	
	public double countXlmSumPoint(int parentId2, String type);	
}
