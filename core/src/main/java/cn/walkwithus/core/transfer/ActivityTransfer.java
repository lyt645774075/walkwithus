/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved
 */

package cn.walkwithus.core.transfer;

import cn.walkwithus.core.domain.ActivityBO;
import cn.walkwithus.persistence.dal.dataobject.ActivityDO;

import com.google.common.base.Preconditions;

/**
 * @author yangtao.lyt
 * @version $Id: ActivityTransfer, v 0.1 2016-01-27 13:13 yangtao.lyt Exp $
 */
public class ActivityTransfer {
    public static ActivityDO toDO(ActivityBO activityBO){

        Preconditions.checkNotNull(activityBO);

        ActivityDO activityDO = new ActivityDO();
        activityDO.setId(activityBO.getId());
        activityDO.setGmtCreate(activityBO.getGmtCreate());
        activityDO.setGmtModified(activityBO.getGmtModified());
        activityDO.setName(activityBO.getName());
        activityDO.setBeginDate(activityBO.getBeginDate());
        activityDO.setEndDate(activityBO.getEndDate());
        activityDO.setDesc(activityBO.getDesc());
        activityDO.setAddress(activityBO.getAddress());

        return activityDO;

    }

    public static ActivityBO toBO(ActivityDO activityDO){

        Preconditions.checkNotNull(activityDO);

        ActivityBO activityBO = new ActivityBO();
        activityBO.setId(activityDO.getId());
        activityBO.setGmtCreate(activityDO.getGmtCreate());
        activityBO.setGmtModified(activityDO.getGmtModified());
        activityBO.setName(activityDO.getName());
        activityBO.setBeginDate(activityDO.getBeginDate());
        activityBO.setEndDate(activityDO.getEndDate());
        activityBO.setDesc(activityDO.getDesc());
        activityBO.setAddress(activityDO.getAddress());

        return activityBO;
    }
}
