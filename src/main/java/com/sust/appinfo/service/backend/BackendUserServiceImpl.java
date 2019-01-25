package com.sust.appinfo.service.backend;

import javax.annotation.Resource;

import com.sust.appinfo.mapper.backenduser.BackendUserMapper;
import com.sust.appinfo.pojo.BackendUser;
import org.springframework.stereotype.Service;



@Service
public class BackendUserServiceImpl implements BackendUserService {
	@Resource
	private BackendUserMapper mapper;
	
	@Override
	public BackendUser login(String userCode, String userPassword) throws Exception {
		// TODO Auto-generated method stub
		BackendUser user = null;
		user = mapper.getLoginUser(userCode);
		//匹配密码
		if(null != user){
			if(!user.getUserPassword().equals(userPassword))
				user = null;
		}
		return user;
	}

}
