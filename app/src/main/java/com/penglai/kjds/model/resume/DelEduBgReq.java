package com.penglai.kjds.model.resume;

import java.io.Serializable;

/**
 * Created by m199 on 2017/6/28.
 */

public class DelEduBgReq implements Serializable {
    private String eduBgId;

    public DelEduBgReq(String eduBgId) {
        this.eduBgId = eduBgId;
    }

    public DelEduBgReq() {
    }

    public String getEduBgId() {
        return eduBgId;
    }

    public void setEduBgId(String eduBgId) {
        this.eduBgId = eduBgId;
    }
}
