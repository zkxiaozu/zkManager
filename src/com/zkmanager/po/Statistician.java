package com.zkmanager.po;

//ͳ����
public class Statistician {
	
	private int id;
	private int parentId;
	private String type;
	//��ǰ�տף��ף�
	private double zkm;
	//���տף��ף�
	private double zkmSum;
	//��ǰ�տף�����
	private int zkg;
	//���տף�����
	private int zkgSum;
	//��ǰ���ۣ��ף�
	private double klm;
	//�ܿ��ۣ��ף�
	private double klmSum;
	//��ǰ���ۣ�����
	private int klg;
	//�ܿ��ۣ�����
	private int klgSum;
	//��ǰ��·���ף�
	private double xlm;
	//����·���ף�
	private double xlmSum;
	//��ǰ��·������
	private int xlt;
	//����·������
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
