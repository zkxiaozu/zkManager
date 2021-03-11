package com.zkmanager.po;

import java.sql.Date;

public class DrillingRecord {
	private int id;
	private int parentId;
	private String sendDate;
	private double zking;
	private double footage;
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
	public double getZking() {
		return zking;
	}
	public void setZking(double zking) {
		this.zking = zking;
	}
	public double getFootage() {
		return footage;
	}
	public void setFootage(double footage) {
		this.footage = footage;
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
				+ ", zking:" + zking
				+ ", isChecked:" + isChecked 
				+ ", stage:" + stage 
				+ "}";
	}

}
