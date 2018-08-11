package com.gg.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController//表示此类中所有方法均返回json
public class MyController2 {
	
	@RequestMapping("/getListJson")
	public List<String> getListJson(@RequestParam("in") String in){
		List<String> list = new ArrayList<String>();
		list.add("hello");
		list.add("spring");
		list.add("boot");
		list.add(in);
		return list;
	}

}
