package com.template.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.template.common.util.JsonUtil;
import com.template.mybatis.mapper.TestMapper;
import com.template.test.model.Test;

import ch.qos.logback.classic.Logger;
import net.minidev.json.JSONArray;

@RestController
public class MainContoller {
	
	@Autowired
	TestMapper testMapper;
	
	
	
	@GetMapping("/json/main/xss")
	public String xss(String tmp) {
		return tmp;
	}
	@GetMapping("/selectAll")
	public String selectAll() {
		List<Test> list = testMapper.getTestListAll();
		while(true) {
			if (list.isEmpty()) {
				System.out.println("sdfsdfsdfsdfsdfsds");
				break;
			}
		}
		return JsonUtil.toJsonString(list);
	}
	
	@GetMapping("/selectList")
	public String getTestList() {
		Test test=  new Test();
		test.setTmp("&");
		List<Test> list = testMapper.getTestList(test);
		return JsonUtil.toJsonString(list);
	}
	
	@GetMapping("/securiySHA")
	public String security() {
		
		return "";
	}
	
	
}
