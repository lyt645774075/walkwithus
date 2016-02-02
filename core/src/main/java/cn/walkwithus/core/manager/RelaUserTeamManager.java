/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved
 */

package cn.walkwithus.core.manager;

import cn.walkwithus.core.domain.RelaUserTeamBO;

import java.util.List;

/**
 * @author yangtao.lyt
 * @version $Id: RelaUserTeamManager, v 0.1 2016-02-01 19:09 yangtao.lyt Exp $
 */
public interface RelaUserTeamManager {

    public RelaUserTeamBO applyJoinTeam(String teamId);

    public List<RelaUserTeamBO> queryAllUserByTeamId(String teamId);

    /**
     * 同意用户加入
     * @param userId
     * @param teamId
     * @return
     */
    public void passUserJoinTeam(String userId, String teamId);

    /**
     * 设置团队管理员
     * @param userId
     * @param teamId
     */
    public void setTeamAdmin(String userId, String teamId);

    /**
     * 取消团队管理员(管理员变成普通成员)
     * @param userId
     * @param teamId
     */
    public void cancelTeamAdmin(String userId, String teamId);

    public void removeUser(String userId, String teamId);



}
