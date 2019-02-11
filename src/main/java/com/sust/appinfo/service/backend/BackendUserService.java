package com.sust.appinfo.service.backend;

import com.sust.appinfo.pojo.BackendUser;

public interface BackendUserService {
	/**
	 * 用户登录
	 * @param userCode
	 * @param userPassword
	 * @return
	 */
	public BackendUser login(String userCode, String userPassword) throws Exception;

	public boolean checkPassword(int id, String password);

	public boolean updatePassword(int id, String newUserPassword);

	public boolean doUpdateUser(int id,String devCode, String devName);

	public BackendUser selectById(int id);


}
