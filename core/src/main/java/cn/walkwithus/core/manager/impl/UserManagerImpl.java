/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved
 */

package cn.walkwithus.core.manager.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.walkwithus.core.domain.UserBO;
import cn.walkwithus.core.manager.UserManager;
import cn.walkwithus.core.transfer.UserTransfer;
import cn.walkwithus.persistence.dal.UserDAO;
import cn.walkwithus.persistence.dal.dataobject.UserDO;

import com.google.common.base.Preconditions;

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
