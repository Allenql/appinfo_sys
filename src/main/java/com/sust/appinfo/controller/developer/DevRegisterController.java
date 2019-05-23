package com.sust.appinfo.controller.developer;

import com.sust.appinfo.tools.MD5;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import com.sust.appinfo.pojo.DevUser;
import com.sust.appinfo.service.developer.DevRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("/dev/register")
public class DevRegisterController {

    private static Logger logger = Logger.getLogger(DevRegisterController.class);

    @Autowired
    private DevRegisterService devRegisterService;

    @RequestMapping("/check")
    @ResponseBody
    public String check(@RequestParam String devCode){
//        System.out.println("ddec"+devCode+"---");
//        System.out.println(devCode);
        boolean res = false;
        if(null != devCode && !"".equals(devCode)){
            res = devRegisterService.checkDevCode(devCode);
            if(res){
                return "可以使用";
            }
            return "该用户名已存在！";
        }
        return "请填写用户名！";
    }

    @RequestMapping("/doadd")
    public String addUser(DevUser devUser, RedirectAttributes ra) throws ServletException, IOException {
        logger.info("Start-------------->APP开发者注册");
        logger.info("DevUser:" + devUser.toString());
        String devPassword = devUser.getDevPassword();
        //对密码进行加密处理
        String s = MD5.md5(devPassword);
        logger.info("密码加密完成");
        devUser.setDevPassword(s);
        boolean res = devRegisterService.addDevUser(devUser);
        if(res){ //注册成功
            ra.addFlashAttribute("msg","注册成功，审核通过之后就可以登陆了");
//            request.getRequestDispatcher("/dev/login").forward(request,response);
            logger.info("End-------------->APP开发者注册成功");
            return "redirect:/dev/login";
        }
//        request.getRequestDispatcher("/register/").forward(request,response);
        return "/register"; //注册失败
    }

}
