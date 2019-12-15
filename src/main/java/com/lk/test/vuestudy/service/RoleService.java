package com.lk.test.vuestudy.service;

import com.lk.test.vuestudy.entity.Role;

import java.util.List;

/**
 * @author longke
 * @date 2019/12/12 14:06
 */
public interface RoleService {

    List<Role> getRoleListByUserId(String userId);
}
