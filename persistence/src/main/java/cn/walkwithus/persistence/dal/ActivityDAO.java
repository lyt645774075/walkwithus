package cn.walkwithus.persistence.dal;

import cn.walkwithus.persistence.dal.dataobject.ActivityDO;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author yangtao.lyt
 * @version $Id: ActivityDAO, v 0.1 2016-01-23 09:45 yangtao.lyt Exp $
 */
public interface ActivityDAO extends MongoRepository<ActivityDO, String>{
}
