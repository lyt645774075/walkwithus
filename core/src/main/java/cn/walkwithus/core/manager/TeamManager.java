package cn.walkwithus.core.manager;

import cn.walkwithus.core.domain.TeamBO;

/**
 * @author yangtao.lyt
 * @version $Id: TeamManager, v 0.1 2016-01-27 12:43 yangtao.lyt Exp $
 */
public interface TeamManager {


    public TeamBO getTeamById(String id);


    public TeamBO createTeam(TeamBO teamBO);

    public TeamBO updateTeam(TeamBO teamBO);


    public boolean isExist(String teamId);

}
