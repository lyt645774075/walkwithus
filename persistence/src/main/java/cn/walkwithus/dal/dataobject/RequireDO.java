/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved
 */

package cn.walkwithus.dal.dataobject;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @author yangtao.lyt
 * @version $Id: RequireDO, v 0.1 2016-01-17 13:39 yangtao.lyt Exp $
 */
@Document(collection = "require")
public class RequireDO {

    private String id;

    private Date gmtCreate;

    private String desc;

    private String creator;

    private String creatorNick;

    private Integer status;

    private String acceptor;

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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }


    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Integer getStatus() {
        return status;
    }

    public String getCreatorNick() {
        return creatorNick;
    }

    public void setCreatorNick(String creatorNick) {
        this.creatorNick = creatorNick;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAcceptor() {
        return acceptor;
    }

    public void setAcceptor(String acceptor) {
        this.acceptor = acceptor;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}
