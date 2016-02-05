package cn.walkwithus.persistence.dal.dataobject;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author yangtao.lyt
 * @version $Id: AccountInfoDO, v 0.1 2016-01-30 23:08 yangtao.lyt Exp $
 */
@Document(collection = "account_info")
public class AccountInfoDO extends BaseMongoObject{

    /**
     * 类型: 1-团队  2-活动
     */
    private Integer domainObj;

    /**
     * 领域对象id:  团队id, 活动id
     */
    private String domainId;

    /**
     * 金额(分)
     */
    private Long money;

    private Integer direction;

    /**
     * 状态: 99-废弃, 1-待审核, 10-审核通过, 20-审核不通过
     */
    private Integer status;

    private String submitUserId;

    private String submitUserNickName;

    private String actionUserNickName;

    private String auditUserId;

    private String auditUserNickName;

    private String memo;


    public Integer getDomainObj() {
        return domainObj;
    }

    public void setDomainObj(Integer domainObj) {
        this.domainObj = domainObj;
    }

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    public String getDomainId() {
        return domainId;
    }

    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
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
