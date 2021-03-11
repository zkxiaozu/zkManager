package com.zkmanager.po;

import java.util.List;

public class UnitListInfo {
	private int code;
	private String msg;
	private List<DrillingUnit> unitList;
	private List<Person> contactors;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<DrillingUnit> getUnitList() {
		return unitList;
	}
	public void setUnitList(List<DrillingUnit> unitList) {
		this.unitList = unitList;
	}
	public List<Person> getContactors() {
		return contactors;
	}
	public void setContactors(List<Person> contactors) {
		this.contactors = contactors;
	}
	@Override
	public String toString() {
		return "{"
				+ "code:" + code 
				+ ", msg:" + msg 
				+ ", unitList:" + unitList 
				+ ", contactors:" + contactors 
				+ "}";
	}
	
	

}
