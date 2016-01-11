/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved
 */

package cn.walkwithus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yangtao.lyt
 * @version $Id: TeamController, v 0.1 2016-01-10 22:44 yangtao.lyt Exp $
 */
@Controller
@RequestMapping("/team")
public class TeamController {

    /** 团队首页 */
    private static final String HOME_VIEW = "screen/team/home";

    @RequestMapping("/home")
    public String doGetHome(){
        return HOME_VIEW;
    }

}
