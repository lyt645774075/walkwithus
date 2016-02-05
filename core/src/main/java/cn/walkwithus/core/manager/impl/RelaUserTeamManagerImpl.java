package cn.walkwithus.core.manager.impl;

import cn.walkwithus.core.domain.RelaUserTeamBO;
import cn.walkwithus.core.manager.RelaUserTeamManager;
import cn.walkwithus.core.transfer.RelaUserTeamTransfer;
import cn.walkwithus.persistence.dal.RelaUserTeamDAO;
import cn.walkwithus.persistence.dal.TeamDAO;
import cn.walkwithus.persistence.dal.dataobject.RelaUserTeamDO;
import cn.walkwithus.persistence.dal.dataobject.TeamDO;
import cn.walkwithus.security.login.LoginUserHolder;
import cn.walkwithus.security.role.UserRole;
import com.google.common.base.Preconditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author yangtao.lyt
 * @version $Id: RelaUserTeamManagerImpl, v 0.1 2016-02-01 19:10 yangtao.lyt Exp $
 */
@Service
public class RelaUserTeamManagerImpl implements RelaUserTeamManager{

    private static final Logger logger = LoggerFactory.getLogger(RelaUserTeamManagerImpl.class);

    @Autowired
    private RelaUserTeamDAO relaUserTeamDAO;

    @Autowired
    private TeamDAO teamDAO;

    @Autowired
    private LoginUserHolder loginUserHolder;

    @Override
    public RelaUserTeamBO applyJoinTeam(String teamId) {

        TeamDO teamDO = teamDAO.findOne(teamId);

        RelaUserTeamDO relaUserTeamDO = new RelaUserTeamDO();

        Date now = new Date();
        relaUserTeamDO.setGmtCreate(now);
        relaUserTeamDO.setGmtModified(now);
        relaUserTeamDO.setUserId(loginUserHolder.getId());
        relaUserTeamDO.setUserNickName(loginUserHolder.getNickName());
        relaUserTeamDO.setUserRole(UserRole.MEMBER.getCode());
        relaUserTeamDO.setTeamId(teamDO.getId());
        relaUserTeamDO.setTeamName(teamDO.getName());
        relaUserTeamDO.setValid(false);

        relaUserTeamDO = relaUserTeamDAO.save(relaUserTeamDO);

        return RelaUserTeamTransfer.toBO(relaUserTeamDO);
    }

    @Override
    public List<RelaUserTeamBO> queryAllUserByTeamId(String teamId) {
        Preconditions.checkNotNull(teamId);

        List<RelaUserTeamDO> allRela = relaUserTeamDAO.findAllUserByTeamId(teamId);

        return RelaUserTeamTransfer.toBOList(allRela);
    }

    @Override
    public void passUserJoinTeam(String userId, String teamId) {
        Preconditions.checkNotNull(userId);
        Preconditions.checkNotNull(teamId);

        RelaUserTeamDO relaUserTeamDO = relaUserTeamDAO.findByUserIdAndTeamId(userId, teamId);
        if(relaUserTeamDO != null){
            relaUserTeamDO.setValid(true);
            relaUserTeamDAO.save(relaUserTeamDO);
        }

    }

    @Override
    public void setTeamAdmin(String userId, String teamId) {

        Preconditions.checkNotNull(userId);
        Preconditions.checkNotNull(teamId);

        RelaUserTeamDO relaUserTeamDO = relaUserTeamDAO.findByUserIdAndTeamId(userId, teamId);
        if(relaUserTeamDO != null){
            relaUserTeamDO.setUserRole(UserRole.ADMIN.getCode());
            relaUserTeamDAO.save(relaUserTeamDO);
        }

    }

    @Override
    public void cancelTeamAdmin(String userId, String teamId) {
        Preconditions.checkNotNull(userId);
        Preconditions.checkNotNull(teamId);

        RelaUserTeamDO relaUserTeamDO = relaUserTeamDAO.findByUserIdAndTeamId(userId, teamId);
        if(relaUserTeamDO != null){
            relaUserTeamDO.setUserRole(UserRole.MEMBER.getCode());
            relaUserTeamDAO.save(relaUserTeamDO);
        }
    }

    @Override
    public void removeUser(String userId, String teamId) {
        Preconditions.checkNotNull(userId);
        Preconditions.checkNotNull(teamId);

        relaUserTeamDAO.deleteOneByUserIdAndTeamId(userId, teamId);

    }
}
