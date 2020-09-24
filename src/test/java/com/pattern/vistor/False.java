package com.pattern.vistor;

public final class False extends Bool {

    @Override
    public <R> R accept(BoolVisitors<? extends R> v) {
        return v.forFalse();
    }
}
