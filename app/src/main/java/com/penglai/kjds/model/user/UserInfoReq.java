package com.penglai.kjds.model.user;

/**
 * Created by m199 on 2017/6/13.
 */

public class UserInfoReq {
    private String userId;

    public UserInfoReq(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
