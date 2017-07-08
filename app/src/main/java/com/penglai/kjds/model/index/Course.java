package com.penglai.kjds.model.index;

import java.io.Serializable;

/**
 * Created by m199 on 2017/7/7.
 *
 * 课程实体类
 */

public class Course implements Serializable {

    // 主键
    private String iD;
    // 课程级别ID（0初级1中级2高级）
    private String levelId;

    // 图片ID
    private String photoId;

    // 课程大纲名称
    private String courseName;

    // 制定时间
    private String setTime;

    // 状态
    private double statusCode;

    // 开始时间
    private String startTime;

    // 结束时间
    private String endTime;

    // 期数（1，2，3，4）
    private double serialNum;
    // 上一期课程ID 若无则为0
    private String preCourse;
    // 是否有考试
    private boolean isTest;
    // 课程描述
    private String desc;
    // 课程创始人
    private String createCourseUser;


    public Course(String iD, String levelId, String photoId, String courseName, String setTime, double statusCode,
                  String startTime, String endTime, double serialNum, String preCourse, boolean isTest,
                  String desc, String createCourseUser) {
        this.iD = iD;
        this.levelId = levelId;
        this.photoId = photoId;
        this.courseName = courseName;
        this.setTime = setTime;
        this.statusCode = statusCode;
        this.startTime = startTime;
        this.endTime = endTime;
        this.serialNum = serialNum;
        this.preCourse = preCourse;
        this.isTest = isTest;
        this.desc = desc;
        this.createCourseUser = createCourseUser;
    }

    public Course() {
    }


    public String getiD() {
        return iD;
    }

    public void setiD(String iD) {
        this.iD = iD;
    }

    public String getLevelId() {
        return levelId;
    }

    public void setLevelId(String levelId) {
        this.levelId = levelId;
    }

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getSetTime() {
        return setTime;
    }

    public void setSetTime(String setTime) {
        this.setTime = setTime;
    }

    public double getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(double statusCode) {
        this.statusCode = statusCode;
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

    public double getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(double serialNum) {
        this.serialNum = serialNum;
    }

    public String getPreCourse() {
        return preCourse;
    }

    public void setPreCourse(String preCourse) {
        this.preCourse = preCourse;
    }

    public boolean isTest() {
        return isTest;
    }

    public void setTest(boolean test) {
        isTest = test;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCreateCourseUser() {
        return createCourseUser;
    }

    public void setCreateCourseUser(String createCourseUser) {
        this.createCourseUser = createCourseUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (Double.compare(course.statusCode, statusCode) != 0) return false;
        if (Double.compare(course.serialNum, serialNum) != 0) return false;
        if (isTest != course.isTest) return false;
        if (iD != null ? !iD.equals(course.iD) : course.iD != null) return false;
        if (levelId != null ? !levelId.equals(course.levelId) : course.levelId != null)
            return false;
        if (photoId != null ? !photoId.equals(course.photoId) : course.photoId != null)
            return false;
        if (courseName != null ? !courseName.equals(course.courseName) : course.courseName != null)
            return false;
        if (setTime != null ? !setTime.equals(course.setTime) : course.setTime != null)
            return false;
        if (startTime != null ? !startTime.equals(course.startTime) : course.startTime != null)
            return false;
        if (endTime != null ? !endTime.equals(course.endTime) : course.endTime != null)
            return false;
        if (preCourse != null ? !preCourse.equals(course.preCourse) : course.preCourse != null)
            return false;
        if (desc != null ? !desc.equals(course.desc) : course.desc != null) return false;
        return createCourseUser != null ? createCourseUser.equals(course.createCourseUser) : course.createCourseUser == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = iD != null ? iD.hashCode() : 0;
        result = 31 * result + (levelId != null ? levelId.hashCode() : 0);
        result = 31 * result + (photoId != null ? photoId.hashCode() : 0);
        result = 31 * result + (courseName != null ? courseName.hashCode() : 0);
        result = 31 * result + (setTime != null ? setTime.hashCode() : 0);
        temp = Double.doubleToLongBits(statusCode);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (startTime != null ? startTime.hashCode() : 0);
        result = 31 * result + (endTime != null ? endTime.hashCode() : 0);
        temp = Double.doubleToLongBits(serialNum);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (preCourse != null ? preCourse.hashCode() : 0);
        result = 31 * result + (isTest ? 1 : 0);
        result = 31 * result + (desc != null ? desc.hashCode() : 0);
        result = 31 * result + (createCourseUser != null ? createCourseUser.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Course{" +
                "iD='" + iD + '\'' +
                ", levelId='" + levelId + '\'' +
                ", photoId='" + photoId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", setTime='" + setTime + '\'' +
                ", statusCode=" + statusCode +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", serialNum=" + serialNum +
                ", preCourse='" + preCourse + '\'' +
                ", isTest=" + isTest +
                ", desc='" + desc + '\'' +
                ", createCourseUser='" + createCourseUser + '\'' +
                '}';
    }
}
