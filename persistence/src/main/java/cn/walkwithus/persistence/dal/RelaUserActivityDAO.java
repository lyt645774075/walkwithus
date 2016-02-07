package cn.walkwithus.persistence.dal;

import cn.walkwithus.persistence.dal.dataobject.RelaUserActivityDO;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author yangtao.lyt
 * @version $Id: RelaUserActivityDAO, v 0.1 2016-01-31 12:55 yangtao.lyt Exp $
 */
public interface RelaUserActivityDAO extends MongoRepository<RelaUserActivityDO, String>{

    public RelaUserActivityDO findByUserIdAndActivityId(String userId, String activityId);

    public List<RelaUserActivityDO> findAllActivityByUserId(String userId);

    public List<RelaUserActivityDO> findAllUserByActivityId(String activityId);

    public List<RelaUserActivityDO> findAllUserByActivityIdAndValid(String activityId, boolean valid);

    public void deleteOneByUserIdAndActivityId(String userId, String activityId);

}
