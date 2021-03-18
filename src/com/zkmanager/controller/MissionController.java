package com.zkmanager.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.zkmanager.po.Hole;
import com.zkmanager.po.Mission;
import com.zkmanager.service.HoleService;
import com.zkmanager.utils.ReadExcel;

@Controller
public class MissionController {

	private static final Integer startLine = 4;
	
	@Autowired
	private HoleService holeService;
	
	@Autowired
	
	private List<Mission> missions = new ArrayList<>();
	
	private List<Hole> holeList;
	
	@RequestMapping(value = "/receiveFile", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public List<Mission> receiveFile(HttpServletRequest request) {
		// 转换为 MultipartHttpServletRequest
		if (request instanceof MultipartHttpServletRequest) {
			MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
			// 通过表单中的参数名来接收文件流（可用 file.getInputStream() 来接收输入流）
			MultipartFile file = multipartRequest.getFile("file");

			try {
				InputStream in = file.getInputStream();
				missions = ReadExcel.readExcel(in, startLine);
			} catch (IOException e) {
				e.printStackTrace();
			}

			return missions;
		} else {
			return null;
		}
	}
}
