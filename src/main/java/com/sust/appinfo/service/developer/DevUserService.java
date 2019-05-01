package com.sust.appinfo.service.developer;


import com.sust.appinfo.pojo.DevUser;

import java.util.List;

public interface DevUserService {
	/**
	 * 用户登录
	 * @param devCode
	 * @param devPassword
	 * @return
	 */
	public DevUser login(String devCode, String devPassword) throws Exception;

	public boolean checkPassword(int id, String password);

	public boolean updatePassword(int id, String newDevPassword);

	public boolean doUpdateDevUser(int id,String devCode, String devName, String devEmail);

	public DevUser selectById(int id);

	public List<DevUser> selectDevUserList();
	public int doUpdateInte(int id, int intelligence);
}
