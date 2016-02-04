/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved
 */

package cn.walkwithus.core.transfer;

import cn.walkwithus.core.domain.RelaTeamActivityBO;
import cn.walkwithus.persistence.dal.dataobject.RelaTeamActivityDO;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author yangtao.lyt
 * @version $Id: RelaTeamActivityTransfer, v 0.1 2016-01-29 13:33 yangtao.lyt Exp $
 */
public class RelaTeamActivityTransfer {


    public static RelaTeamActivityBO toBO(RelaTeamActivityDO relaTeamActivityDO){

        Preconditions.checkNotNull(relaTeamActivityDO);

        RelaTeamActivityBO bo = new RelaTeamActivityBO();
        bo.setId(relaTeamActivityDO.getId());
        bo.setGmtCreate(relaTeamActivityDO.getGmtCreate());
        bo.setGmtModified(relaTeamActivityDO.getGmtModified());
        bo.setActivityId(relaTeamActivityDO.getActivityId());
        bo.setActivityName(relaTeamActivityDO.getActivityName());
        bo.setTeamName(relaTeamActivityDO.getTeamName());
        bo.setTeamId(relaTeamActivityDO.getTeamId());
        bo.setEnable(relaTeamActivityDO.isEnable());
        bo.setActivityBeginDate(relaTeamActivityDO.getActivityBeginDate());
        bo.setActivityEndDate(relaTeamActivityDO.getActivityEndDate());

        return bo;
    }

    public static List<RelaTeamActivityBO> toBOList(List<RelaTeamActivityDO> relaTeamActivityDOList){

        List<RelaTeamActivityBO> result = Lists.newArrayList();

        if(CollectionUtils.isEmpty(relaTeamActivityDOList)){
            return result;
        }

        for(RelaTeamActivityDO relaTeamActivityDO : relaTeamActivityDOList){
            result.add(toBO(relaTeamActivityDO));
        }

        return result;
    }
}
