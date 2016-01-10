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
@RequestMapping("/")
public class WebHomeController {

    @Autowired
    private ActivityManager activityManager;

    @RequestMapping(method = RequestMethod.GET)
    public String doGet(ModelMap modelMap){

        String testStr = activityManager.testStr();

        modelMap.addAttribute("testStr", testStr);

        return "screen/webhome";
    }






}
