package com.zhengj;

import com.zhengj.web.support.MvcConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({ MvcConfiguration.class })
public class ZTtranswarpApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZTtranswarpApplication.class, args);
	}

}
