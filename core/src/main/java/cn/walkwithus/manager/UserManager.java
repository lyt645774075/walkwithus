/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved
 */

package cn.walkwithus.manager;

import cn.walkwithus.domain.UserBO;

/**
 * @author yangtao.lyt
 * @version $Id: UserManager, v 0.1 2016-01-16 23:08 yangtao.lyt Exp $
 */

public interface UserManager {


    public UserBO getUserByUserName(String userName);
}
