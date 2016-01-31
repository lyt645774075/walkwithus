/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved
 */

package cn.walkwithus.web.transfer;

import cn.walkwithus.core.domain.AccountInfoBO;
import cn.walkwithus.support.constants.Direction;
import cn.walkwithus.web.form.AccountInfoForm;
import cn.walkwithus.web.vo.AccountInfoVO;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author yangtao.lyt
 * @version $Id: AccountInfoTransfer, v 0.1 2016-01-31 12:23 yangtao.lyt Exp $
 */
public class AccountInfoTransfer {


    public static AccountInfoBO toBO(AccountInfoForm accountInfoForm){

        Preconditions.checkNotNull(accountInfoForm);

        AccountInfoBO infoBO = new AccountInfoBO();
        infoBO.setDirection(Direction.getDirectionByCode(accountInfoForm.getDirection()));
        infoBO.setMoney(Double.valueOf(accountInfoForm.getMoney() * 100).longValue());
        infoBO.setActionUserNickName(accountInfoForm.getActionUserNickName());
        infoBO.setMemo(accountInfoForm.getMemo());

        return infoBO;
    }

    public static AccountInfoVO toVO(AccountInfoBO accountInfoBO){
        Preconditions.checkNotNull(accountInfoBO);

        AccountInfoVO infoVO = new AccountInfoVO();
        infoVO.setId(accountInfoBO.getId());
        infoVO.setGmtCreate(accountInfoBO.getGmtCreate());
        infoVO.setGmtModified(accountInfoBO.getGmtModified());
        infoVO.setDomainObj(accountInfoBO.getDomainObj());
        infoVO.setDomainId(accountInfoBO.getDomainId());
        infoVO.setDirection(accountInfoBO.getDirection());
        infoVO.setMoney(accountInfoBO.getMoney() / 100.0);
        infoVO.setStatus(accountInfoBO.getStatus());
        infoVO.setSubmitUserId(accountInfoBO.getSubmitUserId());
        infoVO.setSubmitUserNickName(accountInfoBO.getSubmitUserNickName());
        infoVO.setAuditUserId(accountInfoBO.getAuditUserId());
        infoVO.setAuditUserNickName(accountInfoBO.getAuditUserNickName());
        infoVO.setActionUserNickName(accountInfoBO.getActionUserNickName());
        infoVO.setMemo(accountInfoBO.getMemo());

        return infoVO;

    }


    public static List<AccountInfoVO> toVOList(List<AccountInfoBO> accountInfoBOList){

        List<AccountInfoVO> result = Lists.newArrayList();
        if(CollectionUtils.isEmpty(accountInfoBOList)){
            return result;
        }

        for(AccountInfoBO accountInfoBO : accountInfoBOList){
            result.add(toVO(accountInfoBO));
        }

        return result;

    }


}
