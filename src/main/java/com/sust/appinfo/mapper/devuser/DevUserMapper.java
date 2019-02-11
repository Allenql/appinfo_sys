package com.sust.appinfo.mapper.devuser;

import com.sust.appinfo.pojo.DevUser;
import org.apache.ibatis.annotations.Param;
import org.python.antlr.ast.Str;

public interface DevUserMapper {
	/**
	 * 通过userCode获取User
	 * @param devCode
	 * @return
	 * @throws Exception
	 */
	public DevUser getLoginUser(@Param("devCode") String devCode)throws Exception;

	/**
	 * 验证devCode是否存在
	 * @param devCode
	 * @return
	 */
	public int checkDevCode(String devCode);

	/**
	 * devUser注册
	 * @param devUser
	 * @return
	 */
	public int addDevUser(DevUser devUser);


	public int checkPassword(int id, String password);

	public int updatePassword(@Param("id") int id, @Param("newDevPassword") String newDevPassword);

	public int doUpdateDevUser(@Param("id") int id, @Param("devCode") String devCode, @Param("devName") String devName, @Param("devEmail") String devEmail);

	public DevUser selectById(int id);
}
