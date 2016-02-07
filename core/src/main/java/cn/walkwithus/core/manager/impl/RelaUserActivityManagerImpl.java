package cn.walkwithus.core.manager.impl;

import cn.walkwithus.core.domain.RelaUserActivityBO;
import cn.walkwithus.core.manager.RelaUserActivityManager;
import cn.walkwithus.core.transfer.RelaUserActivityTransfer;
import cn.walkwithus.persistence.dal.ActivityDAO;
import cn.walkwithus.persistence.dal.RelaUserActivityDAO;
import cn.walkwithus.persistence.dal.dataobject.ActivityDO;
import cn.walkwithus.persistence.dal.dataobject.RelaUserActivityDO;
import cn.walkwithus.security.login.LoginUserHolder;
import cn.walkwithus.security.role.UserRole;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author yangtao.lyt
 * @version $Id: RelaUserActivityManagerImpl, v 0.1 2016-02-05 22:49 yangtao.lyt Exp $
 */
@Service
public class RelaUserActivityManagerImpl implements RelaUserActivityManager{

    @Autowired
    private RelaUserActivityDAO relaUserActivityDAO;

    @Autowired
    private ActivityDAO activityDAO;

    @Autowired
    private LoginUserHolder loginUserHolder;

    @Override
    public List<RelaUserActivityBO> queryAllUserByActivityId(String activityId) {

        Preconditions.checkNotNull(activityId);

        List<RelaUserActivityDO> relaUserList = relaUserActivityDAO.findAllUserByActivityId(activityId);

        return RelaUserActivityTransfer.toBOList(relaUserList);
    }

    @Override
    public RelaUserActivityBO applyJoinActivity(String activityId) {
        ActivityDO activityDO = activityDAO.findOne(activityId);

        RelaUserActivityDO relaUserActivityDO = new RelaUserActivityDO();

        Date now = new Date();
        relaUserActivityDO.setGmtCreate(now);
        relaUserActivityDO.setGmtModified(now);
        relaUserActivityDO.setUserId(loginUserHolder.getId());
        relaUserActivityDO.setUserNickName(loginUserHolder.getNickName());
        relaUserActivityDO.setUserRole(UserRole.MEMBER.getCode());
        relaUserActivityDO.setActivityId(activityDO.getId());
        relaUserActivityDO.setActivityName(activityDO.getName());
        relaUserActivityDO.setValid(false);

        relaUserActivityDO = relaUserActivityDAO.save(relaUserActivityDO);

        return RelaUserActivityTransfer.toBO(relaUserActivityDO);
    }

    @Override
    public void passUserJoinActivity(String userId, String activityId) {

        Preconditions.checkNotNull(userId);
        Preconditions.checkNotNull(activityId);

        RelaUserActivityDO relaUserActivityDO = relaUserActivityDAO.findByUserIdAndActivityId(userId, activityId);
        if(relaUserActivityDO != null){
            relaUserActivityDO.setValid(true);
            relaUserActivityDAO.save(relaUserActivityDO);
        }

    }

    @Override
    public void removeUser(String userId, String activityId) {

        Preconditions.checkNotNull(userId);
        Preconditions.checkNotNull(activityId);

        relaUserActivityDAO.deleteOneByUserIdAndActivityId(userId, activityId);

    }
}
