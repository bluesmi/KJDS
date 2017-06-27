package com.penglai.kjds.presenter.implView;

import com.penglai.kjds.model.resume.ResumeRes;

/**
 * Created by m199 on 2017/6/26.
 */

public interface GetResumeInfoView {

    //显示错误信息
    void showError(String error);

    void  getResumeInfoSuccess(ResumeRes resumeRes);
}
