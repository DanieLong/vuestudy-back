package com.lk.test.vuestudy.service.impl;

import com.lk.test.vuestudy.dao.PermissionDao;
import com.lk.test.vuestudy.service.PermissionService;
import com.lk.test.vuestudy.vo.ResourceItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author longke
 * @date 2019/12/12 16:13
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionDao permissionDao;

    @Override
    public List<ResourceItem> getUserPermission(String userId, Integer permissionType) {
        return permissionDao.getUserPermission(userId, permissionType);
    }

    @Override
    public List<ResourceItem> getMenuList(String userId) {
        return permissionDao.getMenuList(userId);
    }
}
