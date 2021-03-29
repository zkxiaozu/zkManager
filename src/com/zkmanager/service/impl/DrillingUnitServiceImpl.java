package com.zkmanager.service.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zkmanager.dao.DrillingUnitDao;
import com.zkmanager.po.DrillingRecord;
import com.zkmanager.po.DrillingUnit;
import com.zkmanager.service.DrillingUnitService;

@Service("drillingUnitService")
@Transactional
public class DrillingUnitServiceImpl implements DrillingUnitService {
	
	@Autowired
	private DrillingUnitDao drillingUnitDao;

	@Override
	public DrillingUnit findDrillingUnitById(int id) {
		// TODO Auto-generated method stub
		DrillingUnit result = this.drillingUnitDao.findDrillingUnitById(id);
		if(result!=null) {
			return result;
		}
		return null;
	}

	@Override
	public List<DrillingUnit> findDrillingUnitByParentId(int parentId) {
		// TODO Auto-generated method stub
		List<DrillingUnit> result = this.drillingUnitDao.findDrillingUnitByParentId(parentId);
		return result;
	}

	@Override
	public Integer findDrillingUnitIdByFullName(String fullname) {
		// TODO Auto-generated method stub
		Integer id = drillingUnitDao.findDrillingUnitIdByFullName(fullname);
		return id;
	}

	@Override
	public Integer findParentIdByFullName(String fullname) {
		// TODO Auto-generated method stub
		Integer parentId = drillingUnitDao.findParentIdByFullName(fullname);
		return parentId;
	}

	@Override
	public Integer findDrillingUnitByFullName(String fullname) {
		// TODO Auto-generated method stub
		Integer count = drillingUnitDao.findDrillingUnitByFullName(fullname);
		return count;
	}

	@Override
	public Boolean insertDrillingUnit(DrillingUnit unit) {
		// TODO Auto-generated method stub
		Boolean isInserted = drillingUnitDao.insertDrillingUnit(unit);
		return isInserted;
	}

	@Override
	public Integer updateDrillingUnit(Double length, Integer id) {
		// TODO Auto-generated method stub
		Integer count = drillingUnitDao.updateDrillingUnit(length, id);
		return count;
	}

	@Override
	public Double findDrillingUnitLengthByid(Integer id) {
		// TODO Auto-generated method stub
		Double length = drillingUnitDao.findDrillingUnitLengthByid(id);
		return length;
	}
	
	
	
	

}
