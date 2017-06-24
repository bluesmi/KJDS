package com.penglai.kjds.presenter.impl;

import android.content.Context;

import com.penglai.kjds.http.RequestCallback;
import com.penglai.kjds.http.api.resume.ResumeService;
import com.penglai.kjds.model.BaseRes;
import com.penglai.kjds.presenter.Presenter;
import com.penglai.kjds.presenter.implView.SendResumeInfoView;
import com.penglai.kjds.utils.LogUtils;
import com.penglai.kjds.utils.UiUtils;

/**
 * Created by m199 on 2017/6/24.
 */

public class SendResumeInfoPresenterImpl  implements Presenter {
    private Context mContext;
    private SendResumeInfoView sendResumeInfoView;

    public SendResumeInfoPresenterImpl(Context mContext, SendResumeInfoView sendResumeInfoView) {
        this.mContext = mContext;
        this.sendResumeInfoView = sendResumeInfoView;
    }

    @Override
    public void initialized() {

    }

    public  void setResumeInfo(String opSign,String strJson){
        ResumeService.setResumeInfo(opSign, strJson, new RequestCallback<BaseRes<String>>() {
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
                    sendResumeInfoView.sendResumeSuccess(data);
                }else{
                    UiUtils.showToast(mContext,msg);
                }
            }

            @Override
            public void onFailure(String message) {
                sendResumeInfoView.showError(message);
            }
        });
    }
}
