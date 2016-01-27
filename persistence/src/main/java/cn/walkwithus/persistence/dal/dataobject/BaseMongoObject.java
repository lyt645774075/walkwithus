/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved
 */

package cn.walkwithus.persistence.dal.dataobject;

import java.util.Date;

/**
 * @author yangtao.lyt
 * @version $Id: BaseMongoObject, v 0.1 2016-01-26 18:57 yangtao.lyt Exp $
 */
public abstract class BaseMongoObject {

    private String id;

    private Date gmtCreate;

    private Date gmtModified;


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
}
