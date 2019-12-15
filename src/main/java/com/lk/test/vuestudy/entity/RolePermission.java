package com.lk.test.vuestudy.entity;

import com.lk.test.vuestudy.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author longke
 * @date 2019/12/10 20:55
 * 角色权限表（多对多）
 */

@Entity
public class RolePermission extends BaseEntity {
    @Id
    @Column(length = 35)
    private String id;
    @Column(length = 35)
    private String roleId;
    @Column(length = 35)
    private String permissionId;
    //操作按钮(json数组{"add","update","delete","get"})
    private String opt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public String getOpt() {
        return opt;
    }

    public void setOpt(String opt) {
        this.opt = opt;
    }
}
