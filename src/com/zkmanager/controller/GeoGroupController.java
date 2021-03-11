package com.zkmanager.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zkmanager.po.GeoGroup;
import com.zkmanager.po.GeoGroupInfo;
import com.zkmanager.po.GeoGroupList;
import com.zkmanager.service.GeoGroupService;
import com.zkmanager.service.PersonService;
import com.zkmanager.service.StatisticianService;

@Controller
public class GeoGroupController {
	
	@Autowired
	private GeoGroupService geoGroupService;
	
	@Autowired 
	private PersonService personService;
	
	@Autowired
	private StatisticianService statisticianService;
	
	@RequestMapping(value="findGeoGroups", produces = "application/json")
	@ResponseBody
	public GeoGroupList queryGeoGroupsByBigProId(@RequestParam("bigProId") Integer bigProId){
		GeoGroupList geoGroupList = new GeoGroupList();
		List<GeoGroupInfo> geoGroupInfos = null;
		List<GeoGroup> geoGroups = geoGroupService.queryGeoGroupsByBigProId(bigProId);
		if(geoGroups != null) {
			geoGroupInfos = new ArrayList<>();
			for(GeoGroup geoGroup : geoGroups) {
				GeoGroupInfo geoGroupInfo = new GeoGroupInfo();
				geoGroupInfo.setGeoGroup(geoGroup);
				geoGroupInfo.setContactor(personService.findContactorById(geoGroup.getContactorId()));
				geoGroupInfos.add(geoGroupInfo);
			}
			geoGroupList.setCode(200);
			geoGroupList.setMsg("查询成功");
			geoGroupList.setGeoGroupInfos(geoGroupInfos);
			return geoGroupList;
		}
		geoGroupList.setCode(0);
		geoGroupList.setMsg("该项目暂无地质组");
		return geoGroupList;
		
	}
	
	@RequestMapping(value="showGeoGroupInfo", produces = "application/json")
	@ResponseBody
	public GeoGroupInfo queryGepGroupInfoById(@RequestParam("geoGroupId") Integer id) {
		GeoGroupInfo geoGroupInfo = new GeoGroupInfo();
		GeoGroup geoGroup = geoGroupService.queryGeoGroupById(id);
		if(geoGroup != null) {
			geoGroupInfo.setCode(200);
			geoGroupInfo.setMsg("查询成功");
			geoGroupInfo.setGeoGroup(geoGroup);
			geoGroupInfo.setContactor(personService.findContactorById(geoGroup.getContactorId()));
			geoGroupInfo.setStatisticians(statisticianService.queryStatisticianMapByParentId(id));
			return geoGroupInfo;
		}
		geoGroupInfo.setCode(0);
		geoGroupInfo.setMsg("查询失败");
		return geoGroupInfo;
		
	}
}
