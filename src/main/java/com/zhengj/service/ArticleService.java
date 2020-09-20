package com.zhengj.service;

import com.zhengj.bean.CategoryBean;
import com.zhengj.dao.ArticleMapper;
import com.zhengj.model.Category;
import com.zhengj.util.IdUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    public List<Category> getCategories() {
        return articleMapper.getCategories();
    }


    @Transactional
    public Category createCategory(CategoryBean bean) {
        bean.validate(true);
        long maxDisplayOrder = getCategories().stream().mapToLong(c -> c.getDisplayOrder()).max().orElseGet(() -> 0);
        Category category = new Category();
        category.setId(IdUtil.nextId());
        category.setName(bean.name);
        category.setTag(bean.tag);
        category.setDescription(bean.description);
        category.setDisplayOrder(maxDisplayOrder + 1);
        Long now = System.currentTimeMillis();
        category.setCreatedAt(now);
        category.setUpdatedAt(now);
        this.articleMapper.insertCategory(category);
        return category;
    }
}
