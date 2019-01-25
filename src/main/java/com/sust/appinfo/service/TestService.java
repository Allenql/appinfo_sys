package com.sust.appinfo.service;

import com.sust.appinfo.mapper.TestMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TestService {
    @Resource
    private TestMapper testMapper;

    public int select(){
        return testMapper.select();
    }
}
