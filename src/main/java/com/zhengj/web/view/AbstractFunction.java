package com.zhengj.web.view;

import com.mitchellbosecke.pebble.extension.Function;

import java.util.List;

public abstract class AbstractFunction implements Function {

    public abstract String getName();

    @Override
    public List<String> getArgumentNames() {
        return null;
    }
}
