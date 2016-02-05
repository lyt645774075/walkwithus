package cn.walkwithus.web.transfer;

import cn.walkwithus.core.domain.UserBO;
import cn.walkwithus.web.vo.UserVO;
import com.google.common.base.Preconditions;

/**
 * @author yangtao.lyt
 * @version $Id: UserTransfer, v 0.1 2016-01-27 22:54 yangtao.lyt Exp $
 */
public class UserTransfer {

    public static UserBO toBO(UserVO userVO){

        Preconditions.checkNotNull(userVO);

        UserBO userBO = new UserBO();
        userBO.setId(userVO.getId());
        userBO.setEmail(userVO.getEmail());
        userBO.setNickName(userVO.getNickName());
        userBO.setPassWord(userVO.getPassWord());
        userBO.setGmtCreate(userVO.getGmtCreate());
        userBO.setGmtModified(userVO.getGmtModified());

        return userBO;
    }


    public static UserVO toVO(UserBO userBO){

        Preconditions.checkNotNull(userBO);

        UserVO userVO = new UserVO();
        userVO.setId(userBO.getId());
        userVO.setEmail(userBO.getEmail());
        userVO.setNickName(userBO.getNickName());
        userVO.setPassWord(userBO.getPassWord());
        userVO.setGmtCreate(userBO.getGmtCreate());
        userVO.setGmtModified(userBO.getGmtModified());

        return userVO;
    }

}
