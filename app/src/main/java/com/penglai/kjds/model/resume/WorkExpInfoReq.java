package com.penglai.kjds.model.resume;

import java.io.Serializable;

/**
 * Created by m199 on 2017/6/22.
 */

public class WorkExpInfoReq implements Serializable {
    /**
     * 教育背景Id（ID为空时为新增）
     */
    private String id;
    /**
     * 公司名称
     */
    private String companyName;
    /**
     * 岗位/职位名称
     */
    private String position;
    /**
     * 开始时间
     */
    private String startTime;
    /**
     * 结束时间
     */
    private String endTime;
    /**
     * 工作描述
     */
    private String workContent;
    /**
     * 用户ID
     */
    private String userId;

    public WorkExpInfoReq(String id, String companyName, String position,
                          String startTime, String endTime, String workContent, String userId) {
        this.id = id;
        this.companyName = companyName;
        this.position = position;
        this.startTime = startTime;
        this.endTime = endTime;
        this.workContent = workContent;
        this.userId = userId;
    }

    public WorkExpInfoReq() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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

    public String getWorkContent() {
        return workContent;
    }

    public void setWorkContent(String workContent) {
        this.workContent = workContent;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WorkExpInfoReq that = (WorkExpInfoReq) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (companyName != null ? !companyName.equals(that.companyName) : that.companyName != null)
            return false;
        if (position != null ? !position.equals(that.position) : that.position != null)
            return false;
        if (startTime != null ? !startTime.equals(that.startTime) : that.startTime != null)
            return false;
        if (endTime != null ? !endTime.equals(that.endTime) : that.endTime != null) return false;
        if (workContent != null ? !workContent.equals(that.workContent) : that.workContent != null)
            return false;
        return userId != null ? userId.equals(that.userId) : that.userId == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (companyName != null ? companyName.hashCode() : 0);
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (workContent != null ? workContent.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "WorkExpInfoReq{" +
                "id='" + id + '\'' +
                ", companyName='" + companyName + '\'' +
                ", position='" + position + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", workContent='" + workContent + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
