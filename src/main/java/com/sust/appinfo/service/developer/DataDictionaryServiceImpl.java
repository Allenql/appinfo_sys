package com.sust.appinfo.service.developer;

import java.io.Reader;
import java.util.List;

import javax.annotation.Resource;

import com.sust.appinfo.mapper.datadictionary.DataDictionaryMapper;
import com.sust.appinfo.pojo.DataDictionary;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.mybatis.spring.SqlSessionFactoryBean;
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

	@Override
	public boolean addDataDic(String typeName, String valueName, int valueId, String typeCode) {
		if (mapper.addDataDic(typeName,valueName,valueId,typeCode) >= 1){
			return true;
		}
		return false;
	}

	@Override
	public int selectMaxValueIdByTypeName(String typeName) {
		return mapper.selectMaxValueIdByTypeName(typeName);
	}

	@Override
	public int deleteDataDicById(int id) {
		return mapper.deleteDataDicById(id);
	}

	@Override
	public boolean doUpdate(String valueName, String typeName, int id, int valueId,String typeCode) {
		int i = mapper.doUpdate(valueName, typeName, id, valueId, typeCode);
		if(i >= 1){
			return true;
		}
		return false;
	}

}
