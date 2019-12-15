package com.lk.test.vuestudy.dao;

import com.lk.test.vuestudy.entity.Permission;
import com.lk.test.vuestudy.vo.ResourceItem;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author longke
 * @date 2019/12/10 21:56
 */
@Component
public interface PermissionDao extends Mapper<Permission> {

    List<ResourceItem> getUserPermission(@Param("userId") String userId, @Param("permissionType") Integer permissionType);

    List<ResourceItem> getMenuList(String userId);
}
