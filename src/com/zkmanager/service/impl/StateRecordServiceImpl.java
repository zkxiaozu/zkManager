package com.zkmanager.service.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zkmanager.dao.DrillingRecordDao;
import com.zkmanager.dao.StateRecordDao;
import com.zkmanager.po.DrillingRecord;
import com.zkmanager.po.RoadRecord;
import com.zkmanager.po.StateRecord;
import com.zkmanager.service.DrillingRecordService;
import com.zkmanager.service.RoadRecordService;
import com.zkmanager.service.StateRecordService;

@Service("stateRecordService")
@Transactional
public class StateRecordServiceImpl implements StateRecordService {
	
	@Autowired
	private StateRecordDao stateRecordDao;

	@Override
	public StateRecord findTodayStateRecord(int parentId, Date sendDate) {
		// TODO Auto-generated method stub
		StateRecord result = this.stateRecordDao.findTodayStateRecord(parentId,sendDate);
		if(result != null) {
			return result;
		}
		return null;
	}

	@Override
	public List<StateRecord> findWeekStateRecord(int parentId) {
		// TODO Auto-generated method stub
		List<StateRecord> results = this.stateRecordDao.findWeekStateRecord(parentId);
		if(results.size()!=0) {
			return results;
		}
		return null;
	}

	@Override
	public List<StateRecord> findMonthStateRecord(int parentId) {
		// TODO Auto-generated method stub
		List<StateRecord> results = this.stateRecordDao.findMonthStateRecord(parentId);
		if(results.size()!=0) {
			return results;
		}
		return null;
	}

	@Override
	public boolean addStateRecord(StateRecord stateRecord) {
		// TODO Auto-generated method stub
		return this.stateRecordDao.addStateRecord(stateRecord);
	}
	
	@Override
	public StateRecord checkRepeatDate(int parentId, String sendDate) {
		// TODO Auto-generated method stub
		List<StateRecord> resultList = this.stateRecordDao.checkRepeatDate(parentId, sendDate);
		if(resultList.size()!=0) {
			for(int i=0;i<resultList.size();i++) {
				if(!resultList.get(i).getStage().equals("ÍË»Ø")) {
					StateRecord result = resultList.get(i);
					return result;
				}
			}
		}
		return null;
	}

	@Override
	public String findStageById(int id) {
		// TODO Auto-generated method stub
		String result = this.stateRecordDao.findStageById(id);
		if(!result.isEmpty()) {
			return result;
		}
		return null;
	}
	
	@Override
	public int findFirstCheckNumByParentId(int parentId,String stage) {
		// TODO Auto-generated method stub
		int result = this.stateRecordDao.findFirstCheckNumByParentId(parentId,stage);
		return result;
	}

	@Override
	public int findSecondCheckNumByParentId(int parentId,String stage) {
		// TODO Auto-generated method stub
		int result = this.stateRecordDao.findSecondCheckNumByParentId(parentId,stage);
		return result;
	}

	@Override
	public StateRecord findFirstAuditInfo(int parentId) {
		// TODO Auto-generated method stub
		StateRecord result = this.stateRecordDao.findFirstAuditInfo(parentId);
		if(result!=null) {
			return result;
		}
		return null;
	}
	
	@Override
	public StateRecord findSecondAuditInfo(int parentId) {
		// TODO Auto-generated method stub
		StateRecord result = this.stateRecordDao.findSecondAuditInfo(parentId);
		if(result!=null) {
			return result;
		}
		return null;
	}
	
	@Override
	public List<StateRecord> findSecondAllAuditInfo(int parentId) {
		// TODO Auto-generated method stub
		List<StateRecord> result = this.stateRecordDao.findSecondAllAuditInfo(parentId);
		return result;
	}

	@Override
	public StateRecord checkAuditRecordExist(int parentId, String sendDate, String stage) {
		// TODO Auto-generated method stub
		StateRecord result = this.stateRecordDao.checkAuditRecordExist(parentId, sendDate, stage);
		if(result != null) {
			return result;
		}
		return null;
	}

	@Override
	public boolean passFirstAuditById(int id,String state) {
		// TODO Auto-generated method stub
		boolean result = this.stateRecordDao.passFirstAuditById(id,state);
		if(result) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean passSecondDynamicAudit(int id) {
		// TODO Auto-generated method stub
		boolean result = this.stateRecordDao.passSecondDynamicAudit(id);
		if(result) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean passSecondAuditById(int id,String state) {
		// TODO Auto-generated method stub
		boolean result = this.stateRecordDao.passSecondAuditById(id,state);
		if(result) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean backAuditById(int id) {
		// TODO Auto-generated method stub
		boolean result = this.stateRecordDao.backAuditById(id);
		if(result) {
			return true;
		}
		return false;
	}

	@Override
	public StateRecord checkDynamicAuditRecordExist(int id) {
		// TODO Auto-generated method stub
		StateRecord result = this.stateRecordDao.checkDynamicAuditRecordExist(id);
		return result;
	}

	@Override
	public List<StateRecord> findAllPassAuditInfo(int parentId) {
		// TODO Auto-generated method stub
		List<StateRecord> result = this.stateRecordDao.findAllPassAuditInfo(parentId);
		return result;
	}

	@Override
	public List<StateRecord> findAllBackAuditInfo(int parentId) {
		// TODO Auto-generated method stub
		List<StateRecord> result = this.stateRecordDao.findAllBackAuditInfo(parentId);
		return result;
	}

	@Override
	public StateRecord findNotPassedRecord(int parentId, Date sendDate) {
		// TODO Auto-generated method stub
		StateRecord result = this.stateRecordDao.findNotPassedRecord(parentId,sendDate);
		if(result != null) {
			return result;
		}
		return null;
	}
}
