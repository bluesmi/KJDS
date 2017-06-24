package com.penglai.kjds.model.index;

import java.io.Serializable;

/**
 * Created by m199 on 2017/6/21.
 */

public class JobDetail implements Serializable{

    /**
     *招聘id
     */
    private String iD;

    /**
     *招聘类型，0全部1 兼职、2全职，3项目
     */
    private String typeID;
    /**
     *是否推荐(True:推荐 False：不推荐 )
     */
    private String isRecommend;
    /**
     *职务/岗位名称
     */
    private String title;
    /**
     *学历/学位
     */
    private String eduRequire;
    /**
     *工作经验
     */
    private String workExperience;
    /**
     *薪资
     */
    private String salary;
    /**
     *地址
     */
    private String address;
    /**
     *开始时间
     */
    private String startTime;
    /**
     *结束时间
     */
    private String endTime;
    /**
     *公司名称
     */
    private String companyName;
    /**
     *公司logo地址
     */
    private String logoID;
    /**
     *公司ID
     */
    private String companyId;
    /**
     *公司人数
     */
    private String companyNumber;
    /**
     *公司联系电话
     */
    private String companyphone;
    /**
     *公司地址
     */
    private String companyAddress;
    /**
     *公司介绍
     */
    private String introduction;
    /**
     *公司类型（1：私企，2国企）
     */
    private String orgProp;
    /**
     * 岗位职责
     */
    private String jobResp;
    /**
     * 岗位要求
     */
    private String employDesc;
    /**
     * 职业诱惑
     */
    private String employAtract;

    public JobDetail(String iD, String typeID, String isRecommend, String title, String eduRequire,
                     String workExperience, String salary, String address, String startTime, String endTime,
                     String companyName, String logoID, String companyId, String companyNumber, String companyphone,
                     String companyAddress, String introduction, String orgProp, String jobResp,
                     String employDesc, String employAtract) {
        this.iD = iD;
        this.typeID = typeID;
        this.isRecommend = isRecommend;
        this.title = title;
        this.eduRequire = eduRequire;
        this.workExperience = workExperience;
        this.salary = salary;
        this.address = address;
        this.startTime = startTime;
        this.endTime = endTime;
        this.companyName = companyName;
        this.logoID = logoID;
        this.companyId = companyId;
        this.companyNumber = companyNumber;
        this.companyphone = companyphone;
        this.companyAddress = companyAddress;
        this.introduction = introduction;
        this.orgProp = orgProp;
        this.jobResp = jobResp;
        this.employDesc = employDesc;
        this.employAtract = employAtract;
    }

    public JobDetail() {
    }

    public String getJobResp() {
        return jobResp;
    }

    public void setJobResp(String jobResp) {
        this.jobResp = jobResp;
    }

    public String getEmployDesc() {
        return employDesc;
    }

    public void setEmployDesc(String employDesc) {
        this.employDesc = employDesc;
    }

    public String getEmployAtract() {
        return employAtract;
    }

    public void setEmployAtract(String employAtract) {
        this.employAtract = employAtract;
    }

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
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

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyNumber() {
        return companyNumber;
    }

    public void setCompanyNumber(String companyNumber) {
        this.companyNumber = companyNumber;
    }

    public String getCompanyphone() {
        return companyphone;
    }

