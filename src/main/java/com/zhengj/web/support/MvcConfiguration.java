package com.zhengj.web.support;

import com.mitchellbosecke.pebble.PebbleEngine;
import com.mitchellbosecke.pebble.extension.Extension;
import com.mitchellbosecke.pebble.loader.ClasspathLoader;
import com.mitchellbosecke.pebble.spring.servlet.PebbleViewResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;

public class MvcConfiguration {

    private static Logger LOGGER = LoggerFactory.getLogger(MvcConfiguration.class);

    /**
     * Init view resolver.  要先扫描在能用Bean初始化
     *
     * @return PebbleViewResolver
     */
    @Bean
    public ViewResolver pebbleViewResolver() {
        // disable cache for native profile:
        //boolean cache = !"native".equals(activeProfile);
        LOGGER.info("set cache as {} for active profile is {}.");
        PebbleEngine engine = new PebbleEngine.Builder().autoEscaping(true).cacheActive(false).extension()
                .loader(new ClasspathLoader()).build();
        PebbleViewResolver viewResolver = new PebbleViewResolver();
        viewResolver.setPrefix("templates/");
        viewResolver.setSuffix("");
        viewResolver.setPebbleEngine(engine);
        return viewResolver;
    }

}
