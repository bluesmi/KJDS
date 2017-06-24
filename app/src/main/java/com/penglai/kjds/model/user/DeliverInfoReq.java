package com.penglai.kjds.model.user;

import java.io.Serializable;

/**
 * Created by m199 on 2017/6/24.
 */

public class DeliverInfoReq implements Serializable {
    private String userId;
    private int type;

    public DeliverInfoReq(String userId, int type) {
        this.userId = userId;
        this.type = type;
    }

    public DeliverInfoReq() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

}
