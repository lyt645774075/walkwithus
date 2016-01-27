/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved
 */

package cn.walkwithus.web.controller;

import cn.walkwithus.core.domain.RequireBO;
import cn.walkwithus.security.login.UserAuthDetail;
import cn.walkwithus.core.manager.ActivityManager;
import cn.walkwithus.core.manager.RequireManager;
import cn.walkwithus.web.support.LoginDetailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

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

    private static final String REQUIRE_VIEW = "screen/require";


    @Autowired
    private ActivityManager activityManager;

    @Autowired
    private RequireManager requireManager;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String doGetHome(ModelMap modelMap){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        modelMap.addAttribute("authentication", authentication);

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


    @RequestMapping(value = "/require")
    public String doGetRequire(ModelMap modelMap){

        List<RequireBO> requireBOList = requireManager.queryAll();

        modelMap.addAttribute("requireList", requireBOList);

        return REQUIRE_VIEW;
    }

    @RequestMapping(value = "/require", method = RequestMethod.POST, params = "action=create")
    public String doCreateRequire(@RequestParam("desc") String desc, ModelMap modelMap){

        if(StringUtils.isEmpty(desc)){
            modelMap.addAttribute("sysMsg", "需求描述不能为空");
            return REQUIRE_VIEW;
        }



        UserAuthDetail userAuthDetail = LoginDetailUtil.getLoginDetail();
        if(userAuthDetail == null){
            modelMap.addAttribute("desc", desc);
            modelMap.addAttribute("sysMsg", "您需要先登录,才能创建需求!");

            List<RequireBO> requireBOList = requireManager.queryAll();
            modelMap.addAttribute("requireList", requireBOList);

            return REQUIRE_VIEW;
        }

        RequireBO requireBO = new RequireBO();
        requireBO.setDesc(desc.trim());
        requireBO.setCreator(userAuthDetail.getUsername());
        requireBO.setCreatorNick(userAuthDetail.getNickname());

        requireManager.createRequire(requireBO);

        return "redirect:/require";
    }




}
