package com.zkmanager.service.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zkmanager.dao.DrillingRecordDao;
import com.zkmanager.po.DrillingRecord;
import com.zkmanager.po.RoadRecord;
import com.zkmanager.service.DrillingRecordService;
import com.zkmanager.service.RoadRecordService;

@Service("drillingRecordService")
@Transactional
public class DrillingRecordServiceImpl implements DrillingRecordService {
	
	@Autowired
	private DrillingRecordDao drillingRecordDao;

	@Override
	public DrillingRecord findTodayDrillingRecord(int parentId, Date sendDate) {
		// TODO Auto-generated method stub
		DrillingRecord result = this.drillingRecordDao.findTodayDrillingRecord(parentId,sendDate);
		if(result != null) {
			return result;
		}
		return null;
	}

	@Override
	public List<DrillingRecord> findWeekDrillingRecord(int parentId) {
		// TODO Auto-generated method stub
		List<DrillingRecord> results = this.drillingRecordDao.findWeekDrillingRecord(parentId);
		if(results.size()!=0) {
			return results;
		}
		return null;
	}

	@Override
	public List<DrillingRecord> findMonthDrillingRecord(int parentId) {
		// TODO Auto-generated method stub
		List<DrillingRecord> results = this.drillingRecordDao.findMonthDrillingRecord(parentId);
		if(results.size()!=0) {
			return results;
		}
		return null;
	}

	@Override
	public boolean addDrillingRecord(DrillingRecord drillingRecord) {
		// TODO Auto-generated method stub
		return this.drillingRecordDao.addDrillingRecord(drillingRecord);
	}

	@Override
	public DrillingRecord checkRepeatDate(int parentId, String sendDate) {
		// TODO Auto-generated method stub
		DrillingRecord result = this.drillingRecordDao.checkRepeatDate(parentId, sendDate);
		if(result != null) {
			return result;
		}
		return null;
	}

	@Override
	public String findStageById(int id) {
		// TODO Auto-generated method stub
		String result = this.drillingRecordDao.findStageById(id);
		if(!result.isEmpty()) {
			return result;
		}
		return null;
	}
	
	@Override
	public int findFirstCheckNumByParentId(int parentId,String stage) {
		// TODO Auto-generated method stub
		int result = this.drillingRecordDao.findFirstCheckNumByParentId(parentId,stage);
		return result;
	}

	@Override
	public int findSecondCheckNumByParentId(int parentId,String stage) {
		// TODO Auto-generated method stub
		int result = this.drillingRecordDao.findSecondCheckNumByParentId(parentId,stage);
		return result;
	}
	
	@Override
	public DrillingRecord findFirstAuditInfo(int parentId) {
		// TODO Auto-generated method stub
		DrillingRecord result = this.drillingRecordDao.findFirstAuditInfo(parentId);
		if(result!=null) {
			return result;
		}
		return null;
	}
	
	@Override
	public DrillingRecord findSecondAuditInfo(int parentId) {
		// TODO Auto-generated method stub
		DrillingRecord result = this.drillingRecordDao.findSecondAuditInfo(parentId);
		if(result!=null) {
			return result;
		}
		return null;
	}
	
	@Override
	public List<DrillingRecord> findSecondAllAuditInfo(int parentId) {
		// TODO Auto-generated method stub
		List<DrillingRecord> result = this.drillingRecordDao.findSecondAllAuditInfo(parentId);
		return result;
	}

	@Override
	public DrillingRecord checkAuditRecordExist(int parentId, String sendDate, String stage) {
		// TODO Auto-generated method stub
		DrillingRecord result = this.drillingRecordDao.checkAuditRecordExist(parentId, sendDate, stage);
		if(result != null) {
			return result;
		}
		return null;
	}

	@Override
	public boolean passFirstAuditById(int id,double zking) {
		// TODO Auto-generated method stub
		boolean result = this.drillingRecordDao.passFirstAuditById(id,zking);
		if(result) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean passSecondDynamicAudit(int id,double footage) {
		// TODO Auto-generated method stub
		boolean result = this.drillingRecordDao.passSecondDynamicAudit(id,footage);
		if(result) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean passSecondAuditById(int id,double zking,double footage) {
		// TODO Auto-generated method stub
		boolean result = this.drillingRecordDao.passSecondAuditById(id,zking,footage);
		if(result) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean backAuditById(int id) {
		// TODO Auto-generated method stub
		boolean result = this.drillingRecordDao.backAuditById(id);
		if(result) {
			return true;
		}
		return false;
	}

	@Override
	public DrillingRecord checkDynamicAuditRecordExist(int id) {
		// TODO Auto-generated method stub
		DrillingRecord result = this.drillingRecordDao.checkDynamicAuditRecordExist(id);
		return result;
	}

	@Override
	public List<DrillingRecord> findAllPassAuditInfo(int parentId) {
		// TODO Auto-generated method stub
		List<DrillingRecord> result = this.drillingRecordDao.findAllPassAuditInfo(parentId);
		return result;
	}
	
	@Override
	public List<DrillingRecord> findAllBackAuditInfo(int parentId) {
		// TODO Auto-generated method stub
		List<DrillingRecord> result = this.drillingRecordDao.findAllBackAuditInfo(parentId);
		return result;
	}

	@Override
	public DrillingRecord findNotPassedRecord(int parentId, Date sendDate) {
		// TODO Auto-generated method stub
		DrillingRecord result = this.drillingRecordDao.findNotPassedRecord(parentId,sendDate);
		if(result != null) {
			return result;
		}
		return null;
	}

	@Override
	public DrillingRecord findLastRecordById(int id) {
		// TODO Auto-generated method stub
		DrillingRecord result = this.drillingRecordDao.findLastRecordById(id);
		if(result != null) {
			return result;
		}
		return null;
	}

}
