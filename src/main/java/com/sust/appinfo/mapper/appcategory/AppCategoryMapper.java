package com.sust.appinfo.mapper.appcategory;

import java.util.List;

import com.sust.appinfo.pojo.AppCategory;
import org.apache.ibatis.annotations.Param;

public interface AppCategoryMapper {
	
	public List<AppCategory> getAppCategoryListByParentId(@Param("parentId") Integer parentId)throws Exception;

	public List<AppCategory> getAppCategoryList(String queryCategoryName,int currentPageNo,int pageSize) throws Exception;

	public int getAppCategoryCount(@Param("queryCategoryName") String queryCategoryName);

}
