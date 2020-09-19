package com.zhengj.web.view;

import com.mitchellbosecke.pebble.template.EvaluationContext;
import com.mitchellbosecke.pebble.template.PebbleTemplate;
import com.zhengj.web.view.i18n.Translator;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 这个方法就是能把 {()} 中英文转换的
 * 对应 MvcConfiguration 里 pebbleExtension 变量的 Autowired
 */
@Component
public class I18NFunction extends AbstractFunction {
    @Override
    public String getName() {
        return "_";
    }

    @Override
    public Object execute(Map<String, Object> args, PebbleTemplate self, EvaluationContext context, int lineNumber) {
        String text = (String) args.get("0");
        // has args?
        boolean hasArgs = args.containsKey("1");
        if (hasArgs) {
            List<Object> params = new ArrayList<>();
            int i = 1;
            while (args.containsKey(String.valueOf(i))) {
                params.add(args.get(String.valueOf(i)));
                i++;
            }
            System.out.println("__translator__1");
            Translator t = (Translator) context.getVariable("__translator__");
            return t == null ? String.format(text, params.toArray()) : t.translate(text, params.toArray());
        } else {
            System.out.println("__translator__2");
            Translator t = (Translator) context.getVariable("__translator__");
            System.out.println(t);
            System.out.println(text);
            return t == null ? text : t.translate(text);
        }
    }
}
