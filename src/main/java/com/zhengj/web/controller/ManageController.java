package com.zhengj.web.controller;

import com.zhengj.model.Category;
import com.zhengj.web.view.i18n.Translator;
import com.zhengj.web.view.i18n.Translators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Controller
@RequestMapping("/manage")
public class ManageController extends AbstractController {

    @Value("${server.servlet.context-path}")
    private String server;

    @Autowired
    private Translators translators;

    @Autowired
    LocaleResolver localeResolver;

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
        return prepareModelAndView("manage/attachment/attachment_list.html", pages);
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////
    // article and categories
    ///////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/article/category_list")
    public ModelAndView articleCategoryList() {
        List<Category> categories = articleService.getCategories();
        LOGGER.info("categories是{}", categories.size());
        Map<String, Object> categoriesList = new HashMap<String, Object>() {
            {
                put("categories", categories);
            }
        };
        return prepareModelAndView("manage/article/category_list.html", categoriesList);
    }

    @GetMapping("/article/category_create")
    public ModelAndView articleCategoryCreate() {
        Map<String, Object> maps = new HashMap<String, Object>() {
            {
                put("id", 0);
                put("action", server + "/api/categories");
            }
        };
        return prepareModelAndView("manage/article/category_form.html", maps);
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////
    // utility
    ///////////////////////////////////////////////////////////////////////////////////////////////

    private ModelAndView prepareModelAndView(String view, Map<String, Object> model) {
        ModelAndView mv = new ModelAndView(view, model);
        appendGlobalModelAndView(mv);
        return mv;
    }

    private void appendGlobalModelAndView(ModelAndView mv) {
        //Translator locale = translators.getTranslator(localeResolver.resolveLocale(null));
        Translator locale = translators.getTranslator(new Locale("zh","CN"));
        //这里的__translator__ 不是给前端的
        mv.addObject("__translator__",locale);
        System.out.println(locale);
    }
}
