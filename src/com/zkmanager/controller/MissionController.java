package com.zkmanager.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.zkmanager.po.Hole;
import com.zkmanager.po.Mission;
import com.zkmanager.po.MissionInfo;
import com.zkmanager.service.DrillingUnitService;
import com.zkmanager.service.HoleService;
import com.zkmanager.service.ObjectService;
import com.zkmanager.service.PersonService;
import com.zkmanager.service.WorkPointService;
import com.zkmanager.utils.ReadExcel;

@Controller
public class MissionController {

	private static final Integer startLine = 4;
	
	@Autowired
	private ReadExcel readExcel;
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private ObjectService objectService;

	@Autowired
	private DrillingUnitService drillingUnitService;

	@Autowired
	private WorkPointService workPointService;

	@Autowired
	private HoleService holeService;

	MissionInfo missionInfo = new MissionInfo();

	private List<Mission> missions = new ArrayList<>();

	private List<Hole> holeList = new ArrayList<>();

	@RequestMapping(value = "/receiveFile", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	@Transactional
	public MissionInfo receiveFile(HttpServletRequest request) throws IOException {
		// 转换为 MultipartHttpServletRequest
		if (request instanceof MultipartHttpServletRequest) {
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			// 通过表单中的参数名来接收文件流（可用 file.getInputStream() 来接收输入流）
			MultipartFile file = multipartRequest.getFile("file");

			InputStream in = file.getInputStream();
			
			//读取excel中的数据，将读取到的数据添加到mission对象中；
			missions = readExcel.readexcel(in, startLine);
			if(missions == null) {
				missionInfo.setCode(-1);
				missionInfo.setMsg("设计负责人与接收单位不匹配");
				missionInfo.setHoleList(null);
				return missionInfo;
			}
			
			for (Mission mission : missions) {
				Hole hole = new Hole();
				//在object表中添加一个钻孔对象，并返回一个id
				Integer id = objectService.insertObject("钻孔");
				hole.setId(id);
				hole.setName(mission.getZkNum());
				hole.setType(mission.getType());
				hole.setDesignDeep(mission.getDesignDeep());
				hole.setDesignOffset(mission.getDesignOffset());
//					hole.setDesignRoadLength();
				hole.setX(mission.getX());
				hole.setY(mission.getY());
//					hole.setZ(z);
//					hole.setRailFootage();
				hole.setRailLength(mission.getRailLength());
				hole.setParentId(drillingUnitService.findDrillingUnitIdByFullName(mission.getReceiver()));
				hole.setParentId2(workPointService.findWorkPointIdByFullName(mission.getLittleProName()));
				
//				System.out.println(hole);
				
				holeList.add(hole);

			}
			//执行插入操作
			holeService.insertHoles(holeList);
			missionInfo.setCode(200);
			missionInfo.setMsg("数据添加成功！");
			missionInfo.setHoleList(holeList);
			return missionInfo;
		} else {
			missionInfo.setCode(0);
			missionInfo.setMsg("数据添加失败！");
			return missionInfo;
		}
	}
}
