package com.zkmanager.service;

import java.util.List;

import com.zkmanager.po.BigPro;

public interface BigProService {
	//从所级查找属于该所的项目
	public abstract List<BigPro> queryBigProsBySuoId(Integer parentId);
	
	//查找单个项目
	public abstract BigPro queryBigProById(Integer id);
}
