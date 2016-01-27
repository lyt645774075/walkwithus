/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved
 */

package cn.walkwithus.core.manager.impl;

import cn.walkwithus.core.manager.TeamManager;
import cn.walkwithus.core.domain.TeamBO;
import cn.walkwithus.core.transfer.TeamTransfer;
import cn.walkwithus.persistence.dal.TeamDAO;
import cn.walkwithus.persistence.dal.dataobject.TeamDO;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yangtao.lyt
 * @version $Id: TeamManagerImpl, v 0.1 2016-01-27 12:44 yangtao.lyt Exp $
 */
@Service
public class TeamManagerImpl implements TeamManager {

    @Autowired
    private TeamDAO teamDAO;


    @Override
    public TeamBO getTeamById(String id) {
        Preconditions.checkNotNull(id);

        TeamDO teamDO = teamDAO.findOne(id);

        return teamDO == null ? null : TeamTransfer.toBO(teamDO);
    }
}
