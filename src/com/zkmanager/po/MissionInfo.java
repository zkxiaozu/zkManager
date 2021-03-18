package com.zkmanager.po;

import java.util.List;

public class MissionInfo {
	private Integer code;
	private String msg;
	private List<Hole> holeList;
	public MissionInfo(Integer code, String msg, List<Hole> holeList) {
		super();
		this.code = code;
		this.msg = msg;
		this.holeList = holeList;
	}
	public MissionInfo() {
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
	public List<Hole> getHoleList() {
		return holeList;
	}
	public void setHoleList(List<Hole> holeList) {
		this.holeList = holeList;
	}
	
	
}
