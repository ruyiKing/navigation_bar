package com.wry.service;

import com.wry.model.SysPermItem;
import com.wry.model.SysPermItem;

import java.math.BigDecimal;

/**
 * Created by fate on 2016/7/5.
 */
public interface SysPermItemService {

    SysPermItem findModelById(BigDecimal id);
}
