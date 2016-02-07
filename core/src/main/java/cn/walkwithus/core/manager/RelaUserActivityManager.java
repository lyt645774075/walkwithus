package cn.walkwithus.core.manager;

import cn.walkwithus.core.domain.RelaUserActivityBO;

import java.util.List;

/**
 * @author yangtao.lyt
 * @version $Id: RelaUserActivityManager, v 0.1 2016-02-05 22:48 yangtao.lyt Exp $
 */
public interface RelaUserActivityManager {

    public List<RelaUserActivityBO> queryAllUserByActivityId(String activityId);

    public RelaUserActivityBO applyJoinActivity(String activityId);

    /**
     * 同意用户加入
     * @param userId
     * @param activityId
     * @return
     */
    public void passUserJoinActivity(String userId, String activityId);


    public void removeUser(String userId, String activityId);
}
