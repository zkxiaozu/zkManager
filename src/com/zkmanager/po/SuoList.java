package com.zkmanager.po;

import java.util.List;

public class SuoList {
	private Integer code;
	private String msg;
	private List<SuoInfo> suoInfoList;
	public SuoList(Integer code, String msg, List<SuoInfo> suoInfoList) {
		super();
		this.code = code;
		this.msg = msg;
		this.suoInfoList = suoInfoList;
	}
	public SuoList() {
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
	public List<SuoInfo> getSuoInfoList() {
		return suoInfoList;
	}
	public void setSuoInfoList(List<SuoInfo> suoInfoList) {
		this.suoInfoList = suoInfoList;
	}
}
