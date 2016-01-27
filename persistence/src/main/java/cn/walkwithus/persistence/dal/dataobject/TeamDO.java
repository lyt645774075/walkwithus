/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved
 */

package cn.walkwithus.persistence.dal.dataobject;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author yangtao.lyt
 * @version $Id: TeamDO, v 0.1 2016-01-23 09:44 yangtao.lyt Exp $
 */
@Document(collection = "team")
public class TeamDO extends BaseMongoObject{


    private String name;




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
