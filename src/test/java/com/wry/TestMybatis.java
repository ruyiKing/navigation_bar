package com.wry;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;

import com.wry.model.SysPermItem;
import com.wry.model.User;
import com.wry.service.SysPermItemService;
import com.wry.service.UserRoleService;
import com.wry.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml", "classpath:spring-mybatis.xml" })
@Transactional
@TransactionConfiguration(transactionManager = "transactionManagerOne", defaultRollback = false)
public class TestMybatis {
	private static final Logger logger = Logger.getLogger(TestMybatis.class);	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRoleService userRoleService;

	@Autowired
	private SysPermItemService sysPermItemService;
	
	@Test
	public void test1(){
		User u = userService.findUserById(194540L);
		logger.info(JSON.toJSONStringWithDateFormat(u, "yyyy-MM-dd"));
		/*String s = userService.getuserid("1");
		System.out.println(s);*/
	}
	@Test
	public void test5(){
		BigDecimal b=new BigDecimal(520);
		SysPermItem spi = sysPermItemService.findModelById(b);
		logger.info(JSON.toJSONStringWithDateFormat(spi, "yyyy-MM-dd"));
		/*String s = userService.getuserid("1");
		System.out.println(s);*/
	}

	@Test
	public void test2() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageSize", 10);  
		map.put("pageIndex", 0);
		List<User> list=userService.getAll(map);
		logger.info(JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd"));
	}
	
//	@Test
//	public void test3addUserRole() {
//		for(int i=1;i<=5;i++){
//			UserRole userRole = new UserRole();
//			userRole.setId(String.valueOf(i));
//			userRole.setRoleId("1");
//			userRole.setUserId("1");
//			userRoleService.addUserRole(userRole);
//			
//		}
//	}
	@Test
	public void addUser() {
		int c = 0;
		for(int i = 1;i<=10000;i++){
			User user = new User();
			if(i<=2000){
				user.setName("赵"+String.valueOf(i));
				user.setLoginName("zhao"+String.valueOf(i));
			}else if(i>2000 && i<=3000){
				user.setName("田"+String.valueOf(i));
				user.setLoginName("tian"+String.valueOf(i));
			}else {
				user.setName("严"+String.valueOf(i));
				user.setLoginName("yan"+String.valueOf(i));
			}
			user.setPwd("123456");
			user.setUpdateTime(new Date());
			user.setCreateTime(new Date());
			int iuser = userService.addUsers(user);
			c += iuser;
		}
		logger.info("插入"+c+"个用户。");
	}
	
	@Test
	public void test4() {
		List<User> list=userService.getAll2();
		logger.info(JSON.toJSONStringWithDateFormat(list, "yyyy-MM-dd"));
	}


}
