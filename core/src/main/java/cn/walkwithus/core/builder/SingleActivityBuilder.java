package cn.walkwithus.core.builder;

import cn.walkwithus.core.domain.ActivityBO;
import cn.walkwithus.core.transfer.ActivityTransfer;
import cn.walkwithus.core.transfer.RelaUserActivityTransfer;
import cn.walkwithus.persistence.dal.dataobject.ActivityDO;
import cn.walkwithus.persistence.dal.dataobject.RelaTeamActivityDO;
import cn.walkwithus.persistence.dal.dataobject.RelaUserActivityDO;
import cn.walkwithus.support.constants.DomainObj;
import com.google.common.base.Preconditions;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 *
 * 单个活动信息组装器
 *
 * @author yangtao.lyt
 * @version $Id: SingleActivityBuilder, v 0.1 2016-02-06 22:34 yangtao.lyt Exp $
 */
public class SingleActivityBuilder {

    private ActivityDO activityDO;

    private RelaTeamActivityDO relaTeamActivityDO;

    private List<RelaUserActivityDO> relaUserActivityDOList;



    public ActivityBO build(){

        Preconditions.checkNotNull(activityDO, "核心的活动对象(activityDO)不存在,不能构造");

        //活动基本信息
        ActivityBO activityBO = ActivityTransfer.toBO(activityDO);

        //归属的团队信息
        if(relaTeamActivityDO != null){
            activityBO.setDomainId(relaTeamActivityDO.getTeamId());
            activityBO.setDomainObj(DomainObj.TEAM);
            activityBO.setOwnerName(relaTeamActivityDO.getTeamName());
        }

        //所属成员信息
        if(!CollectionUtils.isEmpty(relaUserActivityDOList)){
            activityBO.setRelaUserActivityBOList(RelaUserActivityTransfer.toBOList(relaUserActivityDOList));
        }

        return activityBO;

    }

    public SingleActivityBuilder from(ActivityDO activityDO){
        this.activityDO = activityDO;
        return this;
    }

    public SingleActivityBuilder fromRelaTeam(RelaTeamActivityDO relaTeamActivityDO){
        this.relaTeamActivityDO = relaTeamActivityDO;
        return this;
    }

    public SingleActivityBuilder fromRelaUserList(List<RelaUserActivityDO> relaUserActivityDOList){
        this.relaUserActivityDOList = relaUserActivityDOList;
        return this;
    }

    private SingleActivityBuilder(){

    }

    public static SingleActivityBuilder newInstance(){
        return new SingleActivityBuilder();
    }
}
