package com.zkmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zkmanager.po.Hole;
import com.zkmanager.po.HoleInfo;
import com.zkmanager.po.SearchInfo;
import com.zkmanager.service.HoleService;

@Controller
public class SearchController {
	
	@Autowired
	private HoleService holeService;
	
	@RequestMapping(value="/searchHole",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public SearchInfo SearchHole(int parentId,String lastPage){
		SearchInfo info = new SearchInfo();
		if(lastPage.equals("钻探单位")) {
			List<Hole> result = holeService.findHoleByParentId(parentId);
			if(result != null) {
				info.setCode(200);
				info.setSearchList(result);
				return info;
			}
		}else if(lastPage.equals("工点")) {
			List<Hole> result = holeService.findHoleByParentId2(parentId);
			if(result != null) {
				info.setCode(200);
				info.setSearchList(result);
				return info;
			}
		}
		info.setCode(0);
		return info;
	}
	
}
