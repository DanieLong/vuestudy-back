package com.lk.test.vuestudy.entity;

import com.lk.test.vuestudy.common.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author longke
 * @date 2019/12/10 20:26
 * 组织机构
 */
@Entity
public class Organization extends BaseEntity {
    @Id
    @Column(length = 35)
    private String id;

    @Column(length = 35)
    private String pid;
    //组织机构代码
    @Column(length = 30)
    private String code;

    @Column(length = 50)
    private String orgName;

    @Column(length = 150)
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
