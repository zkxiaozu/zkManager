package com.zkmanager.po;

//Ëù
public class Suo {
	private Integer parentId;
	private Integer id;
	private String name;
	private String fullName;
	private Integer contactorId;
	
	public Suo(Integer parentId, Integer id, String name, String fullName, Integer contactorId) {
		super();
		this.parentId = parentId;
		this.id = id;
		this.name = name;
		this.fullName = fullName;
		this.contactorId = contactorId;
	}
	public Suo() {
		super();
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
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
	public Integer getContactorId() {
		return contactorId;
	}
	public void setContactorId(Integer contactorId) {
		this.contactorId = contactorId;
	}
	
	
}
