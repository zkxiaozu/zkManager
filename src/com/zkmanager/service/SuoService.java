package com.zkmanager.service;

import java.util.List;

import com.zkmanager.po.Suo;

public interface SuoService {
	//查询所有所
	public abstract List<Suo> querySuosByYuanId(Integer parentId);

}
