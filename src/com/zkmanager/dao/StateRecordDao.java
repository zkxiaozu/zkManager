package com.zkmanager.dao;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zkmanager.po.StateRecord;

public interface StateRecordDao {
	public StateRecord findTodayStateRecord(@Param("parentId") int parentId
			,@Param("sendDate") Date sendDate);
	
	public List<StateRecord> findWeekStateRecord(@Param("parentId") int parentId);
	
	public List<StateRecord> findMonthStateRecord(@Param("parentId") int parentId);
	
	public boolean addStateRecord(StateRecord stateRecord);
	
	public List<StateRecord> checkRepeatDate(@Param("parentId") int parentId
			,@Param("sendDate") String sendDate);
	
	public String findStageById(@Param("id") int id);
	
	public int findFirstCheckNumByParentId(@Param("parentId") int parentId,@Param("stage") String stage);
	
	public int findSecondCheckNumByParentId(@Param("parentId") int parentId,@Param("stage") String stage);

	public StateRecord findFirstAuditInfo(@Param("parentId") int parentId);
	
	public StateRecord findSecondAuditInfo(@Param("parentId") int parentId);
	
	public List<StateRecord> findSecondAllAuditInfo(@Param("parentId") int parentId);
	
	public StateRecord checkAuditRecordExist(@Param("parentId") int parentId
			,@Param("sendDate") String sendDate,@Param("stage") String stage);
	
	public boolean passFirstAuditById(@Param("id") int id,@Param("state") String state);
	
	public boolean passSecondDynamicAudit(@Param("id") int id);
	
	public boolean passSecondAuditById(@Param("id") int id,@Param("state") String state);
	
	public boolean backAuditById(@Param("id") int id);
	
	public StateRecord checkDynamicAuditRecordExist(@Param("id") int id);
	
	public List<StateRecord> findAllPassAuditInfo(@Param("parentId") int parentId);
	
	public List<StateRecord> findAllBackAuditInfo(@Param("parentId") int parentId);
	
	public StateRecord findNotPassedRecord(@Param("parentId") int parentId
			,@Param("sendDate") Date sendDate);
}
