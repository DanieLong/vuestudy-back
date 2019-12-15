package com.lk.test.vuestudy.utils;

import java.io.*;
import java.util.Optional;

/**
 * @author longke
 * @date 2019-07-16 15:31
 * @description bytes工具类
 */
public class BytesUtil {

    /**
     * @param obj
     * @param <T>
     * @return
     * @description object转bytes
     */
    public static <T> Optional<byte[]> objectToBytes(T obj) {
        byte[] bytes = null;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ObjectOutputStream sOut;
        try {
            sOut = new ObjectOutputStream(out);
            sOut.writeObject(obj);
            sOut.flush();
            bytes = out.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(bytes);
    }

    /**
     * @param bytes
     * @param <T>
     * @return
     * @description bytes转object
     */
    public static <T> Optional<T> bytesToObject(byte[] bytes) {
        T t = null;
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        ObjectInputStream sIn;
        try {
            sIn = new ObjectInputStream(in);
            t = (T) sIn.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(t);

    }
}
