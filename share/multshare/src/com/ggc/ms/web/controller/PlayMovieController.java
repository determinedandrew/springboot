package com.ggc.ms.web.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ggc.ms.pojo.CommenPO;
import com.ggc.ms.pojo.ResourcePO;
import com.ggc.ms.service.ICommenService;
import com.ggc.ms.service.IResourceService;


@Controller
@RequestMapping("/playMovie")
public class PlayMovieController {
	@Resource(name="commenService")
	private ICommenService commenService;
	@Resource(name="resourceService")
	private IResourceService resourceService;
	
	@RequestMapping("/list.do")
	public String list(Map<String,Object> map){
		CommenPO commenPO = commenService.getByCcode("serviceaddress");
		map.put("serviceaddress",commenPO.getCvalue());
		return "play-movie-list";
	}
	
	/**
	 * 获取展示信息
	 * @param condetion
	 * @return
	 */
	@RequestMapping("/getByPage.do")
	@ResponseBody
	public Object getByPage(ResourcePO resourcePO){
		//resourcePO.setPageSize(6);//默认每页显示6张以后再做改进由前段进行传值
		resourcePO.setReadgrade(0);//先设置所有资源均可访问
		//{"total":100,"dataList":[{"":"","":"","":"","":""},{},{}]}
		return resourceService.getByCondetionPage(resourcePO);
	}
	
	/**
	 * 获取推荐影片信息
	 * @param condetion
	 * @return
	 */
	@RequestMapping("/getTuijian.do")
	@ResponseBody
	public Object getTuijian(){
		//{"total":100,"dataList":[{"":"","":"","":"","":""},{},{}]}
		ResourcePO resourcePO = new ResourcePO();
		resourcePO.setSpecialmark("tuijian");
		resourcePO.setRetype("play-movie");
		return resourceService.getSpecial(resourcePO);//推荐tuijian
	}
	
	@RequestMapping("/play.do")
	public String play(Map<String,Object> map,String reid){
		ResourcePO playMovie = resourceService.getById(reid);
		CommenPO commenPO = commenService.getByCcode("serviceaddress");
		map.put("serviceaddress",commenPO.getCvalue());
		map.put("playMovie",playMovie);
		return "play-movie";
	}
	
}
