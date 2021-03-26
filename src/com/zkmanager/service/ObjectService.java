package com.zkmanager.service;

import com.zkmanager.po.ObjectTable;

public interface ObjectService {

	public ObjectTable findTypeById(int id);
	
	public boolean addObject(String type);
	
	public ObjectTable findNewObject();
	
	public Integer insertObject(String type);
}
