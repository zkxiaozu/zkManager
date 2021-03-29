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
	
	@Override
	public double countZkm(int parentId, String type) {
		// TODO Auto-generated method stub
		double result = this.holeDao.countZkm(parentId, type);
		return result;
	}

	@Override
	public double countZkmSum(int parentId, String type) {
		// TODO Auto-generated method stub
		double result = this.holeDao.countZkmSum(parentId, type);
		return result;
	}

	@Override
	public Integer countZkg(int parentId, String type) {
		// TODO Auto-generated method stub
		Integer result = this.holeDao.countZkg(parentId, type);
		return result;
	}

	@Override
	public int countZkgSum(int parentId, String type) {
		// TODO Auto-generated method stub
		int result = this.holeDao.countZkgSum(parentId, type);
		return result;
	}

	@Override
	public double countXlm(int parentId, String type) {
		// TODO Auto-generated method stub
		double result = this.holeDao.countXlm(parentId, type);
		return result;
	}

	@Override
	public double countXlmSum(int parentId, String type) {
		// TODO Auto-generated method stub
		double result = this.holeDao.countXlmSum(parentId, type);
		return result;
	}
	
	@Override
	public double countZkmPoint(int parentId2, String type) {
		// TODO Auto-generated method stub
		double result = this.holeDao.countZkmPoint(parentId2, type);
		return result;
	}

	@Override
	public double countZkmSumPoint(int parentId2, String type) {
		// TODO Auto-generated method stub
		double result = this.holeDao.countZkmSumPoint(parentId2, type);
		return result;
	}

	@Override
	public Integer countZkgPoint(int parentId2, String type) {
		// TODO Auto-generated method stub
		Integer result = this.holeDao.countZkgPoint(parentId2, type);
		return result;
	}

	@Override
	public int countZkgSumPoint(int parentId2, String type) {
		// TODO Auto-generated method stub
		int result = this.holeDao.countZkgSumPoint(parentId2, type);
		return result;
	}

	@Override
	public double countXlmPoint(int parentId2, String type) {
		// TODO Auto-generated method stub
		double result = this.holeDao.countXlmPoint(parentId2, type);
		return result;
	}

	@Override
	public double countXlmSumPoint(int parentId2, String type) {
		// TODO Auto-generated method stub
		double result = this.holeDao.countXlmSumPoint(parentId2, type);
		return result;
	}
	
}
