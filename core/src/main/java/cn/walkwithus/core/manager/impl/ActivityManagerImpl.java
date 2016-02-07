package cn.walkwithus.core.manager.impl;

import cn.walkwithus.core.builder.SingleActivityBuilder;
import cn.walkwithus.core.domain.ActivityBO;
import cn.walkwithus.core.manager.ActivityManager;
import cn.walkwithus.core.transfer.ActivityTransfer;
import cn.walkwithus.persistence.dal.ActivityDAO;
import cn.walkwithus.persistence.dal.RelaTeamActivityDAO;
import cn.walkwithus.persistence.dal.RelaUserActivityDAO;
import cn.walkwithus.persistence.dal.dataobject.ActivityDO;
import cn.walkwithus.persistence.dal.dataobject.RelaTeamActivityDO;
import cn.walkwithus.persistence.dal.dataobject.RelaUserActivityDO;
import cn.walkwithus.security.login.LoginUserHolder;
import cn.walkwithus.security.role.UserRole;
import cn.walkwithus.support.constants.DomainObj;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * @author yangtao.lyt
 * @version $Id: ActivityManagerImpl, v 0.1 2016-01-10 16:56 yangtao.lyt Exp $
 */

@Service
public class ActivityManagerImpl implements ActivityManager {

    @Autowired
    private ActivityDAO         activityDAO;

    @Autowired
    private RelaUserActivityDAO relaUserActivityDAO;

    @Autowired
    private RelaTeamActivityDAO relaTeamActivityDAO;

    @Autowired
    private LoginUserHolder     loginUserHolder;

    @Override
    public boolean isExist(String activityId) {
        Preconditions.checkNotNull(activityId);

        return activityDAO.exists(activityId);
    }

    @Override
    public ActivityBO createActivity(ActivityBO activityBO) {

        Date now = new Date();

        activityBO.setGmtCreate(now);
        activityBO.setGmtModified(now);

        ActivityDO activityDO = ActivityTransfer.toDO(activityBO);
        activityDO = activityDAO.save(activityDO);

        //插入"团队-活动"关系
        if (activityBO.getDomainObj() == DomainObj.TEAM) {
            RelaTeamActivityDO relaTeamActivityDO = new RelaTeamActivityDO();
            relaTeamActivityDO.setGmtCreate(now);
            relaTeamActivityDO.setGmtModified(now);
            relaTeamActivityDO.setActivityId(activityDO.getId());
            relaTeamActivityDO.setActivityName(activityDO.getName());
            relaTeamActivityDO.setActivityBeginDate(activityDO.getBeginDate());
            relaTeamActivityDO.setActivityEndDate(activityDO.getEndDate());
            relaTeamActivityDO.setTeamId(activityBO.getDomainId());
            relaTeamActivityDO.setTeamName(activityBO.getOwnerName());
            relaTeamActivityDO.setEnable(true);

            relaTeamActivityDAO.save(relaTeamActivityDO);
        }

        RelaUserActivityDO relaUserActivityDO = new RelaUserActivityDO();
        relaUserActivityDO.setUserId(loginUserHolder.getId());
        relaUserActivityDO.setUserNickName(loginUserHolder.getNickName());
        relaUserActivityDO.setActivityId(activityDO.getId());
        relaUserActivityDO.setActivityName(activityDO.getName());
        relaUserActivityDO.setGmtCreate(now);
        relaUserActivityDO.setGmtCreate(now);
        relaUserActivityDO.setUserRole(UserRole.ADMIN.getCode());
        relaUserActivityDO.setValid(true);

        relaUserActivityDAO.save(relaUserActivityDO);

        return ActivityTransfer.toBO(activityDO);
    }

    @Override
    public ActivityBO updateActivity(ActivityBO activityBO) {
        Preconditions.checkArgument(!StringUtils.isEmpty(activityBO.getId()), "不能更新活动,活动id为空");

        ActivityDO oldActivity = activityDAO.findOne(activityBO.getId());
        if (oldActivity == null) {
            throw new IllegalStateException("活动不存在,不能更新");
        }

        Date now = new Date();
        activityBO.setGmtModified(now);
        ActivityDO activityDO = ActivityTransfer.toDO(activityBO);
        activityDO = activityDAO.save(activityDO);

        //更新团队-活动关系
        if (!activityDO.getName().equals(oldActivity.getName())
            || !activityDO.getBeginDate().equals(oldActivity.getBeginDate())
            || !activityDO.getEndDate().equals(oldActivity.getEndDate())) {

            RelaTeamActivityDO relaTeamActivityDO = relaTeamActivityDAO
                .findTeamByActivityId(activityDO.getId());
            if (relaTeamActivityDO == null) {
                relaTeamActivityDO = new RelaTeamActivityDO();

                relaTeamActivityDO.setGmtCreate(now);
                relaTeamActivityDO.setGmtModified(now);
                relaTeamActivityDO.setActivityId(activityDO.getId());
                relaTeamActivityDO.setActivityName(activityDO.getName());
                relaTeamActivityDO.setActivityBeginDate(activityDO.getBeginDate());
                relaTeamActivityDO.setActivityEndDate(activityDO.getEndDate());
                relaTeamActivityDO.setTeamId(activityBO.getDomainId());
                relaTeamActivityDO.setTeamName(activityBO.getOwnerName());
                relaTeamActivityDO.setEnable(true);
            } else {
                relaTeamActivityDO.setGmtModified(now);
                relaTeamActivityDO.setActivityName(activityDO.getName());
                relaTeamActivityDO.setActivityBeginDate(activityDO.getBeginDate());
                relaTeamActivityDO.setActivityEndDate(activityDO.getEndDate());
            }

            relaTeamActivityDAO.save(relaTeamActivityDO);
        }

        return ActivityTransfer.toBO(activityDO);
    }

    @Override
    public ActivityBO getActivityById(String id) {
        Preconditions.checkArgument(!StringUtils.isEmpty(id), "id不能为空");

        ActivityDO activityDO = activityDAO.findOne(id);
        if (activityDO == null) {
            return null;
        }
        ActivityBO activityBO = ActivityTransfer.toBO(activityDO);

        /*
         * 获取所属团队信息
         */
        RelaTeamActivityDO relaTeamActivityDO = relaTeamActivityDAO.findTeamByActivityId(id);

        /*
         * 获取所属成员信息
         */
        List<RelaUserActivityDO> relaUserActivityDOList = relaUserActivityDAO
            .findAllUserByActivityIdAndValid(id, true);

        return SingleActivityBuilder.newInstance().from(activityDO)
            .fromRelaTeam(relaTeamActivityDO).fromRelaUserList(relaUserActivityDOList).build();

    }
}
