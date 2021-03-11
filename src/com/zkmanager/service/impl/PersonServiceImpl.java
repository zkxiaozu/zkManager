package com.zkmanager.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zkmanager.dao.PersonDao;
import com.zkmanager.po.Person;
import com.zkmanager.service.PersonService;

@Service("personService")
@Transactional
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonDao personDao;

	@Override
	public Person findPersonByNameAndPassword(String name, String password) {
		// TODO Auto-generated method stub
		Person result = this.personDao.findPersonByNameAndPassword(name, password);
		if (result !=null) {
			return result;
		}
		return null;
	}

	@Override
	public Person findContactorById(int id) {
		// TODO Auto-generated method stub
		Person result = this.personDao.findContactorById(id);
		if(result!=null) {
			return result;
		}
		return null;
	}
	
}
