package com.zkmanager.service;

import org.apache.ibatis.annotations.Param;

import com.zkmanager.po.Person;

public interface PersonService {
	public Person findPersonByNameAndPassword(String name,String password);
	
	public Person findContactorById(int id);
}
