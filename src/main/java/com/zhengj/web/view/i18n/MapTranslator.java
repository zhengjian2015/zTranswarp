package com.zhengj.web.view.i18n;

import java.util.HashMap;
import java.util.Map;

public class MapTranslator implements Translator {

    final String displayName;
    final String localeName;
    final Map<String, String> translator;

    public MapTranslator(String localeName, String displayName, Map<String, String> map) {
        this.localeName = localeName;
        this.displayName = displayName;
        this.translator = new HashMap<>(map);
    }

    @Override
    public String getDisplayName() {
        return this.displayName;
    }

    @Override
    public String getLocaleName() {
        return this.localeName;
    }

    @Override
    public String translate(String text, Object... args) {
        String t = this.translator.getOrDefault(text, text);
        return args.length == 0 ? t : String.format(t, args);
    }
}
