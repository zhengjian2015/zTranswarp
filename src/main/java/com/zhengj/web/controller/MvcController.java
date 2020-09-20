package com.zhengj.web.controller;


import com.zhengj.common.ApiException;
import com.zhengj.enums.ApiError;
import com.zhengj.model.Topic;
import com.zhengj.model.User;
import com.zhengj.oauth.OAuthProviders;
import com.zhengj.oauth.provider.AbstractOAuthConfiguration;
import com.zhengj.web.view.i18n.Translator;
import com.zhengj.web.view.i18n.Translators;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Controller
public class MvcController extends AbstractController {

    private static Logger LOGGER = LoggerFactory.getLogger(MvcController.class);


    @Value("${spring.signin.password.enabled}")
    boolean passauthEnabled;

    @Autowired
    OAuthProviders oauthProviders;

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


    ///////////////////////////////////////////////////////////////////////////////////////////////
    // sign in
    ///////////////////////////////////////////////////////////////////////////////////////////////

    @GetMapping("/auth/signin")
    public ModelAndView signin(@RequestParam(value = "type", defaultValue = "") String type) {
        boolean oauthEnabled = !this.oauthProviders.getOAuthProviders().isEmpty();
        boolean passauthEnabled = this.passauthEnabled;
        System.out.println("-----------------------");
        System.out.println(oauthEnabled);
        System.out.println(passauthEnabled);
        if (!oauthEnabled && !passauthEnabled) {
            throw new ApiException(ApiError.INTERNAL_SERVER_ERROR, null, "Invalid signin configuration.");
        }
        if (!oauthEnabled && type.equals("oauth")) {
            throw new ApiException(ApiError.PARAMETER_INVALID, "type", "Do not support OAuth signin.");
        }
        if (!passauthEnabled && type.equals("passauth")) {
            throw new ApiException(ApiError.PARAMETER_INVALID, "type", "Do not support password signin.");
        }
        if (type.isEmpty() && oauthEnabled) {
            type = "oauth";
        }
        if (type.isEmpty() && passauthEnabled) {
            type = "passauth";
        }
        String mType = type;

        Map<String, AbstractOAuthConfiguration> results = this.oauthProviders.getOAuthConfigurations();
        Map<String, Object> maps = new HashMap<String, Object>() {
            {
                put("type", mType);
                put("oauthEnabled", oauthEnabled);
                put("passauthEnabled", passauthEnabled);
                put("oauthConfigurations", results);
            }
        };

        return prepareModelAndView("signin.html", maps);
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
