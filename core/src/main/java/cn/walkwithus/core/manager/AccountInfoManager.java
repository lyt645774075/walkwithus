package cn.walkwithus.core.manager;

import cn.walkwithus.core.domain.AccountInfoBO;
import cn.walkwithus.support.constants.DomainObj;

import java.util.List;

/**
 * 财务管理器
 *
 * @author yangtao.lyt
 * @version $Id: AccountInfoManager, v 0.1 2016-01-30 23:32 yangtao.lyt Exp $
 */
public interface AccountInfoManager {


    public AccountInfoBO addTeamAccountInfo(AccountInfoBO accountInfoBO);

    public AccountInfoBO addActivityAccountInfo(AccountInfoBO accountInfoBO);

    public List<AccountInfoBO> queryTeamAccountInfo(String teamId);

    public List<AccountInfoBO> queryActivityAccountInfo(String activityId);

    public AccountInfoBO passAccountInfo(String id);

    public AccountInfoBO unPassAccountInfo(String id);

    public List<AccountInfoBO> queryAccountInfoByDomainObjAndDomainId(DomainObj domainObj, String domainId);


}
