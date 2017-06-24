package com.penglai.kjds.model.index;

import java.io.Serializable;

/**
 * Created by m199 on 2017/6/17.
 * 获取热门推荐请求的信息
 */

public class CompanyInfoReq implements Serializable{
    private String userId;
    private int employType;
    private int isHot;

    public CompanyInfoReq(String userId, int employType, int isHot) {
        this.userId = userId;
        this.employType = employType;
        this.isHot = isHot;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getEmployType() {
        return employType;
    }

    public void setEmployType(int employType) {
        this.employType = employType;
    }

    public int getIsHot() {
        return isHot;
    }

    public void setIsHot(int isHot) {
        this.isHot = isHot;
    }
}
