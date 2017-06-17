package com.penglai.kjds.model.resume;

import java.io.Serializable;

/**
 * Created by m199 on 2017/6/16.
 */

public class PersionInfo  implements Serializable{
    private String userID;
    private String headPicID;
    private String trueName;
    private String education;
    private String address;
    private String birthDate;
    private String gender;
    private String phone;
    private String email;

    public PersionInfo() {
    }

    public PersionInfo(String userID, String headPicID, String trueName,
                       String education, String address, String birthDate, String gender, String phone, String email) {
        this.userID = userID;
        this.headPicID = headPicID;
        this.trueName = trueName;
        this.education = education;
        this.address = address;
        this.birthDate = birthDate;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getHeadPicID() {
        return headPicID;
    }

    public void setHeadPicID(String headPicID) {
        this.headPicID = headPicID;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersionInfo that = (PersionInfo) o;

        if (userID != null ? !userID.equals(that.userID) : that.userID != null) return false;
        if (headPicID != null ? !headPicID.equals(that.headPicID) : that.headPicID != null)
            return false;
        if (trueName != null ? !trueName.equals(that.trueName) : that.trueName != null)
            return false;
        if (education != null ? !education.equals(that.education) : that.education != null)
            return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (birthDate != null ? !birthDate.equals(that.birthDate) : that.birthDate != null)
            return false;
        if (gender != null ? !gender.equals(that.gender) : that.gender != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        return email != null ? email.equals(that.email) : that.email == null;

    }

    @Override
    public int hashCode() {
        int result = userID != null ? userID.hashCode() : 0;
        result = 31 * result + (headPicID != null ? headPicID.hashCode() : 0);
        result = 31 * result + (trueName != null ? trueName.hashCode() : 0);
        result = 31 * result + (education != null ? education.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (birthDate != null ? birthDate.hashCode() : 0);
        result = 31 * result + (gender != null ? gender.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PersionInfo{" +
                "userID='" + userID + '\'' +
                ", headPicID='" + headPicID + '\'' +
                ", trueName='" + trueName + '\'' +
                ", education='" + education + '\'' +
                ", address='" + address + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
