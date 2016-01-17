/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved
 */

package cn.walkwithus.support.constants;

import com.google.common.base.Preconditions;

/**
 * @author yangtao.lyt
 * @version $Id: RequireStatusEnum, v 0.1 2016-01-17 16:38 yangtao.lyt Exp $
 */
public enum  RequireStatusEnum {

    CREATE("创建", 1),

    HANDING("处理中", 11),

    COMPLETE("已完成", 21),

    INVALID("拒绝", 31),

    UNKNOWN("未知", -1)



    ;

    private String label;

    private Integer code;


    private RequireStatusEnum(String label, Integer code) {

        this.label = label;
        this.code = code;

    }

    public static RequireStatusEnum getStatusByCode(Integer code){
        Preconditions.checkNotNull(code);

        for(RequireStatusEnum statusEnum : values()){
            if (statusEnum.code.equals(code)){
                return statusEnum;
            }
        }

        return UNKNOWN;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
