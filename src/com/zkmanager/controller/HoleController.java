package com.zkmanager.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zkmanager.po.LoginList;
import com.zkmanager.po.ObjectTable;
import com.zkmanager.po.Person;
import com.zkmanager.po.RoadAuditInfo;
import com.zkmanager.po.RoadRecordInfo;
import com.zkmanager.po.StateAuditInfo;
import com.zkmanager.po.StateRecord;
import com.zkmanager.po.StateRecordInfo;
import com.zkmanager.po.RoadRecord;
import com.zkmanager.po.AuditInfo;
import com.zkmanager.po.DrillingAuditInfo;
import com.zkmanager.po.DrillingRecord;
import com.zkmanager.po.DrillingRecordInfo;
import com.zkmanager.po.Hole;
import com.zkmanager.po.HoleInfo;
import com.zkmanager.service.DrillingRecordService;
import com.zkmanager.service.HoleService;
import com.zkmanager.service.ObjectService;
import com.zkmanager.service.RoadRecordService;
import com.zkmanager.service.StateRecordService;

@Controller
public class HoleController {
	
	@Autowired
	private HoleService holeService;
	
	@Autowired
	private RoadRecordService roadRecordService; 
	
	@Autowired
	private DrillingRecordService drillingRecordService;
	
	@Autowired
	private StateRecordService stateRecordService;
	
	@Autowired
	private ObjectService objectService;
	
