package cn.walkwithus.web.transfer;

import cn.walkwithus.core.domain.ActivityBO;
import cn.walkwithus.support.utils.DateUtil;
import cn.walkwithus.web.vo.ActivityVO;
import com.google.common.base.Preconditions;
import org.apache.commons.lang.StringUtils;

/**
 * @author yangtao.lyt
 * @version $Id: ActivityTransfer, v 0.1 2016-01-27 13:19 yangtao.lyt Exp $
 */
public class ActivityTransfer {
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm";

    public static ActivityBO toBO(ActivityVO vo){

        Preconditions.checkNotNull(vo);

        ActivityBO activityBO = new ActivityBO();
        activityBO.setId(vo.getId());
        activityBO.setName(vo.getName());
        if(StringUtils.isNotBlank(vo.getBeginDate())){
            activityBO.setBeginDate(DateUtil.parseStr(vo.getBeginDate(), DATE_FORMAT));
        }
        if (StringUtils.isNotBlank(vo.getEndDate())){
            activityBO.setEndDate(DateUtil.parseStr(vo.getEndDate(), DATE_FORMAT));
        }

        activityBO.setDomainObj(vo.getDomainObj());
        activityBO.setDomainId(vo.getDomainId());
        activityBO.setOwnerName(vo.getOwnerName());
        activityBO.setDesc(vo.getDesc());
        activityBO.setAddress(vo.getAddress());

        return activityBO;
    }


    public static ActivityVO toVO(ActivityBO bo){

        Preconditions.checkNotNull(bo);

        ActivityVO activityVO = new ActivityVO();
        activityVO.setId(bo.getId());
        activityVO.setName(bo.getName());
        if(bo.getBeginDate() != null){
            activityVO.setBeginDate(DateUtil.format(bo.getBeginDate(), DATE_FORMAT));
        }
        if (bo.getEndDate() != null){
            activityVO.setEndDate(DateUtil.format(bo.getEndDate(), DATE_FORMAT));
        }

        activityVO.setDesc(bo.getDesc());
        activityVO.setAddress(bo.getAddress());

        activityVO.setRelaUserActivityBOList(bo.getRelaUserActivityBOList());

        activityVO.setDomainObj(bo.getDomainObj());
        activityVO.setDomainId(bo.getDomainId());
        activityVO.setOwnerName(bo.getOwnerName());

        return activityVO;
    }
}
