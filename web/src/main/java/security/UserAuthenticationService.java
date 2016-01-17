package security;/*
* Alipay.com Inc.
* Copyright (c) 2004-2016 All Rights Reserved
*/

import cn.walkwithus.domain.UserBO;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cn.walkwithus.manager.UserManager;

import javax.annotation.Resource;

/**
 * @author yangtao.lyt
 * @version $Id: security.UserAuthenticationService, v 0.1 2016-01-16 23:04 yangtao.lyt Exp $
 */

@Service
public class UserAuthenticationService implements UserDetailsService {

    @Autowired
    private UserManager userManager;

    @Override
    public UserAuthDetail loadUserByUsername(String userName) throws UsernameNotFoundException {

        UserBO userBO = userManager.getUserByUserName(userName);

        UserAuthDetail userAuthDetail = new UserAuthDetail();
        userAuthDetail.setId(userBO.getId());
        userAuthDetail.setUsername(userBO.getUserName());
        userAuthDetail.setPassword(userBO.getPassWord());
        userAuthDetail.setNickname(userBO.getNickName());

        return userAuthDetail;
    }
}
