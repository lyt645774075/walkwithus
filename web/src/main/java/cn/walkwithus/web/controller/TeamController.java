/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved
 */

package cn.walkwithus.web.controller;

import cn.walkwithus.core.domain.TeamBO;
import cn.walkwithus.core.manager.TeamManager;
import cn.walkwithus.support.constants.RedirectConstants;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author yangtao.lyt
 * @version $Id: TeamController, v 0.1 2016-01-10 22:44 yangtao.lyt Exp $
 */
@Controller
@RequestMapping("/team")
public class TeamController {

    /** 团队首页 */
    private static final String HOME_VIEW = "screen/team/home";

    /** 编辑页面 */
    private static final String EDIT_VIEW = "screen/team/edit";

    @Autowired
    private TeamManager teamManager;

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
        TeamBO teamBO = teamManager.getTeamById(id.trim());
        if(teamBO == null){
            return RedirectConstants.R_WEB_HOME;
        }

        modelMap.addAttribute("team", teamBO);

        return HOME_VIEW;
    }


    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String doGetCreate(){

        return EDIT_VIEW;
    }

}
