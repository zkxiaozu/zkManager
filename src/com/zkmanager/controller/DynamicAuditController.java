package com.zkmanager.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zkmanager.po.DrillingRecord;
import com.zkmanager.po.DrillingUnit;
import com.zkmanager.po.DynamicAuditInfo;
import com.zkmanager.po.Hole;
import com.zkmanager.po.RoadRecord;
import com.zkmanager.po.StateRecord;
import com.zkmanager.po.WorkPoint;
import com.zkmanager.service.DrillingRecordService;
import com.zkmanager.service.DrillingUnitService;
import com.zkmanager.service.HoleService;
import com.zkmanager.service.RoadRecordService;
import com.zkmanager.service.StateRecordService;
import com.zkmanager.service.WorkPointService;

@Controller
public class DynamicAuditController {
	
	@Autowired
	private DrillingUnitService drillingUnitService;
	
	@Autowired
	private WorkPointService workPointService;
	
	@Autowired
	private HoleService holeService;
	
	@Autowired
	private RoadRecordService roadRecordService; 
	
	@Autowired
	private DrillingRecordService drillingRecordService;
	
	@Autowired
	private StateRecordService stateRecordService;
	
	@RequestMapping(value="/showDynamicAudit",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public DynamicAuditInfo ShowDynamicAudit(int geologyId) {
		DynamicAuditInfo info = new DynamicAuditInfo();
		List<DrillingUnit> unitLists = drillingUnitService.findDrillingUnitByParentId(geologyId);
		List<WorkPoint> pointLists = workPointService.findWorkPointByParentId(geologyId);
		List<RoadRecord> rRecord = new ArrayList<RoadRecord>();
		List<DrillingRecord> dRecord = new ArrayList<DrillingRecord>();
		List<StateRecord> sRecord = new ArrayList<StateRecord>();
		List<Hole> rHole = new ArrayList<Hole>();
		List<Hole> dHole = new ArrayList<Hole>();
		List<Hole> sHole = new ArrayList<Hole>();
		if(unitLists.size()!=0) {
			List<Hole> holeSumList = new ArrayList<Hole>();
			List<Hole> unitHoles = new ArrayList<Hole>();
			for(int i=0;i<unitLists.size();i++) {
				unitHoles = holeService.findHoleByParentId(unitLists.get(i).getId());
				holeSumList.addAll(unitHoles);
			}
			List<Hole> pointHoles = new ArrayList<Hole>();
			for(int i=0;i<pointLists.size();i++) {
				pointHoles = holeService.findHoleByParentId2(pointLists.get(i).getId());
			}
			for(int i=0;i<pointHoles.size();i++) {
				int count=0;
				for(int j=0;j<unitHoles.size();j++) {
					if(pointHoles.get(i).getId()==unitHoles.get(j).getId()) {
						count++;
					}
				}
				if(count==0) {
					holeSumList.add(pointHoles.get(i));
				}
			}
			
			for(int i=0;i<holeSumList.size();i++) {
				List<RoadRecord> record1 = roadRecordService.findSecondAllAuditInfo(holeSumList.get(i).getId());
				List<DrillingRecord> record2 = drillingRecordService.findSecondAllAuditInfo(holeSumList.get(i).getId());
				List<StateRecord> record3 = stateRecordService.findSecondAllAuditInfo(holeSumList.get(i).getId());
				if(record1.size()!=0) {
					rRecord.addAll(record1);
				}
				if(record2.size()!=0) {
					dRecord.addAll(record2);
				}
				if(record3.size()!=0) {
					sRecord.addAll(record3);
				}
			}
			for(int i=0;i<rRecord.size();i++) {
				Hole hole = holeService.findHoleById(rRecord.get(i).getParentId());
				rHole.add(hole);
			}
			for(int i=0;i<dRecord.size();i++) {
				Hole hole = holeService.findHoleById(dRecord.get(i).getParentId());
				dHole.add(hole);
			}
			for(int i=0;i<sRecord.size();i++) {
				Hole hole = holeService.findHoleById(sRecord.get(i).getParentId());
				sHole.add(hole);
			}
			info.setCode(200);
			info.setMsg("查询成功");
			info.setrRecord(rRecord);
			info.setdRecord(dRecord);
			info.setsRecord(sRecord);
			info.setrHole(rHole);
			info.setdHole(dHole);
			info.setsHole(sHole);
			return info;
		}
		info.setCode(0);
		info.setMsg("暂无需要审核的记录");
		return info;
	}
	
	
	@RequestMapping(value="/passGeologyAudit",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public boolean PassGeologyAudit(int id,String type,double length,double depth,String state) {
		boolean result=false;
		if(type.equals("修路记录")) {
			RoadRecord record = roadRecordService.checkDynamicAuditRecordExist(id);
			if(record!=null) {
				result = roadRecordService.passSecondDynamicAudit(id);
				if(result) {
					Hole hole = holeService.findHoleById(record.getParentId());
					if(hole!=null) {
						double railLength = hole.getRailLength();
						double newLength = railLength + length;
						//更新修路长度
						boolean updateResult = holeService.updateRailLength(newLength, record.getParentId());
						if (updateResult) {
							return true;
						}
					}
				}	
			}
		}else if(type.equals("钻进记录")) {
			DrillingRecord record = drillingRecordService.checkDynamicAuditRecordExist(id);
			if(record!=null) {
				Hole hole = holeService.findHoleById(record.getParentId());
				if(hole!=null) {
					double lastDepth = hole.getRailDepth();
					double footage = depth-lastDepth;
					result = drillingRecordService.passSecondDynamicAudit(id,footage);
					if(result) {
						//更新孔深和进尺
						boolean updateResult = holeService.updateDepthAndFootage(depth, footage, record.getParentId());
						if (updateResult) {
							return true;
						}
					}
				}
				
			}
		}else {
			StateRecord record = stateRecordService.checkDynamicAuditRecordExist(id);
			if(record!=null) {
				result = stateRecordService.passSecondDynamicAudit(id);
				if(result) {
					boolean updateResult = holeService.updateRailState(state, record.getParentId());
					if (updateResult) {
						return true;
					}	
				}
			}
		}
		return result;
	}
	
	@RequestMapping(value="/backGeologyAudit",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public boolean BackGeologyAudit(int id,String type) {
		boolean result=false;
		if(type.equals("修路记录")) {
			RoadRecord record = roadRecordService.checkDynamicAuditRecordExist(id);
			if(record!=null) {
				result = roadRecordService.backAuditById(id);
			}
		}else if(type.equals("钻进记录")) {
			DrillingRecord record = drillingRecordService.checkDynamicAuditRecordExist(id);
			if(record!=null) {
				result = drillingRecordService.backAuditById(id);
			}
		}else {
			StateRecord record = stateRecordService.checkDynamicAuditRecordExist(id);
			if(record!=null) {
				result = stateRecordService.backAuditById(id);
			}
		}
		return result;
	}
	
	@RequestMapping(value="/showAllPassAudit",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public DynamicAuditInfo ShowAllPassAudit(int geologyId) {
		DynamicAuditInfo info = new DynamicAuditInfo();
		List<DrillingUnit> unitLists = drillingUnitService.findDrillingUnitByParentId(geologyId);
		List<WorkPoint> pointLists = workPointService.findWorkPointByParentId(geologyId);
		List<RoadRecord> rRecord = new ArrayList<RoadRecord>();
		List<DrillingRecord> dRecord = new ArrayList<DrillingRecord>();
		List<StateRecord> sRecord = new ArrayList<StateRecord>();
		List<Hole> rHole = new ArrayList<Hole>();
		List<Hole> dHole = new ArrayList<Hole>();
		List<Hole> sHole = new ArrayList<Hole>();
		
		if(unitLists.size()!=0) {
			List<Hole> holeSumList = new ArrayList<Hole>();
			List<Hole> unitHoles = new ArrayList<Hole>();
			List<Hole> pointHoles = new ArrayList<Hole>();
			for(int i=0;i<unitLists.size();i++) {
				unitHoles = holeService.findHoleByParentId(unitLists.get(i).getId());
				holeSumList.addAll(unitHoles);
			}
			for(int i=0;i<pointLists.size();i++) {
				pointHoles = holeService.findHoleByParentId2(pointLists.get(i).getId());
			}
			for(int i=0;i<pointHoles.size();i++) {
				int count=0;
				for(int j=0;j<unitHoles.size();j++) {
					if(pointHoles.get(i).getId()==unitHoles.get(j).getId()) {
						count++;
					}
				}
				if(count==0) {
					holeSumList.add(pointHoles.get(i));
				}
			}
			
			for(int i=0;i<holeSumList.size();i++) {
				List<RoadRecord> record1 = roadRecordService.findAllPassAuditInfo(holeSumList.get(i).getId());
				List<DrillingRecord> record2 = drillingRecordService.findAllPassAuditInfo(holeSumList.get(i).getId());
				List<StateRecord> record3 = stateRecordService.findAllPassAuditInfo(holeSumList.get(i).getId());
				if(record1.size()!=0) {
					rRecord.addAll(record1);
				}
				if(record2.size()!=0) {
					dRecord.addAll(record2);
				}
				if(record3.size()!=0) {
					sRecord.addAll(record3);
				}
			}
			for(int i=0;i<rRecord.size();i++) {
				Hole hole = holeService.findHoleById(rRecord.get(i).getParentId());
				rHole.add(hole);
			}
			for(int i=0;i<dRecord.size();i++) {
				Hole hole = holeService.findHoleById(dRecord.get(i).getParentId());
				dHole.add(hole);
			}
			for(int i=0;i<sRecord.size();i++) {
				Hole hole = holeService.findHoleById(sRecord.get(i).getParentId());
				sHole.add(hole);
			}
			info.setCode(200);
			info.setMsg("查询成功");
			info.setrRecord(rRecord);
			info.setdRecord(dRecord);
			info.setsRecord(sRecord);
			info.setrHole(rHole);
			info.setdHole(dHole);
			info.setsHole(sHole);
			return info;
			
		}
		
		info.setCode(0);
		info.setMsg("暂无已通过的记录");
		return info;
	}
	
	@RequestMapping(value="/showAllBackAudit",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public DynamicAuditInfo ShowAllBackAudit(int geologyId) {
		DynamicAuditInfo info = new DynamicAuditInfo();
		List<DrillingUnit> unitLists = drillingUnitService.findDrillingUnitByParentId(geologyId);
		List<WorkPoint> pointLists = workPointService.findWorkPointByParentId(geologyId);
		List<RoadRecord> rRecord = new ArrayList<RoadRecord>();
		List<DrillingRecord> dRecord = new ArrayList<DrillingRecord>();
		List<StateRecord> sRecord = new ArrayList<StateRecord>();
		List<Hole> rHole = new ArrayList<Hole>();
		List<Hole> dHole = new ArrayList<Hole>();
		List<Hole> sHole = new ArrayList<Hole>();
		
		if(unitLists.size()!=0) {
			List<Hole> holeSumList = new ArrayList<Hole>();
			List<Hole> unitHoles = new ArrayList<Hole>();
			List<Hole> pointHoles = new ArrayList<Hole>();
			for(int i=0;i<unitLists.size();i++) {
				unitHoles = holeService.findHoleByParentId(unitLists.get(i).getId());
				holeSumList.addAll(unitHoles);
			}
			for(int i=0;i<pointLists.size();i++) {
				pointHoles = holeService.findHoleByParentId2(pointLists.get(i).getId());
			}
			for(int i=0;i<pointHoles.size();i++) {
				int count=0;
				for(int j=0;j<unitHoles.size();j++) {
					if(pointHoles.get(i).getId()==unitHoles.get(j).getId()) {
						count++;
					}
				}
				if(count==0) {
					holeSumList.add(pointHoles.get(i));
				}
			}
			for(int i=0;i<holeSumList.size();i++) {
				List<RoadRecord> record1 = roadRecordService.findAllBackAuditInfo(holeSumList.get(i).getId());
				List<DrillingRecord> record2 = drillingRecordService.findAllBackAuditInfo(holeSumList.get(i).getId());
				List<StateRecord> record3 = stateRecordService.findAllBackAuditInfo(holeSumList.get(i).getId());
				if(record1.size()!=0) {
					rRecord.addAll(record1);
				}
				if(record2.size()!=0) {
					dRecord.addAll(record2);
				}
				if(record3.size()!=0) {
					sRecord.addAll(record3);
				}
			}
			for(int i=0;i<rRecord.size();i++) {
				Hole hole = holeService.findHoleById(rRecord.get(i).getParentId());
				rHole.add(hole);
			}
			for(int i=0;i<dRecord.size();i++) {
				Hole hole = holeService.findHoleById(dRecord.get(i).getParentId());
				dHole.add(hole);
			}
			for(int i=0;i<sRecord.size();i++) {
				Hole hole = holeService.findHoleById(sRecord.get(i).getParentId());
				sHole.add(hole);
			}
			info.setCode(200);
			info.setMsg("查询成功");
			info.setrRecord(rRecord);
			info.setdRecord(dRecord);
			info.setsRecord(sRecord);
			info.setrHole(rHole);
			info.setdHole(dHole);
			info.setsHole(sHole);
			return info;
			
		}
		
		info.setCode(0);
		info.setMsg("暂无已退回的记录");
		return info;
	}

}
