package com.penglai.kjds.presenter.impl;

import android.content.Context;

import com.penglai.kjds.http.RequestCallback;
import com.penglai.kjds.http.api.resume.ResumeService;
import com.penglai.kjds.model.BaseRes;
import com.penglai.kjds.presenter.Presenter;
import com.penglai.kjds.presenter.implView.JobFavoriteView;
import com.penglai.kjds.utils.LogUtils;
import com.penglai.kjds.utils.UiUtils;

/**
 * Created by m199 on 2017/6/24.
 */

public class JobFavoritePresenterImpl implements Presenter {
    private Context mContext;
    private JobFavoriteView jobFavoriteView;

    public JobFavoritePresenterImpl(Context mContext, JobFavoriteView jobFavoriteView) {
        this.mContext = mContext;
        this.jobFavoriteView = jobFavoriteView;
    }

    @Override
    public void initialized() {

    }

    public  void jobFavorite(String opSign,String strJson){
        ResumeService.jobFavorite(opSign, strJson, new RequestCallback<BaseRes<String>>() {
            @Override
            public void onSuccess(BaseRes<String> stringBaseRes) {
                if(stringBaseRes ==null){
                    return;
                }
                int code = stringBaseRes.getCode();
                String msg = stringBaseRes.getMsg();
                String data = stringBaseRes.getData();
                if(code == 0){        //是否成功登陆
                    LogUtils.error("data 中的数值"+data);
                    jobFavoriteView.collectSuccess();
                }else{
                    UiUtils.showToast(mContext,msg);
                }
            }

            @Override
            public void onFailure(String message) {
                jobFavoriteView.showError(message);
            }
        });
    }
}
