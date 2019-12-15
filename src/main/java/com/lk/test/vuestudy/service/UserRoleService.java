package com.lk.test.vuestudy.service;

import com.lk.test.vuestudy.entity.Role;

import java.util.List;

/**
 * @author longke
 * @date 2019/12/12 15:13
 */
public interface UserRoleService {

    List<Role> getRoleListByUserId(String userId);

}
