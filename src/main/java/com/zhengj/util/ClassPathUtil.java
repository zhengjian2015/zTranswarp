package com.zhengj.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.util.ClassUtils;

import org.springframework.core.io.Resource;
import java.io.IOException;
import java.util.Arrays;
import java.util.function.Predicate;

public class ClassPathUtil {

    static final Logger logger = LoggerFactory.getLogger(ClassPathUtil.class);

    public static Resource[] scan(String basePackage, boolean recursive, Predicate<? super Resource> predicate)
            throws IOException {

        String resourcePattern = recursive ? "**/*" : "*";
        ResourcePatternResolver resourcePatternResolver = ResourcePatternUtils.getResourcePatternResolver(null);
        String packageSearchPath = ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + resolveBasePackage(basePackage)
                + '/' + resourcePattern;
        logger.info("游览路径:{}",packageSearchPath);
        Resource[] resources = resourcePatternResolver.getResources(packageSearchPath);
        return Arrays.stream(resources).filter(predicate).toArray(Resource[]::new);
    }

    static String resolveBasePackage(String basePackage) {
        Environment env = new StandardEnvironment();
        return ClassUtils.convertClassNameToResourcePath(env.resolveRequiredPlaceholders(basePackage));
    }

}
