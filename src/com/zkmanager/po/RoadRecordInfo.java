package com.zkmanager.po;

import java.util.List;

public class RoadRecordInfo {
	private int code;
	private String msg;
	private RoadRecord notPassedRecord;
	private int firstCheckNum;
	private int secondCheckNum;
	private RoadRecord todayRecord;
	private List<RoadRecord> weekRecord;
	private List<RoadRecord> monthRecord;
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
	public RoadRecord getNotPassedRecord() {
		return notPassedRecord;
	}
	public void setNotPassedRecord(RoadRecord notPassedRecord) {
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
	public RoadRecord getTodayRecord() {
		return todayRecord;
	}
	public void setTodayRecord(RoadRecord todayRecord) {
		this.todayRecord = todayRecord;
	}
	public List<RoadRecord> getWeekRecord() {
		return weekRecord;
	}
	public void setWeekRecord(List<RoadRecord> weekRecord) {
		this.weekRecord = weekRecord;
	}
	public List<RoadRecord> getMonthRecord() {
		return monthRecord;
	}
	public void setMonthRecord(List<RoadRecord> monthRecord) {
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
