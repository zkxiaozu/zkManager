package com.zkmanager.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zkmanager.dao.HoleDao;
import com.zkmanager.po.Hole;
import com.zkmanager.service.HoleService;

@Service("holeService")
@Transactional
public class HoleServiceImpl implements HoleService {
	
	@Autowired
	private HoleDao holeDao;

	@Override
	public Hole findHoleById(int id) {
		// TODO Auto-generated method stub
		Hole result = this.holeDao.findHoleById(id);
		if (result !=null) {
			return result;
		}
		return null;
	}

	@Override
	public List<Hole> findHoleByParentId(int parentId) {
		// TODO Auto-generated method stub
		List<Hole> result = this.holeDao.findHoleByParentId(parentId);
		if(result.size()!=0) {
			return result;
		}
		return null;
	}

	@Override
	public List<Hole> findHoleByParentId2(int parentId2) {
		// TODO Auto-generated method stub
		List<Hole> result = this.holeDao.findHoleByParentId2(parentId2);
		if(result.size()!=0) {
			return result;
		}
		return null;
	}

	@Override
	public boolean updateRailLength(double railLength, int id) {
		// TODO Auto-generated method stub
		boolean result = this.holeDao.updateRailLength(railLength, id);
		if(result) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean updateRailDepth(double railDepth, int id) {
		// TODO Auto-generated method stub
		boolean result = this.holeDao.updateRailDepth(railDepth, id);
		if(result) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean updateRailState(String railState, int id) {
		// TODO Auto-generated method stub
		boolean result = this.holeDao.updateRailState(railState, id);
		if(result) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateRailFootage(double railFootage, int id) {
		// TODO Auto-generated method stub
		boolean result = this.holeDao.updateRailFootage(railFootage, id);
		if(result) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateDepthAndFootage(double railDepth, double railFootage, int id) {
		// TODO Auto-generated method stub
		boolean result = this.holeDao.updateDepthAndFootage(railDepth, railFootage, id);
		if(result) {
			return true;
		}
		return false;
	}

	@Override
	public boolean insertHoles(List<Hole> holeList) {
		// TODO Auto-generated method stub
		boolean result = this.holeDao.insertHoles(holeList);
		if(result) {
			return true;
		}
		return false;
	}
	
}
