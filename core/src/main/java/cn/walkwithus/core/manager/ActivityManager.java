/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved
 */

package cn.walkwithus.core.manager;

import cn.walkwithus.core.domain.ActivityBO;

/**
 * @author yangtao.lyt
 * @version $Id: ActivityManager, v 0.1 2016-01-10 16:56 yangtao.lyt Exp $
 */
public interface ActivityManager {

    public String testStr();


    /**
     * 创建活动
     * @param activityBO
     * @return
     */
    public ActivityBO createActivity(ActivityBO activityBO);

    /**
     * 创建活动
     * @param activityBO
     * @return
     */
    public ActivityBO updateActivity(ActivityBO activityBO);


    public ActivityBO getActivityById(String id);

}
