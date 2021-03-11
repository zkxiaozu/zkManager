package com.zkmanager.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zkmanager.po.Suo;
import com.zkmanager.po.SuoInfo;
import com.zkmanager.po.SuoList;
import com.zkmanager.service.PersonService;
import com.zkmanager.service.SuoService;

@Controller
public class SuoController {
		
	@Autowired
	private SuoService suoService;
	
	@Autowired
	private PersonService personService;
	
	
	//查找所有所
	@RequestMapping(value = "findSuos", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public SuoList querySuosByYuanId(@RequestParam("yuanId") Integer yuanId) {
		SuoList suoList = new SuoList();
		List<SuoInfo> suoInfos = null;
		List<Suo> suos = suoService.querySuosByYuanId(yuanId);
		if(suos != null) {
			suoInfos = new ArrayList<>();
			for(Suo suo : suos) {
				SuoInfo suoInfo = new SuoInfo();
				suoInfo.setSuo(suo);
				suoInfo.setContactor(personService.findContactorById(suo.getContactorId()));
				suoInfos.add(suoInfo);
			}
			suoList.setCode(200);
			suoList.setMsg("查询成功");
			suoList.setSuoInfoList(suoInfos);
			return suoList;
		}
		suoList.setCode(0);
		suoList.setMsg("该院暂无任何所");
		return suoList;
		
	}
	

}
