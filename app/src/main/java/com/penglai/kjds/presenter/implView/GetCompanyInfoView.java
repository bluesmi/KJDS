package com.penglai.kjds.presenter.implView;

import com.penglai.kjds.model.index.Company;



/**
 * Created by m199 on 2017/6/24.
 */

public interface GetCompanyInfoView {
    /**
     * 显示错误信息
     * @param message
     */
    void showError(String message);

    void getCompanyInfoSuccess(Company company);
}
