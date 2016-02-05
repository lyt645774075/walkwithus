package cn.walkwithus.web.transfer;

import cn.walkwithus.core.domain.TeamBO;
import cn.walkwithus.web.vo.TeamVO;
import com.google.common.base.Preconditions;

/**
 * @author yangtao.lyt
 * @version $Id: TeamTransfer, v 0.1 2016-01-27 18:50 yangtao.lyt Exp $
 */
public class TeamTransfer {

    public static TeamBO toBO(TeamVO teamVO){
        Preconditions.checkNotNull(teamVO);

        TeamBO teamBO = new TeamBO();
        teamBO.setId(teamVO.getId());
        teamBO.setGmtCreate(teamVO.getGmtCreate());
        teamBO.setGmtModified(teamVO.getGmtModified());
        teamBO.setName(teamVO.getName());

        return teamBO;
    }


    public static TeamVO toVO(TeamBO teamBO){
        Preconditions.checkNotNull(teamBO);

        TeamVO teamVO = new TeamVO();
        teamVO.setId(teamBO.getId());
        teamVO.setGmtCreate(teamBO.getGmtCreate());
        teamVO.setGmtModified(teamBO.getGmtModified());
        teamVO.setName(teamBO.getName());

        return teamVO;
    }


}
