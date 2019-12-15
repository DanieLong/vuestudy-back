package com.lk.test.vuestudy.eunms;

/**
 * @author longke
 * @date 2019-06-28
 * 返回信息
 */
public enum ResCode {
    SUCCESS("200"), FAIL("400"), WRONG("500"), NO_DATA("501"), NOT_FIND_READER_SESSION("777"), TRY_LOCK_FAIL("755");

    private final String code;

    ResCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
//
//	public void setCode(String code) {
//		this.code = code;
//	}


}
