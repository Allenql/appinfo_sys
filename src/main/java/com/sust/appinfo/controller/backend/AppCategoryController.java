package com.sust.appinfo.controller.backend;

import com.sust.appinfo.pojo.AppCategory;
import com.sust.appinfo.pojo.DataDictionary;
import com.sust.appinfo.service.developer.AppCategoryService;
import com.sust.appinfo.tools.Constants;
import com.sust.appinfo.tools.PageSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/manager/backend/appcategory")
public class AppCategoryController {

    @Autowired
    private AppCategoryService appCategoryService;

    @RequestMapping("/list")
    public String getAppCategoryList(Model model,
                                     @RequestParam(value="pageIndex",required=false) String pageIndex,
                                     @RequestParam(value="queryCategoryName",required = false)String queryCategoryName) throws Exception{
        List<AppCategory> appCategoryList = null;
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
        totalCount = appCategoryService.getAppCategoryCount(queryCategoryName);
//        System.out.println(totalCount);
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
            appCategoryList = appCategoryService.getAppCategoryList(queryCategoryName, currentPageNo, pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("appCategoryList", appCategoryList);
        model.addAttribute("pages", pages);
//        model.addAttribute("queryType",queryCategoryName);
        return "backend/appcategorylist";
    }
}
