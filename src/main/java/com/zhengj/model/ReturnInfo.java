package com.zhengj.model;

public class ReturnInfo {
    public ReturnInfo() {
        super();
    }

    public ReturnInfo(Integer code, String msg) {
        this.msg = msg;
        this.code = code;
    }

    public ReturnInfo(Integer code, String msg, Object obj) {
        this.msg = msg;
        this.code = code;
        this.obj = obj;
    }

    /**
     * 返回的错误码
     */
    private Integer code;

    /**
     * 返回的错误信息
     */
    private String msg;

    /**
     * 返回的json数据
     */
    private Object obj;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

}
