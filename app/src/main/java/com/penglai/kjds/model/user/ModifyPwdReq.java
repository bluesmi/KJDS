package com.penglai.kjds.model.user;

/**
 *  * 作者：朋来-GZQ on 2017/2/8 15:22
 *  * 邮箱：gongzhiqing@xiyundata.com
 *  
 */
public class ModifyPwdReq {

    private String userName;         //账户
    private String currentPwd;      //旧密码
    private String newPwd;            //新密码
    private String userId;               //用户id

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNewPwd() {
        return newPwd;
    }

    public void setNewPwd(String newPwd) {
        this.newPwd = newPwd;
    }

    public String getCurrentPwd() {
        return currentPwd;
    }

    public void setCurrentPwd(String currentPwd) {
        this.currentPwd = currentPwd;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public ModifyPwdReq() {

    }

    public ModifyPwdReq(String userName, String currentPwd, String newPwd, String userId) {
        this.userName = userName;
        this.currentPwd = currentPwd;
        this.newPwd = newPwd;
        this.userId = userId;
    }
}
