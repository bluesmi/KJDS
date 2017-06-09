package com.penglai.kjds.model.user;

import com.penglai.kjds.model.BaseResRoot;

/**
 *  * 作者：朋来-GZQ on 2017/2/4 11:28
 *  * 邮箱：gongzhiqing@xiyundata.com
 *  
 */
public class LoginRes extends BaseResRoot {

    private UserData data;

    public UserData getData() {
        return data;
    }

    public void setData(UserData data) {
        this.data = data;
    }

}
