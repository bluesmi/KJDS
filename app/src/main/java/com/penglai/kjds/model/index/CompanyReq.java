package com.penglai.kjds.model.index;

import java.io.Serializable;

/**
 * Created by m199 on 2017/6/24.
 * 公司信息请求
 */

public class CompanyReq implements Serializable {
    private String companyId;

    public CompanyReq() {
    }

    public CompanyReq(String companyId) {

        this.companyId = companyId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }
}
