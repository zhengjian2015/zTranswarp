package com.zhengj.web.controller;

import com.zhengj.bean.CategoryBean;
import com.zhengj.bean.SortBean;
import com.zhengj.model.Category;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController extends AbstractController {


    private static final String RESULTS = "results";

    private static final Map<String, Boolean> API_RESULT_TRUE =
            new HashMap<String, Boolean>() {
                {
                    put("result", Boolean.TRUE);
                }
            };


    ///////////////////////////////////////////////////////////////////////////////////////////////
    // category
    ///////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/categories")
    //@RoleWith(Role.CONTRIBUTOR)
    public Map<String, List<Category>> categories() {
        Map<String, List<Category>> results = new HashMap<>();
        results.put(RESULTS, this.articleService.getCategories());
        return results;
    }

    @GetMapping("/categories/" + ID)
    // @RoleWith(Role.CONTRIBUTOR)
    public Category category(@PathVariable("id") long id) {
        return this.articleService.getCategoryById(id);
    }


    @PostMapping("/categories")
    //@RoleWith(Role.ADMIN)
    public Category categoryCreate(@RequestBody CategoryBean bean) {
        return this.articleService.createCategory(bean);
    }

    @PostMapping("/categories/" + ID)
   // @RoleWith(Role.ADMIN)
    public Category categoryUpdate(@PathVariable("id") long id, @RequestBody CategoryBean bean) {
        Category category = this.articleService.updateCategory(id, bean);
        // this.articleService.deleteCategoryFromCache(id);
        return category;
    }

    @PostMapping("/categories/" + ID + "/delete")
   // @RoleWith(Role.ADMIN)
    public Map<String, Boolean> categoryDelete(@PathVariable("id") long id) {
        this.articleService.deleteCategory(id);
        //this.articleService.deleteCategoryFromCache(id);
        return API_RESULT_TRUE;
    }

    @PostMapping("/categories/sort")
    // @RoleWith(Role.ADMIN)
    public Map<String, Boolean> categoriesSort(@RequestBody SortBean bean) {
        System.out.println("bean");
        System.out.println(bean);
        System.out.println(bean.ids);
        this.articleService.sortCategories(bean.ids);
        // this.articleService.deleteCategoriesFromCache();
        return API_RESULT_TRUE;
    }

}
