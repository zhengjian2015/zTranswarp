package com.zhengj;

import com.zhengj.web.support.MvcConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@SpringBootApplication
@Import({ MvcConfiguration.class })
public class ZTtranswarpApplication extends WebMvcConfigurationSupport {

	public static void main(String[] args) {
		SpringApplication.run(ZTtranswarpApplication.class, args);
	}

	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
		super.addResourceHandlers(registry);
	}


}
