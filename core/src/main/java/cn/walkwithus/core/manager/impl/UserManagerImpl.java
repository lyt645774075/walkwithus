package cn.walkwithus.core.manager.impl;

import cn.walkwithus.core.domain.UserBO;
import cn.walkwithus.core.manager.UserManager;
import cn.walkwithus.core.transfer.UserTransfer;
import cn.walkwithus.persistence.dal.UserDAO;
import cn.walkwithus.persistence.dal.dataobject.UserDO;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author yangtao.lyt
 * @version $Id: UserManagerImpl, v 0.1 2016-01-16 23:10 yangtao.lyt Exp $
 */
@Service
public class UserManagerImpl implements UserManager{

    @Autowired
    private UserDAO userDAO;

    public UserBO getUserByEmail(String email){

        Preconditions.checkNotNull(email);

        UserDO userDO = userDAO.findUserByEmail(email);

        return UserTransfer.toBO(userDO);
    }

    @Override
    public UserBO createUser(UserBO userBO) {
        Preconditions.checkNotNull(userBO);

        userBO.setGmtCreate(new Date());
        userBO.setGmtModified(new Date());

        UserDO userDO = userDAO.save(UserTransfer.toDO(userBO));

        return UserTransfer.toBO(userDO);
    }
}
