package com.zkmanager.dao;

import java.util.List;

import com.zkmanager.po.Suo;

public interface SuoDao {
	//²éÕÒËù
	public abstract List<Suo> querySuosByYuanId(Integer parentId);
	
}
