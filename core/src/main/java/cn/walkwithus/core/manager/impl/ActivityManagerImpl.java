/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved
 */

package cn.walkwithus.core.manager.impl;

import cn.walkwithus.core.transfer.ActivityTransfer;
import cn.walkwithus.persistence.dal.dataobject.ActivityDO;
import cn.walkwithus.persistence.dal.ActivityDAO;
import cn.walkwithus.core.domain.ActivityBO;
import cn.walkwithus.core.manager.ActivityManager;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * @author yangtao.lyt
 * @version $Id: ActivityManagerImpl, v 0.1 2016-01-10 16:56 yangtao.lyt Exp $
 */

@Service
public class ActivityManagerImpl implements ActivityManager{

    @Autowired
    private ActivityDAO activityDAO;

    @Override
    public String testStr() {
        return "调用manager成功";
    }


    @Override
    public ActivityBO createActivity(ActivityBO activityBO) {

        activityBO.setGmtCreate(new Date());
        activityBO.setGmtModified(new Date());

        ActivityDO activityDO = ActivityTransfer.toDO(activityBO);

        activityDO = activityDAO.save(activityDO);

        return ActivityTransfer.toBO(activityDO);
    }

    @Override
    public ActivityBO updateActivity(ActivityBO activityBO) {
        Preconditions.checkArgument(!StringUtils.isEmpty(activityBO.getId()), "不能更新活动,活动id为空");

        activityBO.setGmtModified(new Date());

        ActivityDO activityDO = ActivityTransfer.toDO(activityBO);

        activityDO = activityDAO.save(activityDO);

        return ActivityTransfer.toBO(activityDO);
    }

    @Override
    public ActivityBO getActivityById(String id) {
        Preconditions.checkArgument(!StringUtils.isEmpty(id), "id不能为空");

        ActivityDO activityDO = activityDAO.findOne(id);

        return activityDO == null ? null : ActivityTransfer.toBO(activityDO);

    }
}
