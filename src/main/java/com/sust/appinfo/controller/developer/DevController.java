package com.sust.appinfo.controller.developer;

import com.sust.appinfo.pojo.DevUser;
import com.sust.appinfo.service.developer.DevUserService;
import com.sust.appinfo.tools.Constants;
import com.sust.appinfo.tools.MD5;
import jnr.ffi.annotations.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
@RequestMapping("/dev/info")
public class DevController {
    @Autowired
    private DevUserService devUserService;

    @RequestMapping("/show")
    public String showInfo(){
        return "developer/devinfo";
    }

    @RequestMapping("/updatepwd")
    public String updatePassword(@RequestParam(name = "id", required = false) String id, @RequestParam(name = "newDevPassword", required = false) String newDevPassword){
        String pwd = MD5.md5(newDevPassword);
        boolean res = devUserService.updatePassword(Integer.parseInt(id), pwd);
        if(res){
            return "redirect:/dev/login";
        }
        return "redirect:/dev/info/show";
    }

    @RequestMapping("/checkpwd")
    @ResponseBody
    public String checkPassword(@RequestParam(name = "id", required = false) String id, @RequestParam(name = "devPassword", required = false) String devPassword){
//        System.out.println(id + "===" + devPassword);
        if(id != null && null != devPassword){
            String pwd = MD5.md5(devPassword);
            boolean res = devUserService.checkPassword(Integer.parseInt(id), pwd);
            if(res){
                return "<span id='mmm' style='color:green'>旧密码正确<span>";
            }
        }
        return "<span id='mmm' style='color:red'>旧密码错误<span>";
    }

    @RequestMapping("/update")
    public String updateDevUser(){
        return "developer/devupdate";
    }

    @RequestMapping("/doupdate")
    public String doUpdateDevUser(@RequestParam(name = "id", required = false) String id,
                                  @RequestParam(name = "devCode", required = false) String devCode,
                                  @RequestParam(name = "devName", required = false) String devName,
                                  @RequestParam(name = "devEmail", required = false) String devEmail,
                                  HttpSession session) throws IOException {

        boolean res = devUserService.doUpdateDevUser(Integer.parseInt(id), devCode, devName, devEmail);
        if(res){
            DevUser user = devUserService.selectById(Integer.parseInt(id));
            session.setAttribute(Constants.DEV_USER_SESSION, user);
            return "developer/devinfo";
        }
        return "developer/devupdate";
    }

    @RequestMapping("/doupdateinte")
    public String doUpdateInte(@RequestParam String id, @RequestParam String intelligence){
        int res = devUserService.doUpdateInte(Integer.parseInt(id), Integer.parseInt(intelligence));
        if (res >= 1){
            return "redirect:/user/info/devusercheck";
        }
        return "redirect:/user/info/devuserchec";
    }
}
