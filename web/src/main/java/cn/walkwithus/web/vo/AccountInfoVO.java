package cn.walkwithus.web.vo;

import cn.walkwithus.support.constants.AccountInfoStatus;
import cn.walkwithus.support.constants.Direction;
import cn.walkwithus.support.constants.DomainObj;

import java.util.Date;

/**
 * @author yangtao.lyt
 * @version $Id: AccountInfoVO, v 0.1 2016-01-31 00:18 yangtao.lyt Exp $
 */
public class AccountInfoVO {

    private String id;

    private Date gmtCreate;

    private Date gmtModified;

    /**
     * 类型: 1-团队  2-活动
     */
    private DomainObj domainObj;

    /**
     * 领域对象id:  团队id, 活动id
     */
    private String domainId;

    /**
     * 金额(元)
     */
    private Double money;

    private Direction direction;

    private AccountInfoStatus status;

    private String submitUserId;

    private String submitUserNickName;

    private String actionUserNickName;

    private String auditUserId;

    private String auditUserNickName;

    private String memo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }


    public String getDomainId() {
        return domainId;
    }

    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }


    public String getActionUserNickName() {
        return actionUserNickName;
    }

    public void setActionUserNickName(String actionUserNickName) {
        this.actionUserNickName = actionUserNickName;
    }

    public String getAuditUserId() {
        return auditUserId;
    }

    public void setAuditUserId(String auditUserId) {
        this.auditUserId = auditUserId;
    }

    public String getAuditUserNickName() {
        return auditUserNickName;
    }

    public void setAuditUserNickName(String auditUserNickName) {
        this.auditUserNickName = auditUserNickName;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public DomainObj getDomainObj() {
        return domainObj;
    }

    public void setDomainObj(DomainObj domainObj) {
        this.domainObj = domainObj;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public AccountInfoStatus getStatus() {
        return status;
    }

    public void setStatus(AccountInfoStatus status) {
        this.status = status;
    }

    public String getSubmitUserId() {
        return submitUserId;
    }

    public void setSubmitUserId(String submitUserId) {
        this.submitUserId = submitUserId;
    }

    public String getSubmitUserNickName() {
        return submitUserNickName;
    }

    public void setSubmitUserNickName(String submitUserNickName) {
        this.submitUserNickName = submitUserNickName;
    }


}
