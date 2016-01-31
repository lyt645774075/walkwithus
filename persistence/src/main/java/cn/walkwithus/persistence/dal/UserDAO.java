/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved
 */

package cn.walkwithus.persistence.dal;

import cn.walkwithus.persistence.dal.dataobject.UserDO;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author yangtao.lyt
 * @version $Id: UserDAO, v 0.1 2016-01-17 13:34 yangtao.lyt Exp $
 */
public interface UserDAO extends MongoRepository<UserDO, Long>{

    public UserDO findUserByEmail(String email);




}
