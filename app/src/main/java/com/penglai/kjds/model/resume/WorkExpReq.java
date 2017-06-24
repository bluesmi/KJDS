package com.penglai.kjds.model.resume;

import java.io.Serializable;

/**
 * Created by m199 on 2017/6/24.
 */

public class WorkExpReq implements Serializable {
    private String workExpId;

    public WorkExpReq() {
    }

    public WorkExpReq(String workExpId) {

        this.workExpId = workExpId;
    }

    public String getWorkExpId() {
        return workExpId;
    }

    public void setWorkExpId(String workExpId) {
        this.workExpId = workExpId;
    }
}
