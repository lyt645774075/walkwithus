/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved
 */

package cn.walkwithus.core.transfer;

import cn.walkwithus.core.domain.UserBO;
import cn.walkwithus.persistence.dal.dataobject.UserDO;

/**
 * @author yangtao.lyt
 * @version $Id: UserTransfer, v 0.1 2016-01-27 13:16 yangtao.lyt Exp $
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
