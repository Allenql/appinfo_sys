package com.sust.appinfo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(){
//        return "app信息管理平台";
        return "index";
    }
}
