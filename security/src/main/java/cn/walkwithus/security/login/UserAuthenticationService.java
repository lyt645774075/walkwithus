/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved
 */

package cn.walkwithus.security.login;/*
* Alipay.com Inc.
* Copyright (c) 2004-2016 All Rights Reserved
*/

import cn.walkwithus.persistence.dal.UserDAO;
import cn.walkwithus.persistence.dal.dataobject.UserDO;
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

        UserDO userDO = userDAO.findUserByEmail(userName);

        UserAuthDetail userAuthDetail = new UserAuthDetail();
        userAuthDetail.setId(userDO.getId());
        userAuthDetail.setEmail(userDO.getEmail());
        userAuthDetail.setPassword(userDO.getPassWord());
        userAuthDetail.setNickName(userDO.getNickName());

        return userAuthDetail;
    }
}
