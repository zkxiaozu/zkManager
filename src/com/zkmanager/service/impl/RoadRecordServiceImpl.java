package com.zkmanager.service.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zkmanager.dao.RoadRecordDao;
import com.zkmanager.po.RoadRecord;
import com.zkmanager.service.RoadRecordService;

@Service("roadRecordService")
@Transactional
public class RoadRecordServiceImpl implements RoadRecordService {
	
	@Autowired
	private RoadRecordDao roadRecordDao;

	@Override
	public RoadRecord findTodayRoadRecord(int parentId, Date sendDate) {
		// TODO Auto-generated method stub
		RoadRecord result = this.roadRecordDao.findTodayRoadRecord(parentId,sendDate);
		if(result != null) {
			return result;
		}
		return null;
	}

	@Override
	public List<RoadRecord> findWeekRoadRecord(int parentId) {
		// TODO Auto-generated method stub
		List<RoadRecord> results = this.roadRecordDao.findWeekRoadRecord(parentId);
		if(results.size()!=0) {
			return results;
		}
		return null;
	}

	@Override
	public List<RoadRecord> findMonthRoadRecord(int parentId) {
		// TODO Auto-generated method stub
		List<RoadRecord> results = this.roadRecordDao.findMonthRoadRecord(parentId);
		if(results.size()!=0) {
			return results;
		}
		return null;
	}

	@Override
	public boolean addRoadRecord(RoadRecord roadRecord) {
		// TODO Auto-generated method stub
		boolean result = this.roadRecordDao.addRoadRecord(roadRecord);
		if(result) {
			return true;
		}
		return false;
	}

	@Override
	public RoadRecord checkRepeatDate(int parentId, String sendDate) {
		// TODO Auto-generated method stub
		List<RoadRecord> resultList = this.roadRecordDao.checkRepeatDate(parentId, sendDate);
		if(resultList.size()!=0) {
			for(int i=0;i<resultList.size();i++) {
				if(!resultList.get(i).getStage().equals("ÍË»Ø")) {
					RoadRecord result = resultList.get(i);
					return result;
				}
			}
		}
		return null;
	}

	@Override
	public String findStageById(int id) {
		// TODO Auto-generated method stub
		String result = this.roadRecordDao.findStageById(id);
		if(!result.isEmpty()) {
			return result;
		}
		return null;
	}

	@Override
	public int findFirstCheckNumByParentId(int parentId,String stage) {
		// TODO Auto-generated method stub
		int result = this.roadRecordDao.findFirstCheckNumByParentId(parentId,stage);
		return result;
	}

	@Override
	public int findSecondCheckNumByParentId(int parentId,String stage) {
		// TODO Auto-generated method stub
		int result = this.roadRecordDao.findSecondCheckNumByParentId(parentId,stage);
		return result;
	}

	@Override
	public RoadRecord findFirstAuditInfo(int parentId) {
		// TODO Auto-generated method stub
		RoadRecord result = this.roadRecordDao.findFirstAuditInfo(parentId);
		if(result!=null) {
			return result;
		}
		return null;
	}
	
	@Override
	public RoadRecord findSecondAuditInfo(int parentId) {
		// TODO Auto-generated method stub
		RoadRecord result = this.roadRecordDao.findSecondAuditInfo(parentId);
		if(result!=null) {
			return result;
		}
		return null;
	}
	
	@Override
	public List<RoadRecord> findSecondAllAuditInfo(int parentId) {
		// TODO Auto-generated method stub
		List<RoadRecord> result = this.roadRecordDao.findSecondAllAuditInfo(parentId);
		return result;
	}

	@Override
	public RoadRecord checkAuditRecordExist(int parentId, String sendDate, String stage) {
		// TODO Auto-generated method stub
		RoadRecord result = this.roadRecordDao.checkAuditRecordExist(parentId, sendDate, stage);
		if(result != null) {
			return result;
		}
		return null;
	}

	@Override
	public boolean passFirstAuditById(int id,double roading) {
		// TODO Auto-generated method stub
		boolean result = this.roadRecordDao.passFirstAuditById(id,roading);
		if(result) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean passSecondDynamicAudit(int id) {
		// TODO Auto-generated method stub
		boolean result = this.roadRecordDao.passSecondDynamicAudit(id);
		if(result) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean passSecondAuditById(int id,double roading) {
		// TODO Auto-generated method stub
		boolean result = this.roadRecordDao.passSecondAuditById(id,roading);
		if(result) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean backAuditById(int id) {
		// TODO Auto-generated method stub
		boolean result = this.roadRecordDao.backAuditById(id);
		if(result) {
			return true;
		}
		return false;
	}

	@Override
	public RoadRecord checkDynamicAuditRecordExist(int id) {
		// TODO Auto-generated method stub
		RoadRecord result = this.roadRecordDao.checkDynamicAuditRecordExist(id);
		return result;
	}

	@Override
	public List<RoadRecord> findAllPassAuditInfo(int parentId) {
		// TODO Auto-generated method stub
		List<RoadRecord> result = this.roadRecordDao.findAllPassAuditInfo(parentId);
		return result;
	}

	@Override
	public List<RoadRecord> findAllBackAuditInfo(int parentId) {
		// TODO Auto-generated method stub
		List<RoadRecord> result = this.roadRecordDao.findAllBackAuditInfo(parentId);
		return result;
	}

	@Override
	public RoadRecord findNotPassedRoadRecord(int parentId, Date sendDate) {
		// TODO Auto-generated method stub
		RoadRecord result = this.roadRecordDao.findNotPassedRoadRecord(parentId,sendDate);
		if(result != null) {
			return result;
		}
		return null;
	}

}
