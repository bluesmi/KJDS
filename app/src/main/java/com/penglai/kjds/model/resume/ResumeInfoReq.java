package com.penglai.kjds.model.resume;

import java.io.Serializable;

/**
 * Created by m199 on 2017/6/24.
 */

public class ResumeInfoReq implements Serializable {
    private String jobId;
    private String userId;

    public ResumeInfoReq() {
    }

    public ResumeInfoReq(String jobId, String userId) {

        this.jobId = jobId;
        this.userId = userId;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
