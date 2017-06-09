package com.penglai.kjds.model.user;

import java.io.Serializable;

/**
 *  * 作者：朋来-GZQ on 2017/2/4 11:29
 *  * 邮箱：gongzhiqing@xiyundata.com
 *  
 */
public class UserData  implements  Serializable{

    /**
     * userId : 4ad66d57-3184-4cd7-a4f2-faa425ffe667
     * userName : 1001
     * token : 3333
     */

    private String userId;
    private String userName;
    private String token;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
