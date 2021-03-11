package com.zkmanager.po;

import java.sql.Date;
import com.alibaba.fastjson.annotation.JSONField;

public class RoadRecord {
	private int id;
	private int parentId;
	
	@JSONField(format="yyyy-MM-dd")
	private String sendDate;
	
	private double roading;
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
	public double getRoading() {
		return roading;
	}
	public void setRoading(double roading) {
		this.roading = roading;
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
				+ ", roading:" + roading
				+ ", isChecked:" + isChecked 
				+ ", stage:" + stage 
				+ "}";
	}
	
}
