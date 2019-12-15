package com.lk.test.vuestudy.utils;

/**
 * @author longke
 * @date 2019-07-22 16:28
 * @description 进制转换工具类
 */
public class NumberConvertUtil {

    /**
     * @param ints
     * @return
     * @description int数组转16进制
     */
    public static String intArrayToHex(int[] ints) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int b : ints) {
            String s = String.format("%02X", b & 0xFF);
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }
}
