package com.zkmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import com.zkmanager.po.DrillingUnit;
import com.zkmanager.po.GeoGroup;
import com.zkmanager.po.ObjectTable;
import com.zkmanager.po.Statistician;
import com.zkmanager.service.DrillingUnitService;
import com.zkmanager.service.GeoGroupService;
import com.zkmanager.service.HoleService;
import com.zkmanager.service.ObjectService;
import com.zkmanager.service.StatisticianService;
import com.zkmanager.service.WorkPointService;

@Controller
public class StatisticsController {
	
	@Autowired
	private GeoGroupService geoGroupService;
	
	@Autowired
	private DrillingUnitService drillingUnitService;
	
	@Autowired
	private WorkPointService workPointService;
	
	@Autowired
	private HoleService holeService;
	
	@Autowired
	private StatisticianService statisticianService;
	
	@Autowired
	private ObjectService objectService;
	
//	@Scheduled(cron = "0/20 * * * * ?")
//	public void StatisticsData() {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//		String date = sdf.format(new Date());
//		double shadowZkg = holeService.countZkm(40, "浅孔");
//		System.out.println(date+"当前:"+shadowZkg);
//	}
	
	@Scheduled(cron = "0 0 0 * * ?")
	public void StatisticsData() {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String date = sdf.format(new Date());
//        System.out.println(date + ": 执行定时任务job....");
		List<Statistician> result = statisticianService.findAllStatistician();
		if(result.size()!=0) {
			for(int i=0;i<result.size();i++) {
				int parentId = result.get(i).getParentId();
				int id = result.get(i).getId();
				String type = result.get(i).getType();
				ObjectTable result1 = objectService.findTypeById(parentId);
				String objectType = result1.getType();
				if(objectType.equals("项目")) {
					List<GeoGroup> result2 = geoGroupService.queryGeoGroupsByBigProId(parentId);
					if (result2!=null) {
						double zkm = 0;
						double zkmSum = 0;
						int zkg = 0;
						int zkgSum = 0;
						double xlm = 0;
						double xlmSum = 0;
						for(int j=0;j<result2.size();j++) {
							int geoGroupId = result2.get(j).getId();
							List<DrillingUnit> result3 = drillingUnitService.findDrillingUnitByParentId(geoGroupId);
							if(result3.size()!=0) {
								for(int k=0;k<result3.size();k++) {
									int unitId = result3.get(k).getId();
									zkm = zkm + holeService.countZkm(unitId, type);
									zkmSum = zkmSum + holeService.countZkmSum(unitId, type);
									zkg = zkg + holeService.countZkg(unitId, type);
									zkgSum = zkgSum + holeService.countZkgSum(unitId, type);
									xlm = xlm + holeService.countXlm(unitId, type);
									xlmSum = xlmSum + holeService.countXlmSum(unitId, type);
								}
							}
						}
						boolean updateResult = statisticianService.updateDataById(id, zkm, zkmSum, zkg, zkgSum, xlm, xlmSum);
						if(updateResult) {
							System.out.println("更新成功");
						}
					}
				}else if (objectType.equals("地质组")) {
					List<DrillingUnit> result2 = drillingUnitService.findDrillingUnitByParentId(parentId);
					if(result2.size()!=0) {
						double zkm = 0;
						double zkmSum = 0;
						int zkg = 0;
						int zkgSum = 0;
						double xlm = 0;
						double xlmSum = 0;
						for(int j=0;j<result2.size();j++) {
							int unitId = result2.get(j).getId();
							zkm = zkm + holeService.countZkm(unitId, type);
							zkmSum = zkmSum + holeService.countZkmSum(unitId, type);
							zkg = zkg + holeService.countZkg(unitId, type);
							zkgSum = zkgSum + holeService.countZkgSum(unitId, type);
							xlm = xlm + holeService.countXlm(unitId, type);
							xlmSum = xlmSum + holeService.countXlmSum(unitId, type);
							
//							System.out.println(date+"："+unitId +"+"+j+" zkm:"+zkm);
//							System.out.println(date+"："+unitId+"+"+j+" zkmSum:"+zkmSum);
//							System.out.println(date+"："+unitId +"+"+j+" zkg:"+zkg);
//							System.out.println(date+"："+unitId+"+"+j+" zkgSum:"+zkgSum);
						}
						
						boolean updateResult = statisticianService.updateDataById(id, zkm, zkmSum, zkg, zkgSum, xlm, xlmSum);
						if(updateResult) {
							System.out.println("更新成功");
						}
					}
				}else if(objectType.equals("工点")) {
					double zkm = holeService.countZkmPoint(parentId, type);
					double zkmSum = holeService.countZkmSumPoint(parentId, type);
					int zkg = holeService.countZkgPoint(parentId, type);
					int zkgSum = holeService.countZkgSumPoint(parentId, type);
					double xlm = holeService.countXlmPoint(parentId, type);
					double xlmSum = holeService.countXlmSumPoint(parentId, type);
					
					boolean updateResult = statisticianService.updateDataById(id, zkm, zkmSum, zkg, zkgSum, xlm, xlmSum);
					if(updateResult) {
						System.out.println("更新成功");
					}
				}else if(objectType.equals("钻探单位")) {
					
					double zkm = holeService.countZkm(parentId, type);
					double zkmSum = holeService.countZkmSum(parentId, type);
					int zkg = holeService.countZkg(parentId, type);
					int zkgSum = holeService.countZkgSum(parentId, type);
					double xlm = holeService.countXlm(parentId, type);
					double xlmSum = holeService.countXlmSum(parentId, type);
					
					boolean updateResult = statisticianService.updateDataById(id, zkm, zkmSum, zkg, zkgSum, xlm, xlmSum);
					if(updateResult) {
						System.out.println("更新成功");
					}
					
//					System.out.println(date+"："+parentId+" zkm:"+zkm);
//					System.out.println(date+"："+parentId+" zkmSum:"+zkmSum);
					
				}
			}
		}else {
			System.out.println("统计器为空");
		}
			
		
    }

}
