package com.zkmanager.po;

//地质组
public class GeoGroup {
	private int parentId;
	private int id;
	private String name;
	private String fullName;
	private Double length;
	private int contactorId;
	
	public GeoGroup() {
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
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public void setName(String name) {
		this.name = name;
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
