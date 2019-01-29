package com.sust.appinfo.service.backend;

import com.sust.appinfo.mapper.backenduser.BackendUserMapper;
import com.sust.appinfo.pojo.BackendUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class backendUserRegisterServiceImpl implements BackendUserRegisterService {

    @Autowired
    private BackendUserMapper backendUserMapper;
    @Override
    public boolean checkUserCode(String userCode) {
        int count = backendUserMapper.checkUserCode(userCode);
        if (count >= 1) {
            return false;
        }
        return true;
    }

    @Override
    public boolean addBackendUser(BackendUser backendUser) {
        int count = backendUserMapper.addBackendUser(backendUser);
        if (count >= 1) {
            return true;
        }
        return false;
    }
}
