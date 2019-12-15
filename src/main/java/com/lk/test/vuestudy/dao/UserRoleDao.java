package com.lk.test.vuestudy.dao;

import com.lk.test.vuestudy.entity.Role;
import com.lk.test.vuestudy.entity.UserRole;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author longke
 * @date 2019/12/10 21:58
 */
@Component
public interface UserRoleDao extends Mapper<UserRole> {

    List<Role> getRoleListByUserId(String userId);
}