    public void setCompanyphone(String companyphone) {
        this.companyphone = companyphone;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getOrgProp() {
        return orgProp;
    }

    public void setOrgProp(String orgProp) {
        this.orgProp = orgProp;
    }

    @Override
    public String toString() {
        return "JobDetail{" +
                "iD='" + iD + '\'' +
                ", typeID='" + typeID + '\'' +
                ", isRecommend='" + isRecommend + '\'' +
                ", title='" + title + '\'' +
                ", eduRequire='" + eduRequire + '\'' +
                ", workExperience='" + workExperience + '\'' +
                ", salary='" + salary + '\'' +
                ", address='" + address + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", companyName='" + companyName + '\'' +
                ", logoID='" + logoID + '\'' +
                ", companyId='" + companyId + '\'' +
                ", companyNumber='" + companyNumber + '\'' +
                ", companyphone='" + companyphone + '\'' +
                ", companyAddress='" + companyAddress + '\'' +
                ", introduction='" + introduction + '\'' +
                ", orgProp='" + orgProp + '\'' +
                ", jobResp='" + jobResp + '\'' +
                ", employDesc='" + employDesc + '\'' +
                ", employAtract='" + employAtract + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        JobDetail jobDetail = (JobDetail) o;

        if (iD != null ? !iD.equals(jobDetail.iD) : jobDetail.iD != null) return false;
        if (typeID != null ? !typeID.equals(jobDetail.typeID) : jobDetail.typeID != null)
            return false;
        if (isRecommend != null ? !isRecommend.equals(jobDetail.isRecommend) : jobDetail.isRecommend != null)
            return false;
        if (title != null ? !title.equals(jobDetail.title) : jobDetail.title != null) return false;
        if (eduRequire != null ? !eduRequire.equals(jobDetail.eduRequire) : jobDetail.eduRequire != null)
            return false;
        if (workExperience != null ? !workExperience.equals(jobDetail.workExperience) : jobDetail.workExperience != null)
            return false;
        if (salary != null ? !salary.equals(jobDetail.salary) : jobDetail.salary != null)
            return false;
        if (address != null ? !address.equals(jobDetail.address) : jobDetail.address != null)
            return false;
        if (startTime != null ? !startTime.equals(jobDetail.startTime) : jobDetail.startTime != null)
            return false;
        if (endTime != null ? !endTime.equals(jobDetail.endTime) : jobDetail.endTime != null)
            return false;
        if (companyName != null ? !companyName.equals(jobDetail.companyName) : jobDetail.companyName != null)
            return false;
        if (logoID != null ? !logoID.equals(jobDetail.logoID) : jobDetail.logoID != null)
            return false;
        if (companyId != null ? !companyId.equals(jobDetail.companyId) : jobDetail.companyId != null)
            return false;
        if (companyNumber != null ? !companyNumber.equals(jobDetail.companyNumber) : jobDetail.companyNumber != null)
            return false;
        if (companyphone != null ? !companyphone.equals(jobDetail.companyphone) : jobDetail.companyphone != null)
            return false;
        if (companyAddress != null ? !companyAddress.equals(jobDetail.companyAddress) : jobDetail.companyAddress != null)
            return false;
        if (introduction != null ? !introduction.equals(jobDetail.introduction) : jobDetail.introduction != null)
            return false;
        if (orgProp != null ? !orgProp.equals(jobDetail.orgProp) : jobDetail.orgProp != null)
            return false;
        if (jobResp != null ? !jobResp.equals(jobDetail.jobResp) : jobDetail.jobResp != null)
            return false;
        if (employDesc != null ? !employDesc.equals(jobDetail.employDesc) : jobDetail.employDesc != null)
            return false;
        return employAtract != null ? employAtract.equals(jobDetail.employAtract) : jobDetail.employAtract == null;

    }

    @Override
    public int hashCode() {
        int result = iD != null ? iD.hashCode() : 0;
        result = 31 * result + (typeID != null ? typeID.hashCode() : 0);
        result = 31 * result + (isRecommend != null ? isRecommend.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (eduRequire != null ? eduRequire.hashCode() : 0);
        result = 31 * result + (workExperience != null ? workExperience.hashCode() : 0);
        result = 31 * result + (salary != null ? salary.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        result = 31 * result + (logoID != null ? logoID.hashCode() : 0);
        result = 31 * result + (companyId != null ? companyId.hashCode() : 0);
        result = 31 * result + (companyNumber != null ? companyNumber.hashCode() : 0);
        result = 31 * result + (companyphone != null ? companyphone.hashCode() : 0);
        result = 31 * result + (companyAddress != null ? companyAddress.hashCode() : 0);
        result = 31 * result + (introduction != null ? introduction.hashCode() : 0);
        result = 31 * result + (orgProp != null ? orgProp.hashCode() : 0);
        result = 31 * result + (jobResp != null ? jobResp.hashCode() : 0);
        result = 31 * result + (employDesc != null ? employDesc.hashCode() : 0);
        result = 31 * result + (employAtract != null ? employAtract.hashCode() : 0);
        return result;
    }

}
