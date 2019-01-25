package com.sust.appinfo.service.developer;

import com.sust.appinfo.pojo.AppVersion;

import java.util.List;

public interface AppVersionService {
	/**
	 * 根据appId查询相应的app版本列表
	 * @param appId
	 * @return
	 * @throws Exception
	 */
	public List<AppVersion> getAppVersionList(Integer appId)throws Exception;
	/**
	 * 新增app版本信息，并更新app_info表的versionId字段
	 * @param appVersion
	 * @return
	 * @throws Exception
	 */
	public boolean appsysadd(AppVersion appVersion)throws Exception;
	/**
	 * 根据id获取AppVersion
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public AppVersion getAppVersionById(Integer id)throws Exception;
	
	/**
	 * 修改app版本信息
	 * @param appVersion
	 * @return
	 * @throws Exception
	 */
	public boolean modify(AppVersion appVersion)throws Exception;
	
	/**
	 * 删除apk文件
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public boolean deleteApkFile(Integer id)throws Exception;
}
