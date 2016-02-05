package cn.walkwithus.core.transfer;

import java.util.List;

import org.springframework.util.CollectionUtils;

import cn.walkwithus.core.domain.RequireBO;
import cn.walkwithus.persistence.dal.dataobject.RequireDO;
import cn.walkwithus.support.constants.RequireStatusEnum;

import com.google.common.collect.Lists;

/**
 * @author yangtao.lyt
 * @version $Id: RequireTransfer, v 0.1 2016-01-27 13:14 yangtao.lyt Exp $
 */
public class RequireTransfer {
    public static RequireBO toBO(RequireDO requireDO){
        if(requireDO == null){
            return null;
        }

        RequireBO requireBO = new RequireBO();
        requireBO.setId(requireDO.getId());
        requireBO.setGmtCreate(requireDO.getGmtCreate());
        requireBO.setDesc(requireDO.getDesc());
        requireBO.setAcceptor(requireDO.getAcceptor());
        requireBO.setStatus(RequireStatusEnum.getStatusByCode(requireDO.getStatus()));
        requireBO.setMemo(requireDO.getMemo());
        requireBO.setCreator(requireDO.getCreator());
        requireBO.setCreatorNick(requireDO.getCreatorNick());

        return requireBO;
    }

    public static List<RequireBO> toBOList(List<RequireDO> requireDOList){

        if(CollectionUtils.isEmpty(requireDOList)){
            return Lists.newArrayList();
        }

        List<RequireBO> result = Lists.newArrayList();

        for(RequireDO requireDO : requireDOList){
            result.add(toBO(requireDO));
        }

        return result;
    }
}
