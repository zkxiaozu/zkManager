package com.zkmanager.dao;

import java.sql.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.zkmanager.po.DrillingRecord;
import com.zkmanager.po.RoadRecord;

public interface DrillingRecordDao {
	public DrillingRecord findTodayDrillingRecord(@Param("parentId") int parentId
			,@Param("sendDate") Date sendDate);
	
	public List<DrillingRecord> findWeekDrillingRecord(@Param("parentId") int parentId);
	
	public List<DrillingRecord> findMonthDrillingRecord(@Param("parentId") int parentId);
	
	public boolean addDrillingRecord(DrillingRecord drillingRecord);
	
	public DrillingRecord checkRepeatDate(@Param("parentId") int parentId
			,@Param("sendDate") String sendDate);
	
	public String findStageById(@Param("id") int id);
	
	public int findFirstCheckNumByParentId(@Param("parentId") int parentId,@Param("stage") String stage);
	
	public int findSecondCheckNumByParentId(@Param("parentId") int parentId,@Param("stage") String stage);
	
	public DrillingRecord findFirstAuditInfo(@Param("parentId") int parentId);
	
	public DrillingRecord findSecondAuditInfo(@Param("parentId") int parentId);
	
	public List<DrillingRecord> findSecondAllAuditInfo(@Param("parentId") int parentId);
	
	public DrillingRecord checkAuditRecordExist(@Param("parentId") int parentId
			,@Param("sendDate") String sendDate,@Param("stage") String stage);
	
	public boolean passFirstAuditById(@Param("id") int id,@Param("zking") double zking);
	
	public boolean passSecondDynamicAudit(@Param("id") int id,@Param("footage") double footage);
	
	public boolean passSecondAuditById(@Param("id") int id
			,@Param("zking") double zking,@Param("footage") double footage);
	
	public boolean backAuditById(@Param("id") int id);
	
	public DrillingRecord checkDynamicAuditRecordExist(@Param("id") int id);
	
	public List<DrillingRecord> findAllPassAuditInfo(@Param("parentId") int parentId);
	
	public List<DrillingRecord> findAllBackAuditInfo(@Param("parentId") int parentId);
	
	public DrillingRecord findNotPassedRecord(@Param("parentId") int parentId
			,@Param("sendDate") Date sendDate);
	
	public DrillingRecord findLastRecordById(@Param("id") int id);
}
