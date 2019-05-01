package com.sust.appinfo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Controller
@RequestMapping(value = "/dev", method = RequestMethod.GET)
public class IndexController {

    @RequestMapping("/person")
    public String register(){
        return "{\n" +
                "\t\"nodes\": [\n" +
                "\t  {\n" +
                "\t\t\"id\": \"a\"\n" +
                "\t  },\n" +
                "\t  {\n" +
                "\t\t\"id\": \"b\"\n" +
                "\t  },\n" +
                "\t  {\n" +
                "\t\t\"id\": \"c\"\n" +
                "\t  }\n" +
                "\t],\n" +
                "\t\"links\": [\n" +
                "\t  {\n" +
                "\t\t\"source\":\"a\",\n" +
                "\t\t\"target\": \"b\",\n" +
                "\t\t\"relation\":\"关系1\"\n" +
                "\t  },\n" +
                "\t  {\n" +
                "\t\t\"source\":\"c\",\n" +
                "\t\t\"target\": \"b\",\n" +
                "\t\t\"relation\":\"关系2\"\n" +
                "\t  },\n" +
                "\t  {\n" +
                "\t\t\"source\":\"a\",\n" +
                "\t\t\"target\": \"c\",\n" +
                "\t\t\"relation\":\"关系3\"\n" +
                "\t  }\n" +
                "\t]\n" +
                "  }";
        //return "register";
    }
}
