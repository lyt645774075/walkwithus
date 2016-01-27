/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved
 */

package cn.walkwithus.core.domain;


import cn.walkwithus.support.constants.RequireStatusEnum;

import java.util.Date;

/**
 *
 * 需求对象
 *
 * @author yangtao.lyt
 * @version $Id: RequireBO, v 0.1 2016-01-17 16:26 yangtao.lyt Exp $
 */
public class RequireBO {
    private String id;

    private Date gmtCreate;

    private String desc;

    private String creator;

    private String creatorNick;

    private RequireStatusEnum status;

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


    public String getCreatorNick() {
        return creatorNick;
    }

    public void setCreatorNick(String creatorNick) {
        this.creatorNick = creatorNick;
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

    public RequireStatusEnum getStatus() {
        return status;
    }

    public void setStatus(RequireStatusEnum status) {
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
