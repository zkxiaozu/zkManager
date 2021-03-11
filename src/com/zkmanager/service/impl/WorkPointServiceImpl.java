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

	
}
