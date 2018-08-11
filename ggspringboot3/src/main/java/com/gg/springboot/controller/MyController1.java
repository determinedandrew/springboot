package com.gg.springboot.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gg.springboot.config.MyConfig;

@Controller
public class MyController1 {
	//基础测试
	@GetMapping("/getData")
	public @ResponseBody Map<String,String> getData(@RequestParam("in") String in){
		Map<String,String> map = new HashMap<String,String>();
		map.put("hellow", "spring boot"+in);
		return map;
	}
	//配置读取测试
	@RequestMapping(value="/getConfig",method=RequestMethod.GET)
	public @ResponseBody String getConfig(){
		return MyConfig.getGgRemotePort()+"---"+MyConfig.getGgRoot()+"---"+MyConfig.getGgTime();
	}
}
