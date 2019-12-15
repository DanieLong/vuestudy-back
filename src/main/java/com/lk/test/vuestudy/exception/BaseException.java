package com.lk.test.vuestudy.exception;

/**
 * @author longke
 * @date 2019-06-28 22:30
 * 基础异常类
 */
public class BaseException extends RuntimeException {
    private String code;
    private String msg;

    public BaseException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
