package com.pattern.vistor;

public final class True extends Bool {
    @Override
    public <R> R accept(BoolVisitors<? extends R> v) {
        return v.forTrue(); //用Visitor访问私有字段value，并进行变换
    }
}
