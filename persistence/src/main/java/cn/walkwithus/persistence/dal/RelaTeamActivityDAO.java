/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved
 */

package cn.walkwithus.persistence.dal;

import cn.walkwithus.persistence.dal.dataobject.RelaTeamActivityDO;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author yangtao.lyt
 * @version $Id: RelaTeamActivityDAO, v 0.1 2016-01-29 13:06 yangtao.lyt Exp $
 */
public interface RelaTeamActivityDAO extends MongoRepository<RelaTeamActivityDO, String>{

    public List<RelaTeamActivityDO> findAllActivityByTeamId(String teamId);

    public RelaTeamActivityDO findTeamByActivityId(String activityId);

}
