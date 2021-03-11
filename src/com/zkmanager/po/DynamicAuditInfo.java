package com.zkmanager.po;

import java.util.List;

public class DynamicAuditInfo {
	private int code;
	private String msg;
	private List<RoadRecord> rRecord;
	private List<DrillingRecord> dRecord;
	private List<StateRecord> sRecord;
	private List<Hole> rHole;
	private List<Hole> dHole;
	private List<Hole> sHole;
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
	public List<RoadRecord> getrRecord() {
		return rRecord;
	}
	public void setrRecord(List<RoadRecord> rRecord) {
		this.rRecord = rRecord;
	}
	public List<DrillingRecord> getdRecord() {
		return dRecord;
	}
	public void setdRecord(List<DrillingRecord> dRecord) {
		this.dRecord = dRecord;
	}
	public List<StateRecord> getsRecord() {
		return sRecord;
	}
	public void setsRecord(List<StateRecord> sRecord) {
		this.sRecord = sRecord;
	}
	public List<Hole> getrHole() {
		return rHole;
	}
	public void setrHole(List<Hole> rHole) {
		this.rHole = rHole;
	}
	public List<Hole> getdHole() {
		return dHole;
	}
	public void setdHole(List<Hole> dHole) {
		this.dHole = dHole;
	}
	public List<Hole> getsHole() {
		return sHole;
	}
	public void setsHole(List<Hole> sHole) {
		this.sHole = sHole;
	}
	@Override
	public String toString() {
		return "{"
				+ "code:" + code 
				+ ", msg:" + msg 
				+ ", rRecord:" + rRecord 
				+ ", dRecord:" + dRecord
				+ ", sRecord:" + sRecord 
				+ ", rHole:" + rHole 
				+ ", dHole:" + dHole 
				+ ", sHole:" + sHole 
				+ "}";
	}
	
	
}
