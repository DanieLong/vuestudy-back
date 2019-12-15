package com.lk.test.vuestudy.exception;

/**
 * @author longke
 * @date 2019-06-26 15:39
 * 服务异常
 */
public class ServiceException extends BaseException {

    public ServiceException(String code, String msg) {
        super(code, msg);
    }
}
