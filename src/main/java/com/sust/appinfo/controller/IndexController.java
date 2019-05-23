package com.sust.appinfo.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@Controller
@RequestMapping(value = "/register", method = RequestMethod.GET)
public class IndexController {

    private static Logger logger = Logger.getLogger(IndexController.class);

    @RequestMapping("/")
    public String register(){
        logger.info("Start-------------->用户注册");
        return "register";
    }
}
