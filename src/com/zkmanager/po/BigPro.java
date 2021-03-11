package com.zkmanager.po;

public class BigPro {
	private int parentId;
	private int id;
	private String name;
	private String fullName;
	private Double length;
	private int contactorId;
	
	public BigPro(int parentId, int id, String name, String fullName, Double length, int contactorId) {
		super();
		this.parentId = parentId;
		this.id = id;
		this.name = name;
		this.fullName = fullName;
		this.length = length;
		this.contactorId = contactorId;
	}
	public BigPro() {
		super();
	}
	
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Double getLength() {
		return length;
	}
	public void setLength(Double length) {
		this.length = length;
	}
	public int getContactorId() {
		return contactorId;
	}
	public void setContactorId(int contactorId) {
		this.contactorId = contactorId;
	}
	
}
