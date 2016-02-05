package cn.walkwithus.core.manager.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.walkwithus.core.domain.RequireBO;
import cn.walkwithus.core.manager.RequireManager;
import cn.walkwithus.core.transfer.RequireTransfer;
import cn.walkwithus.persistence.dal.RequireDAO;
import cn.walkwithus.persistence.dal.dataobject.RequireDO;
import cn.walkwithus.support.constants.RequireStatusEnum;

import com.google.common.base.Preconditions;

/**
 * @author yangtao.lyt
 * @version $Id: RequireManagerImpl, v 0.1 2016-01-17 16:25 yangtao.lyt Exp $
 */
@Service
public class RequireManagerImpl implements RequireManager {

    @Autowired
    private RequireDAO requireDAO;


    @Override
    public List<RequireBO> queryAll() {
        List<RequireDO> requireDOList = requireDAO.findAll();

        return RequireTransfer.toBOList(requireDOList);
    }

    @Override
    public void createRequire(RequireBO requireBO) {

        Preconditions.checkNotNull(requireBO);

        RequireDO requireDO = new RequireDO();
        requireDO.setDesc(requireBO.getDesc());
        requireDO.setGmtCreate(new Date());
        requireDO.setStatus(RequireStatusEnum.CREATE.getCode());
        requireDO.setCreator(requireBO.getCreator());
        requireDO.setCreatorNick(requireBO.getCreatorNick());

        requireDAO.save(requireDO);

    }
}
