package com.zkmanager.po;

import java.util.List;

public class BigProList {
	private int code;
	private String msg;
	private List<BigProInfo> bigProInfos;
	public BigProList(int code, String msg, List<BigProInfo> bigProInfos) {
		super();
		this.code = code;
		this.msg = msg;
		this.bigProInfos = bigProInfos;
	}
	public BigProList() {
		super();
	}
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
	public List<BigProInfo> getBigProInfos() {
		return bigProInfos;
	}
	public void setBigProInfos(List<BigProInfo> bigProInfos) {
		this.bigProInfos = bigProInfos;
	}
}
