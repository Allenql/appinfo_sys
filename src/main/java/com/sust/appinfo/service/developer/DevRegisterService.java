package com.sust.appinfo.service.developer;

import com.sust.appinfo.pojo.DevUser;

public interface DevRegisterService {
    /**
     * 验证devCode是否存在
     * @return
     */
    public boolean checkDevCode(String devCode);

    /**
     * devUser注册
     * @param devUser
     * @return
     */
    public boolean addDevUser(DevUser devUser);
}
