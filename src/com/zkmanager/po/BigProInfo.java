package com.zkmanager.po;

import java.util.Map;

public class BigProInfo {
	private int code;
	private String msg;
	private BigPro bigPro;
	private Person contatcor;
	private Map<String, Statistician> statisticians;
	
	public BigProInfo(int code, String msg, BigPro bigPro, Person contatcor, Map<String, Statistician> statisticians) {
		super();
		this.code = code;
		this.msg = msg;
		this.bigPro = bigPro;
		this.contatcor = contatcor;
		this.statisticians = statisticians;
	}
	public BigProInfo() {
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
	public BigPro getBigPro() {
		return bigPro;
	}
	public void setBigPro(BigPro bigPro) {
		this.bigPro = bigPro;
	}
	public Person getContatcor() {
		return contatcor;
	}
	public void setContatcor(Person contatcor) {
		this.contatcor = contatcor;
	}
	public Map<String, Statistician> getStatisticians() {
		return statisticians;
	}
	public void setStatisticians(Map<String, Statistician> statisticians) {
		this.statisticians = statisticians;
	}
}
