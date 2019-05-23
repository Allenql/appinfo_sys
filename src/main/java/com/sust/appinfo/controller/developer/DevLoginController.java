package com.sust.appinfo.controller.developer;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sust.appinfo.pojo.DevUser;
import com.sust.appinfo.service.developer.DevUserService;
import com.sust.appinfo.tools.Constants;
import com.sust.appinfo.tools.MD5;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping(value = "/dev")
public class DevLoginController {
    private Logger logger = Logger.getLogger(DevLoginController.class);

    @Resource
    private DevUserService devUserService;

    @RequestMapping(value = "/login")
    public String login() {
        logger.debug("==================LoginController welcome AppInfoSystem develpor==================");
        return "devlogin";
    }

    @RequestMapping(value = "/dologin", method = RequestMethod.POST)
    public String doLogin(@RequestParam String devCode, @RequestParam String devPassword, HttpServletRequest request, HttpSession session) {
        logger.info("Start-------------->App开发者登录");
        logger.info("devCode:" + devCode + ",password:" + devPassword);
        //调用service方法，进行用户匹配
        DevUser user = null;
        try {
            //加密处理
            String dpwd = MD5.md5(devPassword);
            user = devUserService.login(devCode, dpwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (null != user) {//登录成功
            if (user.getIntelligence() == 2) {
                //放入session
                session.setAttribute(Constants.DEV_USER_SESSION, user);
                //页面跳转（main.jsp）
                logger.info("End-------------->App开发者登录成功");
                return "redirect:/dev/flatform/main";
            }
            if (user.getIntelligence() == 3) {
                request.setAttribute("error", "资质审核未通过");
                logger.info("资质审核未通过");
                return "devlogin";
            }
            request.setAttribute("error", "资质审核中...");
            logger.info("资质审核中...");
            return "devlogin";
        } else {
            //页面跳转（login.jsp）带出提示信息--转发
            request.setAttribute("error", "用户名或密码不正确&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href='' style='color:red' data-toggle='modal' data-target='#myModal'>忘记密码？</a>");
            logger.info("用户名或密码不正确");
            return "devlogin";
        }
    }

    @RequestMapping(value = "/flatform/main")
    public String main(HttpSession session) {
        if (session.getAttribute(Constants.DEV_USER_SESSION) == null) {
            return "redirect:/dev/login";
        }
        return "developer/main";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
        //清除session
        session.removeAttribute(Constants.DEV_USER_SESSION);
        return "devlogin";
    }
}

