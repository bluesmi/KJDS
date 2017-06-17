package com.penglai.kjds.presenter.implView;

import com.penglai.kjds.model.resume.PersionInfo;

/**
 * Created by m199 on 2017/6/16.
 */

public interface GetPersionInfoView {
    //显示错误信息
    void showError(String error);

    /**
     * 显示简历中个人基本信息
     * @param persionInfo
     */
    void showPersionInfo(PersionInfo persionInfo);
}
