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
		// TODO Auto-generated method stub
		return mapper.getDataDictionaryList(typeCode);
	}

}
