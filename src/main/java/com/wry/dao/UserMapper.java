package com.wry.dao;

import java.util.List;
import java.util.Map;

import com.wry.annotation.MybatisDateBaseOracleOne;
import com.wry.model.User;
import com.wry.annotation.MybatisDateBaseOracleOne;
import com.wry.model.User;
@MybatisDateBaseOracleOne
public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	List<User> getAll(Map<String, Object> map);

	List<User> getAll2();

	List<User> selectByParameter(Map<String, Object> map);
	User findUserByLoginName(Map<String, Object> map);

	Integer getAllCount();
}