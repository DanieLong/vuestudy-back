package com.lk.test.vuestudy.service;

import com.lk.test.vuestudy.vo.ResourceItem;

import java.util.List;

/**
 * @author longke
 * @date 2019/12/12 14:06
 */
public interface PermissionService {
    List<ResourceItem> getUserPermission(String userId, Integer permissionType);

    List<ResourceItem> getMenuList(String userId);
}
