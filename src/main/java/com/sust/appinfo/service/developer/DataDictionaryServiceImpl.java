package com.sust.appinfo.service.developer;

import java.util.List;

import javax.annotation.Resource;

import com.sust.appinfo.mapper.datadictionary.DataDictionaryMapper;
import com.sust.appinfo.pojo.DataDictionary;
import org.springframework.stereotype.Service;



@Service
public class DataDictionaryServiceImpl implements DataDictionaryService {
	
	@Resource
	private DataDictionaryMapper mapper;
	
	@Override
	public List<DataDictionary> getDataDictionaryList(String typeCode)
			throws Exception {
		return mapper.getDataDictionaryList(typeCode);
	}

	@Override
	public List<DataDictionary> getDataDictionaryLists(String queryValueName, String queryType,int currentPageNo, int pageSize) throws Exception {
		return mapper.getDataDictionaryLists(queryValueName,queryType,(currentPageNo-1)*pageSize, pageSize);
	}

	@Override
	public int getDataDicCount(String queryValueName, String queryType) throws Exception {
		return mapper.getDataDicCount(queryValueName,queryType);
	}

	@Override
	public List<String> getAllTypeName() throws Exception {
		return mapper.getAllTypeName();
	}

}
