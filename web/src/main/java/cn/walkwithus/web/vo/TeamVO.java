package cn.walkwithus.web.vo;

import java.util.Date;

/**
 * @author yangtao.lyt
 * @version $Id: TeamVO, v 0.1 2016-01-27 18:47 yangtao.lyt Exp $
 */
public class TeamVO {


    private String id;

    private Date gmtCreate;

    private Date gmtModified;

    private String name;


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



}
