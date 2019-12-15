package com.lk.test.vuestudy.entity;

import com.lk.test.vuestudy.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author longke
 * @date 2019/12/10 17:19
 * 权限
 */

@Entity
public class Permission extends BaseEntity {

    @Id
    @Column(length = 35)
    private String id;

    @Column(length = 35)
    private String pid;

    //权限名称
    @Column(length = 50)
    private String permissionName;

    //权限类型 1目录2页面3按钮4api
    private Integer permissionType;

    //权限排序
    private Integer permissionSort;

    //权限url
    @Column(length = 200)
    private String resourceUrl;

    @Column(length = 64)
    private String iconName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public Integer getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(Integer permissionType) {
        this.permissionType = permissionType;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public Integer getPermissionSort() {
        return permissionSort;
    }

    public void setPermissionSort(Integer permissionSort) {
        this.permissionSort = permissionSort;
    }
}
