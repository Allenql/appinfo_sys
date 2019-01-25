package com.sust.appinfo.service.developer;

import javax.annotation.Resource;

import com.sust.appinfo.mapper.devuser.DevUserMapper;
import com.sust.appinfo.pojo.DevUser;
import org.springframework.stereotype.Service;



@Service
public class DevUserServiceImpl implements DevUserService {
	@Resource
	private DevUserMapper mapper;
	@Override
	public DevUser login(String devCode, String devPassword) throws Exception {
		// TODO Auto-generated method stub
		DevUser user = null;
		user = mapper.getLoginUser(devCode);
		//匹配密码
		if(null != user){
			if(!user.getDevPassword().equals(devPassword))
				user = null;
		}
		return user;
	}

}
