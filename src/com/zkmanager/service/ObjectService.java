package com.zkmanager.service;

import org.apache.ibatis.annotations.Param;

import com.zkmanager.po.ObjectTable;
import com.zkmanager.po.Person;

public interface ObjectService {

	public ObjectTable findTypeById(int id);
	
	public boolean addObject(String type);
	
	public ObjectTable findNewObject();
}
