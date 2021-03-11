package com.zkmanager.po;

import java.util.List;

public class LoginList {
	private int code;
	private String msg;
	private Person person;
	private ObjectTable object;
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
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public ObjectTable getObject() {
		return object;
	}
	public void setObject(ObjectTable object) {
		this.object = object;
	}
	
	
	@Override
	public String toString() {
		return '{' +
                "code:" + code +
                ", msg:" + msg +
                ", person:" + person +
                ", object:" + object +
                '}';
	}
}
