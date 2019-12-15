package com.lk.test.vuestudy.entity;

import com.lk.test.vuestudy.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author longke
 * @date 2019/12/10 20:16
 * 用户角色（多对多）
 */
@Entity
public class UserRole extends BaseEntity {
    @Id
    @Column(length = 35)
    private String id;
    @Column(length = 35)
    private String userId;
    @Column(length = 35)
    private String roleId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
