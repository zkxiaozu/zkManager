package com.zkmanager.dao;

import java.util.List;

import com.zkmanager.po.BigPro;

public interface BigProDao {
	//�������������ڸ�����������Ŀ
	public abstract List<BigPro> queryBigProsBySuoId(Integer parentId);
		
	//���ҵ�����Ŀ����Ϣ
	public abstract BigPro queryBigProById(Integer id);
}
