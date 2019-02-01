package com.sust.appinfo.controller.backend;

import com.sust.appinfo.pojo.AppCategory;
import com.sust.appinfo.pojo.DataDictionary;
import com.sust.appinfo.service.developer.AppCategoryService;
import com.sust.appinfo.tools.ChooseTypeCode;
import com.sust.appinfo.tools.Constants;
import com.sust.appinfo.tools.PageSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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


    /**
     * 跳转到新增页面
     * @return
     */
    @RequestMapping("/add")
    public String show(HttpServletRequest request) throws Exception {
//        System.out.println("----------------------add");
        return "backend/appcategoryadd";
    }

    /**
     * 跳转到新增页面
     * @return
     */
    @RequestMapping("/add/{id}")
    public String show(HttpServletRequest request,@PathVariable String id) throws Exception {
//        System.out.println("=====================add/rest");
        request.setAttribute("id",id);
        return "backend/appcategoryadd";
    }

    /**
     * 新增执行
     * @return
     */
    @RequestMapping("/appcategoryaddsave")
    public String doAdd(@RequestParam String categoryCode, @RequestParam String categoryName, @RequestParam(name = "id", required = false) String id) throws Exception{
//        System.out.println(id);
        Integer id1 = null;
        if (null == id || "".equals(id)){
            id1 = null;
        }else{
            id1 = Integer.parseInt(id);
        }
        System.out.println(id1 +"-------id1");
        boolean res = appCategoryService.addAppCategory(categoryCode, categoryName,id1);
        if (res){ //新增成功跳转到查询页面
            return "redirect:/manager/backend/appcategory/list";
        }
        return "backend/appcategoryadd";
    }


    @RequestMapping("/delete/{id}")
//    @ResponseBody
    public String deleteDataDicById(@PathVariable(name = "id") String id, HttpServletResponse response, RedirectAttributes redirectAttributes) throws IOException {
//        System.out.println(id);
        int res = 0;
        if(null != id && !"".equals(id)){
            res = appCategoryService.deleteAppCategoryById(Integer.parseInt(id));
        }
        if(res >= 1){
            //alert("删除成功")
            redirectAttributes.addAttribute("msg","删除成功！");
            return "redirect:/manager/backend/appcategory/list";
        }
        //alert("删除失败")
        redirectAttributes.addAttribute("msg","删除失败！");
        return "redirect:/manager/backend/appcategory/list";
    }

}
