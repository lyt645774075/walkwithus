/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved
 */

package cn.walkwithus.persistence.dal;

import cn.walkwithus.persistence.dal.dataobject.TeamDO;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author yangtao.lyt
 * @version $Id: TeamDAO, v 0.1 2016-01-23 09:47 yangtao.lyt Exp $
 */
public interface TeamDAO extends MongoRepository<TeamDO, String>{
}
