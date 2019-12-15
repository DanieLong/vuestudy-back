package com.lk.test.vuestudy.entity;

import com.lk.test.vuestudy.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author longke
 * @date 2019/12/10 20:46
 * 用户组织机构（多对多）
 */

@Entity
public class UserOrg extends BaseEntity {
    @Id
    @Column(length = 35)
    private String id;

    @Column(length = 35)
    private String userId;

    @Column(length = 35)
    private String orgId;

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

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }
}
