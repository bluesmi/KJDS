package com.penglai.kjds.model.index;

import java.io.Serializable;

/**
 * Created by m199 on 2017/6/24.
 * 公司信息
 */

public class Company implements Serializable {
    /**
     * 公司logo
     */
    private String companyLogo;
    /**
     * 公司名称
     */
    private String companyName;
    /**
     * 所在行业
     */
    private String orgProp;
    /**
     * 公司规模
     */
    private String orgPeopleNumber;
    /**
     * 公司类型
     */
    private String orgContact;
    /**
     * 公司地址
     */
    private String telphone;
    /**
     * 联系方式
     */
    private String address;
    /**
     *公司简介
     */
    private String introduction;
    /**
     *邮箱
     */
    private String email;

    public Company(String companyLogo, String companyName, String orgProp,
                   String orgPeopleNumber, String orgContact, String telphone,
                   String address, String introduction, String email) {
        this.companyLogo = companyLogo;
        this.companyName = companyName;
        this.orgProp = orgProp;
        this.orgPeopleNumber = orgPeopleNumber;
        this.orgContact = orgContact;
        this.telphone = telphone;
        this.address = address;
        this.introduction = introduction;
        this.email = email;
    }

    public Company() {
    }

    public String getCompanyLogo() {
        return companyLogo;
    }

    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getOrgProp() {
        return orgProp;
    }

    public void setOrgProp(String orgProp) {
        this.orgProp = orgProp;
    }

    public String getOrgPeopleNumber() {
        return orgPeopleNumber;
    }

    public void setOrgPeopleNumber(String orgPeopleNumber) {
        this.orgPeopleNumber = orgPeopleNumber;
    }

    public String getOrgContact() {
        return orgContact;
    }

    public void setOrgContact(String orgContact) {
        this.orgContact = orgContact;
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
