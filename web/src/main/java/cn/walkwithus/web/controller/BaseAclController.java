package cn.walkwithus.web.controller;


import cn.walkwithus.core.domain.AccountInfoBO;
import cn.walkwithus.core.domain.RelaUserActivityBO;
import cn.walkwithus.core.domain.RelaUserTeamBO;
import cn.walkwithus.core.manager.AccountInfoManager;
import cn.walkwithus.core.manager.ActivityManager;
import cn.walkwithus.core.manager.RelaUserActivityManager;
import cn.walkwithus.core.manager.RelaUserTeamManager;
import cn.walkwithus.core.manager.TeamManager;
import cn.walkwithus.security.login.LoginUserHolder;
import cn.walkwithus.support.constants.RedirectConstants;
import cn.walkwithus.web.form.AccountInfoForm;
import cn.walkwithus.web.transfer.AccountInfoTransfer;
import cn.walkwithus.web.vo.AccountInfoVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author yangtao.lyt
 * @version $Id: BaseAclController, v 0.1 2016-01-17 00:30 yangtao.lyt Exp $
 */
@RequestMapping("/acl")
@Controller
public class BaseAclController {

    private static final Logger logger = LoggerFactory.getLogger(BaseAclController.class);

    /**
     * 活动账务情况
     */
    private static final String ACCOUNT_INFO_VIEW = "screen/acl/activity/accountinfo";
    /**
     * 团队账务情况
     */
    private static final String TEAM_INFO_VIEW = "screen/acl/team/accountinfo";
    /**
     * 团队成员管理
     */
    private static final String TEAM_MEMBER_VIEW = "screen/acl/team/member";
    /**
     * 活动成员管理
     */
    private static final String ACTIVITY_MEMBER_VIEW = "screen/acl/activity/member";


    @Autowired
    private LoginUserHolder loginUserHolder;

    @Autowired
    private AccountInfoManager accountInfoManager;

    @Autowired
    private TeamManager teamManager;

    @Autowired
    private ActivityManager activityManager;

    @Autowired
    private RelaUserTeamManager relaUserTeamManager;

    @Autowired
    private RelaUserActivityManager relaUserActivityManager;

    @RequestMapping(value = "/activity/accountinfo", method = RequestMethod.GET)
    public String doGetActivityAccountInfo(@RequestParam("id") String id, ModelMap modelMap) {

        if (StringUtils.isEmpty(id)) {
            return RedirectConstants.R_WEB_HOME;
        }

        if (loginUserHolder.isActivityVisitor(id)) {
            modelMap.addAttribute("sysmsg", "你还不是该活动的成员,不能查看该活动的财务信息");

            return ACCOUNT_INFO_VIEW;
        }

        List<AccountInfoBO> accountInfoBOList = accountInfoManager.queryActivityAccountInfo(id);

        List<AccountInfoVO> accountInfoVOList = AccountInfoTransfer.toVOList(accountInfoBOList);

        modelMap.addAttribute("accountInfoList", accountInfoVOList);

        return ACCOUNT_INFO_VIEW;
    }

    @RequestMapping(value = "/activity/accountinfo", method = RequestMethod.POST, params = "action=pass")
    public String doPostPassActivityAccountInfo(@RequestParam String accountInfoId, @RequestParam String id){

        accountInfoManager.passAccountInfo(accountInfoId);

        return RedirectConstants.R_ACTIVITY_ACCOUNTINFO_PRE + id;
    }

    @RequestMapping(value = "/activity/accountinfo", method = RequestMethod.POST, params = "action=reject")
    public String doPostRejectActivityAccountInfo(@RequestParam String accountInfoId, @RequestParam String id){

        accountInfoManager.unPassAccountInfo(accountInfoId);

        return RedirectConstants.R_ACTIVITY_ACCOUNTINFO_PRE + id;
    }


    @RequestMapping(value = "/team/accountinfo", method = RequestMethod.GET)
    public String doGetTeamAccountInfo() {
        return TEAM_INFO_VIEW;
    }


    @RequestMapping(value = "/team/member", method = RequestMethod.GET)
    public String doGetTeamMember(@RequestParam("teamId") String teamId, ModelMap modelMap) {

        List<RelaUserTeamBO> allRelaUser = relaUserTeamManager.queryAllUserByTeamId(teamId);

        Collections.sort(allRelaUser, new Comparator<RelaUserTeamBO>() {
            @Override
            public int compare(RelaUserTeamBO a, RelaUserTeamBO b) {
                Integer aOrder = a.getUserRole().getOrder();
                Integer bOrder = b.getUserRole().getOrder();

                return aOrder - bOrder;
            }
        });


        modelMap.addAttribute("allRelaUser", allRelaUser);
        modelMap.addAttribute("teamId", teamId);

        return TEAM_MEMBER_VIEW;
    }

