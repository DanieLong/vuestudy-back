package com.lk.test.vuestudy.service.impl;

import com.lk.test.vuestudy.dao.UserDao;
import com.lk.test.vuestudy.dto.SignUpDto;
import com.lk.test.vuestudy.entity.Role;
import com.lk.test.vuestudy.entity.SysUser;
import com.lk.test.vuestudy.security.MyUserDetails;
import com.lk.test.vuestudy.service.RoleService;
import com.lk.test.vuestudy.service.UserService;
import com.lk.test.vuestudy.utils.BCryptEncoderUtils;
import com.lk.test.vuestudy.utils.UUIDTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author longke
 * @date 2019/12/11 23:31
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleService roleService;

    @Override
    public SysUser getUserById(String userId) {
        Example example = new Example(SysUser.class);
        example.createCriteria().andEqualTo("id", userId);
        return userDao.selectOneByExample(example);
    }

    @Override
    public SysUser getUserByUsername(String username) {
        Example example = new Example(SysUser.class);
        example.createCriteria().andEqualTo("username", username);
        return userDao.selectOneByExample(example);
    }

    @Override
    public void signUp(SignUpDto signUpDto) {
        SysUser sysUser = new SysUser();
        sysUser.setId(UUIDTool.getUUID());
        sysUser.setUsername(signUpDto.getUsername());
        sysUser.setPassword(BCryptEncoderUtils.encode(signUpDto.getPassword()));
        userDao.insertSelective(sysUser);
    }

    @Override
    public MyUserDetails getUserDetailsByUsername(String username) {
        SysUser user = this.getUserByUsername(username);
        List<Role> roleList = roleService.getRoleListByUserId(user.getId());
        //权限
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        if (0 != roleList.size()) {
            for (Role role : roleList) {
                authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
            }
        }
//        List<ResourceItem> resourceItemList = permissionService.getUserPermission(user.getId(), null);
        return new MyUserDetails(user.getUsername(), user.getPassword(), authorities, user.getId());
    }
}
