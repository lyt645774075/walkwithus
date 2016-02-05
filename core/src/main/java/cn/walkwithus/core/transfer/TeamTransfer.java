package cn.walkwithus.core.transfer;

import cn.walkwithus.core.domain.TeamBO;
import cn.walkwithus.persistence.dal.dataobject.TeamDO;
import com.google.common.base.Preconditions;

/**
 * @author yangtao.lyt
 * @version $Id: TeamTransfer, v 0.1 2016-01-27 13:24 yangtao.lyt Exp $
 */
public class TeamTransfer {


    public static TeamBO toBO(TeamDO teamDO){

        Preconditions.checkNotNull(teamDO);

        TeamBO teamBO = new TeamBO();
        teamBO.setId(teamDO.getId());
        teamBO.setGmtCreate(teamDO.getGmtCreate());
        teamBO.setGmtModified(teamDO.getGmtModified());
        teamBO.setName(teamDO.getName());

        return teamBO;
    }

    public static TeamDO toDO(TeamBO teamBO){

        Preconditions.checkNotNull(teamBO);

        TeamDO teamDO = new TeamDO();
        teamDO.setId(teamBO.getId());
        teamDO.setGmtCreate(teamBO.getGmtCreate());
        teamDO.setGmtModified(teamBO.getGmtModified());
        teamDO.setName(teamBO.getName());

        return teamDO;
    }

}
