package com.zkmanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zkmanager.dao.ObjectDao;
import com.zkmanager.po.ObjectTable;
import com.zkmanager.service.ObjectService;

@Service("objectService")
@Transactional
public class ObjectServiceImpl implements ObjectService {
	
	@Autowired
	private ObjectDao objectDao;

	@Override
	public ObjectTable findTypeById(int id) {
		// TODO Auto-generated method stub
		ObjectTable result = this.objectDao.findTypeById(id);
		if (result != null) {
			return result;
		}
		return null;
	}

	@Override
	public boolean addObject(String type) {
		// TODO Auto-generated method stub
		boolean result = this.objectDao.addObject(type);
		if (result) {
			return true;
		}
		return false;
	}

	@Override
	public ObjectTable findNewObject() {
		// TODO Auto-generated method stub
		ObjectTable result = this.objectDao.findNewObject();
		if (result !=null) {
			return result;
		}
		return null;
	}

}
