/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved
 */

package cn.walkwithus.core.domain;

import cn.walkwithus.support.constants.DomainObj;

import java.util.Date;

/**
 * @author yangtao.lyt
 * @version $Id: ActivityBO, v 0.1 2016-01-26 18:49 yangtao.lyt Exp $
 */
public class ActivityBO {

    private String id;

    private Date gmtCreate;

    private Date gmtModified;

    private String name;

    /** 归属的领域对象类型 归属团队,归属个人*/
    private DomainObj domainObj;
    /** 归属的领域对象id */
    private String domainId;
    /** owner的名字   团队名称,个人昵称 */
    private String ownerName;

    private Date beginDate;

    private Date endDate;

    private String address;

    private String desc;


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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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
