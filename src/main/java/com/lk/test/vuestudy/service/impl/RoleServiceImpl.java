package com.lk.test.vuestudy.service.impl;

import com.lk.test.vuestudy.dao.RoleDao;
import com.lk.test.vuestudy.dao.UserRoleDao;
import com.lk.test.vuestudy.entity.Role;
import com.lk.test.vuestudy.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author longke
 * @date 2019/12/12 14:11
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;

    @Autowired
    private UserRoleDao userRoleDao;

    @Override
    public List<Role> getRoleListByUserId(String userId) {
        return userRoleDao.getRoleListByUserId(userId);
    }
}
