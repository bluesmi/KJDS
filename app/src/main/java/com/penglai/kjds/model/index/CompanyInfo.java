package com.penglai.kjds.model.index;

import java.io.Serializable;

/**
 * Created by m199 on 2017/6/17.
 * 公司信息
 */

public class CompanyInfo implements Serializable {
    /**
     * 招聘ID
     */
    private String iD;
    /**
     * 公司名称
     */
    private String companyName;
    /**
     * 公司logo地址
     */
    private String logoID;
    /**
     * 招聘类型，0全部1 兼职、2全职，3项目
     */
    private String typeID;
    /**
     * 是否推荐
     */
    private String isRecommend;
    /**
     * 职位、岗位名称
     */
    private String title;
    /**
     *公司类型：例：2国企、1私企
     */
    private String orgProp;
    /**
     * 学历/学位
     */
    private String eduRequire;
    /**
     * 工作经验
     */
    private String workExperience;
    /**
     * 薪资
     */
    private String salary;
    /**
     * 地址
     */
    private String address;
    /**
     * 开始时间
     */
    private String startTime;
    /**
     * 结束时间
     */
    private String endTime;
    private String state;

    public CompanyInfo() {
    }

    public CompanyInfo(String iD, String companyName, String logoID, String typeID, String isRecommend, String title, String orgProp, String eduRequire,
                       String workExperience, String salary, String address, String startTime, String endTime, String state) {
        this.iD = iD;
        this.companyName = companyName;
        this.logoID = logoID;
        this.typeID = typeID;
        this.isRecommend = isRecommend;
        this.title = title;
        this.orgProp = orgProp;
        this.eduRequire = eduRequire;
        this.workExperience = workExperience;
        this.salary = salary;
        this.address = address;
        this.startTime = startTime;
        this.endTime = endTime;
        this.state = state;
    }

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLogoID() {
        return logoID;
    }

    public void setLogoID(String logoID) {
        this.logoID = logoID;
    }

    public String getTypeID() {
        return typeID;
    }

    public void setTypeID(String typeID) {
        this.typeID = typeID;
    }

    public String getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(String isRecommend) {
        this.isRecommend = isRecommend;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOrgProp() {
        return orgProp;
    }

    public void setOrgProp(String orgProp) {
        this.orgProp = orgProp;
    }

    public String getEduRequire() {
        return eduRequire;
    }

    public void setEduRequire(String eduRequire) {
        this.eduRequire = eduRequire;
    }

    public String getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompanyInfo that = (CompanyInfo) o;

        if (iD != null ? !iD.equals(that.iD) : that.iD != null) return false;
        if (companyName != null ? !companyName.equals(that.companyName) : that.companyName != null)
            return false;
        if (logoID != null ? !logoID.equals(that.logoID) : that.logoID != null) return false;
        if (typeID != null ? !typeID.equals(that.typeID) : that.typeID != null) return false;
        if (isRecommend != null ? !isRecommend.equals(that.isRecommend) : that.isRecommend != null)
            return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (orgProp != null ? !orgProp.equals(that.orgProp) : that.orgProp != null) return false;
        if (eduRequire != null ? !eduRequire.equals(that.eduRequire) : that.eduRequire != null)
            return false;
        if (workExperience != null ? !workExperience.equals(that.workExperience) : that.workExperience != null)
            return false;
        if (salary != null ? !salary.equals(that.salary) : that.salary != null) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null)
            return false;
        if (endTime != null ? !endTime.equals(that.endTime) : that.endTime != null) return false;
        return state != null ? state.equals(that.state) : that.state == null;

    }

    @Override
    public int hashCode() {
        int result = iD != null ? iD.hashCode() : 0;
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        result = 31 * result + (logoID != null ? logoID.hashCode() : 0);
        result = 31 * result + (typeID != null ? typeID.hashCode() : 0);
        result = 31 * result + (isRecommend != null ? isRecommend.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (orgProp != null ? orgProp.hashCode() : 0);
        result = 31 * result + (eduRequire != null ? eduRequire.hashCode() : 0);
        result = 31 * result + (workExperience != null ? workExperience.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CompanyInfo{" +
                "iD='" + iD + '\'' +
                ", companyName='" + companyName + '\'' +
                ", logoID='" + logoID + '\'' +
                ", typeID='" + typeID + '\'' +
                ", isRecommend='" + isRecommend + '\'' +
                ", title='" + title + '\'' +
                ", orgProp='" + orgProp + '\'' +
                ", eduRequire='" + eduRequire + '\'' +
                ", workExperience='" + workExperience + '\'' +
                ", salary='" + salary + '\'' +
                ", address='" + address + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
