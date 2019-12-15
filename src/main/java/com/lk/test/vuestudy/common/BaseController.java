package com.lk.test.vuestudy.common;

import com.lk.test.vuestudy.eunms.ResCode;

/**
 * @author longke
 * @date 2019/12/13 09:59
 */
public class BaseController {

    /**
     * @return
     * @description 返回成功不含数据
     */
    protected BaseResult<?> successWithoutData() {
        BaseResult<?> resultDto = new BaseResult<>();
        resultDto.setCode(ResCode.SUCCESS.getCode());
        resultDto.setMsg("success");
        return resultDto;
    }

    /**
     * @param t
     * @param <T>
     * @return
     * @description 返回成功包含数据
     */
    protected <T> BaseResult<T> successWithData(T t) {
        BaseResult<T> resultDto = new BaseResult<>();
        resultDto.setCode(ResCode.SUCCESS.getCode());
        resultDto.setMsg("success");
        resultDto.setData(t);
        return resultDto;
    }

    /**
     * @return
     * @description 失败不包含数据
     */
    protected BaseResult<?> failWithoutData() {
        BaseResult<?> resultDto = new BaseResult<>();
        resultDto.setCode(ResCode.FAIL.getCode());
        resultDto.setMsg("fail");
        return resultDto;
    }
}
