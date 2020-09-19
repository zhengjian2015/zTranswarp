package com.zhengj.web.support;

import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.extension.AbstractExtension;
import com.mitchellbosecke.pebble.extension.Extension;
import com.mitchellbosecke.pebble.extension.Function;
import com.mitchellbosecke.pebble.loader.ClasspathLoader;
import com.mitchellbosecke.pebble.spring.PebbleViewResolver;
import com.zhengj.web.view.AbstractFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import java.util.HashMap;
import java.util.Map;

public class MvcConfiguration {

    private static Logger LOGGER = LoggerFactory.getLogger(MvcConfiguration.class);

    @Bean
    public CookieLocaleResolver createLocaleResolver() {
        CookieLocaleResolver resolver = new CookieLocaleResolver();
        resolver.setCookieName("_locale_");
        resolver.setCookieHttpOnly(true);
        resolver.setCookieMaxAge(Integer.MAX_VALUE);
        resolver.setCookiePath("/");
        LOGGER.info("resolver:{}",resolver.getCookiePath());
        return resolver;
    }

    @Bean
    WebMvcConfigurer createWebMvcConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addResourceHandlers(ResourceHandlerRegistry registry) {
                LOGGER.info("static registry");
                registry.addResourceHandler("/static/**")
                        .addResourceLocations("classpath:/static/");
            }
        };
    }

    /**
     * Init view resolver.  要先扫描在能用Bean初始化
     *
     * @return PebbleViewResolver
     */
    @Bean
    public ViewResolver pebbleViewResolver(@Autowired Extension pebbleExtension) {
        // disable cache for native profile:
        //boolean cache = !"native".equals(activeProfile);
        LOGGER.info("set cache as {} for active profile is {}.");
        PebbleEngine engine = new PebbleEngine.Builder().autoEscaping(true).cacheActive(false).extension(pebbleExtension)
                .loader(new ClasspathLoader()).build();
        PebbleViewResolver viewResolver = new PebbleViewResolver();
        viewResolver.setPrefix("templates/");
        viewResolver.setSuffix("");
        viewResolver.setPebbleEngine(engine);
        return viewResolver;
    }

    @Bean("pebbleExtension")
    Extension pebbleExtension(@Autowired(required = false) AbstractFunction[] functions) {
        return new AbstractExtension() {

            @Override
            public Map<String, Function> getFunctions() {
                LOGGER.info("项目启动时运行pebbleExtension");
                Map<String, Function> map = new HashMap<>();
                if (functions != null) {
                    for (AbstractFunction function : functions) {
                        System.out.println(function.getName());
                        map.put(function.getName(), function);
                    }
                }
                return map;
            }
        };
    }
}
