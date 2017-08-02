package com.wry.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wry.model.BarClassify;
import com.wry.model.User;
import com.wry.service.BarClassifyService;
import com.wry.service.UserService;
import com.wry.util.DataGridModel;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by frankie on 2017/8/1.
 */

@Controller
@RequestMapping("/barClassify")
public class BarClassifyController {
    private static final Logger logger = Logger.getLogger(UserController.class) ;

    @Autowired
    private BarClassifyService barClassifyService;

    @RequestMapping("/barClassifyList.do")
    public String userList() {
        logger.info("barClassifyList");
        return "/jsp/barClassify/barClassifyList";
    }

    @RequestMapping("/findBarClassifyList.do")
    @ResponseBody
    public Object findBarClassifyList(HttpServletRequest request,
                               HttpServletResponse response,
                               @RequestParam(required = false, defaultValue = "1") Integer page, //第几页
                               @RequestParam(required = false, defaultValue = "10") Integer rows, //页数大小

                               DataGridModel dgm) {
        List<BarClassify> findBarClassifyList;
        Integer count = 0;
//        String userName = request.getParameter("queryUserName");
        Map<String,Object> map = new HashMap<String,Object>();
//        map.put("userName", userName);
        map.put("begin", (page-1)*rows);
        map.put("end", page*rows);

        logger.info("+++++查询条件"+" begin="+map.get("begin")+" end="+map.get("end"));

        logger.info("查询总条数begin...");
        count = barClassifyService.getAllCount();
        logger.info("查询总条数end...");
        findBarClassifyList=barClassifyService.findAllByParams(map);

        JSONObject result = new JSONObject();
        String jsonArray = JSONArray.toJSONStringWithDateFormat(findBarClassifyList, "yyyy-MM-dd");
        logger.info("jsonArray= = >:"+jsonArray+" 查询总条数："+count);
        result.put("total", count);
        result.put("rows", JSONObject.parse(jsonArray));

        //return JSONObject.parseArray(jsonArray);
        return result;
    }


    @RequestMapping("/saveBarClassify.do")
    @ResponseBody
    public Object saveBarClassify(HttpServletRequest request,
                               HttpServletResponse response,
                               DataGridModel dgm) {
        BarClassify barClassify = new BarClassify();
        barClassify.setClassifyName(request.getParameter("classifyName"));
        barClassifyService.saveBarClassify(barClassify);
        JSONObject result = new JSONObject();
        return result;
    }
}
