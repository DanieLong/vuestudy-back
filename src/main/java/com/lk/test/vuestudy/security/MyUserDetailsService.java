package com.lk.test.vuestudy.security;

import com.lk.test.vuestudy.entity.SysUser;
import com.lk.test.vuestudy.service.RoleService;
import com.lk.test.vuestudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author longke
 * @date 2019/12/11 22:39
 */
@Service
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    /**
     * 这一步在验证用户名密码之前 todo
     *
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = userService.getUserByUsername(username);
        if (null == sysUser) {
            throw new UsernameNotFoundException("usernameNotFound");
        }
//        List<Role> roleList = roleService.getRoleListByUserId(sysUser.getId());
        //权限
//        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
//        if (0 != roleList.size()) {
//            for (Role role : roleList) {
//                authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
//            }
//        }
//        return User.builder().username(sysUser.getUsername())
//                .password(sysUser.getPassword())
//                .build();
        return userService.getUserDetailsByUsername(username);
    }
}
