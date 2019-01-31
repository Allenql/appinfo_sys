package com.sust.appinfo.service.developer;

import com.sust.appinfo.pojo.DataDictionary;
import org.python.antlr.ast.Str;

import java.util.List;


public interface DataDictionaryService {

    /**
     * 根据typeCode查询相应的数据字典列表
     *
     * @param typeCode
     * @return
     * @throws Exception
     */
    public List<DataDictionary> getDataDictionaryList(String typeCode) throws Exception;

    /**
     * 查询数据字典列表
     *
     * @param
     * @return
     * @throws Exception
     */
    public List<DataDictionary> getDataDictionaryLists(String queryValueName, String queryType, int currentPageNo, int pageSize) throws Exception;

    public int getDataDicCount(String queryValueName, String queryType) throws Exception;

    public List<String> getAllTypeName() throws Exception;

    /**
     * 新增数据字典信息
     * @param typeName
     * @param valueName
     * @return
     */
    public boolean addDataDic(String typeName, String valueName, int valueId, String typeCode);

    public int selectMaxValueIdByTypeName(String typeName);

    /**
     * 通过id删除数据字典信息
     * @param id
     * @return
     */
    public int deleteDataDicById(int id);

    public boolean doUpdate(String valueName, String typeName, int id, int ValueId,String typeCode);
}
