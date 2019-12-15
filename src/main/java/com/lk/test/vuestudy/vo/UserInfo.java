package com.lk.test.vuestudy.vo;

import java.util.List;

/**
 * @author longke
 * @date 2019/12/13 14:22
 */
public class UserInfo {

    private String userId;

    private String username;

    private List<ResourceItem> resourceItems;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<ResourceItem> getResourceItems() {
        return resourceItems;
    }

    public void setResourceItems(List<ResourceItem> resourceItems) {
        this.resourceItems = resourceItems;
    }
}
