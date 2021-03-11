package com.zkmanager.po;

import java.sql.Date;

public class StateRecord {
	private int id;
	private int parentId;
	private String sendDate;
	private String state;
	private boolean isChecked;
	private String stage;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String getSendDate() {
		return sendDate;
	}
	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public boolean isChecked() {
		return isChecked;
	}
	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}
	
	public String getStage() {
		return stage;
	}
	public void setStage(String stage) {
		this.stage = stage;
	}
	@Override
	public String toString() {
		return "{"
				+ "id:" + id 
				+ ", parentId:" + parentId 
				+ ", sendDate:" + sendDate 
				+ ", state:" + state
				+ ", isChecked:" + isChecked 
				+ ", stage:" + stage 
				+ "}";
	}
}
