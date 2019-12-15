package com.lk.test.vuestudy.service;

import com.lk.test.vuestudy.dto.SignUpDto;
import com.lk.test.vuestudy.entity.SysUser;
import com.lk.test.vuestudy.security.MyUserDetails;

/**
 * @author longke
 * @date 2019/12/11 23:31
 */
public interface UserService {

    SysUser getUserById(String userId);

    SysUser getUserByUsername(String username);

    /**
     * 注册用户
     *
     * @param signUpDto
     */
    void signUp(SignUpDto signUpDto);

    MyUserDetails getUserDetailsByUsername(String username);
}
