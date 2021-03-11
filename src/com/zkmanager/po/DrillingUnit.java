package com.zkmanager.po;

public class DrillingUnit {
	private int id;
	private int parentId;
	private String name;
	private String fullName;
	private double length;
	private int contactorId;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public int getContactorId() {
		return contactorId;
	}
	public void setContactorId(int contactorId) {
		this.contactorId = contactorId;
	}
	@Override
	public String toString() {
		return "{"
				+ "id:" + id 
				+ ", parentId:" + parentId 
				+ ", name:" + name 
				+ ", fullName:" + fullName
				+ ", length:" + length 
				+ ", contactorId:" + contactorId 
				+ "}";
	}
	
}
