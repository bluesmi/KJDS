package com.penglai.kjds.model.user;

import com.penglai.kjds.model.BaseResRoot;

/**
 * Created by m199 on 2017/6/13.
 */

public class UserInfoRes extends BaseResRoot {
    public UserInfo getData() {
        return data;
    }

    public void setData(UserInfo data) {
        this.data = data;
    }

    private UserInfo data;


}
