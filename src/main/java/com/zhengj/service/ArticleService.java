package com.zhengj.service;

import com.zhengj.bean.CategoryBean;
import com.zhengj.common.ApiException;
import com.zhengj.dao.ArticleMapper;
import com.zhengj.dao.EntityMapper;
import com.zhengj.enums.ApiError;
import com.zhengj.model.AbstractSortableEntity;
import com.zhengj.model.Article;
import com.zhengj.model.Category;
import com.zhengj.util.IdUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ArticleService extends AbstractService<Article> {

    private static Logger LOGGER = LoggerFactory.getLogger(ArticleService.class);

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
        category.setVersion(0L);
        this.articleMapper.insertCategory(category);
        return category;
    }

    @Transactional
    public void deleteCategory(Long id) {
        Category category = this.getCategoryById(id);
        if (getArticleByCategoryId(category.getId()).size() == 0) {
            LOGGER.info("category is 0");
            this.articleMapper.deleteCategoryById(id);
        } else {
            throw new ApiException(ApiError.OPERATION_FAILED, "category", "Cannot delete non-empty category.");
        }
    }


    public Category getCategoryById(Long id) throws ApiException {
        Category cat = articleMapper.getCategoriesById(id);
        if (cat == null) {
            throw new ApiException(ApiError.ENTITY_NOT_FOUND, "Category", "Category not found.");
        }
        return cat;
    }

    public List<Article> getArticleByCategoryId(Long id) {
        return articleMapper.getArticleByCategoryId(id);
    }

    @Transactional
    public Category updateCategory(Long id, CategoryBean bean) {
        bean.validate(false);
        Category category = this.getCategoryById(id);
        category.setTag(bean.tag);
        category.setDescription(bean.description);
        category.setName(bean.name);
        Long now = System.currentTimeMillis();
        category.setUpdatedAt(now);
        articleMapper.updateCategory(category);
        return category;
    }

    @Transactional
    public void sortCategories(List<Long> ids) {
        List<Category> categories = getCategories();
        sortEntities("categories",categories, ids);
    }

}
