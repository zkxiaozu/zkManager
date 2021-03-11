package com.zkmanager.po;

public class Hole {
	private int id;
	private String name;
	private int parentId;
	private int parentId2;
	private String type;
	private double designDeep;
	private double designOffset;
	private double designRoadLength;
	private double x;
	private double y;
	private double z;
	private double railFootage;
	private double railLength;
	private double railDepth;
	private String railState;
	
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
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public int getParentId2() {
		return parentId2;
	}
	public void setParentId2(int parentId2) {
		this.parentId2 = parentId2;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getDesignDeep() {
		return designDeep;
	}
	public void setDesignDeep(double designDeep) {
		this.designDeep = designDeep;
	}
	public double getDesignOffset() {
		return designOffset;
	}
	public void setDesignOffset(double designOffset) {
		this.designOffset = designOffset;
	}
	public double getDesignRoadLength() {
		return designRoadLength;
	}
	public void setDesignRoadLength(double designRoadLength) {
		this.designRoadLength = designRoadLength;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	public double getZ() {
		return z;
	}
	public void setZ(double z) {
		this.z = z;
	}
	public double getRailFootage() {
		return railFootage;
	}
	public void setRailFootage(double railFootage) {
		this.railFootage = railFootage;
	}
	public double getRailLength() {
		return railLength;
	}
	public void setRailLength(double railLength) {
		this.railLength = railLength;
	}
	public double getRailDepth() {
		return railDepth;
	}
	public void setRailDepth(double railDepth) {
		this.railDepth = railDepth;
	}
	public String getRailState() {
		return railState;
	}
	public void setRailState(String railState) {
		this.railState = railState;
	}
	@Override
	public String toString() {
		return "{" 
	            + "id:" + id 
				+ ", name:" + name 
				+ ", parentId:" + parentId
				+ ", parentId2:" + parentId2 
				+ ", type:" + type
				+ ", designDeep:" + designDeep 
				+ ", designOffset:" + designOffset
				+ ", designRoadLength:" + designRoadLength 
				+ ", x:" + x 
				+ ", y:" + y 
				+ ", z:" + z 
				+ ", railLength:" + railLength
				+ ", railDepth:" + railDepth 
				+ ", railState:" + railState +
				"}";
	}
	
	
	
}
