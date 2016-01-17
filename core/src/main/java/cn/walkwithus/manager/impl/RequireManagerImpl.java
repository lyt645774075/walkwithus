/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved
 */

package cn.walkwithus.manager.impl;

import cn.walkwithus.dal.RequireDAO;
import cn.walkwithus.dal.dataobject.RequireDO;
import cn.walkwithus.domain.RequireBO;
import cn.walkwithus.manager.RequireManager;
import cn.walkwithus.support.constants.RequireStatusEnum;
import cn.walkwithus.support.transfer.RequireTransfer;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author yangtao.lyt
 * @version $Id: RequireManagerImpl, v 0.1 2016-01-17 16:25 yangtao.lyt Exp $
 */
@Service
public class RequireManagerImpl implements RequireManager{

    @Autowired
    private RequireDAO requireDAO;


    @Override
    public List<RequireBO> queryAll() {
        List<RequireDO> requireDOList = requireDAO.findAll();

        return RequireTransfer.toBOList(requireDOList);
    }

    @Override
    public void createRequire(RequireBO requireBO) {

        Preconditions.checkNotNull(requireBO);

        RequireDO requireDO = new RequireDO();
        requireDO.setDesc(requireBO.getDesc());
        requireDO.setGmtCreate(new Date());
        requireDO.setStatus(RequireStatusEnum.CREATE.getCode());
        requireDO.setCreator(requireBO.getCreator());
        requireDO.setCreatorNick(requireBO.getCreatorNick());

        requireDAO.save(requireDO);

    }
}
