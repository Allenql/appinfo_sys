package com.sust.appinfo.controller.backend;

import com.alibaba.fastjson.JSONArray;
import com.sust.appinfo.pojo.AppCategory;
import com.sust.appinfo.pojo.AppInfo;
import com.sust.appinfo.pojo.DataDictionary;
import com.sust.appinfo.service.developer.DataDictionaryService;
import com.sust.appinfo.tools.Constants;
import com.sust.appinfo.tools.PageSupport;
import org.apache.log4j.Logger;
import org.python.antlr.ast.Str;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 数据字典
 *      create-date:2019.1.30
 *      author:zql
 */
@Controller
@RequestMapping("/manager/backend/datadic")
public class DataDictionaryController {
    private Logger logger = Logger.getLogger(AppCheckController.class);
    @Resource
    private DataDictionaryService dataDictionaryService;

    @RequestMapping(value="/list")
    public String getDataDictionaryList(Model model,
                                        @RequestParam(value="pageIndex",required=false) String pageIndex,
                                        @RequestParam(value="queryValueName",required = false)String queryValueName,
                                        @RequestParam(value = "queryType",required = false)String queryType) throws Exception{

//        System.out.println(queryValueName + "===========" + queryType);
        List<DataDictionary> dataDicList = null;
        //页面容量
        int pageSize = Constants.pageSize;
        //当前页码
        Integer currentPageNo = 1;
        if(pageIndex != null){
            try{
                currentPageNo = Integer.valueOf(pageIndex);
            }catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        //总数量（表）
        int totalCount = 0;
        totalCount = dataDictionaryService.getDataDicCount(queryValueName,queryType);
        //总页数
        PageSupport pages = new PageSupport();
        pages.setCurrentPageNo(currentPageNo);
        pages.setPageSize(pageSize);
        pages.setTotalCount(totalCount);
        int totalPageCount = pages.getTotalPageCount();
        //控制首页和尾页
        if(currentPageNo < 1){
            currentPageNo = 1;
        }else if(currentPageNo > totalPageCount){
            currentPageNo = totalPageCount;
        }
        try {
            dataDicList = dataDictionaryService.getDataDictionaryLists(queryValueName,queryType,currentPageNo, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<String> typeNames = dataDictionaryService.getAllTypeName();
        model.addAttribute("typeNames",typeNames);
        model.addAttribute("dataDicList", dataDicList);
        model.addAttribute("pages", pages);
//        for (DataDictionary dd:flatFormList) {
//            System.out.println(dd.getValueName());
//        }
        return "backend/datadiclist";
    }
}
