package com.sust.appinfo.service.backend;

import com.sust.appinfo.pojo.BackendUser;

public interface BackendUserRegisterService {
    /**
     * 验证userCode是否存在
     * @return
     */
    public boolean checkUserCode(String userCode);

    /**
     * User注册
     * @param backendUser
     * @return
     */
    public boolean addBackendUser(BackendUser backendUser);
}
