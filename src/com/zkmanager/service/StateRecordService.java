package com.zkmanager.service;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zkmanager.po.RoadRecord;
import com.zkmanager.po.StateRecord;

public interface StateRecordService {
	public StateRecord findTodayStateRecord(int parentId,Date sendDate);
	
	public List<StateRecord> findWeekStateRecord(int parentId);
	
	public List<StateRecord> findMonthStateRecord(int parentId);
	
	public boolean addStateRecord(StateRecord stateRecord);
	
	public StateRecord checkRepeatDate(int parentId,String sendDate);
	
	public String findStageById(int id);
	
	public int findFirstCheckNumByParentId(int parentId,String stage);
	
	public int findSecondCheckNumByParentId(int parentId,String stage);
	
	public StateRecord findFirstAuditInfo(int parentId);
	
	public StateRecord findSecondAuditInfo(int parentId);
	
	public List<StateRecord> findSecondAllAuditInfo(int parentId);
	
	public StateRecord checkAuditRecordExist(int parentId,String sendDate,String stage);
	
	public boolean passFirstAuditById(int id,String state);
	
	public boolean passSecondDynamicAudit(int id);
	
	public boolean passSecondAuditById(int id,String state);
	
	public boolean backAuditById(int id);
	
	public StateRecord checkDynamicAuditRecordExist(int id);
	
	public List<StateRecord> findAllPassAuditInfo(int parentId);
	
	public List<StateRecord> findAllBackAuditInfo(int parentId);
	
	public StateRecord findNotPassedRecord(int parentId,Date sendDate);
}
