package com.zkmanager.po;

import java.util.Map;

public class UPOverviewInfo {
	private int code;
	private String msg;
	private DrillingUnit unit;
	private WorkPoint point;
	private Person contactor;
	private Map<String, Statistician> statisticians;
	
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
	public DrillingUnit getUnit() {
		return unit;
	}
	public void setUnit(DrillingUnit unit) {
		this.unit = unit;
	}
	public WorkPoint getPoint() {
		return point;
	}
	public void setPoint(WorkPoint point) {
		this.point = point;
	}
	public Person getContactor() {
		return contactor;
	}
	public void setContactor(Person contactor) {
		this.contactor = contactor;
	}
	
	public Map<String, Statistician> getStatisticians() {
		return statisticians;
	}
	public void setStatisticians(Map<String, Statistician> statisticians) {
		this.statisticians = statisticians;
	}
	@Override
	public String toString() {
		return "{"
				+ "code:" + code 
				+ ", msg:" + msg 
				+ ", unit:" + unit 
				+ ", point:" + point
				+ ", contactor:" + contactor
				+ ", statisticians:" + statisticians
				+ "}";
	}
	
	
	
}
