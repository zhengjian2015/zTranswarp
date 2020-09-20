package com.zhengj.web.controller;

import com.zhengj.bean.CategoryBean;
import com.zhengj.model.Category;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController extends AbstractController {


    private static final String RESULTS = "results";


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

    @PostMapping("/categories")
    //@RoleWith(Role.ADMIN)
    public Category categoryCreate(@RequestBody CategoryBean bean) {
        return this.articleService.createCategory(bean);
    }

}
