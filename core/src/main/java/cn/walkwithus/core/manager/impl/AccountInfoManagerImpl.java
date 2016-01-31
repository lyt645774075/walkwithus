/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved
 */

package cn.walkwithus.core.manager.impl;

import cn.walkwithus.core.domain.AccountInfoBO;
import cn.walkwithus.core.manager.AccountInfoManager;
import cn.walkwithus.core.transfer.AccountInfoTransfer;
import cn.walkwithus.persistence.dal.AccountInfoDAO;
import cn.walkwithus.persistence.dal.dataobject.AccountInfoDO;
import cn.walkwithus.security.login.LoginUserHolder;
import cn.walkwithus.support.constants.AccountInfoStatus;
import cn.walkwithus.support.constants.DomainObj;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @author yangtao.lyt
 * @version $Id: AccountInfoManagerImpl, v 0.1 2016-01-31 00:16 yangtao.lyt Exp $
 */
@Service
public class AccountInfoManagerImpl implements AccountInfoManager {

    private static final Logger logger = LoggerFactory.getLogger(AccountInfoManagerImpl.class);

    @Autowired
    private LoginUserHolder     loginUserHolder;

    @Autowired
    private AccountInfoDAO      accountInfoDAO;

    @Override
    public AccountInfoBO addTeamAccountInfo(AccountInfoBO accountInfoBO) {
        return null;
    }

    @Override
    public AccountInfoBO addActivityAccountInfo(AccountInfoBO accountInfoBO) {

        accountInfoBO.setSubmitUserId(loginUserHolder.getId());
        accountInfoBO.setSubmitUserNickName(loginUserHolder.getNickName());

        Date now = new Date();
        accountInfoBO.setGmtCreate(now);
        accountInfoBO.setGmtModified(now);

        accountInfoBO.setStatus(AccountInfoStatus.WAIT_AUDIT);
        accountInfoBO.setDomainObj(DomainObj.ACTIVITY);

        AccountInfoDO accountInfoDO = accountInfoDAO.save(AccountInfoTransfer.toDO(accountInfoBO));

        return AccountInfoTransfer.toBO(accountInfoDO);
    }

    @Override
    public List<AccountInfoBO> queryTeamAccountInfo(String teamId) {
        Preconditions.checkNotNull(teamId);

        return this.queryAccountInfoByDomainObjAndDomainId(DomainObj.TEAM, teamId);
    }

    @Override
    public List<AccountInfoBO> queryActivityAccountInfo(String activityId) {

        Preconditions.checkNotNull(activityId);

        return this.queryAccountInfoByDomainObjAndDomainId(DomainObj.ACTIVITY, activityId);
    }

    @Override
    public List<AccountInfoBO> queryAccountInfoByDomainObjAndDomainId(DomainObj domainObj,
                                                                      String domainId) {
        Preconditions.checkNotNull(domainId);
        Preconditions.checkNotNull(domainObj);

        List<AccountInfoDO> accountInfoDOList = accountInfoDAO
            .findAccountInfoByDomainObjAndDomainId(domainObj.getCode(), domainId);

        if (CollectionUtils.isEmpty(accountInfoDOList)) {
            return Lists.newArrayList();
        }

        return AccountInfoTransfer.toBOList(accountInfoDOList);

    }

    @Override
    public AccountInfoBO passAccountInfo(String id) {
        return null;
    }

    @Override
    public AccountInfoBO unPassAccountInfo(String id) {
        return null;
    }
}
