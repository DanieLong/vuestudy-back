package com.lk.test.vuestudy.dao;

import com.lk.test.vuestudy.entity.Role;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author longke
 * @date 2019/12/10 21:57
 */
@Component
public interface RoleDao extends Mapper<Role> {
}
