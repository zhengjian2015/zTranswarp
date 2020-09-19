package com.zhengj.web.view.i18n;

import com.alibaba.fastjson.JSON;
import com.zhengj.util.ClassPathUtil;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Component
public class Translators {
    final Logger logger = LoggerFactory.getLogger(getClass());

    List<Language> languages;

    Map<String, Translator> translators;

    Translator defaultTranslator;

    @PostConstruct
    public void init() throws IOException {
        List<Translator> list = getTranslators("i18n");
        logger.info("postContruct of Translator init start");
        this.languages = list.stream().map(t -> new Language(t.getDisplayName(), t.getLocaleName()))
                .collect(Collectors.toList());
        this.translators = list.stream().collect(Collectors.toMap(Translator::getLocaleName, t -> t));
        System.out.println("0000000000000");
        System.out.println(translators);
        this.defaultTranslator = this.translators.getOrDefault("en", new DefaultTranslator());
    }

    public Translator getTranslator(Locale locale) {
        String l = locale.getLanguage();
        String c = locale.getCountry();
        Translator t = null;
        if (!c.isEmpty()) {
            // try get language + COUNTRY:
            t = this.translators.get(l + "_" + c);
        }
        if (t == null) {
            // try get language only:
            t = this.translators.get(l);
        }
        if (t == null) {
            t = defaultTranslator;
        }
        return t;
    }


    private List<Translator> getTranslators(String basePackage) throws IOException {
        //扫描 json文件
        Resource[] resources = ClassPathUtil.scan(basePackage, false, resource -> {
            return resource.getFilename().endsWith(".json");
        });
        System.out.println("resourcessss");
        System.out.println(resources.length);
        List<Translator> translators = new ArrayList<>();
        for (Resource resource : resources) {
            String filename = resource.getFilename();
            System.out.println("filename" + filename);
            Locale locale = parseLocale(filename.substring(0, filename.length() - 5));
            try (InputStream input = resource.getInputStream()) {
                String text = IOUtils.toString(input, "utf8");
                Map map = JSON.parseObject(text, Map.class);
                String displayName = map.remove("__name__").toString();
                if (displayName == null) {
                    logger.warn("No display name found in resource {}: using default: {}.", filename,
                            locale.toString());
                    displayName = locale.toString();
                }
                Translator translator = new MapTranslator(locale.toString(), displayName, map);
                logger.info("Found i18n translator {} for {} at {}", translator.getDisplayName(),
                        translator.getLocaleName(), resource.getURL());
                translators.add(translator);
            }
        }
        return translators;
    }

    private Locale parseLocale(String name) {
        Matcher m1 = PATTERN_LOCALE_1.matcher(name);
        if (m1.matches()) {
            System.out.println("m1");
            System.out.println(m1.group(1));
            return new Locale(m1.group(1));
        }
        Matcher m2 = PATTERN_LOCALE_2.matcher(name);
        if (m2.matches()) {
            System.out.println("m2");
            System.out.println(m2.group(1));
            System.out.println(m2.group(2));
            return new Locale(m2.group(1), m2.group(2));
        }
        throw new IllegalArgumentException("Invalid locale: " + name);
    }

    private static final Pattern PATTERN_LOCALE_1 = Pattern.compile("^([a-z]+)$");
    private static final Pattern PATTERN_LOCALE_2 = Pattern.compile("^([a-z]+)\\_([A-Z]+)$");

    public static class Language {

        public final String name;
        public final String locale;

        public Language(String name, String locale) {
            this.name = name;
            this.locale = locale;
        }
    }
}
