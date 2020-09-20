package com.zhengj.web.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhengj.bean.CategoryBean;
import com.zhengj.bean.SortBean;
import com.zhengj.model.Article;
import com.zhengj.model.Category;
import com.zhengj.model.ReturnInfo;
import com.zhengj.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
    // user
    ///////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/users/ids")
    // @RoleWith(Role.CONTRIBUTOR)
    public Map<Long, User> usersByIds(@RequestParam("id") long[] ids) {
        System.out.println(Arrays.toString(ids));
        List<User> users = this.userService.getUsersByIds(ids);
        return users.stream().collect(Collectors.toMap(u -> u.getId(), u -> u));
    }


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



    ///////////////////////////////////////////////////////////////////////////////////////////////
    // article
    ///////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/articles")
    //@RoleWith(Role.CONTRIBUTOR)
    public ReturnInfo articles(@RequestParam(value = "page", defaultValue = "1") int current) {
        int pageSize = 5;
        PageHelper.startPage(current, (pageSize > 0 && pageSize <= 500) ? pageSize : 20);
        List<Article> articleList = articleService.getArticles();
        return new ReturnInfo(200, "获取数据字典列表数据成功！", new PageInfo(articleList));
    }

}
