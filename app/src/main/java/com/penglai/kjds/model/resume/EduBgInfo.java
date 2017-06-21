package com.penglai.kjds.model.resume;

import java.io.Serializable;

/**
 * Created by m199 on 2017/6/20.
 * 教育背景信息
 */

public class EduBgInfo implements Serializable{
    private String id;
    private String userId;
    private String schoolName;
    private String academy;
    private String professional;
    private String startTime;
    private String endTime;


    public EduBgInfo(String id, String userId,
                     String schoolName, String academy, String professional, String startTime, String endTime) {
        this.id = id;
        this.userId = userId;
        this.schoolName = schoolName;
        this.academy = academy;
        this.professional = professional;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public EduBgInfo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EduBgInfo eduBgInfo = (EduBgInfo) o;

        if (id != null ? !id.equals(eduBgInfo.id) : eduBgInfo.id != null) return false;
        if (userId != null ? !userId.equals(eduBgInfo.userId) : eduBgInfo.userId != null)
            return false;
        if (schoolName != null ? !schoolName.equals(eduBgInfo.schoolName) : eduBgInfo.schoolName != null)
            return false;
        if (academy != null ? !academy.equals(eduBgInfo.academy) : eduBgInfo.academy != null)
            return false;
        if (professional != null ? !professional.equals(eduBgInfo.professional) : eduBgInfo.professional != null)
            return false;
        if (startTime != null ? !startTime.equals(eduBgInfo.startTime) : eduBgInfo.startTime != null)
            return false;
        return endTime != null ? endTime.equals(eduBgInfo.endTime) : eduBgInfo.endTime == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (schoolName != null ? schoolName.hashCode() : 0);
        result = 31 * result + (academy != null ? academy.hashCode() : 0);
        result = 31 * result + (professional != null ? professional.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "EduBgInfo{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", schoolName='" + schoolName + '\'' +
                ", academy='" + academy + '\'' +
                ", professional='" + professional + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}
