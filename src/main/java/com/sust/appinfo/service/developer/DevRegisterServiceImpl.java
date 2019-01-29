package com.sust.appinfo.service.developer;

import com.sust.appinfo.mapper.devuser.DevUserMapper;
import com.sust.appinfo.pojo.DevUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DevRegisterServiceImpl implements DevRegisterService{
    @Autowired
    private DevUserMapper devUserMapper;
    @Override
    public boolean checkDevCode(String devCode) {
        int count = devUserMapper.checkDevCode(devCode);
        if(count >= 1){
            return false;
        }
        return true;
    }

    @Override
    public boolean addDevUser(DevUser devUser) {
        int count = devUserMapper.addDevUser(devUser);
        if(count >= 1){
            return true;
        }
        return false;
    }
}
