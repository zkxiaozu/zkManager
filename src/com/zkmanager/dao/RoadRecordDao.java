package com.zkmanager.dao;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zkmanager.po.RoadRecord;

public interface RoadRecordDao {
	public RoadRecord findTodayRoadRecord(@Param("parentId") int parentId
			,@Param("sendDate") Date sendDate);
	
	public List<RoadRecord> findWeekRoadRecord(@Param("parentId") int parentId);
	
	public List<RoadRecord> findMonthRoadRecord(@Param("parentId") int parentId);
	
	public boolean addRoadRecord(RoadRecord roadRecord);
	
	public List<RoadRecord> checkRepeatDate(@Param("parentId") int parentId
			,@Param("sendDate") String sendDate);
	
	public String findStageById(@Param("id") int id);
	
	public int findFirstCheckNumByParentId(@Param("parentId") int parentId,@Param("stage") String stage);
	
	public int findSecondCheckNumByParentId(@Param("parentId") int parentId,@Param("stage") String stage);
	
	public RoadRecord findFirstAuditInfo(@Param("parentId") int parentId);
	
	public RoadRecord findSecondAuditInfo(@Param("parentId") int parentId);
	
	public List<RoadRecord> findSecondAllAuditInfo(@Param("parentId") int parentId);
	
	public RoadRecord checkAuditRecordExist(@Param("parentId") int parentId
			,@Param("sendDate") String sendDate,@Param("stage") String stage);
	
	public boolean passFirstAuditById(@Param("id") int id,@Param("roading") double roading);
	
	public boolean passSecondDynamicAudit(@Param("id") int id);
	
	public boolean passSecondAuditById(@Param("id") int id,@Param("roading") double roading);
	
	public boolean backAuditById(@Param("id") int id);
	
	public RoadRecord checkDynamicAuditRecordExist(@Param("id") int id);
	
	public List<RoadRecord> findAllPassAuditInfo(@Param("parentId") int parentId);
	
	public List<RoadRecord> findAllBackAuditInfo(@Param("parentId") int parentId);
	
	public RoadRecord findNotPassedRoadRecord(@Param("parentId") int parentId
			,@Param("sendDate") Date sendDate);
}
