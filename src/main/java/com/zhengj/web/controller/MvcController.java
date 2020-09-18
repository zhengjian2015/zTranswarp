package com.zhengj.web.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MvcController {

    private static Logger LOGGER = LoggerFactory.getLogger(MvcController.class);

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        LOGGER.debug("hello啊");
        LOGGER.info("hello啊2");
        return "hello iTranswarp";
    }
}
