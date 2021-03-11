package com.zkmanager.service;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zkmanager.po.RoadRecord;

public interface RoadRecordService {
	public RoadRecord findTodayRoadRecord(int parentId,Date sendDate);
	
	public List<RoadRecord> findWeekRoadRecord(int parentId);
	
	public List<RoadRecord> findMonthRoadRecord(int parentId);
	
	public boolean addRoadRecord(RoadRecord roadRecord);
	
	public RoadRecord checkRepeatDate(int parentId,String sendDate);
	
	public String findStageById(int id);
	
	public int findFirstCheckNumByParentId(int parentId,String stage);
	
	public int findSecondCheckNumByParentId(int parentId,String stage);
	
	public RoadRecord findFirstAuditInfo(int parentId);
	
	public RoadRecord findSecondAuditInfo(int parentId);
	
	public List<RoadRecord> findSecondAllAuditInfo(int parentId);
	
	public RoadRecord checkAuditRecordExist(int parentId,String sendDate,String stage);
	
	public boolean passFirstAuditById(int id,double roading);
	
	public boolean passSecondDynamicAudit(int id);
	
	public boolean passSecondAuditById(int id,double roading);
	
	public boolean backAuditById(int id);
	
	public RoadRecord checkDynamicAuditRecordExist(int id);
	
	public List<RoadRecord> findAllPassAuditInfo(int parentId);
	
	public List<RoadRecord> findAllBackAuditInfo(int parentId);
	
	public RoadRecord findNotPassedRoadRecord(int parentId,Date sendDate);
}
