package com.zkmanager.po;

import java.util.List;

public class DrillingRecordInfo {
	private int code;
	private String msg;
	private DrillingRecord notPassedRecord;
	private int firstCheckNum;
	private int secondCheckNum;
	private DrillingRecord todayRecord;
	private List<DrillingRecord> weekRecord;
	private List<DrillingRecord> monthRecord;
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
	
	public DrillingRecord getNotPassedRecord() {
		return notPassedRecord;
	}
	public void setNotPassedRecord(DrillingRecord notPassedRecord) {
		this.notPassedRecord = notPassedRecord;
	}
	public int getFirstCheckNum() {
		return firstCheckNum;
	}
	public void setFirstCheckNum(int firstCheckNum) {
		this.firstCheckNum = firstCheckNum;
	}
	public int getSecondCheckNum() {
		return secondCheckNum;
	}
	public void setSecondCheckNum(int secondCheckNum) {
		this.secondCheckNum = secondCheckNum;
	}
	public DrillingRecord getTodayRecord() {
		return todayRecord;
	}
	public void setTodayRecord(DrillingRecord todayRecord) {
		this.todayRecord = todayRecord;
	}
	public List<DrillingRecord> getWeekRecord() {
		return weekRecord;
	}
	public void setWeekRecord(List<DrillingRecord> weekRecord) {
		this.weekRecord = weekRecord;
	}
	public List<DrillingRecord> getMonthRecord() {
		return monthRecord;
	}
	public void setMonthRecord(List<DrillingRecord> monthRecord) {
		this.monthRecord = monthRecord;
	}
	@Override
	public String toString() {
		return "{"
				+ "code:" + code 
				+ ", msg:" + msg 
				+ ", firstCheckNum:" + firstCheckNum 
				+ ", secondCheckNum:" + secondCheckNum
				+ ", todayRecord:" + todayRecord 
				+ ", weekRecord:" + weekRecord 
				+ ", monthRecord:" + monthRecord 
				+ "}";
	}
	
	
}
