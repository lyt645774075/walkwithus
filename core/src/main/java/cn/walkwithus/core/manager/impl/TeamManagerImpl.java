package cn.walkwithus.core.manager.impl;

import cn.walkwithus.core.builder.SingleTeamBuilder;
import cn.walkwithus.core.domain.TeamBO;
import cn.walkwithus.core.manager.TeamManager;
import cn.walkwithus.core.transfer.TeamTransfer;
import cn.walkwithus.persistence.dal.RelaTeamActivityDAO;
import cn.walkwithus.persistence.dal.RelaUserTeamDAO;
import cn.walkwithus.persistence.dal.TeamDAO;
import cn.walkwithus.persistence.dal.dataobject.RelaTeamActivityDO;
import cn.walkwithus.persistence.dal.dataobject.RelaUserTeamDO;
import cn.walkwithus.persistence.dal.dataobject.TeamDO;
import cn.walkwithus.security.login.LoginUserHolder;
import cn.walkwithus.security.role.UserRole;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author yangtao.lyt
 * @version $Id: TeamManagerImpl, v 0.1 2016-01-27 12:44 yangtao.lyt Exp $
 */
@Service
public class TeamManagerImpl implements TeamManager {

    @Autowired
    private TeamDAO             teamDAO;

    @Autowired
    private RelaUserTeamDAO     relaUserTeamDAO;

    @Autowired
    private RelaTeamActivityDAO relaTeamActivityDAO;

    @Autowired
    private LoginUserHolder     loginUserHolder;

    @Override
    public TeamBO getTeamById(String id) {
        Preconditions.checkNotNull(id);

        TeamDO teamDO = teamDAO.findOne(id);

        if (teamDO == null) {
            return null;
        }

        List<RelaTeamActivityDO> allActivity = relaTeamActivityDAO.findAllActivityByTeamId(id);

        List<RelaUserTeamDO> allUser = relaUserTeamDAO.findAllUserByTeamIdAndValid(id, true);

        return SingleTeamBuilder.newInstance().from(teamDO).fromActivityList(allActivity)
            .fromUserList(allUser).build();
    }

    @Override
    public TeamBO createTeam(TeamBO teamBO) {
        Preconditions.checkNotNull(teamBO);

        Date now = new Date();

        teamBO.setGmtCreate(now);
        teamBO.setGmtModified(now);

        TeamDO teamDO = teamDAO.save(TeamTransfer.toDO(teamBO));

        RelaUserTeamDO relaDO = new RelaUserTeamDO();
        relaDO.setGmtCreate(now);
        relaDO.setGmtModified(now);
        relaDO.setUserId(loginUserHolder.getId());
        relaDO.setUserNickName(loginUserHolder.getNickName());
        relaDO.setTeamId(teamDO.getId());
        relaDO.setTeamName(teamDO.getName());
        relaDO.setUserRole(UserRole.OWNER.getCode());
        relaDO.setValid(true);

        relaUserTeamDAO.save(relaDO);

        return TeamTransfer.toBO(teamDO);
    }

    @Override
    public TeamBO updateTeam(TeamBO teamBO) {
        Preconditions.checkNotNull(teamBO);

        TeamDO oldTeam = teamDAO.findOne(teamBO.getId());

        teamBO.setGmtModified(new Date());
        TeamDO newTeam = teamDAO.save(TeamTransfer.toDO(teamBO));

        //判断是否是队伍名字发生了修改,如果是,需要同步修改关系表
        if (!oldTeam.getName().equals(newTeam.getName())) {
            List<RelaUserTeamDO> relaUserTeamDOList = relaUserTeamDAO.findAllUserByTeamId(newTeam
                .getId());
            for (RelaUserTeamDO relaUserTeamDO : relaUserTeamDOList) {
                relaUserTeamDO.setTeamName(newTeam.getName());
            }

            relaUserTeamDAO.save(relaUserTeamDOList);
        }

        return TeamTransfer.toBO(newTeam);
    }

    @Override
    public boolean isExist(String teamId) {
        Preconditions.checkNotNull(teamId);

        return teamDAO.exists(teamId);

    }
}
