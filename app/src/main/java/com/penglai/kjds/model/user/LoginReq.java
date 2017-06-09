package com.penglai.kjds.model.user;

/**
 *  * 作者：朋来-GZQ on 2017/2/4 16:18
 *  * 邮箱：gongzhiqing@xiyundata.com
 *  
 */
public class LoginReq {

    public String userName;

    public String password;

    public int type;

    public LoginReq() {

    }

    public LoginReq(String userName, String password, int type) {
        this.userName = userName;
        this.password = password;
        this.type = type;
    }
}