	@RequestMapping(value="/findZkInfo",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public HoleInfo FindZkInfo(int id){
		System.out.println("第一行");
		System.out.println(id);
		HoleInfo holeInfo = new HoleInfo();
		Hole hole = holeService.findHoleById(id);
		System.out.println("第二行");
		System.out.println(hole);
		if(hole != null) {
			holeInfo.setHole(hole);
			holeInfo.setCode(200);
			System.out.println(holeInfo);
			return holeInfo;
		}
		holeInfo.setCode(0);
		return holeInfo;
	}
	
	
	@RequestMapping(value="/findRoadRecord",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public RoadRecordInfo FindRoadRecord(int parentId){
		RoadRecordInfo recordInfo = new RoadRecordInfo();
		Date date = new Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		String currentDate = String.format("%tF", date);
		recordInfo.setCode(200);
		RoadRecord notPassedRecord = roadRecordService.findNotPassedRoadRecord(parentId, sqlDate);
		recordInfo.setNotPassedRecord(notPassedRecord);
		int firstCheckNum = roadRecordService.findFirstCheckNumByParentId(parentId,"钻探单位或工点");
		int secondCheckNum = roadRecordService.findSecondCheckNumByParentId(parentId,"地质组");
		recordInfo.setFirstCheckNum(firstCheckNum);
		recordInfo.setSecondCheckNum(secondCheckNum);
		RoadRecord todayRecord = roadRecordService.findTodayRoadRecord(parentId,sqlDate);
		recordInfo.setTodayRecord(todayRecord);
		List<RoadRecord> weekRecord = roadRecordService.findWeekRoadRecord(parentId);
		recordInfo.setWeekRecord(weekRecord);
		List<RoadRecord> monthRecord = roadRecordService.findMonthRoadRecord(parentId);
		recordInfo.setMonthRecord(monthRecord);
//		if(todayRecord != null) {
//			recordInfo.setCode(200);
//		}else {
//			recordInfo.setCode(0);
//		}
//		if(String.format("%tF", roadRecord.getSendDate()).equals(currentDate))
//			System.out.println(currentDate);
		System.out.println(recordInfo);
		return recordInfo;
	}
	
	@RequestMapping(value="/findDrillingRecord",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public DrillingRecordInfo FindDrillingRecord(int parentId){
		DrillingRecordInfo recordInfo = new DrillingRecordInfo();
		Date date = new Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		recordInfo.setCode(200);
		DrillingRecord notPassedRecord = drillingRecordService.findNotPassedRecord(parentId, sqlDate);
		recordInfo.setNotPassedRecord(notPassedRecord);
		int firstCheckNum = drillingRecordService.findFirstCheckNumByParentId(parentId,"钻探单位或工点");
		int secondCheckNum = drillingRecordService.findSecondCheckNumByParentId(parentId,"地质组");
		recordInfo.setFirstCheckNum(firstCheckNum);
		recordInfo.setSecondCheckNum(secondCheckNum);
		DrillingRecord todayRecord = drillingRecordService.findTodayDrillingRecord(parentId,sqlDate);
		recordInfo.setTodayRecord(todayRecord);
		List<DrillingRecord> weekRecord = drillingRecordService.findWeekDrillingRecord(parentId);
		recordInfo.setWeekRecord(weekRecord);
		List<DrillingRecord> monthRecord = drillingRecordService.findMonthDrillingRecord(parentId);
		recordInfo.setMonthRecord(monthRecord);
		System.out.println(recordInfo);
		return recordInfo;
	}
	
	@RequestMapping(value="/findStateRecord",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public StateRecordInfo FindStateRecord(int parentId){
		StateRecordInfo recordInfo = new StateRecordInfo();
		Date date = new Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		recordInfo.setCode(200);
		StateRecord notPassedRecord = stateRecordService.findNotPassedRecord(parentId, sqlDate);
		recordInfo.setNotPassedRecord(notPassedRecord);
		int firstCheckNum = stateRecordService.findFirstCheckNumByParentId(parentId,"钻探单位或工点");
		int secondCheckNum = stateRecordService.findSecondCheckNumByParentId(parentId,"地质组");
		recordInfo.setFirstCheckNum(firstCheckNum);
		recordInfo.setSecondCheckNum(secondCheckNum);
		StateRecord todayRecord = stateRecordService.findTodayStateRecord(parentId,sqlDate);
		recordInfo.setTodayRecord(todayRecord);
		List<StateRecord> weekRecord = stateRecordService.findWeekStateRecord(parentId);
		recordInfo.setWeekRecord(weekRecord);
		List<StateRecord> monthRecord = stateRecordService.findMonthStateRecord(parentId);
		recordInfo.setMonthRecord(monthRecord);
		System.out.println(recordInfo);
		return recordInfo;
	}
	
	@RequestMapping(value="/reportRoadRecord",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String ReportRoadRecord(int parentId,String date,double roading) {
		RoadRecord record = roadRecordService.checkRepeatDate(parentId, date);
		if(record != null) {
			return "当前日期的数据已上报";
		}
		boolean addObjectResult = objectService.addObject("钻孔修路记录");
		if(addObjectResult) {
			ObjectTable object = objectService.findNewObject();
			if (object != null) {
				RoadRecord roadRecord = new RoadRecord();
				roadRecord.setParentId(parentId);
				roadRecord.setId(object.getId());
				roadRecord.setRoading(roading);
				roadRecord.setSendDate(date);
				roadRecord.setChecked(false);
				roadRecord.setStage("钻探单位或工点");
				boolean addRecordResult = roadRecordService.addRoadRecord(roadRecord);
				if(addRecordResult) {
					return "上报成功";
				}
				return "上报失败";
			}
			return "上报失败";
		}
		
		return "上报失败";
	}
	
	@RequestMapping(value="/reportSecondRoadRecord",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String ReportSecondRoadRecord(int parentId,String date,double roading) {
		RoadRecord record = roadRecordService.checkRepeatDate(parentId, date);
		if(record != null) {
			return "当前日期的数据已上报";
		}
		boolean addObjectResult = objectService.addObject("钻孔修路记录");
		if(addObjectResult) {
			ObjectTable object = objectService.findNewObject();
			if (object != null) {
				RoadRecord roadRecord = new RoadRecord();
				roadRecord.setParentId(parentId);
				roadRecord.setId(object.getId());
				roadRecord.setRoading(roading);
				roadRecord.setSendDate(date);
				roadRecord.setChecked(false);
				roadRecord.setStage("地质组");
				boolean addRecordResult = roadRecordService.addRoadRecord(roadRecord);
				if(addRecordResult) {
					return "上报成功";
				}
				return "上报失败";
			}
			return "上报失败";
		}
		
		return "上报失败";
	}
	
	@RequestMapping(value="/reportThirdRoadRecord",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String ReportThirdRoadRecord(int parentId,String date,double roading) {
		RoadRecord record = roadRecordService.checkRepeatDate(parentId, date);
		if(record != null) {
			return "当前日期的数据已上报";
		}
		boolean addObjectResult = objectService.addObject("钻孔修路记录");
		if(addObjectResult) {
			ObjectTable object = objectService.findNewObject();
			if (object != null) {
				RoadRecord roadRecord = new RoadRecord();
				roadRecord.setParentId(parentId);
				roadRecord.setId(object.getId());
				roadRecord.setRoading(roading);
				roadRecord.setSendDate(date);
				roadRecord.setChecked(true);
				roadRecord.setStage("通过");
				boolean addRecordResult = roadRecordService.addRoadRecord(roadRecord);
				if(addRecordResult) {
					
					//查看上报之前的修路长度
					Hole hole = holeService.findHoleById(parentId);
					if(hole!=null) {
						double railLength = hole.getRailLength();
						double newLength = railLength + roading;
						//更新修路长度
						boolean updateResult = holeService.updateRailLength(railLength, parentId);
						if (updateResult) {
							return "上报成功";
						}
						return "上报失败";
					}
					return "上报失败";
					
					// return "上报成功";
				}
				return "上报失败";
			}
			return "上报失败";
		}
		
		return "上报失败";
	}
	
	@RequestMapping(value="/reportDrillingRecord",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String ReportDrillingRecord(int parentId,String date,double zking) {
		DrillingRecord record = drillingRecordService.checkRepeatDate(parentId, date);
		if(record != null) {
			return "当前日期的数据已上报";
		}
		boolean addObjectResult = objectService.addObject("钻孔进尺记录");
		if(addObjectResult) {
			ObjectTable object = objectService.findNewObject();
			if (object != null) {
				DrillingRecord dRecord = new DrillingRecord();
				dRecord.setParentId(parentId);
				dRecord.setId(object.getId());
				dRecord.setZking(zking);
				dRecord.setSendDate(date);
				dRecord.setChecked(false);
				dRecord.setStage("钻探单位或工点");
				boolean addRecordResult = drillingRecordService.addDrillingRecord(dRecord);
				if(addRecordResult) {
					return "上报成功";
				}
				return "上报失败";
			}
			return "上报失败";
		}
		
		return "上报失败";
	}
	
	@RequestMapping(value="/reportSecondDrillingRecord",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String ReportSecondDrillingRecord(int parentId,String date,double zking) {
		DrillingRecord record = drillingRecordService.checkRepeatDate(parentId, date);
		if(record != null) {
			return "当前日期的数据已上报";
		}
		boolean addObjectResult = objectService.addObject("钻孔进尺记录");
		if(addObjectResult) {
			ObjectTable object = objectService.findNewObject();
			if (object != null) {
				DrillingRecord dRecord = new DrillingRecord();
				dRecord.setParentId(parentId);
				dRecord.setId(object.getId());
				dRecord.setZking(zking);
				dRecord.setSendDate(date);
				dRecord.setChecked(false);
				dRecord.setStage("地质组");
				boolean addRecordResult = drillingRecordService.addDrillingRecord(dRecord);
				if(addRecordResult) {
					return "上报成功";
				}
				return "上报失败";
			}
			return "上报失败";
		}
		
		return "上报失败";
	}
	
	@RequestMapping(value="/reportThirdDrillingRecord",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String ReportThirdDrillingRecord(int parentId,String date,double zking) {
		DrillingRecord record = drillingRecordService.checkRepeatDate(parentId, date);
		if(record != null) {
			return "当前日期的数据已上报";
		}
		boolean addObjectResult = objectService.addObject("钻孔进尺记录");
		if(addObjectResult) {
			ObjectTable object = objectService.findNewObject();
			if (object != null) {
				DrillingRecord dRecord = new DrillingRecord();
				dRecord.setParentId(parentId);
				dRecord.setId(object.getId());
				dRecord.setZking(zking);
				double lastDepth = 0;
				DrillingRecord lastRecord = drillingRecordService.findLastRecordById(record.getId()); 
				if(lastRecord!=null) {
					lastDepth = lastRecord.getZking();
				}
				double footage = zking-lastDepth;
				dRecord.setFootage(footage);
				dRecord.setSendDate(date);
				dRecord.setChecked(true);
				dRecord.setStage("通过");
				boolean addRecordResult = drillingRecordService.addDrillingRecord(dRecord);
				if(addRecordResult) {
					
					//更新孔深和进尺
//					Hole hole = holeService.findHoleById(parentId);
//					if(hole!=null) {
//						lastDepth = hole.getRailDepth();
//						footage = zking - lastDepth;
					boolean updateResult = holeService.updateDepthAndFootage(zking, footage, parentId);
					if (updateResult) {
						return "上报成功";
					}
//						return "上报失败";
//					}
					return "上报失败";
					
//					return "上报成功";
				}
				return "上报失败";
			}
			return "上报失败";
		}
		
		return "上报失败";
	}
	
	@RequestMapping(value="/reportStateRecord",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String ReportStateRecord(int parentId,String date,String state) {
		StateRecord record = stateRecordService.checkRepeatDate(parentId, date);
		if(record != null) {
			return "当前日期的数据已上报";
		}
		boolean addObjectResult = objectService.addObject("钻孔状态记录");
		if(addObjectResult) {
			ObjectTable object = objectService.findNewObject();
			if (object != null) {
				StateRecord sRecord = new StateRecord();
				sRecord.setParentId(parentId);
				sRecord.setId(object.getId());
				sRecord.setState(state);
				sRecord.setSendDate(date);
				sRecord.setChecked(false);
				sRecord.setStage("钻探单位或工点");
				System.out.println(state);
				boolean addRecordResult = stateRecordService.addStateRecord(sRecord);
				if(addRecordResult) {
					return "上报成功";
				}
				return "上报失败";
			}
			return "上报失败";
		}
		
		return "上报失败";
	}
	
	@RequestMapping(value="/reportSecondStateRecord",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String ReportSecondStateRecord(int parentId,String date,String state) {
		StateRecord record = stateRecordService.checkRepeatDate(parentId, date);
		if(record != null) {
			return "当前日期的数据已上报";
		}
		boolean addObjectResult = objectService.addObject("钻孔状态记录");
		if(addObjectResult) {
			ObjectTable object = objectService.findNewObject();
			if (object != null) {
				StateRecord sRecord = new StateRecord();
				sRecord.setParentId(parentId);
				sRecord.setId(object.getId());
				sRecord.setState(state);
				sRecord.setSendDate(date);
				sRecord.setChecked(false);
				sRecord.setStage("地质组");
				System.out.println(state);
				boolean addRecordResult = stateRecordService.addStateRecord(sRecord);
				if(addRecordResult) {
					return "上报成功";
				}
				return "上报失败";
			}
			return "上报失败";
		}
		
		return "上报失败";
	}
	
	@RequestMapping(value="/reportThirdStateRecord",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String ReportThirdStateRecord(int parentId,String date,String state) {
		StateRecord record = stateRecordService.checkRepeatDate(parentId, date);
		if(record != null) {
			return "当前日期的数据已上报";
		}
		boolean addObjectResult = objectService.addObject("钻孔状态记录");
		if(addObjectResult) {
			ObjectTable object = objectService.findNewObject();
			if (object != null) {
				StateRecord sRecord = new StateRecord();
				sRecord.setParentId(parentId);
				sRecord.setId(object.getId());
				sRecord.setState(state);
				sRecord.setSendDate(date);
				sRecord.setChecked(true);
				sRecord.setStage("通过");
				System.out.println(state);
				boolean addRecordResult = stateRecordService.addStateRecord(sRecord);
				if(addRecordResult) {
					
					//更新修路长度
					boolean updateResult = holeService.updateRailState(state, parentId);
					if (updateResult) {
						return "上报成功";
					}
					return "上报失败";
					
//					return "上报成功";
				}
				return "上报失败";
			}
			return "上报失败";
		}
		
		return "上报失败";
	}
	
	@RequestMapping(value="/showAuditRoadRecord",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public RoadAuditInfo ShowAuditRoadRecord(int parentId,String objectType) {
		RoadAuditInfo info = new RoadAuditInfo();
		info.setCode(0);
		if(objectType.equals("钻探单位")||objectType.equals("工点")) {
			info.setCode(200);
			int firstCheckNum = roadRecordService.findFirstCheckNumByParentId(parentId,"钻探单位或工点");
			int secondCheckNum = roadRecordService.findSecondCheckNumByParentId(parentId,"地质组");
			info.setFirstCheckNum(firstCheckNum);
			info.setSecondCheckNum(secondCheckNum);
			RoadRecord roadRecord = roadRecordService.findFirstAuditInfo(parentId);
			info.setAuditRecord(roadRecord);
		}else if(objectType.equals("地质组")){
			info.setCode(200);
			int firstCheckNum = roadRecordService.findFirstCheckNumByParentId(parentId,"钻探单位或工点");
			int secondCheckNum = roadRecordService.findSecondCheckNumByParentId(parentId,"地质组");
			info.setFirstCheckNum(firstCheckNum);
			info.setSecondCheckNum(secondCheckNum);
			RoadRecord roadRecord = roadRecordService.findSecondAuditInfo(parentId);
			info.setAuditRecord(roadRecord);
		}
		
		return info;
	}
	
	
	
	@RequestMapping(value="/auditPassRoadRecord",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public AuditInfo auditPassRoadRecord(int parentId,String objectType,String date,String stage,int id,double roading) {
		System.out.println(stage);
		RoadRecord record = roadRecordService.checkAuditRecordExist(parentId, date, stage);
		AuditInfo info = new AuditInfo();
		if(record != null) {
			
			if(objectType.equals("钻探单位")||objectType.equals("工点")) {
				boolean result = roadRecordService.passFirstAuditById(id,roading);
				if(result) {
					int checkNum = roadRecordService.findFirstCheckNumByParentId(parentId, stage);
					info.setCode(200);
					info.setCheckNum(checkNum);
					info.setResult("上报成功");
					return info;
				}
			}else if(objectType.equals("地质组")){
				boolean result = roadRecordService.passSecondAuditById(id,roading);
				if(result) {
					int checkNum = roadRecordService.findSecondCheckNumByParentId(parentId, stage);
//					info.setCode(200);
//					info.setCheckNum(checkNum);
					
					//查看上报之前的修路长度
					Hole hole = holeService.findHoleById(parentId);
					if(hole!=null) {
						double railLength = hole.getRailLength();
						double newLength = railLength + roading;
						//更新修路长度
						boolean updateResult = holeService.updateRailLength(newLength, parentId);
						if (updateResult) {
							info.setCode(200);
							info.setCheckNum(checkNum);
							info.setResult("上报成功");
							return info;
						}
					}
					
//					info.setResult("上报成功");
//					return info;
				}
			}
			info.setCode(0);
			info.setResult("上报失败");
			return info;
		}
		
		info.setCode(0);
		info.setResult("该审核已被处理");
		return info;
	}
	
	@RequestMapping(value="/auditBackRoadRecord",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public AuditInfo auditBackRoadRecord(int parentId,String objectType,String date,String stage,int id) {
		System.out.println(stage);
		RoadRecord record = roadRecordService.checkAuditRecordExist(parentId, date, stage);
		AuditInfo info = new AuditInfo();
		if(record != null) {
			if(objectType.equals("钻探单位")||objectType.equals("工点")) {
				boolean result = roadRecordService.backAuditById(id);
				if(result) {
					int checkNum = roadRecordService.findFirstCheckNumByParentId(parentId, stage);
					info.setCode(200);
					info.setCheckNum(checkNum);
					info.setResult("退回成功");
					return info;
				}
			}else if(objectType.equals("地质组")){
				boolean result = roadRecordService.backAuditById(id);
				if(result) {
					int checkNum = roadRecordService.findSecondCheckNumByParentId(parentId, stage);
					info.setCode(200);
					info.setCheckNum(checkNum);
					info.setResult("退回成功");
					return info;
				}
			}
			info.setCode(0);
			info.setResult("退回失败");
			return info;
		}
		
		info.setCode(0);
		info.setResult("该审核已被处理");
		return info;
	}
	
	
	@RequestMapping(value="/showAuditDrillingRecord",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public DrillingAuditInfo ShowAuditDrillingRecord(int parentId,String objectType) {
		DrillingAuditInfo info = new DrillingAuditInfo();
		info.setCode(0);
		if(objectType.equals("钻探单位")||objectType.equals("工点")) {
			info.setCode(200);
			int firstCheckNum = drillingRecordService.findFirstCheckNumByParentId(parentId,"钻探单位或工点");
			int secondCheckNum = drillingRecordService.findSecondCheckNumByParentId(parentId,"地质组");
			info.setFirstCheckNum(firstCheckNum);
			info.setSecondCheckNum(secondCheckNum);
			DrillingRecord dRecord = drillingRecordService.findFirstAuditInfo(parentId);
			info.setAuditRecord(dRecord);
		}else if(objectType.equals("地质组")){
			info.setCode(200);
			int firstCheckNum = drillingRecordService.findFirstCheckNumByParentId(parentId,"钻探单位或工点");
			int secondCheckNum = drillingRecordService.findSecondCheckNumByParentId(parentId,"地质组");
			info.setFirstCheckNum(firstCheckNum);
			info.setSecondCheckNum(secondCheckNum);
			DrillingRecord dRecord = drillingRecordService.findSecondAuditInfo(parentId);
			info.setAuditRecord(dRecord);
		}
		
		return info;
	}
	
	@RequestMapping(value="/auditPassDrillingRecord",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public AuditInfo auditPassDrillingRecord(int parentId,String objectType,String date,String stage,int id,double zking) {
		System.out.println(stage);
		DrillingRecord record = drillingRecordService.checkAuditRecordExist(parentId, date, stage);
		AuditInfo info = new AuditInfo();
		if(record != null) {
			
			if(objectType.equals("钻探单位")||objectType.equals("工点")) {
				boolean result = drillingRecordService.passFirstAuditById(id,zking);
				if(result) {
					int checkNum = drillingRecordService.findFirstCheckNumByParentId(parentId, stage);
					info.setCode(200);
					info.setCheckNum(checkNum);
					info.setResult("上报成功");
					return info;
				}
			}else if(objectType.equals("地质组")){
				//查看上报之前的孔深和进尺
				Hole hole = holeService.findHoleById(parentId);
				if(hole!=null) {
					double lastDepth = hole.getRailDepth();
					double footage = zking-lastDepth;
					boolean result = drillingRecordService.passSecondAuditById(id,zking,footage);
					if(result) {
						int checkNum = drillingRecordService.findSecondCheckNumByParentId(parentId, stage);
//						info.setCode(200);
//						info.setCheckNum(checkNum);
//						info.setResult("上报成功");
							
						//更新孔深和进尺
						boolean updateResult = holeService.updateDepthAndFootage(zking, footage, parentId);
						if (updateResult) {
							info.setCode(200);
							info.setCheckNum(checkNum);
							info.setResult("上报成功");
							return info;
						}
						
//						return info;
					}
				}	
				
			}
			info.setCode(0);
			info.setResult("上报失败");
			return info;
		}
		
		info.setCode(0);
		info.setResult("该审核已被处理");
		return info;
	}
	
	@RequestMapping(value="/auditBackDrillingRecord",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public AuditInfo auditBackDrillingRecord(int parentId,String objectType,String date,String stage,int id) {
		System.out.println(stage);
		DrillingRecord record = drillingRecordService.checkAuditRecordExist(parentId, date, stage);
		AuditInfo info = new AuditInfo();
		if(record != null) {
			if(objectType.equals("钻探单位")||objectType.equals("工点")) {
				boolean result = drillingRecordService.backAuditById(id);
				if(result) {
					int checkNum = drillingRecordService.findFirstCheckNumByParentId(parentId, stage);
					info.setCode(200);
					info.setCheckNum(checkNum);
					info.setResult("退回成功");
					return info;
				}
			}else if(objectType.equals("地质组")){
				boolean result = drillingRecordService.backAuditById(id);
				if(result) {
					int checkNum = drillingRecordService.findSecondCheckNumByParentId(parentId, stage);
					info.setCode(200);
					info.setCheckNum(checkNum);
					info.setResult("退回成功");
					return info;
				}
			}
			info.setCode(0);
			info.setResult("退回失败");
			return info;
		}
		
		info.setCode(0);
		info.setResult("该审核已被处理");
		return info;
	}
	
	@RequestMapping(value="/showAuditStateRecord",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public StateAuditInfo ShowAuditStateRecord(int parentId,String objectType) {
		StateAuditInfo info = new StateAuditInfo();
		info.setCode(0);
		if(objectType.equals("钻探单位")||objectType.equals("工点")) {
			info.setCode(200);
			int firstCheckNum = stateRecordService.findFirstCheckNumByParentId(parentId,"钻探单位或工点");
			int secondCheckNum = stateRecordService.findSecondCheckNumByParentId(parentId,"地质组");
			info.setFirstCheckNum(firstCheckNum);
			info.setSecondCheckNum(secondCheckNum);
			StateRecord sRecord = stateRecordService.findFirstAuditInfo(parentId);
			info.setAuditRecord(sRecord);
		}else if(objectType.equals("地质组")){
			info.setCode(200);
			int firstCheckNum = stateRecordService.findFirstCheckNumByParentId(parentId,"钻探单位或工点");
			int secondCheckNum = stateRecordService.findSecondCheckNumByParentId(parentId,"地质组");
			info.setFirstCheckNum(firstCheckNum);
			info.setSecondCheckNum(secondCheckNum);
			StateRecord sRecord = stateRecordService.findSecondAuditInfo(parentId);
			info.setAuditRecord(sRecord);
		}
		
		return info;
	}
	
	@RequestMapping(value="/auditPassStateRecord",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public AuditInfo auditPassStateRecord(int parentId,String objectType,String date,String stage,int id,String state) {
		System.out.println(stage);
		StateRecord record = stateRecordService.checkAuditRecordExist(parentId, date, stage);
		AuditInfo info = new AuditInfo();
		if(record != null) {
			
			if(objectType.equals("钻探单位")||objectType.equals("工点")) {
				boolean result = stateRecordService.passFirstAuditById(id,state);
				if(result) {
					int checkNum = stateRecordService.findFirstCheckNumByParentId(parentId, stage);
					info.setCode(200);
					info.setCheckNum(checkNum);
					info.setResult("上报成功");
					return info;
				}
			}else if(objectType.equals("地质组")){
				boolean result = stateRecordService.passSecondAuditById(id,state);
				if(result) {
					int checkNum = stateRecordService.findSecondCheckNumByParentId(parentId, stage);
					
					//更新钻孔状态
					boolean updateResult = holeService.updateRailState(state, parentId);
					if (updateResult) {
						info.setCode(200);
						info.setCheckNum(checkNum);
						info.setResult("上报成功");
						return info;
					}	
					
				}
			}
			info.setCode(0);
			info.setResult("上报失败");
			return info;
		}
		
		info.setCode(0);
		info.setResult("该审核已被处理");
		return info;
	}
	
	@RequestMapping(value="/auditBackStateRecord",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public AuditInfo auditBackStateRecord(int parentId,String objectType,String date,String stage,int id) {
		System.out.println(stage);
		StateRecord record = stateRecordService.checkAuditRecordExist(parentId, date, stage);
		AuditInfo info = new AuditInfo();
		if(record != null) {
			if(objectType.equals("钻探单位")||objectType.equals("工点")) {
				boolean result = stateRecordService.backAuditById(id);
				if(result) {
					int checkNum = stateRecordService.findFirstCheckNumByParentId(parentId, stage);
					info.setCode(200);
					info.setCheckNum(checkNum);
					info.setResult("退回成功");
					return info;
				}
			}else if(objectType.equals("地质组")){
				boolean result = stateRecordService.backAuditById(id);
				if(result) {
					int checkNum = stateRecordService.findSecondCheckNumByParentId(parentId, stage);
					info.setCode(200);
					info.setCheckNum(checkNum);
					info.setResult("退回成功");
					return info;
				}
			}
			info.setCode(0);
			info.setResult("退回失败");
			return info;
		}
		
		info.setCode(0);
		info.setResult("该审核已被处理");
		return info;
	}
}
