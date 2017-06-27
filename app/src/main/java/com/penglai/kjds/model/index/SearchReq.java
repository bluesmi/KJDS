package com.penglai.kjds.model.index;

import java.io.Serializable;

/**
 * Created by m199 on 2017/6/27.
 */

public class SearchReq implements Serializable {

    private String userId;
    private String keyValue;

    public SearchReq() {
    }

    public SearchReq(String userId, String keyValue) {

        this.userId = userId;
        this.keyValue = keyValue;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }
}
