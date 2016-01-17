/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved
 */

package cn.walkwithus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author yangtao.lyt
 * @version $Id: BaseAclController, v 0.1 2016-01-17 00:30 yangtao.lyt Exp $
 */
@RequestMapping("/acl")
@Controller
public class BaseAclController {

    /** 活动账务情况 */
    private static final String ACCOUNT_INFO_VIEW = "screen/activity/accountinfo";

    @RequestMapping(value = "/activity/accountinfo")
    public String doGetAccountInfo(){
        return ACCOUNT_INFO_VIEW;
    }
}
