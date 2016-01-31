/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved
 */

package cn.walkwithus.persistence.dal.dataobject;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author yangtao.lyt
 * @version $Id: UserDO, v 0.1 2016-01-17 13:35 yangtao.lyt Exp $
 */
@Document(collection = "user")
public class UserDO extends BaseMongoObject{


    private String email;

    private String passWord;

    private String nickName;

    private String sex;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
