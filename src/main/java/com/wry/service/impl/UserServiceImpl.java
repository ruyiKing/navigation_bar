package com.wry.service.impl;

import java.util.List;
import java.util.Map;

import com.wry.dao.UserMapper;
import com.wry.model.User;
import com.wry.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User findUserById(Long id) {
		return userMapper.selectByPrimaryKey(id);
	}
	
	public Long getuserid(Long id){
		System.out.println(id);
		return id;
	}

	@Override
	public List<User> getAll(Map<String, Object> map) {
		return userMapper.getAll(map);
	}

	@Override
	public List<User> getAll2() {
		return userMapper.getAll2();
	}

	@Override
	public List<User> findUserByName(Map<String, Object> map) {
		return userMapper.selectByParameter(map);
	}

	@Override
	public User findUserByLoginName(Map<String, Object> map) {
		return userMapper.findUserByLoginName(map);
	}

	@Override
	public int addUsers(User user) {
		return userMapper.insert(user);
	}

	@Override
	public Integer getAllCount() {
		return userMapper.getAllCount();
	}




}
