package com.wry.dao;

import com.wry.annotation.MybatisDateBaseOracleOne;
import com.wry.annotation.MybatisDateBaseOracleOne;
import com.wry.model.UserRole;
@MybatisDateBaseOracleOne
public interface UserRoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);
}