package com.wry.service;

import com.wry.model.BarClassify;
import com.wry.model.User;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * Created by frankie on 2017/8/1.
 */
public interface BarClassifyService {

    List<BarClassify> findAllByParams(Map<String, Object> map) ;

    Integer getAllCount();

    int deleteByPrimaryKey(BigDecimal id);

    int insert(BarClassify record);

    int insertSelective(BarClassify record);

    BarClassify selectByPrimaryKey(BigDecimal id);

    int updateByPrimaryKeySelective(BarClassify record);

    int updateByPrimaryKey(BarClassify record);

    void saveBarClassify(BarClassify barClassify);
}
