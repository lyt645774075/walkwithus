package cn.walkwithus.core.transfer;

import cn.walkwithus.core.domain.AccountInfoBO;
import cn.walkwithus.persistence.dal.dataobject.AccountInfoDO;
import cn.walkwithus.support.constants.AccountInfoStatus;
import cn.walkwithus.support.constants.Direction;
import cn.walkwithus.support.constants.DomainObj;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author yangtao.lyt
 * @version $Id: AccountInfoTransfer, v 0.1 2016-01-30 23:49 yangtao.lyt Exp $
 */
public class AccountInfoTransfer {

    public static AccountInfoBO toBO(AccountInfoDO accountInfoDO){

        Preconditions.checkNotNull(accountInfoDO);

        AccountInfoBO accountInfoBO = new AccountInfoBO();
        accountInfoBO.setId(accountInfoDO.getId());
        accountInfoBO.setGmtCreate(accountInfoDO.getGmtCreate());
        accountInfoBO.setGmtModified(accountInfoDO.getGmtModified());
        accountInfoBO.setDomainObj(DomainObj.getDomainObjByCode(accountInfoDO.getDomainObj()));
        accountInfoBO.setDomainId(accountInfoDO.getDomainId());
        accountInfoBO.setMoney(accountInfoDO.getMoney());
        accountInfoBO.setStatus(AccountInfoStatus.getStatusByCode(accountInfoDO.getStatus()));
        accountInfoBO.setDirection(Direction.getDirectionByCode(accountInfoDO.getDirection()));
        accountInfoBO.setSubmitUserId(accountInfoDO.getSubmitUserId());
        accountInfoBO.setSubmitUserNickName(accountInfoDO.getSubmitUserNickName());
        accountInfoBO.setActionUserNickName(accountInfoDO.getActionUserNickName());
        accountInfoBO.setAuditUserId(accountInfoDO.getAuditUserId());
        accountInfoBO.setAuditUserNickName(accountInfoDO.getAuditUserNickName());
        accountInfoBO.setMemo(accountInfoDO.getMemo());

        return accountInfoBO;
    }

    public static AccountInfoDO toDO(AccountInfoBO accountInfoBO){

        Preconditions.checkNotNull(accountInfoBO);

        AccountInfoDO accountInfoDO = new AccountInfoDO();
        accountInfoDO.setId(accountInfoBO.getId());
        accountInfoDO.setGmtCreate(accountInfoBO.getGmtCreate());
        accountInfoDO.setGmtModified(accountInfoBO.getGmtModified());
        accountInfoDO.setDomainObj(accountInfoBO.getDomainObj().getCode());
        accountInfoDO.setDomainId(accountInfoBO.getDomainId());
        accountInfoDO.setMoney(accountInfoBO.getMoney());
        accountInfoDO.setStatus(accountInfoBO.getStatus().getCode());
        accountInfoDO.setDirection(accountInfoBO.getDirection().getCode());
        accountInfoDO.setSubmitUserId(accountInfoBO.getSubmitUserId());
        accountInfoDO.setSubmitUserNickName(accountInfoBO.getSubmitUserNickName());
        accountInfoDO.setActionUserNickName(accountInfoBO.getActionUserNickName());
        accountInfoDO.setAuditUserId(accountInfoBO.getAuditUserId());
        accountInfoDO.setAuditUserNickName(accountInfoBO.getAuditUserNickName());
        accountInfoDO.setMemo(accountInfoBO.getMemo());

        return accountInfoDO;

    }

    public static List<AccountInfoBO> toBOList(List<AccountInfoDO> accountInfoDOList){

        List<AccountInfoBO> result = Lists.newArrayList();
        if(CollectionUtils.isEmpty(accountInfoDOList)){
            return result;
        }

        for(AccountInfoDO accountInfoDO : accountInfoDOList){
            result.add(toBO(accountInfoDO));
        }

        return result;
    }



}
