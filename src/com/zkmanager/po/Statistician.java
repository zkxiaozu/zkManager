package com.zkmanager.po;

//统计器
public class Statistician {
	
	private int id;
	private int parentId;
	private String type;
	//当前终孔（米）
	private double zkm;
	//总终孔（米）
	private double zkmSum;
	//当前终孔（个）
	private int zkg;
	//总终孔（个）
	private int zkgSum;
	//当前开累（米）
	private double klm;
	//总开累（米）
	private double klmSum;
	//当前开累（个）
	private int klg;
	//总开累（个）
	private int klgSum;
	//当前修路（米）
	private double xlm;
	//总修路（米）
	private double xlmSum;
	//当前修路（条）
	private int xlt;
	//总修路（条）
	private int xltSum;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getParentId() {
		return parentId;
	}
	public void setParentId(int parentId) {
		this.parentId = parentId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getZkm() {
		return zkm;
	}
	public void setZkm(double zkm) {
		this.zkm = zkm;
	}
	public double getZkmSum() {
		return zkmSum;
	}
	public void setZkmSum(double zkmSum) {
		this.zkmSum = zkmSum;
	}
	public int getZkg() {
		return zkg;
	}
	public void setZkg(int zkg) {
		this.zkg = zkg;
	}
	public int getZkgSum() {
		return zkgSum;
	}
	public void setZkgSum(int zkgSum) {
		this.zkgSum = zkgSum;
	}
	public double getKlm() {
		return klm;
	}
	public void setKlm(double klm) {
		this.klm = klm;
	}
	public double getKlmSum() {
		return klmSum;
	}
	public void setKlmSum(double klmSum) {
		this.klmSum = klmSum;
	}
	public int getKlg() {
		return klg;
	}
	public void setKlg(int klg) {
		this.klg = klg;
	}
	public int getKlgSum() {
		return klgSum;
	}
	public void setKlgSum(int klgSum) {
		this.klgSum = klgSum;
	}
	public double getXlm() {
		return xlm;
	}
	public void setXlm(double xlm) {
		this.xlm = xlm;
	}
	public double getXlmSum() {
		return xlmSum;
	}
	public void setXlmSum(double xlmSum) {
		this.xlmSum = xlmSum;
	}
	public int getXlt() {
		return xlt;
	}
	public void setXlt(int xlt) {
		this.xlt = xlt;
	}
	public int getXltSum() {
		return xltSum;
	}
	public void setXltSum(int xltSum) {
		this.xltSum = xltSum;
	}
	@Override
	public String toString() {
		return "{"
				+ "id:" + id 
				+ ", parentId:" + parentId 
				+ ", type:" + type 
				+ ", zkm:" + zkm 
				+ ", zkmSum:" + zkmSum 
				+ ", zkg:" + zkg 
				+ ", zkgSum:" + zkgSum 
				+ ", klm:" + klm 
				+ ", klmSum:" + klmSum 
				+ ", klg:" + klg 
				+ ", klgSum:" + klgSum 
				+ ", xlm:" + xlm 
				+ ", xlmSum:" + xlmSum 
				+ ", xlt:" + xlt 
				+ ", xltSum:" + xltSum 
				+ "}";
	}
	
	

}
