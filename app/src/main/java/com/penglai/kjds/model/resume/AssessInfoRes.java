package com.penglai.kjds.model.resume;

import java.io.Serializable;

/**
 * Created by m199 on 2017/6/21.
 */

public class AssessInfoRes implements Serializable {
    /**
     * 自我评价ID
     */
    private String assessId;
    /**
     * 评价内容
     */
    private String content;

    public AssessInfoRes() {
    }

    public AssessInfoRes(String assessId, String content) {

        this.assessId = assessId;
        this.content = content;
    }

    public String getAssessId() {
        return assessId;
    }

    public void setAssessId(String assessId) {
        this.assessId = assessId;
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

        AssessInfoRes that = (AssessInfoRes) o;

        if (assessId != null ? !assessId.equals(that.assessId) : that.assessId != null)
            return false;
        return content != null ? content.equals(that.content) : that.content == null;

    }

    @Override
    public int hashCode() {
        int result = assessId != null ? assessId.hashCode() : 0;
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AssessInfoRes{" +
                "assessId='" + assessId + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
