package com.penglai.kjds.model.resume;

import java.io.Serializable;

/**
 * Created by m199 on 2017/6/28.
 */

public class DelWorkExpReq implements Serializable {
    private String workExpId;

    public DelWorkExpReq(String workExpId) {
        this.workExpId = workExpId;
    }

    public DelWorkExpReq() {
    }

    public String getWorkExpId() {
        return workExpId;
    }

    public void setWorkExpId(String workExpId) {
        this.workExpId = workExpId;
    }
}
