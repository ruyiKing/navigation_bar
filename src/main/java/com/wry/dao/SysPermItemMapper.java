package com.wry.dao;

import java.math.BigDecimal;

import com.wry.annotation.MybatisDateBaseOracleTwo;
import com.wry.annotation.MybatisDateBaseOracleTwo;
import com.wry.model.SysPermItem;
@MybatisDateBaseOracleTwo
public interface SysPermItemMapper {
    int deleteByPrimaryKey(BigDecimal id);

    int insert(SysPermItem record);

    int insertSelective(SysPermItem record);

    SysPermItem selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(SysPermItem record);

    int updateByPrimaryKey(SysPermItem record);
}