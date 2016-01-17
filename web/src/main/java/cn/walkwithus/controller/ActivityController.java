/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved
 */

package cn.walkwithus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yangtao.lyt
 * @version $Id: ActivityController, v 0.1 2016-01-10 21:45 yangtao.lyt Exp $
 */
@Controller
@RequestMapping("/activity")
public class ActivityController {

    /** 活动首页 */
    private static final String HOME_VIEW = "screen/activity/home";

    /** 活动详情页 */
    private static final String DETAIL_VIEW = "screen/activity/detail";



    @RequestMapping("/home")
    public String doGetHome(){
        return HOME_VIEW;
    }


    @RequestMapping(value = "/detail")
    public String doGetDetail(){
        return DETAIL_VIEW;
    }





}
