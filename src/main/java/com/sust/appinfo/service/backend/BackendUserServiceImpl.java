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
		BackendUser user = null;
		user = mapper.getLoginUser(userCode);
		//匹配密码
		if(null != user){
			if(!user.getUserPassword().equals(userPassword))
				user = null;
		}
		return user;
	}

	@Override
	public boolean checkPassword(int id, String password) {
		int i = mapper.checkPassword(id, password);
		if(i >= 1){
			return true;
		}
		return false;
	}

	@Override
	public boolean updatePassword(int id, String newUserPassword) {
		int i = mapper.updatePassword(id, newUserPassword);
		if(i >= 1){
			return true;
		}
		return false;
	}

	@Override
	public boolean doUpdateUser(int id, String userCode, String userName) {
		if(mapper.doUpdateUser(id,userCode,userName) >= 1){
			return true;
		}
		return false;
	}

	@Override
	public BackendUser selectById(int id) {
		return mapper.selectById(id);
	}

}
