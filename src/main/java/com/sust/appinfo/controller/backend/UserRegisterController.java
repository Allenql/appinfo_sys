package com.sust.appinfo.controller.backend;

import com.sust.appinfo.pojo.BackendUser;
import com.sust.appinfo.pojo.DevUser;
import com.sust.appinfo.service.backend.BackendUserRegisterService;
import com.sust.appinfo.tools.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.ServletException;
import java.io.IOException;

@Controller
@RequestMapping("/user/register")
public class UserRegisterController {
    @Autowired
    private BackendUserRegisterService backendUserRegisterService;

    @RequestMapping("/check")
    @ResponseBody
    public String check(@RequestParam String userCode){
        boolean res = false;
        if(null != userCode && !"".equals(userCode)){
            res = backendUserRegisterService.checkUserCode(userCode);
            if(res){
                return "可以使用";
            }
            return "该用户名已存在！";
        }
        return "请填写用户名！";
    }

    @RequestMapping("/doadd")
    public String addUser(BackendUser backendUser, RedirectAttributes ra) throws ServletException, IOException {
        String userPassword = backendUser.getUserPassword();
        //对密码进行加密处理
        String s = MD5.md5(userPassword);
        backendUser.setUserPassword(s);
        boolean res = backendUserRegisterService.addBackendUser(backendUser);
        if(res){ //注册成功
            ra.addFlashAttribute("msg","注册成功，可以登陆了");
//            request.getRequestDispatcher("/dev/login").forward(request,response);
            return "redirect:/manager/login";
        }
//        request.getRequestDispatcher("/register/").forward(request,response);
        return "/register"; //注册失败
    }

}
