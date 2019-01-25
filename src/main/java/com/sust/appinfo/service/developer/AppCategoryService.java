package com.sust.appinfo.service.developer;

import com.sust.appinfo.pojo.AppCategory;

import java.util.List;

public interface AppCategoryService {
	/**
	 * 根据父节点parentId获取相应的分类列表
	 * @param parentId
	 * @return
	 * @throws Exception
	 */
	public List<AppCategory> getAppCategoryListByParentId(Integer parentId)throws Exception;
}
