/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved
 */

package cn.walkwithus.core.transfer;

import cn.walkwithus.core.domain.RelaUserTeamBO;
import cn.walkwithus.persistence.dal.dataobject.RelaUserTeamDO;
import cn.walkwithus.security.role.UserRole;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author yangtao.lyt
 * @version $Id: RelaUserTeamTransfer, v 0.1 2016-01-29 13:33 yangtao.lyt Exp $
 */
public class RelaUserTeamTransfer {


    public static RelaUserTeamBO toBO(RelaUserTeamDO relaUserTeamDO){

        Preconditions.checkNotNull(relaUserTeamDO);

        RelaUserTeamBO bo = new RelaUserTeamBO();
        bo.setId(relaUserTeamDO.getId());
        bo.setGmtCreate(relaUserTeamDO.getGmtCreate());
        bo.setGmtModified(relaUserTeamDO.getGmtModified());
        bo.setUserId(relaUserTeamDO.getUserId());
        bo.setUserRole(UserRole.getUserRoleByCode(relaUserTeamDO.getUserRole()));
        bo.setUserNickName(relaUserTeamDO.getUserNickName());
        bo.setTeamName(relaUserTeamDO.getTeamName());
        bo.setTeamId(relaUserTeamDO.getTeamId());
        bo.setValid(relaUserTeamDO.isValid());

        return bo;
    }

    public static List<RelaUserTeamBO> toBOList(List<RelaUserTeamDO> relaUserTeamDOList){

        List<RelaUserTeamBO> result = Lists.newArrayList();

        if(CollectionUtils.isEmpty(relaUserTeamDOList)){
            return result;
        }

        for(RelaUserTeamDO relaUserTeamDO : relaUserTeamDOList){
            result.add(toBO(relaUserTeamDO));
        }

        return result;
    }



}
