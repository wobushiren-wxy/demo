package com.xx.demo.model.enums;

public enum ErrorCode {

    OK(0, "ok"), 
    SIGN_EMPTY(1001, "账号不存在"), 
    PARAM_ERROR(1002, "参数错误"), 
    SYSTEM_ERROR(1003, "系统错误")
    ;

    public final int    result;
    public final String msg;

    private ErrorCode(int result, String msg) {
        this.result = result;
        this.msg = msg;
    }

    public int getResult() {
        return result;
    }

    public String getMsg() {
        return msg;
    }

}
