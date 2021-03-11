package com.zkmanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zkmanager.dao.SuoDao;
import com.zkmanager.po.Suo;
import com.zkmanager.service.SuoService;

@Service("suoService")
@Transactional
public class SuoServiceImpl implements SuoService{
	
	@Autowired
	private SuoDao suoDao;
	
	//查询所有所
	@Override
	public List<Suo> querySuosByYuanId(Integer parentId) {
		List<Suo> suos = suoDao.querySuosByYuanId(parentId);
		if(suos.size() != 0) {
			return suos;
		}
		return null;
	}


}

