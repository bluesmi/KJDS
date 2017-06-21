package com.penglai.kjds.model.resume;

import java.io.Serializable;

/**
 * Created by m199 on 2017/6/21.
 */

public class AssessInfoReq implements Serializable {
    /**
     * 评价ID
     */
    private String assessId;
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 自我评价内容
     */
    private String content;

    public AssessInfoReq() {
    }

    public AssessInfoReq(String assessId, String userId, String content) {

        this.assessId = assessId;
        this.userId = userId;
        this.content = content;
    }

    public String getAssessId() {
        return assessId;
    }

    public void setAssessId(String assessId) {
        this.assessId = assessId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AssessInfoReq that = (AssessInfoReq) o;

        if (assessId != null ? !assessId.equals(that.assessId) : that.assessId != null)
            return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        return content != null ? content.equals(that.content) : that.content == null;

    }

    @Override
    public int hashCode() {
        int result = assessId != null ? assessId.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AssessInfoReq{" +
                "assessId='" + assessId + '\'' +
                ", userId='" + userId + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
