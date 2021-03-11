package com.zkmanager.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zkmanager.po.LoginList;
import com.zkmanager.po.ObjectTable;
import com.zkmanager.po.Person;
import com.zkmanager.service.ObjectService;
import com.zkmanager.service.PersonService;

@Controller
public class LoginController {
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private ObjectService objectService;
	
	@RequestMapping(value="/loginSystem",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public LoginList Login(String name,String password){
		System.out.println("第一行");
		System.out.println(name+"+"+password);
		LoginList lList = new LoginList();
		Person pList = personService.findPersonByNameAndPassword(name, password);
		System.out.println("第二行");
		System.out.println(pList);
		if(pList != null) {
			ObjectTable object = objectService.findTypeById(pList.getId());
			lList.setObject(object);
			lList.setPerson(pList);
			lList.setCode(200);
			System.out.println(lList);
			return lList;
		}
		lList.setCode(0);
		return lList;
	}
	
	
}
