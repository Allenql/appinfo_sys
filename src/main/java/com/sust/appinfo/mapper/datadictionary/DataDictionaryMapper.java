package com.sust.appinfo.mapper.datadictionary;

import java.util.List;

import com.sust.appinfo.pojo.DataDictionary;
import org.apache.ibatis.annotations.Param;

public interface DataDictionaryMapper {
	
	public List<DataDictionary> getDataDictionaryList(@Param("typeCode") String typeCode)throws Exception;

	public List<DataDictionary> getDataDictionaryLists(String queryValueName, String queryType,int currentPageNo, int pageSize)throws Exception;

	public int getDataDicCount(@Param("queryValueName") String queryValueName, @Param("queryType")String queryType) throws Exception;

	public List<String> getAllTypeName() throws Exception;
}
