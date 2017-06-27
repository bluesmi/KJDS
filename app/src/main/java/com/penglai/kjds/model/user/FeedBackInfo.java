package com.penglai.kjds.model.user;

import java.io.Serializable;

/**
 * Created by m199 on 2017/6/27.
 */

public class FeedBackInfo implements Serializable {
    private String userId;
    private String title;
    private String content;
    private String appInfo;

    public FeedBackInfo(String userId, String title, String content, String appInfo) {
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.appInfo = appInfo;
    }

    public FeedBackInfo() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAppInfo() {
        return appInfo;
    }

    public void setAppInfo(String appInfo) {
        this.appInfo = appInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FeedBackInfo that = (FeedBackInfo) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        return appInfo != null ? appInfo.equals(that.appInfo) : that.appInfo == null;

    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (appInfo != null ? appInfo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "FeedBackInfo{" +
                "userId='" + userId + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", appInfo='" + appInfo + '\'' +
                '}';
    }
}
