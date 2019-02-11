package com.sust.appinfo.controller.backend;

import com.sust.appinfo.pojo.BackendUser;
import com.sust.appinfo.pojo.DevUser;
import com.sust.appinfo.service.backend.BackendUserService;
import com.sust.appinfo.tools.Constants;
import com.sust.appinfo.tools.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
@RequestMapping("/user/info")
public class UserController {

    @Autowired
    private BackendUserService backendUserService;
    @RequestMapping("/show")
    public String showInfo(){
        return "backend/userinfo";
    }

    @RequestMapping("/updatepwd")
    public String updatePassword(@RequestParam(name = "id", required = false) String id, @RequestParam(name = "newUserPassword", required = false) String newUserPassword){
        String pwd = MD5.md5(newUserPassword);
        boolean res = backendUserService.updatePassword(Integer.parseInt(id), pwd);
        if(res){
            return "redirect:/manager/login";
        }
        return "redirect:/user/info/show";
    }

    @RequestMapping("/checkpwd")
    @ResponseBody
    public String checkPassword(@RequestParam(name = "id", required = false) String id, @RequestParam(name = "userPassword", required = false) String userPassword){
//        System.out.println("-pwd-----------" + userPassword);
        if(id != null && null != userPassword){
            String pwd = MD5.md5(userPassword);
            boolean res = backendUserService.checkPassword(Integer.parseInt(id), pwd);
            if(res){
                return "<span id='mmm' style='color:green'>旧密码正确<span>";
            }
        }
        return "<span id='mmm' style='color:red'>旧密码错误<span>";
    }

    @RequestMapping("/update")
    public String updateDevUser(){
        return "backend/userupdate";
    }

    @RequestMapping("/doupdate")
    public String doUpdateDevUser(@RequestParam(name = "id", required = false) String id,
                                  @RequestParam(name = "userCode", required = false) String userCode,
                                  @RequestParam(name = "userName", required = false) String userName,
                                  HttpSession session) throws IOException {

        boolean res = backendUserService.doUpdateUser(Integer.parseInt(id), userCode, userName);
        if(res){
            BackendUser user = backendUserService.selectById(Integer.parseInt(id));
            session.setAttribute(Constants.USER_SESSION, user);
            return "backend/userinfo";
        }
        return "backend/userupdate";
    }
}
