package com.fintecher.common.vo.manage;

import javax.validation.constraints.Size;

public class ModifyPwdParam {

    private Long userId;

    private String oldPwd;

    @Size(min = 6,max = 64,message = "密码长度必须大于6位小于64位")
    private String newPwd;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getOldPwd() {
        return oldPwd;
    }

    public void setOldPwd(String oldPwd) {
        this.oldPwd = oldPwd;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }
}
