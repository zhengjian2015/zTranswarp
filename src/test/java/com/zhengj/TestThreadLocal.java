package com.zhengj;

public class TestThreadLocal {
    public static void main(String[] args) {
        log("start mina..");
        new Thread(() -> {
            log("run task...");
        }).start();
        new Thread(() -> {
            log("print...");
        }).start();
        log("end main");
    }

    static void log(String s) {
        System.out.println(Thread.currentThread().getName()+":"+s);
    }
}
