package com.pattern.vistor;

public abstract class Bool {

    public abstract <R> R accept(BoolVisitors<? extends R> v);

    public static Bool True() {
        return new True();
    }

    public static Bool False() {
        return new False();
    }
}


