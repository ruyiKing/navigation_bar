package com.wry.service.impl;

import com.wry.dao.UserRoleMapper;
import com.wry.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wry.dao.UserRoleMapper;
import com.wry.model.UserRole;
import com.wry.service.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService {
	
	@Autowired
	private UserRoleMapper userRoleMapper;

	@Override
	public void addUserRole(UserRole userRole) {
		userRoleMapper.insert(userRole);

	}

}
