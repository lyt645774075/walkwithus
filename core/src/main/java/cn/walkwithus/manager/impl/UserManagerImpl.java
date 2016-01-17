/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved
 */

package cn.walkwithus.manager.impl;

import cn.walkwithus.support.transfer.UserTransfer;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.walkwithus.dal.UserDAO;
import cn.walkwithus.dal.dataobject.UserDO;
import cn.walkwithus.domain.UserBO;
import cn.walkwithus.manager.UserManager;

/**
 * @author yangtao.lyt
 * @version $Id: UserManagerImpl, v 0.1 2016-01-16 23:10 yangtao.lyt Exp $
 */
@Service
public class UserManagerImpl implements UserManager{

    @Autowired
    private UserDAO userDAO;

    public UserBO getUserByUserName(String userName){

        Preconditions.checkNotNull(userName);

        UserDO userDO = userDAO.findUserByUserName(userName);

        return UserTransfer.toBO(userDO);
    }


}
