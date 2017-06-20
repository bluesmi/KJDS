package com.penglai.kjds.model.resume;

import java.io.Serializable;

/**
 * Created by m199 on 2017/6/20.
 */

public class ModifyPersionInfoReq implements Serializable {
    private String userId;
    private String UserImg;
    private String TrueName;
    private String Education;
    private String Address;
    private String BirthDate;
    private int Gender;
    private String Phone;
    private String Email;

    public ModifyPersionInfoReq() {
    }

    public ModifyPersionInfoReq(String userId, String userImg, String trueName,
                                String education, String address, String birthDate, int gender, String phone, String email) {
        this.userId = userId;
        UserImg = userImg;
        TrueName = trueName;
        Education = education;
        Address = address;
        BirthDate = birthDate;
        Gender = gender;
        Phone = phone;
        Email = email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserImg() {
        return UserImg;
    }

    public void setUserImg(String userImg) {
        UserImg = userImg;
    }

    public String getTrueName() {
        return TrueName;
    }

    public void setTrueName(String trueName) {
        TrueName = trueName;
    }

    public String getEducation() {
        return Education;
    }

    public void setEducation(String education) {
        Education = education;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(String birthDate) {
        BirthDate = birthDate;
    }

    public int getGender() {
        return Gender;
    }

    public void setGender(int gender) {
        Gender = gender;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
