package com.penglai.kjds.presenter.impl;

import android.content.Context;

import com.penglai.kjds.http.RequestCallback;
import com.penglai.kjds.http.api.index.IndexService;
import com.penglai.kjds.model.BaseRes;
import com.penglai.kjds.model.index.JobDetail;
import com.penglai.kjds.presenter.Presenter;
import com.penglai.kjds.presenter.implView.GetJobDetailView;
import com.penglai.kjds.utils.LogUtils;
import com.penglai.kjds.utils.UiUtils;

/**
 * Created by m199 on 2017/6/22.
 */

public class GetJobDetailPresenterImpl implements Presenter {

    private Context mContext;
    private GetJobDetailView  jobDetailView;

    public GetJobDetailPresenterImpl(Context mContext, GetJobDetailView jobDetailView) {
        this.mContext = mContext;
        this.jobDetailView = jobDetailView;
    }

    @Override
    public void initialized() {

    }

    public  void getJobDetail(String opSign, String strJson){
        IndexService.getJobDetail(opSign, strJson, new RequestCallback<BaseRes<JobDetail>>() {
            @Override
            public void onSuccess(BaseRes<JobDetail> jobDetailBaseRes) {
                if(jobDetailBaseRes ==null){
                    return;
                }
                int code = jobDetailBaseRes.getCode();
                String msg = jobDetailBaseRes.getMsg();
                JobDetail jobDetail = jobDetailBaseRes.getData();
                if(code == 0){        //是否成功登陆
                    LogUtils.error("data 中的数值"+jobDetail);

                    jobDetailView.getJobDetailSuccess(jobDetail);
                }else{
                    UiUtils.showToast(mContext,msg);
                }
            }

            @Override
            public void onFailure(String message) {
                jobDetailView.showError(message);
            }
        });
    }
}
