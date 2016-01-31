/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved
 */

package cn.walkwithus.persistence.dal;

import cn.walkwithus.persistence.dal.dataobject.AccountInfoDO;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author yangtao.lyt
 * @version $Id: AccountInfoDAO, v 0.1 2016-01-30 23:20 yangtao.lyt Exp $
 */
public interface AccountInfoDAO extends MongoRepository<AccountInfoDO, String>{

    List<AccountInfoDO> findAccountInfoByDomainObjAndDomainId(Integer domainObj, String domainId);

}
