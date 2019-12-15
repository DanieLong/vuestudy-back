package com.lk.test.vuestudy.common;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.lk.test.vuestudy.utils.ResultSerializerUtils;

/**
 * @author longke
 * @date 2019/12/12 21:03
 */
public class BaseResult<T> {
    /**
     * 状态码
     */
    private String code;
    /**
     * 业务类型
     */
    private String businessType;
    /**
     * 信息
     */
    private String msg;
    /**
     * 返回对象
     */

    @JsonSerialize(nullsUsing = ResultSerializerUtils.class)
    private T data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
