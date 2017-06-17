package com.penglai.kjds.model.user;

/**
 * Created by m199 on 2017/6/16.
 */

public class ModifyUserInfoReq {
    private String userId;
    private String nickName;
    private int sex;
    private String birthday;
    private String logImg;

    public ModifyUserInfoReq() {

    }

    public ModifyUserInfoReq(String userId, String nickName, int sex, String birthday, String logImg) {
        this.userId = userId;
        this.nickName = nickName;
        this.sex = sex;
        this.birthday = birthday;
        this.logImg = logImg;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getLogImg() {
        return logImg;
    }

    public void setLogImg(String logImg) {
        this.logImg = logImg;
    }
}
