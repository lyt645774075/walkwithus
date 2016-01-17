/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved
 */

package cn.walkwithus.support.transfer;

import cn.walkwithus.dal.dataobject.UserDO;
import cn.walkwithus.domain.UserBO;

/**
 * @author yangtao.lyt
 * @version $Id: UserTransfer, v 0.1 2016-01-17 13:48 yangtao.lyt Exp $
 */
public class UserTransfer {

    public static UserBO toBO(UserDO userDO){
        if(userDO == null){
            return null;
        }

        UserBO userBO = new UserBO();
        userBO.setId(userDO.getId());
        userBO.setUserName(userDO.getUserName());
        userBO.setPassWord(userDO.getPassWord());
        userBO.setNickName(userDO.getNickName());

        return userBO;

    }

}
