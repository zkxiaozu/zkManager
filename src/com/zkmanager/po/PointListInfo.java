package com.zkmanager.po;

import java.util.List;

public class PointListInfo {
	private int code;
	private String msg;
	private List<WorkPoint> pointList;
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
	public List<WorkPoint> getPointList() {
		return pointList;
	}
	public void setPointList(List<WorkPoint> pointList) {
		this.pointList = pointList;
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
				+ ", pointList:" + pointList 
				+ ", contactors:" + contactors 
				+ "}";
	}
	
	

}
