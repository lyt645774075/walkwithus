package cn.walkwithus.web.controller;

import cn.walkwithus.core.domain.RequireBO;
import cn.walkwithus.core.domain.UserBO;
import cn.walkwithus.core.manager.RequireManager;
import cn.walkwithus.core.manager.UserManager;
import cn.walkwithus.security.login.LoginUserHolder;
import cn.walkwithus.support.constants.RedirectConstants;
import cn.walkwithus.web.transfer.UserTransfer;
import cn.walkwithus.web.vo.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author yangtao.lyt
 * @version $Id: WebHomeController, v 0.1 2015-10-12 00:11 yangtao.lyt Exp $
 */

@Controller
public class WebHomeController {

    private static final Logger logger = LoggerFactory.getLogger(WebHomeController.class);

    /** 网站首页 */
    private static final String WEB_HOME_VIEW = "screen/webhome";

    private static final String ABOUT_US_VIEW = "screen/aboutus";

    private static final String CONTACT_VIEW = "screen/contact";

    private static final String LOGIN_VIEW = "screen/login";

    private static final String REQUIRE_VIEW = "screen/require";

    private static final String REGISTER_VIEW = "screen/register";


    @Autowired
    private UserManager userManager;

    @Autowired
    private RequireManager requireManager;

    @Autowired
    private LoginUserHolder loginUserHolder;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String doGetHome(ModelMap modelMap){


        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        modelMap.addAttribute("authentication", authentication);

        return WEB_HOME_VIEW;
    }

    @RequestMapping(value = "/aboutus")
    public String doGetAboutUs(){
        return ABOUT_US_VIEW;
    }


    @RequestMapping(value = "/contact")
    public String doGetContact(){
        return CONTACT_VIEW;
    }

    @RequestMapping(value = "/login")
    public String doGetLogin(){
        return LOGIN_VIEW;
    }


    @RequestMapping(value = "/require")
    public String doGetRequire(ModelMap modelMap){

        List<RequireBO> requireBOList = requireManager.queryAll();

        modelMap.addAttribute("requireList", requireBOList);

        return REQUIRE_VIEW;
    }

    @RequestMapping(value = "/require", method = RequestMethod.POST, params = "action=create")
    public String doCreateRequire(@RequestParam("desc") String desc, ModelMap modelMap){

        if(StringUtils.isEmpty(desc)){
            modelMap.addAttribute("sysMsg", "需求描述不能为空");
            return REQUIRE_VIEW;
        }

        if(loginUserHolder.isNotLogin()){
            modelMap.addAttribute("desc", desc);
            modelMap.addAttribute("sysMsg", "您需要先登录,才能创建需求!");

            List<RequireBO> requireBOList = requireManager.queryAll();
            modelMap.addAttribute("requireList", requireBOList);

            return REQUIRE_VIEW;
        }

        RequireBO requireBO = new RequireBO();
        requireBO.setDesc(desc.trim());
        requireBO.setCreator(loginUserHolder.getEmail());
        requireBO.setCreatorNick(loginUserHolder.getNickName());

        requireManager.createRequire(requireBO);

        return "redirect:/require";
    }


    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String doGetRegister(){
        return REGISTER_VIEW;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String doPostRegister(UserVO userVO){

        UserBO userBO = UserTransfer.toBO(userVO);

        userManager.createUser(userBO);

        return RedirectConstants.R_WEB_LOGIN;
    }



}
