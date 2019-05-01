package com.sust.appinfo.mapper.backenduser;
import com.sust.appinfo.pojo.BackendUser;
import org.apache.ibatis.annotations.Param;

public interface BackendUserMapper {

	/**
	 * 通过userCode获取User
	 * @param userCode
	 * @return
	 * @throws Exception
	 */
	public BackendUser getLoginUser(@Param("userCode") String userCode)throws Exception;

	/**
	 * 验证userCode是否存在
	 * @param userCode
	 * @return
	 */
	public int checkUserCode(String userCode);

	/**
	 * User注册
	 * @param backendUser
	 * @return
	 */
	public int addBackendUser(BackendUser backendUser);

	public int checkPassword(int id, String password);

	public int updatePassword(@Param("id") int id, @Param("newUserPassword") String newUserPassword);

	public int doUpdateUser(@Param("id") int id, @Param("userCode") String userCode, @Param("userName") String userName);

	public BackendUser selectById(int id);

	public int updateStatus(int status, int id);

}
