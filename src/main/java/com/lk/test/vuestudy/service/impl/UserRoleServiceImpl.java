package com.lk.test.vuestudy.service.impl;

import com.lk.test.vuestudy.entity.Role;
import com.lk.test.vuestudy.service.UserRoleService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author longke
 * @date 2019/12/12 15:13
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {
    @Override
    public List<Role> getRoleListByUserId(String userId) {
        return null;
    }
}