    @RequestMapping(value = "/activity/member", method = RequestMethod.GET)
    public String doGetActivityMember(@RequestParam String activityId, ModelMap modelMap) {
        List<RelaUserActivityBO> allRelaUser = relaUserActivityManager.queryAllUserByActivityId(activityId);

        Collections.sort(allRelaUser, new Comparator<RelaUserActivityBO>() {
            @Override
            public int compare(RelaUserActivityBO a, RelaUserActivityBO b) {
                Integer aOrder = a.getUserRole().getOrder();
                Integer bOrder = b.getUserRole().getOrder();

                return aOrder - bOrder;
            }
        });


        modelMap.addAttribute("allRelaUser", allRelaUser);
        modelMap.addAttribute("activityId", activityId);
        return ACTIVITY_MEMBER_VIEW;
    }

    @RequestMapping(value = "/activity/accountinfo", method = RequestMethod.POST, params = "action=add")
    public String addActivityAccountInfo(@RequestParam("id") String id, AccountInfoForm accountInfoForm, ModelMap modelMap) {

        AccountInfoBO accountInfoBO = AccountInfoTransfer.toBO(accountInfoForm);
        accountInfoBO.setDomainId(id);

        accountInfoBO = accountInfoManager.addActivityAccountInfo(accountInfoBO);

        return RedirectConstants.R_ACTIVITY_ACCOUNTINFO_PRE + id;
    }


    @RequestMapping(value = "/activity/applyjoin", method = RequestMethod.POST)
    public String postApplyJoinActivity(@RequestParam String activityId) {

        if (StringUtils.isEmpty(activityId)) {
            return RedirectConstants.R_WEB_HOME;
        }

        if (!activityManager.isExist(activityId)) {
            return RedirectConstants.R_WEB_HOME;
        }

        relaUserActivityManager.applyJoinActivity(activityId);

        return RedirectConstants.R_ACTIVITY_HOME_PRE + activityId;
    }

    @RequestMapping(value = "/activity/member", method = RequestMethod.POST, params = "action=passMember")
    public String doPostPassJoinInActivity(@RequestParam String activityId, @RequestParam String userId) {

        relaUserActivityManager.passUserJoinActivity(userId, activityId);

        return RedirectConstants.R_ACTIVITY_MEMBER_PRE + activityId;
    }

    @RequestMapping(value = "/activity/member", method = RequestMethod.POST, params = "action=removeUser")
    public String doPostRemoveActivityUser(@RequestParam String activityId, @RequestParam String userId) {

        relaUserActivityManager.removeUser(userId, activityId);

        return RedirectConstants.R_ACTIVITY_MEMBER_PRE + activityId;
    }

    @RequestMapping(value = "/team/applyjoin", method = RequestMethod.POST)
    public String postApplyJoinTeam(@RequestParam("teamId") String teamId) {

        if (StringUtils.isEmpty(teamId)) {
            return RedirectConstants.R_WEB_HOME;
        }

        if (!teamManager.isExist(teamId)) {
            return RedirectConstants.R_WEB_HOME;
        }

        relaUserTeamManager.applyJoinTeam(teamId);

        return RedirectConstants.R_TEAM_HOME_PRE + teamId;
    }


    @RequestMapping(value = "/team/member", method = RequestMethod.POST, params = "action=passMember")
    public String doPostPassJoinInTeam(@RequestParam String teamId, @RequestParam String userId) {

        relaUserTeamManager.passUserJoinTeam(userId, teamId);

        return RedirectConstants.R_TEAM_MEMBER_PRE + teamId;
    }

    @RequestMapping(value = "/team/member", method = RequestMethod.POST, params = "action=setAdmin")
    public String doPostSetTeamAdmin(@RequestParam String teamId, @RequestParam String userId) {

        relaUserTeamManager.setTeamAdmin(userId, teamId);

        return RedirectConstants.R_TEAM_MEMBER_PRE + teamId;
    }

    @RequestMapping(value = "/team/member", method = RequestMethod.POST, params = "action=cancelAdmin")
    public String doPostCancelTeamAdmin(@RequestParam String teamId, @RequestParam String userId) {

        relaUserTeamManager.cancelTeamAdmin(userId, teamId);

        return RedirectConstants.R_TEAM_MEMBER_PRE + teamId;
    }

    @RequestMapping(value = "/team/member", method = RequestMethod.POST, params = "action=removeUser")
    public String doPostRemoveTeamUser(@RequestParam String teamId, @RequestParam String userId) {

        relaUserTeamManager.removeUser(userId, teamId);

        return RedirectConstants.R_TEAM_MEMBER_PRE + teamId;
    }

}
