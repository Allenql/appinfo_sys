package com.sust.appinfo.controller.backend;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sust.appinfo.pojo.BackendUser;
import com.sust.appinfo.service.backend.BackendUserService;
import com.sust.appinfo.tools.Constants;
import com.sust.appinfo.tools.MD5;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value = "/manager")
public class UserLoginController {
    private Logger logger = Logger.getLogger(UserLoginController.class);

    @Resource
    private BackendUserService backendUserService;

    @RequestMapping(value = "/login")
    public String login() {
        logger.info("==================LoginController welcome AppInfoSystem backend==================");
        return "backendlogin";
    }

    @RequestMapping(value = "/dologin", method = RequestMethod.POST)
//    @ResponseBody
//    @CrossOrigin(origins = "*",maxAge = 3600)
    public String doLogin(@RequestParam String userCode, @RequestParam String userPassword, HttpServletRequest request, HttpSession session) {
//    public String doLogin(@RequestParam String username, @RequestParam String password, HttpServletRequest request, HttpSession session) {
        logger.info("Start-------------->后台管理员登录");
        logger.info("userCode:" + userCode + ",password:" + userPassword);
//        logger.info("userCode:" + username + ",password:" + password);

        //调用service方法，进行用户匹配
        BackendUser user = null;
        try {
            //对密码进行加密
            String upwd = MD5.md5(userPassword);
            user = backendUserService.login(userCode, upwd);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (null != user) {//登录成功
            //判断是否已经登录
            if (user.getStatus() == 1) {
                //放入session
                session.setAttribute(Constants.USER_SESSION, user);
                backendUserService.updateStatus(2, user.getId());
                //页面跳转（main.jsp）
                logger.info("End-------------->后台管理员登录成功");
                return "redirect:/manager/backend/main";
            }
            //页面跳转（login.jsp）带出提示信息--转发
            request.setAttribute("error", "该用户已登录！");
            logger.info("该用户已登录");
            return "backendlogin";
//            return "{'username':'test','password':'test'}";
        } else {
            //页面跳转（login.jsp）带出提示信息--转发
            request.setAttribute("error", "用户名或密码不正确！");
            logger.info("用户名或密码不正确");
            return "backendlogin";
        }
    }

    @RequestMapping(value = "/backend/main")
    public String main(HttpSession session) {
        if (session.getAttribute(Constants.USER_SESSION) == null) {
            return "redirect:/manager/login";
        }
        return "backend/main";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
        BackendUser user = (BackendUser) session.getAttribute(Constants.USER_SESSION);
        backendUserService.updateStatus(1, user.getId());
//        System.out.println(user.getId());
        //清除session
        session.removeAttribute(Constants.USER_SESSION);
        return "backendlogin";
    }
}
