package com.ggc.ms.web.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ggc.ms.pojo.CommenPO;
import com.ggc.ms.service.ICommenService;


@Controller
@RequestMapping("/main")
public class MainController {
	
	@Resource(name="commenService")
	private ICommenService commenService;
	
	@RequestMapping("mainSwiper.do")
	public String main(Map<String,Object> map){
		CommenPO commenPO = commenService.getByCcode("serviceaddress");
		map.put("serviceaddress",commenPO.getCvalue());
		return "mains-wiper";
	}
	@RequestMapping("/changepwd.do")
	public String changepwd(){
		return "changepwd";
	}
	
	@RequestMapping("/login.do")
	@ResponseBody
	public Object login(String accountNo,String password,HttpServletRequest request){
		//{"success":true}成功 {"success":false,"errMsg":""}失败
		/*Map<String,Object> jsonMap = new HashMap<String,Object>();
		try {
			String ip = request.getRemoteAddr();
			//System.out.println(ip);
			User user = userService.login(accountNo,MD5Util.MD5(password),ip);
			//如果登录认证成功了    将用户信息放到session中
			request.getSession().setAttribute(Constant.SESSION_USER, user);
			
			//如果用户登录成功,将这个用户能够操作的所有url获取并放到session
			Set<String> urls = userService.getUrlsByUserId(user.getId());
			request.getSession().setAttribute(Constant.URLS, urls);
			
			jsonMap.put("success", true);
		} catch (ApplicationException e) {
			jsonMap.put("success", false);
			jsonMap.put("errMsg", e.getMessage());
		}
		return jsonMap;*/
		return null;
	}
}
