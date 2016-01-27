/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved
 */

package cn.walkwithus.web.support;

import cn.walkwithus.security.login.UserAuthDetail;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author yangtao.lyt
 * @version $Id: VelocitySecurityUtil, v 0.1 2016-01-18 20:16 yangtao.lyt Exp $
 */
public class VelocitySecurityUtil {
    public static String getPrincipal() {
        Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (obj instanceof UserDetails) {
            return ((UserAuthDetail) obj).getNickname();
        } else {
            return "anonymous";
        }
    }

    public static boolean isAuthenticated() {
        return !getPrincipal().equals("anonymous");
    }
}
