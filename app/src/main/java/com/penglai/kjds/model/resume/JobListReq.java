package com.penglai.kjds.model.resume;

import java.io.Serializable;

/**
 * Created by m199 on 2017/6/27.
 */

public class JobListReq implements Serializable {
    private String userId;
    private int employType;
    private String areaId;
    private String industryId;

    public JobListReq(String userId, int employType, String areaId, String industryId) {
        this.userId = userId;
        this.employType = employType;
        this.areaId = areaId;
        this.industryId = industryId;
    }

    public JobListReq() {
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

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public String getIndustryId() {
        return industryId;
    }

    public void setIndustryId(String industryId) {
        this.industryId = industryId;
    }
}
