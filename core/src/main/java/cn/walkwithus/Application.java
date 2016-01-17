/*
 * Alipay.com Inc.
 * Copyright (c) 2004-2016 All Rights Reserved
 */

package cn.walkwithus;

import cn.walkwithus.dal.UserDAO;
import cn.walkwithus.dal.dataobject.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yangtao.lyt
 * @version $Id: Application, v 0.1 2016-01-15 13:29 yangtao.lyt Exp $
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    private UserDAO userDAO;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        userDAO.deleteAll();

        UserDO userDO = new UserDO();
        userDO.setNickName("李洋涛");
        userDO.setUserName("yangtao.lyt@alibaba-inc.com");
        userDO.setPassWord("123");

        userDAO.save(userDO);

        userDO = userDAO.findUserByUserName("yangtao.lyt@alibaba-inc.com");

        System.out.println(userDO);

    }

}