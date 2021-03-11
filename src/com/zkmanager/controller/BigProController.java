package com.zkmanager.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zkmanager.po.BigPro;
import com.zkmanager.po.BigProInfo;
import com.zkmanager.po.BigProList;
import com.zkmanager.service.BigProService;
import com.zkmanager.service.PersonService;
import com.zkmanager.service.StatisticianService;

@Controller
public class BigProController {
	
	@Autowired
	private BigProService bigProService;
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private StatisticianService statisticianService;
	
	@RequestMapping(value = "findBigPros", produces = "application/json")
	@ResponseBody
	public BigProList queryBigProsBySuoId(@RequestParam("suoId") Integer suoId){
		BigProList bigProList = new BigProList();
		List<BigProInfo> bigProInfos = null;
		List<BigPro> bigPros = bigProService.queryBigProsBySuoId(suoId);
		System.out.println(bigPros.size());
		if(bigPros != null) {
			bigProInfos = new ArrayList<>();
			for(BigPro bigPro : bigPros) {
				BigProInfo bigProInfo = new BigProInfo();
				bigProInfo.setBigPro(bigPro);
				bigProInfo.setContatcor(personService.findContactorById(bigPro.getContactorId()));
				bigProInfos.add(bigProInfo);
			}
			
			bigProList.setCode(200);
			bigProList.setMsg("查询成功");
			bigProList.setBigProInfos(bigProInfos);
			return bigProList;
		}
		bigProList.setCode(0);
		bigProList.setMsg("该所暂无任何项目");
		return bigProList;
		
	}
	
	@RequestMapping(value = "findBigProInfo", produces = "application/json")
	@ResponseBody
	public BigProInfo queryBigProInfoById(@RequestParam("bigProId") Integer id) {
		BigProInfo bigProInfo = new BigProInfo();
		BigPro bigPro = bigProService.queryBigProById(id);
		System.out.println(bigPro.getParentId());
		if(bigPro != null) {
			bigProInfo.setCode(200);
			bigProInfo.setMsg("查询成功");
			bigProInfo.setBigPro(bigPro);
			bigProInfo.setContatcor(personService.findContactorById(bigPro.getContactorId()));
			bigProInfo.setStatisticians(statisticianService.queryStatisticianMapByParentId(id));
			return bigProInfo;
		}
		bigProInfo.setCode(0);
		bigProInfo.setMsg("查询失败");
		return bigProInfo;
	}
	
}

