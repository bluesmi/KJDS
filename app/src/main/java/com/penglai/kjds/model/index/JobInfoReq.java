package com.penglai.kjds.model.index;

import java.io.Serializable;

/**
 * Created by m199 on 2017/6/21.
 */

public class JobInfoReq implements Serializable{
     private String jobId;

    public JobInfoReq() {
    }

    public JobInfoReq(String jobId) {

        this.jobId = jobId;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }
}
