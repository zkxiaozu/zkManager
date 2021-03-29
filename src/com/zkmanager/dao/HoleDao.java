package com.zkmanager.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zkmanager.po.Hole;

public interface HoleDao {
	public Hole findHoleById(@Param("id") int id);
	
	public List<Hole> findHoleByParentId(@Param("parentId") int parentId);
	
	public List<Hole> findHoleByParentId2(@Param("parentId2") int parentId2);
	
	public boolean updateRailLength(@Param("railLength") double railLength, @Param("id") int id);
	
	public boolean updateRailDepth(@Param("railDepth") double railDepth, @Param("id") int id);
	
	public boolean updateRailState(@Param("railState") String railState, @Param("id") int id);
	
	public boolean updateRailFootage(@Param("railFootage") double railFootage, @Param("id") int id);
	
	public boolean updateDepthAndFootage(@Param("railDepth") double railDepth
			,@Param("railFootage") double railFootage, @Param("id") int id);
	
	public boolean insertHoles(@Param("holeList") List<Hole> holeList);
	
	public double countZkm(@Param("parentId") int parentId
			, @Param("type") String type);
	
	public double countZkmSum(@Param("parentId") int parentId
			, @Param("type") String type);
	
	public Integer countZkg(@Param("parentId") int parentId
			, @Param("type") String type);
	
	public int countZkgSum(@Param("parentId") int parentId
			, @Param("type") String type);
	
	public double countXlm(@Param("parentId") int parentId
			, @Param("type") String type);
	
	public double countXlmSum(@Param("parentId") int parentId
			, @Param("type") String type);
	
	
	public double countZkmPoint(@Param("parentId2") int parentId2
			, @Param("type") String type);
	
	public double countZkmSumPoint(@Param("parentId2") int parentId2
			, @Param("type") String type);
	
	public Integer countZkgPoint(@Param("parentId2") int parentId2
			, @Param("type") String type);
	
	public int countZkgSumPoint(@Param("parentId2") int parentId2
			, @Param("type") String type);
	
	public double countXlmPoint(@Param("parentId2") int parentId2
			, @Param("type") String type);
	
	public double countXlmSumPoint(@Param("parentId2") int parentId2
			, @Param("type") String type);

}
