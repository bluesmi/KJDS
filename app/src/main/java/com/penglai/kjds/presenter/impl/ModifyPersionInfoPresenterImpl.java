package com.penglai.kjds.presenter.impl;

import android.content.Context;

import com.penglai.kjds.http.RequestCallback;
import com.penglai.kjds.http.api.resume.ResumeService;
import com.penglai.kjds.model.BaseRes;
import com.penglai.kjds.presenter.Presenter;
import com.penglai.kjds.presenter.implView.ModifyPersionInfoView;
import com.penglai.kjds.utils.LogUtils;
import com.penglai.kjds.utils.UiUtils;

/**
 * Created by m199 on 2017/6/20.
 */

public class ModifyPersionInfoPresenterImpl implements Presenter {
    private Context context;
    private ModifyPersionInfoView modifyPersionInfoView;

    public ModifyPersionInfoPresenterImpl(Context context, ModifyPersionInfoView modifyPersionInfoView) {
        this.context = context;
        this.modifyPersionInfoView = modifyPersionInfoView;
    }

    @Override
    public void initialized() {

    }
    public void modifyPersionInfo(String opSign, String strJson){
        ResumeService.modifyPersionInfo(opSign, strJson, new RequestCallback<BaseRes<String>>() {
            @Override
            public void onSuccess(BaseRes<String> stringBaseRes) {
                if(stringBaseRes ==null){
                    return;
                }
                int code = stringBaseRes.getCode();
                String msg = stringBaseRes.getMsg();
                LogUtils.error("code","响应码"+code);
                if(0 == code){
                    modifyPersionInfoView.modifyPersionInfoSuccess();
                }else {
                    UiUtils.showToast(context,msg);
                }
            }

            @Override
            public void onFailure(String message) {

            }
        });
    }
}
