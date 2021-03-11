package com.zkmanager.po;

public class SuoInfo {
	private Suo suo;
	private Person contactor;
	public SuoInfo(Suo suo, Person contactor) {
		super();
		this.suo = suo;
		this.contactor = contactor;
	}
	public SuoInfo() {
		super();
	}
	public Suo getSuo() {
		return suo;
	}
	public void setSuo(Suo suo) {
		this.suo = suo;
	}
	public Person getContactor() {
		return contactor;
	}
	public void setContactor(Person contactor) {
		this.contactor = contactor;
	}
	
	
}
