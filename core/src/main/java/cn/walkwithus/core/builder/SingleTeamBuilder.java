package cn.walkwithus.core.builder;

import cn.walkwithus.core.domain.TeamBO;
import cn.walkwithus.core.transfer.RelaTeamActivityTransfer;
import cn.walkwithus.core.transfer.RelaUserTeamTransfer;
import cn.walkwithus.core.transfer.TeamTransfer;
import cn.walkwithus.persistence.dal.dataobject.RelaTeamActivityDO;
import cn.walkwithus.persistence.dal.dataobject.RelaUserTeamDO;
import cn.walkwithus.persistence.dal.dataobject.TeamDO;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author yangtao.lyt
 * @version $Id: SingleTeamBuilder, v 0.1 2016-01-29 13:15 yangtao.lyt Exp $
 */
public class SingleTeamBuilder {

    private TeamDO                   teamDO;

    private List<RelaTeamActivityDO> relaTeamAcitivityDOList = Lists.newArrayList();

    private List<RelaUserTeamDO>     relaUserTeamDOList      = Lists.newArrayList();

    public TeamBO build() {
        Preconditions.checkNotNull(teamDO, "核心的团队对象(TeamDO)不存在,不能构造");

        //组装团队基本信息
        TeamBO teamBO = TeamTransfer.toBO(teamDO);

        //组装活动信息
        if (!CollectionUtils.isEmpty(relaTeamAcitivityDOList)) {
            teamBO.setRelaTeamActivityBOList(RelaTeamActivityTransfer
                .toBOList(relaTeamAcitivityDOList));
        }

        //组装成员信息
        if (!CollectionUtils.isEmpty(relaUserTeamDOList)) {
            teamBO.setRelaUserTeamBOList(RelaUserTeamTransfer.toBOList(relaUserTeamDOList));
        }

        return teamBO;
    }

    public SingleTeamBuilder from(TeamDO teamDO) {
        Preconditions.checkNotNull(teamDO);
        this.teamDO = teamDO;
        return this;
    }

    public SingleTeamBuilder fromActivityList(List<RelaTeamActivityDO> activityList) {
        if (!CollectionUtils.isEmpty(activityList)) {
            relaTeamAcitivityDOList.addAll(activityList);
        }

        return this;
    }

    public SingleTeamBuilder fromUserList(List<RelaUserTeamDO> userList) {
        if (!CollectionUtils.isEmpty(userList)) {
            relaUserTeamDOList.addAll(userList);
        }

        return this;
    }

    private SingleTeamBuilder() {
    }

    public static SingleTeamBuilder newInstance() {
        return new SingleTeamBuilder();
    }

}
