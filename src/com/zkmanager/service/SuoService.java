package com.zkmanager.service;

import java.util.List;

import com.zkmanager.po.Suo;

public interface SuoService {
	//��ѯ������
	public abstract List<Suo> querySuosByYuanId(Integer parentId);

}
