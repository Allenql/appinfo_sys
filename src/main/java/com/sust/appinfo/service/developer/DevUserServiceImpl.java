package com.sust.appinfo.service.developer;

import javax.annotation.Resource;

import com.sust.appinfo.mapper.devuser.DevUserMapper;
import com.sust.appinfo.pojo.DevUser;
import org.springframework.stereotype.Service;

import java.util.List;


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

	@Override
	public boolean checkPassword(int id, String password) {
		int i = mapper.checkPassword(id, password);
		if(i >= 1){
			return true;
		}
		return false;
	}

	@Override
	public boolean updatePassword(int id, String newDevPassword) {
		int i = mapper.updatePassword(id, newDevPassword);
		if(i >= 1){
			return true;
		}
		return false;
	}

	@Override
	public boolean resetPassword(String code,String email, String pwd) {
		int i = mapper.resetPassword(code,email,pwd);
		if(i >= 1){
			return true;
		}
		return false;
	}

	@Override
	public boolean doUpdateDevUser(int id, String devCode, String devName, String devEmail) {
		if(mapper.doUpdateDevUser(id,devCode,devName,devEmail) >= 1){
			return true;
		}
		return false;
	}

	@Override
	public DevUser selectById(int id) {
		return mapper.selectById(id);
	}

	@Override
	public List<DevUser> selectDevUserList() {
		return mapper.selectDevUserList();
	}

	@Override
	public int doUpdateInte(int id, int intelligence) {
		return mapper.doUpdateInte(id, intelligence);
	}

}
