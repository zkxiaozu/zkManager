package com.zkmanager.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zkmanager.po.DrillingUnit;
import com.zkmanager.po.Person;
import com.zkmanager.po.PointListInfo;
import com.zkmanager.po.Statistician;
import com.zkmanager.po.UPOverviewInfo;
import com.zkmanager.po.UnitListInfo;
import com.zkmanager.po.WorkPoint;
import com.zkmanager.service.DrillingUnitService;
import com.zkmanager.service.PersonService;
import com.zkmanager.service.StatisticianService;
import com.zkmanager.service.WorkPointService;

@Controller
public class UnitAndPointController {
	
	@Autowired
	private DrillingUnitService drillingUnitService;
	
	@Autowired
	private WorkPointService workPointService;
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private StatisticianService statisticianService;
	
	@RequestMapping(value="/findUPOverviewInfo",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public UPOverviewInfo FindUPOverviewInfo(int id,String lastPage) {
		UPOverviewInfo info = new UPOverviewInfo();
		if(lastPage.equals("钻探单位")) {
			DrillingUnit unit = drillingUnitService.findDrillingUnitById(id);
			if(unit!=null) {
				info.setCode(200);
				info.setUnit(unit);
				Person contactor = personService.findContactorById(unit.getContactorId());
				info.setContactor(contactor);
				info.setStatisticians(statisticianService.queryStatisticianMapByParentId(id));
				return info;
			}
		}else if(lastPage.equals("工点")) {
			WorkPoint point = workPointService.findWorkPointById(id);
			if(point != null) {
				info.setCode(200);
				info.setPoint(point);
				Person contactor = personService.findContactorById(point.getContactorId());
				info.setContactor(contactor);
				info.setStatisticians(statisticianService.queryStatisticianMapByParentId(id));
				return info;
			}
		}
		
		info.setCode(0);
		return info;
	}
	
	@RequestMapping(value="/findDrillingUnitList",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public UnitListInfo FindDrillingUnitList(int parentId) {
		UnitListInfo info = new UnitListInfo();
		
		List<DrillingUnit> unitList = drillingUnitService.findDrillingUnitByParentId(parentId);
		List<Person> contactors = new ArrayList<>();
		if(unitList.size()!=0) {
			for(int i=0;i<unitList.size();i++) {
				Person person = personService.findContactorById(unitList.get(i).getContactorId());
				if(person==null) {
					info.setCode(0);
					info.setMsg("存在钻探单位联系人为空");
					return info;
				}
				contactors.add(person);
			}
			info.setCode(200);
			info.setMsg("查询成功");
			info.setUnitList(unitList);
			info.setContactors(contactors);
			return info;
		}
		
		info.setCode(0);
		info.setMsg("暂无钻探单位");
		return info;
	}
	
	@RequestMapping(value="/findWorkPointList",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public PointListInfo FindWorkPointList(int parentId) {
		PointListInfo info = new PointListInfo();
		
		List<WorkPoint> pointList = workPointService.findWorkPointByParentId(parentId);
		List<Person> contactors = new ArrayList<>();
		if(pointList.size()!=0) {
			for(int i=0;i<pointList.size();i++) {
				Person person = personService.findContactorById(pointList.get(i).getContactorId());
				if(person==null) {
					info.setCode(0);
					info.setMsg("存在钻探单位联系人为空");
					return info;
				}
				contactors.add(person);
			}
			info.setCode(200);
			info.setMsg("查询成功");
			info.setPointList(pointList);
			info.setContactors(contactors);
			return info;
		}
		
		info.setCode(0);
		info.setMsg("暂无钻探单位");
		return info;
	}

}
