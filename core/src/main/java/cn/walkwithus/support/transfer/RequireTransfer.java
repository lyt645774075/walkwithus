/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved
 */

package cn.walkwithus.support.transfer;

import cn.walkwithus.dal.dataobject.RequireDO;
import cn.walkwithus.domain.RequireBO;
import cn.walkwithus.support.constants.RequireStatusEnum;
import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author yangtao.lyt
 * @version $Id: RequireTransfer, v 0.1 2016-01-17 16:28 yangtao.lyt Exp $
 */
public class RequireTransfer {

    public static RequireBO toBO(RequireDO requireDO){
        if(requireDO == null){
            return null;
        }

        RequireBO requireBO = new RequireBO();
        requireBO.setId(requireDO.getId());
        requireBO.setGmtCreate(requireDO.getGmtCreate());
        requireBO.setDesc(requireDO.getDesc());
        requireBO.setAcceptor(requireDO.getAcceptor());
        requireBO.setStatus(RequireStatusEnum.getStatusByCode(requireDO.getStatus()));
        requireBO.setMemo(requireDO.getMemo());
        requireBO.setCreator(requireDO.getCreator());
        requireBO.setCreatorNick(requireDO.getCreatorNick());

        return requireBO;
    }

    public static List<RequireBO> toBOList(List<RequireDO> requireDOList){

        if(CollectionUtils.isEmpty(requireDOList)){
            return Lists.newArrayList();
        }

        List<RequireBO> result = Lists.newArrayList();

        for(RequireDO requireDO : requireDOList){
            result.add(toBO(requireDO));
        }

        return result;
    }
}
