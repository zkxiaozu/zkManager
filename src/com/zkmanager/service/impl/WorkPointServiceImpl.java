package com.zkmanager.service.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zkmanager.dao.WorkPointDao;
import com.zkmanager.po.WorkPoint;
import com.zkmanager.service.WorkPointService;

@Service("workPointService")
@Transactional
public class WorkPointServiceImpl implements WorkPointService {
	
	@Autowired
	private WorkPointDao workPointDao;

	@Override
	public WorkPoint findWorkPointById(int id) {
		// TODO Auto-generated method stub
		WorkPoint result = this.workPointDao.findWorkPointById(id);
		if(result!=null) {
			return result;
		}
		return null;
	}

	@Override
	public List<WorkPoint> findWorkPointByParentId(int parentId) {
		// TODO Auto-generated method stub
		List<WorkPoint> result = this.workPointDao.findWorkPointByParentId(parentId);
		return result;
	}

	@Override
	public Integer findWorkPointIdByFullName(String fullname) {
		// TODO Auto-generated method stub
		Integer id = workPointDao.findWorkPointIdByFullName(fullname);
		return id;
	}

	@Override
	public Boolean insertWorkPoint(WorkPoint workPoint) {
		// TODO Auto-generated method stub
		Boolean result = workPointDao.insertWorkPoint(workPoint);
		return result;
	}

	@Override
	public Integer updateWorkPoint(Double length, Integer id) {
		// TODO Auto-generated method stub
		Integer result = workPointDao.updateWorkPoint(length, id);
		return result;
	}

	@Override
	public Double findWorkPointLengthById(Integer id) {
		// TODO Auto-generated method stub
		Double result = workPointDao.findWorkPointLengthById(id);
		return result;
	}
	
	
}
