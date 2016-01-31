/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved
 */

package cn.walkwithus.persistence.dal;

import cn.walkwithus.persistence.dal.dataobject.RelaUserTeamDO;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author yangtao.lyt
 * @version $Id: RelaUserTeamDAO, v 0.1 2016-01-28 13:48 yangtao.lyt Exp $
 */
public interface RelaUserTeamDAO extends MongoRepository<RelaUserTeamDO, String>{

    public RelaUserTeamDO findByUserIdAndTeamId(String userId, String teamId);


    public List<RelaUserTeamDO> findAllTeamByUserId(String userId);

    public List<RelaUserTeamDO> findAllUserByTeamId(String teamId);

}
