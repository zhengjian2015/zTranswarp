package com.zhengj.web.controller;

import com.zhengj.service.ArticleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractController {

    protected final Logger LOGGER = LoggerFactory.getLogger(getClass());

    protected static final String ID = "{id:[0-9]{1,17}}";

    @Autowired
    protected ArticleService articleService;
}
