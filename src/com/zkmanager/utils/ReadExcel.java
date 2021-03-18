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

import com.zkmanager.po.Mission;

public class ReadExcel {
	public static List<Mission> readExcel(InputStream in, Integer startLine)
			throws EncryptedDocumentException, IOException {
		List<Mission> missions = new ArrayList<>();
		Workbook workbook = WorkbookFactory.create(in);

		// 获取到每一张表
		for (int sheetNum = 0; sheetNum < workbook.getNumberOfSheets(); sheetNum++) {
			Sheet sheet = workbook.getSheetAt(sheetNum);
			
			//获取到最后一行文本，以获取到接收单位
			Cell lastCell = sheet.getRow(sheet.getLastRowNum()).getCell(0);
			String str[] = lastCell.getStringCellValue().split("接收单位（全称）：");
			String receiver = str[1];
			System.out.println(str[1]);
			
			System.out.println(sheet.getSheetName());
			for (int rowNum = startLine; rowNum <= sheet.getLastRowNum() - 1; rowNum++) {
				Row row = sheet.getRow(rowNum);

				// 如果读取到每一行的第一个单元格为空，那么直接结束循环
				if (row.getCell(row.getFirstCellNum()).getCellType() == CellType.BLANK)
					break;
				Mission mission = new Mission();
				Map<Integer, Object> map = new HashMap<>();
				for (int colNum = 0; colNum < 8; colNum++) {
					Cell cell = row.getCell(colNum);
					if (cell.getCellType() == CellType.STRING) {
						System.out.print(cell.getStringCellValue() + "\t");
						map.put(colNum, cell.getStringCellValue());
					} else {
						System.out.print(cell.getNumericCellValue() + "\t");
						map.put(colNum, cell.getNumericCellValue());
					}
				}
				System.out.println();
				mission.setZkNum(map.get(1).toString());//编号
				mission.setLittleProName(map.get(2).toString());//工点名称
				mission.setRailLength((Double)map.get(3));//钻孔里程
				mission.setDesignOffset((Double)map.get(4));//偏距
				mission.setX((Double)map.get(5));//坐标x
				mission.setY((Double)map.get(6));//坐标y
				mission.setDesignDeep((Double)map.get(7));//设计深度
				mission.setType(sheet.getSheetName());//钻孔类型
				mission.setReceiver(receiver);//接收者
				missions.add(mission);
			}
			
		}
		return missions;

	}
}
