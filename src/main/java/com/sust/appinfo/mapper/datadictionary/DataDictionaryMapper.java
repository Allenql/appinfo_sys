package com.sust.appinfo.mapper.datadictionary;

import java.util.List;

import com.sust.appinfo.pojo.DataDictionary;
import org.apache.ibatis.annotations.Param;

public interface DataDictionaryMapper {

	public List<DataDictionary> getDataDictionaryList(@Param("typeCode") String typeCode) throws Exception;

	public List<DataDictionary> getDataDictionaryLists(String queryValueName, String queryType, int currentPageNo, int pageSize) throws Exception;

	public int getDataDicCount(@Param("queryValueName") String queryValueName, @Param("queryType") String queryType) throws Exception;

	public List<String> getAllTypeName() throws Exception;

	public int addDataDic(@Param("typeName") String typeName,@Param("valueName") String valueName,@Param("valueId") int valueId, @Param("typeCode") String typeCode);

	public int selectMaxValueIdByTypeName(@Param("typeName") String typeName);

	public int deleteDataDicById(int id);

	public int doUpdate(String valueName, String typeName, int id, int valueId,String typeCode);
}