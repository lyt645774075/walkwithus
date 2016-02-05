package cn.walkwithus.core.domain;

import com.google.common.collect.Lists;

import java.util.Date;
import java.util.List;

/**
 * @author yangtao.lyt
 * @version $Id: TeamBO, v 0.1 2016-01-27 12:44 yangtao.lyt Exp $
 */
public class TeamBO {

    private String id;

    private Date gmtCreate;

    private Date gmtModified;

    private String name;

    private List<RelaTeamActivityBO> relaTeamActivityBOList = Lists.newArrayList();

    private List<RelaUserTeamBO> relaUserTeamBOList = Lists.newArrayList();

    private String creatorId;

    private String creatorNickName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreatorNickName() {
        return creatorNickName;
    }

    public void setCreatorNickName(String creatorNickName) {
        this.creatorNickName = creatorNickName;
    }

    public List<RelaTeamActivityBO> getRelaTeamActivityBOList() {
        return relaTeamActivityBOList;
    }

    public void setRelaTeamActivityBOList(List<RelaTeamActivityBO> relaTeamActivityBOList) {
        this.relaTeamActivityBOList = relaTeamActivityBOList;
    }

    public List<RelaUserTeamBO> getRelaUserTeamBOList() {
        return relaUserTeamBOList;
    }

    public void setRelaUserTeamBOList(List<RelaUserTeamBO> relaUserTeamBOList) {
        this.relaUserTeamBOList = relaUserTeamBOList;
    }
}
