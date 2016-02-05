package cn.walkwithus.persistence.dal.dataobject;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * @author yangtao.lyt
 * @version $Id: RelaTeamActivityDO, v 0.1 2016-01-29 13:04 yangtao.lyt Exp $
 */
@Document(collection = "rela_team_activity")
public class RelaTeamActivityDO extends BaseMongoObject {

    private String teamId;

    private String teamName;

    private String activityId;

    private String activityName;

    private Date activityBeginDate;

    private Date activityEndDate;

    private boolean enable;


    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public Date getActivityBeginDate() {
        return activityBeginDate;
    }

    public void setActivityBeginDate(Date activityBeginDate) {
        this.activityBeginDate = activityBeginDate;
    }

    public Date getActivityEndDate() {
        return activityEndDate;
    }

    public void setActivityEndDate(Date activityEndDate) {
        this.activityEndDate = activityEndDate;
    }
}
