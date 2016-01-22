/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved
 */

package support;

import cn.walkwithus.login.UserAuthDetail;

import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author yangtao.lyt
 * @version $Id: LoginDetailUtil, v 0.1 2016-01-17 16:56 yangtao.lyt Exp $
 */
public class LoginDetailUtil {

    private static final String ANONYMOUS_USER = "anonymousUser";

    public static UserAuthDetail getLoginDetail(){
        Object user = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if(ANONYMOUS_USER.equals(user)){
            return null;
        }

        return (UserAuthDetail) user;

    }

}
