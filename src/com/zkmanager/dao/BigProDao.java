package com.zkmanager.dao;

import java.util.List;

import com.zkmanager.po.BigPro;

public interface BigProDao {
	//从所级查找属于该所的所有项目
	public abstract List<BigPro> queryBigProsBySuoId(Integer parentId);
		
	//查找单个项目的信息
	public abstract BigPro queryBigProById(Integer id);
}
