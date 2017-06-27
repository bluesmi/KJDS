package com.penglai.kjds.presenter.impl;

import android.content.Context;

import com.penglai.kjds.http.RequestCallback;
import com.penglai.kjds.http.api.resume.ResumeService;
import com.penglai.kjds.model.BaseRes;
import com.penglai.kjds.model.resume.ResumeRes;
import com.penglai.kjds.presenter.Presenter;
import com.penglai.kjds.presenter.implView.GetResumeInfoView;
import com.penglai.kjds.utils.LogUtils;
import com.penglai.kjds.utils.UiUtils;

/**
 * Created by m199 on 2017/6/26.
 */

public class GetResumeInfoPresenterImpl implements Presenter {
    private Context mContext;
    private GetResumeInfoView resumeInfoView;

    public GetResumeInfoPresenterImpl(Context mContext, GetResumeInfoView resumeInfoView) {
        this.mContext = mContext;
        this.resumeInfoView = resumeInfoView;
    }

    @Override
    public void initialized() {

    }

    public void getResumeInfo(String opSign,String strJson){
        ResumeService.getResumeInfo(opSign, strJson, new RequestCallback<BaseRes<ResumeRes>>() {
            @Override
            public void onSuccess(BaseRes<ResumeRes> resumeResBaseRes) {
                if(resumeResBaseRes ==null){
                    return;
                }
                int code = resumeResBaseRes.getCode();
                String msg = resumeResBaseRes.getMsg();
                ResumeRes data =resumeResBaseRes.getData();
                if(code == 0){        //是否成功登陆
                    LogUtils.error("data 中的数值"+data.toString());

                    resumeInfoView.getResumeInfoSuccess(data);
                }else{
                    UiUtils.showToast(mContext,msg);
                }
            }

            @Override
            public void onFailure(String message) {
                resumeInfoView.showError(message);
            }
        });
    }
}
