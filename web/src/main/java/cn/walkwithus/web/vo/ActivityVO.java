/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved
 */

package cn.walkwithus.web.vo;

import cn.walkwithus.support.constants.DomainObj;

/**
 * @author yangtao.lyt
 * @version $Id: ActivityVO, v 0.1 2016-01-26 19:08 yangtao.lyt Exp $
 */
public class ActivityVO {

    private String id;

    private String name;

    /** 归属的领域对象类型 归属团队,归属个人*/
    private DomainObj domainObj;
    /** 归属的领域对象id */
    private String domainId;
    /** owner的名字   团队名称,个人昵称 */
    private String ownerName;

    private String beginDate;

    private String endDate;

    private String address;

    private String desc;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public DomainObj getDomainObj() {
        return domainObj;
    }

    public void setDomainObj(DomainObj domainObj) {
        this.domainObj = domainObj;
    }

    public String getDomainId() {
        return domainId;
    }

    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
