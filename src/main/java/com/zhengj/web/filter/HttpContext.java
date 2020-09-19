package com.zhengj.web.filter;

public class HttpContext implements AutoCloseable {

    static final ThreadLocal<HttpContext> CONTEXT_THREAD_LOCAL = new ThreadLocal<>();



    /**
     * 实现AutoCloseable中类似 finally
     * @throws Exception
     */
    @Override
    public void close() throws Exception {
        System.out.println("--close--");
        CONTEXT_THREAD_LOCAL.remove();
    }
}
