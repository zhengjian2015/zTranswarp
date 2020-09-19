package com.zhengj.dao;


import com.zhengj.model.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ArticleMapper  {

    List<Category> getCategories();

}
