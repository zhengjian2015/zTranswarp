package com.zhengj.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/manage")
public class ManageController {

    private static Logger LOGGER = LoggerFactory.getLogger(ManageController.class);

    ///////////////////////////////////////////////////////////////////////////////////////////////
    // attachment
    ///////////////////////////////////////////////////////////////////////////////////////////////
    @GetMapping("/attachment")
    public ModelAndView attachmentList(@RequestParam(value = "page", defaultValue = "1") int pageIndex) {
        Map<String, Object> pages = new HashMap<String, Object>() {
            {
                put("page", pageIndex);
            }
        };
        LOGGER.info("进入attachment");
        return prepareModelAndView("manage/attachment/attachment_list.html",pages);
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////
    // utility
    ///////////////////////////////////////////////////////////////////////////////////////////////

    private ModelAndView prepareModelAndView(String view, Map<String, Object> model) {
        ModelAndView mv = new ModelAndView(view, model);
        // appendGlobalModelAndView(mv);
        return mv;
    }
}
