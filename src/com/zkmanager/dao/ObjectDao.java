package com.zkmanager.dao;

import org.apache.ibatis.annotations.Param;

import com.zkmanager.po.ObjectTable;
import com.zkmanager.po.Person;

public interface ObjectDao {
	public ObjectTable findTypeById(@Param("id") int id);
	
	public boolean addObject(@Param("type") String type);
	
	public ObjectTable findNewObject();
}
