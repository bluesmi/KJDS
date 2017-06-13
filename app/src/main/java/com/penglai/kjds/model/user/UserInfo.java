package com.penglai.kjds.model.user;

import java.io.Serializable;

/**
 * Created by m199 on 2017/6/13.
 */

public class UserInfo implements Serializable {
    private String userId;
    private String userImage;
    private String nickName;
    private String school;
    private String sex;
    private String birthday;

    public UserInfo() {
    }

    public UserInfo(String userId, String userImage, String nickName, String school, String sex, String birthday) {
        this.userId = userId;
        this.userImage = userImage;
        this.nickName = nickName;
        this.school = school;
        this.sex = sex;
        this.birthday = birthday;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserInfo that = (UserInfo) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (userImage != null ? !userImage.equals(that.userImage) : that.userImage != null)
            return false;
        if (nickName != null ? !nickName.equals(that.nickName) : that.nickName != null)
            return false;
        if (school != null ? !school.equals(that.school) : that.school != null) return false;
        if (sex != null ? !sex.equals(that.sex) : that.sex != null) return false;
        return birthday != null ? birthday.equals(that.birthday) : that.birthday == null;

    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (userImage != null ? userImage.hashCode() : 0);
        result = 31 * result + (nickName != null ? nickName.hashCode() : 0);
        result = 31 * result + (school != null ? school.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (birthday != null ? birthday.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId='" + userId + '\'' +
                ", userImage='" + userImage + '\'' +
                ", nickName='" + nickName + '\'' +
                ", school='" + school + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
