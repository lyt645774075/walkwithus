/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved
 */

package cn.walkwithus.controller;

import cn.walkwithus.manager.ActivityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author yangtao.lyt
 * @version $Id: WebHomeController, v 0.1 2015-10-12 00:11 yangtao.lyt Exp $
 */

@Controller
public class WebHomeController {

    /** 网站首页 */
    private static final String WEB_HOME_VIEW = "screen/webhome";

    private static final String ABOUT_US_VIEW = "screen/aboutus";

    private static final String CONTACT_VIEW = "screen/contact";

    private static final String LOGIN_VIEW = "screen/login";


    @Autowired
    private ActivityManager activityManager;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String doGetHome(ModelMap modelMap){

        String testStr = activityManager.testStr();
        modelMap.addAttribute("testStr", testStr);
        return WEB_HOME_VIEW;
    }

    @RequestMapping(value = "/aboutus")
    public String doGetAboutUs(){
        return ABOUT_US_VIEW;
    }


    @RequestMapping(value = "/contact")
    public String doGetContact(){
        return CONTACT_VIEW;
    }

    @RequestMapping(value = "/login")
    public String doGetLogin(){
        return LOGIN_VIEW;
    }





}
