package com.lk.test.vuestudy.exception;

/**
 * @author longke
 * @date 2019-06-26 15:40
 * 业务异常
 */
public class BusinessException extends BaseException {
    public BusinessException(String code, String msg) {
        super(code, msg);
    }
}
