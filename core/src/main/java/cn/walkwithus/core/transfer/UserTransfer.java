package cn.walkwithus.core.transfer;

import cn.walkwithus.core.domain.UserBO;
import cn.walkwithus.persistence.dal.dataobject.UserDO;

/**
 * @author yangtao.lyt
 * @version $Id: UserTransfer, v 0.1 2016-01-27 13:16 yangtao.lyt Exp $
 */
public class UserTransfer {
    public static UserBO toBO(UserDO userDO){
        if(userDO == null){
            return null;
        }

        UserBO userBO = new UserBO();
        userBO.setId(userDO.getId());
        userBO.setEmail(userDO.getEmail());
        userBO.setPassWord(userDO.getPassWord());
        userBO.setNickName(userDO.getNickName());
        userBO.setGmtCreate(userDO.getGmtCreate());
        userBO.setGmtModified(userDO.getGmtModified());

        return userBO;

    }

    public static UserDO toDO(UserBO userBO){
        if(userBO == null){
            return null;
        }

        UserDO userDO = new UserDO();
        userDO.setId(userBO.getId());
        userDO.setEmail(userBO.getEmail());
        userDO.setPassWord(userBO.getPassWord());
        userDO.setNickName(userBO.getNickName());
        userDO.setGmtCreate(userBO.getGmtCreate());
        userDO.setGmtModified(userBO.getGmtModified());

        return userDO;

    }

}
