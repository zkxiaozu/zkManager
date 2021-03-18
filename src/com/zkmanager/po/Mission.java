package com.zkmanager.po;

public class Mission {
	private String zkNum;//钻孔编号
	private String littleProName;//工程名称
	private Double railLength;//钻孔里程
	private Double designOffset;//偏距
	private Double x;//坐标
	private Double y;//坐标
	private Double designDeep;//设计深度
	private String type;//类型
	private String receiver;//接收单位
	public Mission(String zkNum, String littleProName, Double railLength, Double designOffset, Double x, Double y,
			Double designDeep, String type, String receiver) {
		super();
		this.zkNum = zkNum;
		this.littleProName = littleProName;
		this.railLength = railLength;
		this.designOffset = designOffset;
		this.x = x;
		this.y = y;
		this.designDeep = designDeep;
		this.type = type;
		this.receiver = receiver;
	}
	public Mission() {
		super();
	}
	public String getZkNum() {
		return zkNum;
	}
	public void setZkNum(String zkNum) {
		this.zkNum = zkNum;
	}
	public String getLittleProName() {
		return littleProName;
	}
	public void setLittleProName(String littleProName) {
		this.littleProName = littleProName;
	}
	public Double getRailLength() {
		return railLength;
	}
	public void setRailLength(Double railLength) {
		this.railLength = railLength;
	}
	public Double getDesignOffset() {
		return designOffset;
	}
	public void setDesignOffset(Double designOffset) {
		this.designOffset = designOffset;
	}
	public Double getX() {
		return x;
	}
	public void setX(Double x) {
		this.x = x;
	}
	public Double getY() {
		return y;
	}
	public void setY(Double y) {
		this.y = y;
	}
	public Double getDesignDeep() {
		return designDeep;
	}
	public void setDesignDeep(Double designDeep) {
		this.designDeep = designDeep;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	
	
}
