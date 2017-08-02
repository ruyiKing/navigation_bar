package com.wry.service.impl;

import com.wry.dao.BarClassifyMapper;
import com.wry.model.BarClassify;
import com.wry.service.BarClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by frankie on 2017/8/1.
 */
@Service
public class BarClassifyServiceImpl implements BarClassifyService{

    @Autowired
    private BarClassifyMapper barClassifyMapper;

    @Override
    public List<BarClassify> findAllByParams(Map<String, Object> map) {
        return barClassifyMapper.findAllByParams(map);
    }

    @Override
    public int deleteByPrimaryKey(BigDecimal id) {
        return 0;
    }

    @Override
    public int insert(BarClassify record) {
        return 0;
    }

    @Override
    public int insertSelective(BarClassify record) {
        return 0;
    }

    @Override
    public BarClassify selectByPrimaryKey(BigDecimal id) {
        return null;
    }

    @Override
    public int updateByPrimaryKeySelective(BarClassify record) {
        return 0;
    }

    @Override
    public int updateByPrimaryKey(BarClassify record) {
        return 0;
    }

    @Override
    public void saveBarClassify(BarClassify barClassify) {
        Integer seq = barClassifyMapper.seqBarClassify();
        barClassify.setId(new BigDecimal(seq));
        barClassify.setDateCreated(new Date());
        barClassifyMapper.insert(barClassify);
    }

    @Override
    public Integer getAllCount() {
        return barClassifyMapper.getAllCount();
    }
}
