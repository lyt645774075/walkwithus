package cn.walkwithus.security.login;

import cn.walkwithus.persistence.dal.RelaUserActivityDAO;
import cn.walkwithus.persistence.dal.RelaUserTeamDAO;
import cn.walkwithus.persistence.dal.dataobject.RelaUserActivityDO;
import cn.walkwithus.persistence.dal.dataobject.RelaUserTeamDO;
import cn.walkwithus.security.role.UserRole;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author yangtao.lyt
 * @version $Id: LoginUserHolder, v 0.1 2016-01-27 23:38 yangtao.lyt Exp $
 */
public class LoginUserHolder {

    @Autowired
    private RelaUserTeamDAO relaUserTeamDAO;

    @Autowired
    private RelaUserActivityDAO relaUserActivityDAO;

    /**
     * 获取登陆用户的昵称
     * @return
     */
    public String getNickName() {

        UserAuthDetail userAuthDetail = getLoginUser();

        return userAuthDetail == null ? null : userAuthDetail.getNickName();

    }

    /**
     * 获取登陆用户的id
     * @return
     */
    public String getId() {

        UserAuthDetail userAuthDetail = getLoginUser();

        return userAuthDetail == null ? null : userAuthDetail.getId();
    }

    /**
     * 获取登陆用户的email(用户名)
     * @return
     */
    public String getEmail() {
        UserAuthDetail userAuthDetail = getLoginUser();

        return userAuthDetail == null ? null : userAuthDetail.getEmail();
    }

    /**
     * 用户是否登陆
     * @return
     */
    public boolean isLogin() {
        return getLoginUser() == null ? false : true;
    }

    /**
     * 用户信息
     * @return
     */
    public UserAuthDetail getLoginUser(){
        Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (obj instanceof UserDetails) {
            return (UserAuthDetail) obj;
        } else {
            return null;
        }
    }

    public boolean isNotLogin(){
        return !isLogin();
    }

    /**
     * 是否是团队owner
     * @param teamId
     * @return
     */
    public boolean isTeamOwner(String teamId){

        UserRole userRole = getUserRoleInTeam(teamId);

        return userRole == UserRole.OWNER ? true : false;
    }

    public boolean isTeamAdmin(String teamId){

        UserRole userRole = getUserRoleInTeam(teamId);

        return userRole == UserRole.ADMIN ? true : false;
    }

    public boolean isTeamMember(String teamId){

        UserRole userRole = getUserRoleInTeam(teamId);

        return userRole == UserRole.MEMBER ? true : false;
    }

    public boolean isTeamVisitor(String teamId){

        UserRole userRole = getUserRoleInTeam(teamId);

        return userRole == UserRole.VISITOR ? true : false;
    }

    /**
     * 是否已经申请加入团队
     * @param teamId
     * @return
     */
    public boolean isApplyJoinInTeam(String teamId){

        RelaUserTeamDO relaUserTeamDO = relaUserTeamDAO.findByUserIdAndTeamId(getId(), teamId);

        if(relaUserTeamDO != null && !relaUserTeamDO.isValid()){
            return true;
        }

        return false;
    }

    /**
     * 是否已经申请加入活动
     * @param activityId
     * @return
     */
    public boolean isApplyJoinInActivity(String activityId){

        RelaUserActivityDO relaUserActivityDO = relaUserActivityDAO.findByUserIdAndActivityId(getId(), activityId);

        if(relaUserActivityDO != null && !relaUserActivityDO.isValid()){
            return true;
        }

        return false;
    }

    public boolean isActivityAdmin(String activityId){

        UserRole userRole = getUserRoleInActivity(activityId);

        return userRole == UserRole.ADMIN ? true : false;
    }

    public boolean isActivityMember(String activityId){

        UserRole userRole = getUserRoleInActivity(activityId);

        return userRole == UserRole.MEMBER ? true : false;
    }

    public boolean isActivityVisitor(String activityId){

        UserRole userRole = getUserRoleInActivity(activityId);

        return userRole == UserRole.VISITOR ? true : false;
    }


    public UserRole getUserRoleInTeam(String teamId){

        if(isNotLogin()){
            return UserRole.VISITOR;
        }

        Preconditions.checkNotNull(teamId);
        RelaUserTeamDO relaUserTeamDO = relaUserTeamDAO.findByUserIdAndTeamId(getId(), teamId);

        //如果未生效,一律是游客
        if(relaUserTeamDO!= null && !relaUserTeamDO.isValid()){
            return UserRole.VISITOR;
        }

        return relaUserTeamDO == null ? UserRole.VISITOR : UserRole.getUserRoleByCode(relaUserTeamDO.getUserRole());
    }

    public UserRole getUserRoleInActivity(String activityId){

        if(isNotLogin()){
            return UserRole.VISITOR;
        }

        Preconditions.checkNotNull(activityId);
        RelaUserActivityDO relaUserActivityDO = relaUserActivityDAO.findByUserIdAndActivityId(getId(), activityId);

        if(relaUserActivityDO != null && !relaUserActivityDO.isValid()){
            return UserRole.VISITOR;
        }

        return relaUserActivityDO == null ? UserRole.VISITOR : UserRole.getUserRoleByCode(relaUserActivityDO.getUserRole());
    }

    public List<RelaUserTeamDO> getAllTeam(){
        List<RelaUserTeamDO> relaUserTeamDOList = relaUserTeamDAO.findAllTeamByUserId(getId());

        if(CollectionUtils.isEmpty(relaUserTeamDOList)){
            return Lists.newArrayList();
        }

        return relaUserTeamDOList;
    }

}
