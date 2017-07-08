package com.penglai.kjds.model.index;

import java.io.Serializable;

/**
 * Created by m199 on 2017/7/8.
 */

public class TrainInfo implements Serializable {

    private String iD;
    private String user;
    private String photoId;
    private String host;
    private String address;
    private String content;
    private String trainTitle;
    private String statusCode;
    private Double limitNumber;
    private Double partNumber;
    private String publishTime;
    private String startTime;
    private String endTime;
    private String applySTime;
    private String applyETime;
    private String summary;

    public TrainInfo(String iD, String user, String photoId, String host,
                     String address, String content, String trainTitle,
                     String statusCode, Double limitNumber, Double partNumber,
                     String publishTime, String startTime, String endTime,
                     String applySTime, String applyETime, String summary) {
        this.iD = iD;
        this.user = user;
        this.photoId = photoId;
        this.host = host;
        this.address = address;
        this.content = content;
        this.trainTitle = trainTitle;
        this.statusCode = statusCode;
        this.limitNumber = limitNumber;
        this.partNumber = partNumber;
        this.publishTime = publishTime;
        this.startTime = startTime;
        this.endTime = endTime;
        this.applySTime = applySTime;
        this.applyETime = applyETime;
        this.summary = summary;
    }

    public TrainInfo() {
    }

    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTrainTitle() {
        return trainTitle;
    }

    public void setTrainTitle(String trainTitle) {
        this.trainTitle = trainTitle;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Double getLimitNumber() {
        return limitNumber;
    }

    public void setLimitNumber(Double limitNumber) {
        this.limitNumber = limitNumber;
    }

    public Double getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(Double partNumber) {
        this.partNumber = partNumber;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
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

    public String getApplySTime() {
        return applySTime;
    }

    public void setApplySTime(String applySTime) {
        this.applySTime = applySTime;
    }

    public String getApplyETime() {
        return applyETime;
    }

    public void setApplyETime(String applyETime) {
        this.applyETime = applyETime;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TrainInfo trainInfo = (TrainInfo) o;

        if (iD != null ? !iD.equals(trainInfo.iD) : trainInfo.iD != null) return false;
        if (user != null ? !user.equals(trainInfo.user) : trainInfo.user != null) return false;
        if (photoId != null ? !photoId.equals(trainInfo.photoId) : trainInfo.photoId != null)
            return false;
        if (host != null ? !host.equals(trainInfo.host) : trainInfo.host != null) return false;
        if (address != null ? !address.equals(trainInfo.address) : trainInfo.address != null)
            return false;
        if (content != null ? !content.equals(trainInfo.content) : trainInfo.content != null)
            return false;
        if (trainTitle != null ? !trainTitle.equals(trainInfo.trainTitle) : trainInfo.trainTitle != null)
            return false;
        if (statusCode != null ? !statusCode.equals(trainInfo.statusCode) : trainInfo.statusCode != null)
            return false;
        if (limitNumber != null ? !limitNumber.equals(trainInfo.limitNumber) : trainInfo.limitNumber != null)
            return false;
        if (partNumber != null ? !partNumber.equals(trainInfo.partNumber) : trainInfo.partNumber != null)
            return false;
        if (publishTime != null ? !publishTime.equals(trainInfo.publishTime) : trainInfo.publishTime != null)
            return false;
        if (startTime != null ? !startTime.equals(trainInfo.startTime) : trainInfo.startTime != null)
            return false;
        if (endTime != null ? !endTime.equals(trainInfo.endTime) : trainInfo.endTime != null)
            return false;
        if (applySTime != null ? !applySTime.equals(trainInfo.applySTime) : trainInfo.applySTime != null)
            return false;
        if (applyETime != null ? !applyETime.equals(trainInfo.applyETime) : trainInfo.applyETime != null)
            return false;
        return summary != null ? summary.equals(trainInfo.summary) : trainInfo.summary == null;

    }

    @Override
    public int hashCode() {
        int result = iD != null ? iD.hashCode() : 0;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (photoId != null ? photoId.hashCode() : 0);
        result = 31 * result + (host != null ? host.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (trainTitle != null ? trainTitle.hashCode() : 0);
        result = 31 * result + (statusCode != null ? statusCode.hashCode() : 0);
        result = 31 * result + (limitNumber != null ? limitNumber.hashCode() : 0);
        result = 31 * result + (partNumber != null ? partNumber.hashCode() : 0);
        result = 31 * result + (publishTime != null ? publishTime.hashCode() : 0);
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        result = 31 * result + (applySTime != null ? applySTime.hashCode() : 0);
        result = 31 * result + (applyETime != null ? applyETime.hashCode() : 0);
        result = 31 * result + (summary != null ? summary.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TrainInfo{" +
                "iD='" + iD + '\'' +
                ", user='" + user + '\'' +
                ", photoId='" + photoId + '\'' +
                ", host='" + host + '\'' +
                ", address='" + address + '\'' +
                ", content='" + content + '\'' +
                ", trainTitle='" + trainTitle + '\'' +
                ", statusCode='" + statusCode + '\'' +
                ", limitNumber=" + limitNumber +
                ", partNumber=" + partNumber +
                ", publishTime='" + publishTime + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", applySTime='" + applySTime + '\'' +
                ", applyETime='" + applyETime + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }
}
