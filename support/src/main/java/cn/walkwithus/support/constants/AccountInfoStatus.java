/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved
 */

package cn.walkwithus.support.constants;

import com.google.common.base.Preconditions;

/**
 * @author yangtao.lyt
 * @version $Id: AccountInfoStatus, v 0.1 2016-01-31 00:03 yangtao.lyt Exp $
 */
public enum  AccountInfoStatus {

    INVALID(99, "无效"),

    WAIT_AUDIT(1, "待审核"),

    PASS(10, "审核通过"),

    UNPASS(20, "审核不通过")

            ;

    private Integer code;

    private String label;


    AccountInfoStatus(Integer code, String label){
        this.code = code;
        this.label = label;
    }


    public static AccountInfoStatus getStatusByCode(Integer code){

        Preconditions.checkNotNull(code);

        for(AccountInfoStatus status : values()){
            if(status.getCode().equals(code)){
                return status;
            }
        }

        throw new IllegalArgumentException("无效的code,不能获取AccountInfoStatus. code=" + code);
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }




}
