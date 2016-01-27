/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved
 */

package cn.walkwithus.web.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.walkwithus.core.domain.ActivityBO;
import cn.walkwithus.core.manager.ActivityManager;
import cn.walkwithus.support.constants.RedirectConstants;
import cn.walkwithus.web.transfer.ActivityTransfer;
import cn.walkwithus.web.vo.ActivityVO;

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
    private static final String EDIT_VIEW = "screen/activity/edit";

    @Autowired
    private ActivityManager activityManager;



    @RequestMapping("/home")
    public String doGetHome(@RequestParam(value = "id",required = false)String id, ModelMap modelMap){
        /*
         * id为空,重定向到全站首页
         */
        if(StringUtils.isEmpty(id)){
            return RedirectConstants.R_WEB_HOME;
        }
        /*
         * 查不到相应活动信息,重定向到全站首页
         */
        ActivityBO activityBO = activityManager.getActivityById(id.trim());
        if(activityBO == null){
            return RedirectConstants.R_WEB_HOME;
        }

        modelMap.addAttribute("activity", ActivityTransfer.toVO(activityBO));

        return HOME_VIEW;
    }


    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String doGetCreate(){

        return EDIT_VIEW;
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String doGetUpdate(ModelMap modelMap, @RequestParam("id") String id){

        /*
         * id为空,重定向到全站首页
         */
        if(StringUtils.isEmpty(id)){
            return RedirectConstants.R_WEB_HOME;
        }
        /*
         * 查不到相应活动信息,重定向到全站首页
         */
        ActivityBO activityBO = activityManager.getActivityById(id.trim());
        if(activityBO == null){
            return RedirectConstants.R_WEB_HOME;
        }

        modelMap.addAttribute("activity", ActivityTransfer.toVO(activityBO));


        return EDIT_VIEW;
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String doPostCreateActivity(ActivityVO activityVO){

        ActivityBO newObj = ActivityTransfer.toBO(activityVO);

        ActivityBO reObj = activityManager.createActivity(newObj);

        return "redirect:/activity/home?id=" + reObj.getId();
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String doPostUpdateActivity(ActivityVO activityVO){

        ActivityBO newObj = ActivityTransfer.toBO(activityVO);

        ActivityBO reObj = activityManager.updateActivity(newObj);

        return "redirect:/activity/home?id=" + reObj.getId();
    }





}
