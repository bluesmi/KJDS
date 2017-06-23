package com.penglai.kjds.presenter.impl;

import android.content.Context;

import com.penglai.kjds.http.RequestCallback;
import com.penglai.kjds.http.api.resume.ResumeService;
import com.penglai.kjds.model.BaseRes;
import com.penglai.kjds.presenter.Presenter;
import com.penglai.kjds.presenter.implView.ModifyWorkExpInfoView;
import com.penglai.kjds.utils.LogUtils;
import com.penglai.kjds.utils.UiUtils;

import java.util.List;

/**
 * Created by m199 on 2017/6/22.
 */

public class ModifyWorkExpInfoPresenterImpl implements Presenter {
    private Context mContext;
    private ModifyWorkExpInfoView workExpInfoView;

    public ModifyWorkExpInfoPresenterImpl(Context mContext, ModifyWorkExpInfoView workExpInfoView) {
        this.mContext = mContext;
        this.workExpInfoView = workExpInfoView;
    }

    @Override
    public void initialized() {

    }

    public void modifyWorkExpInfo(String opSign,String strJson){
        ResumeService.modifyWorkExpInfo(opSign, strJson, new RequestCallback<BaseRes<String>>() {
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
                   workExpInfoView.modifyWorkExpInfoSuccess();
                }else{
                    UiUtils.showToast(mContext,msg);
                }
            }

            @Override
            public void onFailure(String message) {
                workExpInfoView.showError(message);
            }
        });
    }
}
