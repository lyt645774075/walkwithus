/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved
 */

package cn.walkwithus.manager.impl;

import cn.walkwithus.manager.ActivityManager;
import org.springframework.stereotype.Service;

/**
 * @author yangtao.lyt
 * @version $Id: ActivityManagerImpl, v 0.1 2016-01-10 16:56 yangtao.lyt Exp $
 */

@Service
public class ActivityManagerImpl implements ActivityManager{


    @Override
    public String testStr() {
        return "调用manager成功";
    }
}
