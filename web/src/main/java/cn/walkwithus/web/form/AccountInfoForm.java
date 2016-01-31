/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved
 */

package cn.walkwithus.web.form;

/**
 * @author yangtao.lyt
 * @version $Id: AccountInfoForm, v 0.1 2016-01-31 13:25 yangtao.lyt Exp $
 */
public class AccountInfoForm {

    private Double money;

    private Integer direction;

    private String actionUserNickName;

    private String memo;


    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getDirection() {
        return direction;
    }

    public void setDirection(Integer direction) {
        this.direction = direction;
    }

    public String getActionUserNickName() {
        return actionUserNickName;
    }

    public void setActionUserNickName(String actionUserNickName) {
        this.actionUserNickName = actionUserNickName;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }



}
