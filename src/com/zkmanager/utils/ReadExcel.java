package com.zkmanager.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.zkmanager.po.DrillingUnit;
import com.zkmanager.po.Mission;
import com.zkmanager.po.ObjectTable;
import com.zkmanager.po.WorkPoint;
import com.zkmanager.service.DrillingUnitService;
import com.zkmanager.service.ObjectService;
import com.zkmanager.service.PersonService;
import com.zkmanager.service.WorkPointService;

@Component
public class ReadExcel {

	@Autowired
	private PersonService personService;

	@Autowired
	private DrillingUnitService drillingUnitService;

	@Autowired
	private ObjectService objectService;
	
	@Autowired 
	private WorkPointService workPointService;

	
	@Transactional(rollbackFor = Exception.class)
	public List<Mission> readexcel(InputStream in, Integer startLine) throws EncryptedDocumentException, IOException {
		if (in == null)
			return null;

		List<Mission> missions = new ArrayList<>();
		Workbook workbook = WorkbookFactory.create(in);

		// 获取到每一张表
		for (int sheetNum = 0; sheetNum < workbook.getNumberOfSheets(); sheetNum++) {
			Sheet sheet = workbook.getSheetAt(sheetNum);

			// 获取到最后一行文本，以获取到接收单位和设计负责人
			Cell lastCell = sheet.getRow(sheet.getLastRowNum()).getCell(0);
			String str1[] = lastCell.getStringCellValue().split("接收单位（全称）：");
			// 接收单位
			String receiver = str1[1].trim();
//			System.out.println(str[1]);
//			 [0]编制：           年   月   日    复核：            年   月   日    ,[1]年   月   日    接收人：           年   月   日   接收单位（全称）：地勘钻探单位3
			String str2[] = lastCell.getStringCellValue().split("设计负责人：");
//			[0]（设计负责人）,[1]   月   日    接收人：           ,[2]   月   日   接收单位（全称）：地勘钻探单位3
			String str3[] = str2[1].split("年");
			// 设计负责人
			String designer = str3[0].trim();
			System.out.println(designer);
			// 因为地质组id和联系人id是一致的
			Integer geoId = personService.findIdByName(designer);
//			检查是否存在该地质组
			if (drillingUnitService.findDrillingUnitByFullName(receiver) == 1) { // 如果存在
//				检查该单位是否属于该地质组
				Integer unitParentId = drillingUnitService.findParentIdByFullName(receiver);

				if (unitParentId != geoId) { // 单位不属于地质组
					return null;
				}
			} else { // 不存在,则新建
				DrillingUnit unit = new DrillingUnit();
				Integer unitId = objectService.insertObject("钻探单位");
				unit.setId(unitId);
				unit.setParentId(geoId);
				unit.setContactorId(geoId);
				unit.setLength(0);
				unit.setName("钻探单位" + unitId.toString());
				unit.setFullName(receiver);
				drillingUnitService.insertDrillingUnit(unit);
			}

//			System.out.println(sheet.getSheetName());

			String name = sheet.getSheetName();
			if (name.equals("其他类型")) {
				name = "其他";
			}

			/*
			 * startLine:开始读取的行 最后一行不读,
			 */
			for (int rowNum = startLine; rowNum <= sheet.getLastRowNum() - 1; rowNum++) {
				Row row = sheet.getRow(rowNum);

				// 如果读取到每一行的第一个单元格为空，那么直接结束循环
				if (row.getCell(row.getFirstCellNum()).getCellType() == CellType.BLANK)
					break;
				Mission mission = new Mission();
				// 用来存储每一个单元格的内容，并用列索引做key值
				Map<Integer, Object> map = new HashMap<>();
				for (int colNum = 0; colNum < 8; colNum++) {
					Cell cell = row.getCell(colNum);

					// 检查单元格内容数据类型，如果是string类型
					if (cell.getCellType() == CellType.STRING) {
						System.out.print(cell.getStringCellValue() + "\t");
						map.put(colNum, cell.getStringCellValue());
					} else { // 如果是其他类型（number类型）
						System.out.print(cell.getNumericCellValue() + "\t");
						map.put(colNum, cell.getNumericCellValue());
					}
				}
				System.out.println();
				
				//检查工点是否存在
				String workPointName = map.get(2).toString();
				if(workPointService.findWorkPointIdByFullName(workPointName) == null) {	//不存在
//					创建
					WorkPoint point = new WorkPoint();
					Integer id = objectService.insertObject("工点");
					point.setId(id);
					point.setFullName(workPointName);
					point.setLength(0);
					point.setName("工点" + id);
					point.setParentId(geoId);
					point.setContactorId(geoId);
					workPointService.insertWorkPoint(point);
				}
				
				
//				将各单元格的内容写入到mission对象中
				mission.setZkNum(map.get(1).toString());// 编号
				mission.setLittleProName(map.get(2).toString());// 工点名称
				mission.setRailLength((Double) map.get(3));// 钻孔里程
				mission.setDesignOffset((Double) map.get(4));// 偏距
				mission.setX((Double) map.get(5));// 坐标x
				mission.setY((Double) map.get(6));// 坐标y
				mission.setDesignDeep((Double) map.get(7));// 设计深度
				mission.setType(name);// 钻孔类型
				mission.setReceiver(receiver);// 接收者
				mission.setDesigner(designer);// 设计者
				missions.add(mission);
			}

		}
//		返回mission对象(list列表)
		return missions;
	}
}
