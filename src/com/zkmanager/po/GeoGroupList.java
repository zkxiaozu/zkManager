package com.zkmanager.po;

import java.util.List;

public class GeoGroupList {
	private Integer code;
	private String msg;
	private List<GeoGroupInfo> geoGroupInfos;
	public GeoGroupList(Integer code, String msg, List<GeoGroupInfo> geoGroupInfos) {
		super();
		this.code = code;
		this.msg = msg;
		this.geoGroupInfos = geoGroupInfos;
	}
	public GeoGroupList() {
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
	public List<GeoGroupInfo> getGeoGroupInfos() {
		return geoGroupInfos;
	}
	public void setGeoGroupInfos(List<GeoGroupInfo> geoGroupInfos) {
		this.geoGroupInfos = geoGroupInfos;
	}
	
}
