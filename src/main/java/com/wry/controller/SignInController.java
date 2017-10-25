package com.wry.controller;

import com.wry.model.User;
import com.wry.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by frankie on 2017/9/20.
 */
@Controller
@RequestMapping("/sign")
public class SignInController {
    private static final Logger logger = Logger.getLogger(UserController.class) ;

    @Autowired
    private UserService userService;


    @RequestMapping("/signIn.do")
    public String signIn(Long id,HttpServletRequest request) {
        Map<String,Object> map = new HashMap<String,Object>();
        String loginName = request.getParameter("inputEmail");
        map.put("loginName", loginName);
        User u = userService.findUserByLoginName(map);
        if (u==null){
//            logger.info("登录用户："+u.getLoginName());
//            request.setAttribute("user", u);
            return "jsp/signIn/signIn";
        }else {
            logger.info("登录用户："+u.getLoginName());
            request.setAttribute("user", u);
            return "main";
        }

    }

}
