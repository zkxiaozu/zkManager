package com.zkmanager.service;

import com.zkmanager.po.Person;

public interface PersonService {
	public Person findPersonByNameAndPassword(String name,String password);
	
	public Person findContactorById(int id);
	
	public Integer findIdByName(String name);
}
