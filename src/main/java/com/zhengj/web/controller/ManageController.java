package com.zhengj.web.controller;

import com.zhengj.model.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/manage")
public class ManageController extends AbstractController{

    ///////////////////////////////////////////////////////////////////////////////////////////////
    // attachment
    ///////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/attachment")
    public ModelAndView attachmentList(@RequestParam(value = "page", defaultValue = "1") int pageIndex) {
        Map<String, Object> pages = new HashMap<String, Object>() {
            {
                put("page", pageIndex);
            }
        };
        LOGGER.info("进入attachment");
        return prepareModelAndView("manage/attachment/attachment_list.html",pages);
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////
    // article and categories
    ///////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/article/category_list")
    public ModelAndView articleCategoryList() {
        List<Category> categories = articleService. getCategories();
        LOGGER.info("categories是{}",categories.size());
        Map<String, Object> categoriesList = new HashMap<String, Object>() {
            {
                put("categories", categories);
            }
        };
        return prepareModelAndView("manage/article/category_list.html", categoriesList);
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////
    // utility
    ///////////////////////////////////////////////////////////////////////////////////////////////

    private ModelAndView prepareModelAndView(String view, Map<String, Object> model) {
        ModelAndView mv = new ModelAndView(view, model);
        // appendGlobalModelAndView(mv);
        return mv;
    }
}
