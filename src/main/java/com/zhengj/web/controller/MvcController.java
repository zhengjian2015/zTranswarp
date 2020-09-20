package com.zhengj.web.controller;


import com.zhengj.model.Topic;
import com.zhengj.model.User;
import com.zhengj.web.view.i18n.Translator;
import com.zhengj.web.view.i18n.Translators;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Controller
public class MvcController extends AbstractController {

    private static Logger LOGGER = LoggerFactory.getLogger(MvcController.class);

    @Autowired
    Translators translators;

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        LOGGER.debug("hello啊");
        LOGGER.info("hello啊2");
        return "hello iTranswarp";
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////
    // user and profile
    ///////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/user/" + ID)
    public ModelAndView user(@PathVariable("id") long id) {
        User user = userService.getById(id);
        List<Topic> topics = boardService.getTopicsByUser(user.getId());
        Map<String, Object> maps = new HashMap<String, Object>() {
            {
                put("user", user);
                put("topics",topics);
            }
        };
        return prepareModelAndView("profile.html", maps);
    }

    private ModelAndView prepareModelAndView(String view, Map<String, Object> model) {
        ModelAndView mv = new ModelAndView(view, model);
        appendGlobalModelAndView(mv);
        return mv;
    }

    private void appendGlobalModelAndView(ModelAndView mv) {
        //Translator locale = translators.getTranslator(localeResolver.resolveLocale(null));
        Translator locale = translators.getTranslator(new Locale("zh","CN"));
        //这里的__translator__ 不是给前端的
        mv.addObject("__translator__",locale);
        System.out.println(locale);
    }

}
