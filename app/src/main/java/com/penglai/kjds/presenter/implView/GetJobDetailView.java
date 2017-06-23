package com.penglai.kjds.presenter.implView;

import com.penglai.kjds.model.index.JobDetail;

/**
 * Created by m199 on 2017/6/22.
 */

public interface GetJobDetailView {
    //显示错误信息
    void showError(String error);


    /**
     * 获取工作详情成功
     * @param jobDetail
     */
    void getJobDetailSuccess(JobDetail jobDetail);
}
