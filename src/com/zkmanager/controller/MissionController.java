package com.zkmanager.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.EncryptedDocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
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

	MissionInfo missionInfo = null;

	private List<Mission> missions = null;

	private List<Hole> holeList = null;

	@RequestMapping(value = "/receiveFile", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	@Transactional(readOnly = false, rollbackFor = Exception.class, propagation = Propagation.REQUIRED)
	public MissionInfo receiveFile(HttpServletRequest request) throws IOException {
		// ????????? MultipartHttpServletRequest
		if (request instanceof MultipartHttpServletRequest) {
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			// ?????????????????????????????????????????????????????? file.getInputStream() ?????????????????????
			MultipartFile file = multipartRequest.getFile("file");
			missionInfo = new MissionInfo();

			InputStream in = null;
			try {
				in = file.getInputStream();
			} catch (IOException e1) {
				e1.printStackTrace();
				missionInfo.setMsg("?????????????????????");
			} catch (NullPointerException e) {
				e.printStackTrace();
				missionInfo.setMsg("???????????????");
			}

			missions = new ArrayList<>();
			holeList = new ArrayList<>();

			missions = readExcel.readexcel(in, startLine);
			if (missions == null) {
				missionInfo.setCode(0);
				missionInfo.setMsg("???????????????????????????????????????");
				missionInfo.setHoleList(null);
				return missionInfo;
			}

			for (Mission mission : missions) {
				Hole hole = new Hole();
				/*****************************
				 * 
				 * ????????? update???????????????
				 */
				Integer unitId = drillingUnitService.findDrillingUnitIdByFullName(mission.getReceiver());
				Double railLength = mission.getRailLength();
//				Double length = railLength + unitLength;
//				drillingUnitService.updateDrillingUnit(length, unitId);

				// ???object????????????????????????????????????????????????id
				Integer id = objectService.insertObject("??????");
				hole.setId(id);
				hole.setName(mission.getZkNum());
				hole.setType(mission.getType());
				hole.setDesignDeep(mission.getDesignDeep());
				hole.setDesignOffset(mission.getDesignOffset());
				hole.setX(mission.getX());
				hole.setY(mission.getY());
				hole.setRailLength(railLength);
				hole.setParentId(unitId);
				hole.setParentId2(workPointService.findWorkPointIdByFullName(mission.getLittleProName()));
				holeList.add(hole);

			}
			// ??????????????????
			holeService.insertHoles(holeList);
			missionInfo.setCode(200);
			missionInfo.setMsg("?????????????????????");
			missionInfo.setHoleList(holeList);

//			??????unit???????????????
//			key???unitId, value???length
			Map<Integer, Double> unitMap = new HashMap<>();
			unitMap.clear();
			Iterator<Hole> unitIterator = holeList.iterator();
			while (unitIterator.hasNext()) {
				Hole h = unitIterator.next();
				if (!unitMap.containsKey(h.getParentId())) {
					unitMap.put(h.getParentId(), 0d);
				}
				unitMap.put(h.getParentId(), unitMap.get(h.getParentId()) + h.getRailLength());
			}
			Set<Integer> unitKeySet = unitMap.keySet();
			for (Integer key : unitKeySet) {
				Double unitLength = drillingUnitService.findDrillingUnitLengthByid(key);
				drillingUnitService.updateDrillingUnit(unitMap.get(key) + unitLength, key);
			}

//			??????littlePro???????????????
			Map<Integer, Double> pointMap = new HashMap<>();
			pointMap.clear();
			Iterator<Hole> pointIterator = holeList.iterator();
			while (pointIterator.hasNext()) {
				Hole h = pointIterator.next();
				if (!pointMap.containsKey(h.getParentId2())) {
					pointMap.put(h.getParentId2(), 0d);
				}
				pointMap.put(h.getParentId2(), pointMap.get(h.getParentId2()) + h.getRailLength());
			}
			Set<Integer> pointKeySet = pointMap.keySet();
			for (Integer key : pointKeySet) {
				Double pointLength = workPointService.findWorkPointLengthById(key);
				workPointService.updateWorkPoint(pointMap.get(key) + pointLength, key);
			}

			return missionInfo;

		} else {
			missionInfo.setCode(0);
			missionInfo.setMsg("?????????????????????");
			return missionInfo;
		}
	}

}
