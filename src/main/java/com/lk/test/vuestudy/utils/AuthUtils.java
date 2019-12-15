package com.lk.test.vuestudy.utils;

import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author longke
 * @date 2019/12/14 15:37
 */
public class AuthUtils {

    public static String getUserId() {
        SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return null;
    }
}
