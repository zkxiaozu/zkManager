package com.zkmanager.service;

import java.util.List;

import com.zkmanager.po.BigPro;

public interface BigProService {
	//�������������ڸ�������Ŀ
	public abstract List<BigPro> queryBigProsBySuoId(Integer parentId);
	
	//���ҵ�����Ŀ
	public abstract BigPro queryBigProById(Integer id);
}
