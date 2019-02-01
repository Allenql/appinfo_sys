package com.sust.appinfo.service.developer;

import java.util.List;
import javax.annotation.Resource;

import com.sust.appinfo.mapper.appcategory.AppCategoryMapper;
import com.sust.appinfo.pojo.AppCategory;
import org.springframework.stereotype.Service;


@Service
public class AppCategoryServiceImpl implements AppCategoryService {

	@Resource
	private AppCategoryMapper mapper;
	
	@Override
	public List<AppCategory> getAppCategoryListByParentId(Integer parentId)
			throws Exception {
		return mapper.getAppCategoryListByParentId(parentId);
	}

	@Override
	public List<AppCategory> getAppCategoryList(String queryCategoryName, int currentPageNo, int pageSize) throws Exception {
		return mapper.getAppCategoryList(queryCategoryName,(currentPageNo - 1) * pageSize, pageSize);
	}

	@Override
	public int getAppCategoryCount(String queryCategoryName) {
		return mapper.getAppCategoryCount(queryCategoryName);
	}

	@Override
	public boolean addAppCategory(String categoryCode, String categoryName, Integer id) {
		if(mapper.addAppCategory(categoryCode,categoryName, id) >= 1){
			return true;
		}
		return false;
	}

	@Override
	public int deleteAppCategoryById(int id) {
		return mapper.deleteAppCategoryById(id);
	}

}
