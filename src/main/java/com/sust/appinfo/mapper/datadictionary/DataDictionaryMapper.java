package com.sust.appinfo.mapper.datadictionary;

import java.util.List;

import com.sust.appinfo.pojo.DataDictionary;
import org.apache.ibatis.annotations.Param;

public interface DataDictionaryMapper {
	
	public List<DataDictionary> getDataDictionaryList(@Param("typeCode") String typeCode)throws Exception;
}
