package com.zkmanager.po;

import java.util.Map;

public class GeoGroupInfo {
	private Integer code;
	private String msg;
	private GeoGroup geoGroup;
	private Person contactor;
	private Map<String, Statistician> statisticians;
	public GeoGroupInfo(Integer code, String msg, GeoGroup geoGroup, Person contactor,
			Map<String, Statistician> statisticians) {
		super();
		this.code = code;
		this.msg = msg;
		this.geoGroup = geoGroup;
		this.contactor = contactor;
		this.statisticians = statisticians;
	}
	public GeoGroupInfo() {
		super();
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public GeoGroup getGeoGroup() {
		return geoGroup;
	}
	public void setGeoGroup(GeoGroup geoGroup) {
		this.geoGroup = geoGroup;
	}
	public Person getContactor() {
		return contactor;
	}
	public void setContactor(Person contactor) {
		this.contactor = contactor;
	}
	public Map<String, Statistician> getStatisticians() {
		return statisticians;
	}
	public void setStatisticians(Map<String, Statistician> statisticians) {
		this.statisticians = statisticians;
	}
	
}
