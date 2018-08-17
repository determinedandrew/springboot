package com.gg.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.gg.springboot.mapper.IRiskInfoMapper;
import com.gg.springboot.model.RiskInfo;

@Controller//测试jsp
public class MyController3 {
	@Autowired
	private IRiskInfoMapper riskInfoMapper;

	@GetMapping("/getIndexJsp")
	public String getIndexJsp(@RequestParam("jspInfo") String jspInfo,Model model){
		model.addAttribute("jspInfo", jspInfo);
		return "index";
	}
	
	@GetMapping("/getDataBase")
	@Transactional
	public String getDataBase(Model model){
		RiskInfo riskInfo = new RiskInfo();
		riskInfo.setRiskCode("1000048565475");
		List<RiskInfo> riskInfos = riskInfoMapper.getRiskInfos(riskInfo);
		model.addAttribute("jspInfo", riskInfos);
		return "index";
	}
	
	@GetMapping("/getDataBaseForRestfull/{id}")
	public String getDataBaseForRestfull(@PathVariable("id") String id,Model model){
		RiskInfo riskInfo = new RiskInfo();
		riskInfo.setRiskCode("1000048565475");
		List<RiskInfo> riskInfos = riskInfoMapper.getRiskInfos(riskInfo);
		model.addAttribute("jspInfo", riskInfos);
		return "index";
	}
	
	
}
