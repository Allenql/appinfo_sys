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
}
