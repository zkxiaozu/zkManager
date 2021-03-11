package com.zkmanager.po;

import java.util.List;

public class HoleInfo {
	private int code;
	private String msg;
	private Hole hole;
	
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
	
	public Hole getHole() {
		return hole;
	}

	public void setHole(Hole hole) {
		this.hole = hole;
	}

	@Override
	public String toString() {
		return '{' +
                "code:" + code +
                ", msg:" + msg +
                ", hole:" + hole +
                '}';
	}
}
