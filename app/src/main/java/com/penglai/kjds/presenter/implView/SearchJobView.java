package com.penglai.kjds.presenter.implView;

import com.penglai.kjds.model.index.CompanyInfo;

import java.util.List;

/**
 * Created by m199 on 2017/6/27.
 */

public interface SearchJobView {
    //显示错误信息
    void showError(String error);

    void searchJobListSuccess(List<CompanyInfo> companyInfoList);
}
