package com.zkmanager.service;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zkmanager.po.DrillingRecord;
import com.zkmanager.po.RoadRecord;

public interface DrillingRecordService {
	public DrillingRecord findTodayDrillingRecord(int parentId,Date sendDate);
	
	public List<DrillingRecord> findWeekDrillingRecord(int parentId);
	
	public List<DrillingRecord> findMonthDrillingRecord(int parentId);
	
	public boolean addDrillingRecord(DrillingRecord drillingRecord);
	
	public DrillingRecord checkRepeatDate(int parentId,String sendDate);
	
	public String findStageById(int id);
	
	public int findFirstCheckNumByParentId(int parentId,String stage);
	
	public int findSecondCheckNumByParentId(int parentId,String stage);
	
	public DrillingRecord findFirstAuditInfo(int parentId);
	
	public DrillingRecord findSecondAuditInfo(int parentId);
	
	public List<DrillingRecord> findSecondAllAuditInfo(int parentId);
	
	public DrillingRecord checkAuditRecordExist(int parentId,String sendDate,String stage);
	
	public boolean passFirstAuditById(int id,double zking);
	
	public boolean passSecondDynamicAudit(int id,double footage);
	
	public boolean passSecondAuditById(int id,double zking,double footage);
	
	public boolean backAuditById(int id);
	
	public DrillingRecord checkDynamicAuditRecordExist(int id);
	
	public List<DrillingRecord> findAllPassAuditInfo(int parentId);
	
	public List<DrillingRecord> findAllBackAuditInfo(int parentId);
	
	public DrillingRecord findNotPassedRecord(int parentId,Date sendDate);
	
	public DrillingRecord findLastRecordById(int id);
}
