package com.lk.test.vuestudy.entity;

import com.lk.test.vuestudy.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author longke
 * @date 2019/12/10 16:52
 * 角色
 */

@Entity
public class Role extends BaseEntity {
    @Id
    @Column(length = 35)
    private String id;
    @Column(length = 35)
    private String pid;
    @Column(length = 50)
    private String roleName;


    //描述
    private String description;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
