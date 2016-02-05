package cn.walkwithus.persistence.dal.dataobject;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * 团队-用户的关系对象
 *
 * @author yangtao.lyt
 * @version $Id: RelaUserTeamDO, v 0.1 2016-01-28 13:43 yangtao.lyt Exp $
 */
@Document(collection = "rela_user_team")
public class RelaUserTeamDO extends BaseMongoObject{

    private String teamId;

    private String teamName;

    private String userId;

    private String userNickName;

    private String userRole;

    private boolean valid;

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getUserNickName() {
        return userNickName;
    }

    public void setUserNickName(String userNickName) {
        this.userNickName = userNickName;
    }
}
