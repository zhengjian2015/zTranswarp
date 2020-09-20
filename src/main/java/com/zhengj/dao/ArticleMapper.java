package com.zhengj.dao;


import com.zhengj.model.Article;
import com.zhengj.model.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper extends tk.mybatis.mapper.common.Mapper<Article> {

    List<Category> getCategories();

    int insertCategory(Category category);

    int updateCategory(Category category);

    Category getCategoriesById(Long id);

    List<Article> getArticleByCategoryId(Long id);

    int deleteCategoryById(Long id);

    int udpateCategoryOrderById(Long id);
}
