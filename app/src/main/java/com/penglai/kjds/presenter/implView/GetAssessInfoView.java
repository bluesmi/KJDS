package com.penglai.kjds.presenter.implView;

import com.penglai.kjds.model.resume.AssessInfoRes;

/**
 * Created by m199 on 2017/6/21.
 */

public interface GetAssessInfoView {
    /**
     * 显示错误信息
     * @param message
     */
    void showError(String message);

    void getAssessInfoSuccess(AssessInfoRes assessInfoRes);
}
