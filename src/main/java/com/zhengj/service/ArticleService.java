package com.zhengj.service;

import com.zhengj.dao.ArticleMapper;
import com.zhengj.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    public List<Category> getCategories() {
        return articleMapper.getCategories();
    }
}
