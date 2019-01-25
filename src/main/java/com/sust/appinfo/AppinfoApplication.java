package com.sust.appinfo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.sust.appinfo.mapper")
@SpringBootApplication
public class AppinfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppinfoApplication.class, args);
    }

}

