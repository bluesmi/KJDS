package com.penglai.kjds.model.resume;

import java.io.Serializable;

/**
 * Created by m199 on 2017/6/20.
 * 教育背景信息
 */

public class EduBgInfo implements Serializable{
    private String ID;
    private String UserID;
    private String SchoolName;
    private String Academy;
    private String Professional;
    private String StartTime;
    private String EndTime;

    public EduBgInfo(String ID, String userID, String schoolName,
                     String academy, String professional, String startTime, String endTime) {
        this.ID = ID;
        UserID = userID;
        SchoolName = schoolName;
        Academy = academy;
        Professional = professional;
        StartTime = startTime;
        EndTime = endTime;
    }

    public EduBgInfo() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getSchoolName() {
        return SchoolName;
    }

    public void setSchoolName(String schoolName) {
        SchoolName = schoolName;
    }

    public String getAcademy() {
        return Academy;
    }

    public void setAcademy(String academy) {
        Academy = academy;
    }

    public String getProfessional() {
        return Professional;
    }

    public void setProfessional(String professional) {
        Professional = professional;
    }

    public String getStartTime() {
        return StartTime;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }

    public String getEndTime() {
        return EndTime;
    }

    public void setEndTime(String endTime) {
        EndTime = endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EduBgInfo eduBgInfo = (EduBgInfo) o;

        if (ID != null ? !ID.equals(eduBgInfo.ID) : eduBgInfo.ID != null) return false;
        if (UserID != null ? !UserID.equals(eduBgInfo.UserID) : eduBgInfo.UserID != null)
            return false;
        if (SchoolName != null ? !SchoolName.equals(eduBgInfo.SchoolName) : eduBgInfo.SchoolName != null)
            return false;
        if (Academy != null ? !Academy.equals(eduBgInfo.Academy) : eduBgInfo.Academy != null)
            return false;
        if (Professional != null ? !Professional.equals(eduBgInfo.Professional) : eduBgInfo.Professional != null)
            return false;
        if (StartTime != null ? !StartTime.equals(eduBgInfo.StartTime) : eduBgInfo.StartTime != null)
            return false;
        return EndTime != null ? EndTime.equals(eduBgInfo.EndTime) : eduBgInfo.EndTime == null;

    }

    @Override
    public int hashCode() {
        int result = ID != null ? ID.hashCode() : 0;
        result = 31 * result + (UserID != null ? UserID.hashCode() : 0);
        result = 31 * result + (SchoolName != null ? SchoolName.hashCode() : 0);
        result = 31 * result + (Academy != null ? Academy.hashCode() : 0);
        result = 31 * result + (Professional != null ? Professional.hashCode() : 0);
        result = 31 * result + (StartTime != null ? StartTime.hashCode() : 0);
        result = 31 * result + (EndTime != null ? EndTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "EduBgInfo{" +
                "ID='" + ID + '\'' +
                ", UserID='" + UserID + '\'' +
                ", SchoolName='" + SchoolName + '\'' +
                ", Academy='" + Academy + '\'' +
                ", Professional='" + Professional + '\'' +
                ", StartTime='" + StartTime + '\'' +
                ", EndTime='" + EndTime + '\'' +
                '}';
    }
}
