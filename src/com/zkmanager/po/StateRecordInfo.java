package com.zkmanager.po;

import java.util.List;

public class StateRecordInfo {
	private int code;
	private String msg;
	private StateRecord notPassedRecord;
	private int firstCheckNum;
	private int secondCheckNum;
	private StateRecord todayRecord;
	private List<StateRecord> weekRecord;
	private List<StateRecord> monthRecord;
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
	
	public StateRecord getNotPassedRecord() {
		return notPassedRecord;
	}
	public void setNotPassedRecord(StateRecord notPassedRecord) {
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
	public StateRecord getTodayRecord() {
		return todayRecord;
	}
	public void setTodayRecord(StateRecord todayRecord) {
		this.todayRecord = todayRecord;
	}
	public List<StateRecord> getWeekRecord() {
		return weekRecord;
	}
	public void setWeekRecord(List<StateRecord> weekRecord) {
		this.weekRecord = weekRecord;
	}
	public List<StateRecord> getMonthRecord() {
		return monthRecord;
	}
	public void setMonthRecord(List<StateRecord> monthRecord) {
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
