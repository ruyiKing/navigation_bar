package com.wry.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wry.model.User;
import com.wry.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import com.wry.util.DataGridModel;

@Controller
@RequestMapping("/user")
public class UserController {
	private static final Logger logger = Logger.getLogger(UserController.class) ;

	@Autowired
	private UserService userService;
	
	@RequestMapping("/showUser.do")
	public String showUser(HttpServletRequest request) {
		Long id = Long.parseLong(request.getParameter("id"));
		User u = userService.findUserById(id);
		logger.info("登录名："+u.getName());
		request.setAttribute("user", u);
		return "jsp/user/showUser";
	}
	
	@RequestMapping("/userList.do")
	public String userList() {
		logger.info("跳转返回userList");
		return "/jsp/user/userList";
	}
	
	@RequestMapping("/finduserList.do")
	@ResponseBody
	public Object finduserList(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(required = false, defaultValue = "1") Integer page, //第几页  
			@RequestParam(required = false, defaultValue = "10") Integer rows, //页数大小  

			DataGridModel dgm) {
		List<User> finduserList= new ArrayList<User>();
		Integer count = 0;
		String userName = request.getParameter("queryUserName");
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userName", userName);
		map.put("begin", (page-1)*rows);  
		map.put("end", page*rows);  

		logger.info("+++++查询条件userName="+map.get("userName")+" begin="+map.get("begin")+" end="+map.get("end"));
//		String userName = "赵四";
		if(userName!=null && userName!=""){
			finduserList=userService.findUserByName(map);
		}else {
			logger.info("查询总条数begin...");
			count = userService.getAllCount();
			logger.info("查询总条数end...");
			finduserList=userService.getAll(map);
		}
		JSONObject result = new JSONObject();  
		String jsonArray = JSONArray.toJSONStringWithDateFormat(finduserList , "yyyy-MM-dd");
		logger.info("jsonArray= = >:"+jsonArray+" 查询总条数："+count);
		result.put("total", count);  
		result.put("rows", JSONObject.parse(jsonArray));  

        //return JSONObject.parseArray(jsonArray);
		return result; 
	}
}
