package com.fintecher.common.vo.manage;

import java.util.List;

public class DistributionRole {

    private List<Long> userIds;

    private List<Long> roleIds;

    public List<Long> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Long> userIds) {
        this.userIds = userIds;
    }

    public List<Long> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Long> roleIds) {
        this.roleIds = roleIds;
    }
}
