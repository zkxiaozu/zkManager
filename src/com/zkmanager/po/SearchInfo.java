package com.zkmanager.po;

import java.util.List;

public class SearchInfo {
	private int code;
	private String msg;
	private List<Hole> searchList;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<Hole> getSearchList() {
		return searchList;
	}
	public void setSearchList(List<Hole> searchList) {
		this.searchList = searchList;
	}
	@Override
	public String toString() {
		return "{"
				+ "code:" + code 
				+ ", msg:" + msg 
				+ ", searchList:" + searchList 
				+ "}";
	}

	
}
