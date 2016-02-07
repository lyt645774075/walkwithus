package cn.walkwithus.core.transfer;

import cn.walkwithus.core.domain.RelaUserActivityBO;
import cn.walkwithus.persistence.dal.dataobject.RelaUserActivityDO;
import cn.walkwithus.security.role.UserRole;
import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author yangtao.lyt
 * @version $Id: RelaUserActivityTransfer, v 0.1 2016-02-06 21:42 yangtao.lyt Exp $
 */
public class RelaUserActivityTransfer {

    public static final RelaUserActivityBO toBO(RelaUserActivityDO relaUserDO){

        if(relaUserDO == null){
            return null;
        }

        RelaUserActivityBO relaUserBO = new RelaUserActivityBO();
        relaUserBO.setId(relaUserDO.getId());
        relaUserBO.setGmtCreate(relaUserDO.getGmtCreate());
        relaUserBO.setGmtCreate(relaUserDO.getGmtModified());
        relaUserBO.setActivityId(relaUserDO.getActivityId());
        relaUserBO.setActivityName(relaUserDO.getActivityName());
        relaUserBO.setUserId(relaUserDO.getUserId());
        relaUserBO.setUserNickName(relaUserDO.getUserNickName());
        relaUserBO.setUserRole(UserRole.getUserRoleByCode(relaUserDO.getUserRole()));
        relaUserBO.setValid(relaUserDO.isValid());

        return relaUserBO;
    }

    public static final List<RelaUserActivityBO> toBOList(List<RelaUserActivityDO> relaUserDOList){

        List<RelaUserActivityBO> relaUserActivityBOList = Lists.newArrayList();
        if(CollectionUtils.isEmpty(relaUserDOList)){
            return relaUserActivityBOList;
        }

        for(RelaUserActivityDO relaUserActivityDO : relaUserDOList){
            relaUserActivityBOList.add(toBO(relaUserActivityDO));
        }

        return relaUserActivityBOList;
    }

}
