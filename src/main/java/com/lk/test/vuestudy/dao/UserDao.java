package com.lk.test.vuestudy.dao;

import com.lk.test.vuestudy.entity.SysUser;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;

/**
 * @author longke
 * @date 2019/12/10 21:54
 */
@Component
public interface UserDao extends Mapper<SysUser> {
}
