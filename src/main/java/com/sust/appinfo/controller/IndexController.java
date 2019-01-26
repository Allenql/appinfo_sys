package com.sust.appinfo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
@RequestMapping(value = "/register", method = RequestMethod.GET)
public class IndexController {

    @RequestMapping("/")
    public String register(){
//        return "app信息管理平台";
        return "register";
    }
}
