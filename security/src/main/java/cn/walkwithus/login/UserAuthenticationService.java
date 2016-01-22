/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved
 */

package cn.walkwithus.login;/*
* Alipay.com Inc.
* Copyright (c) 2004-2016 All Rights Reserved
*/

import cn.walkwithus.dal.UserDAO;
import cn.walkwithus.dal.dataobject.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author yangtao.lyt
 * @version $Id: security.UserAuthenticationService, v 0.1 2016-01-16 23:04 yangtao.lyt Exp $
 */

@Service
public class UserAuthenticationService implements UserDetailsService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public UserAuthDetail loadUserByUsername(String userName) throws UsernameNotFoundException {

        UserDO userDO = userDAO.findUserByUserName(userName);

        UserAuthDetail userAuthDetail = new UserAuthDetail();
        userAuthDetail.setId(userDO.getId());
        userAuthDetail.setUsername(userDO.getUserName());
        userAuthDetail.setPassword(userDO.getPassWord());
        userAuthDetail.setNickname(userDO.getNickName());

        return userAuthDetail;
    }
}
