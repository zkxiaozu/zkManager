package com.zkmanager.dao;

import org.apache.ibatis.annotations.Param;
import com.zkmanager.po.Person;

public interface PersonDao {
	
	public Person findPersonByNameAndPassword(@Param("name") String name
			,@Param("password") String password);
	
	public Person findContactorById(@Param("id") int id);
	
	public Integer findIdByName(@Param("name") String name);
	
}
