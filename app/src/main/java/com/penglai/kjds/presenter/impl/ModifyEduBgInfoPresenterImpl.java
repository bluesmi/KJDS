package com.penglai.kjds.presenter.impl;

import android.content.Context;

import com.penglai.kjds.http.RequestCallback;
import com.penglai.kjds.http.api.resume.ResumeService;
import com.penglai.kjds.model.BaseRes;
import com.penglai.kjds.presenter.Presenter;
import com.penglai.kjds.presenter.implView.ModifyEduBgInfoView;
import com.penglai.kjds.utils.LogUtils;
import com.penglai.kjds.utils.UiUtils;

/**
 * Created by m199 on 2017/6/21.
 */

public class ModifyEduBgInfoPresenterImpl implements Presenter {


    private Context mContext;

    private ModifyEduBgInfoView modifyEduBgInfoView;

    public ModifyEduBgInfoPresenterImpl(Context mContext, ModifyEduBgInfoView modifyEduBgInfoView) {
        this.mContext = mContext;
        this.modifyEduBgInfoView = modifyEduBgInfoView;
    }

    @Override
    public void initialized() {

    }

    public void modifyEduBgInfo(String opSign,String strJson){
        ResumeService.modifyEduBgInfo(opSign, strJson, new RequestCallback<BaseRes<String>>() {
            @Override
            public void onSuccess(BaseRes<String> stringBaseRes) {
                if(stringBaseRes ==null){
                    return;
                }
                int code = stringBaseRes.getCode();
                String msg = stringBaseRes.getMsg();
                LogUtils.error("code","响应码"+code);
                if(0 == code){
                    modifyEduBgInfoView.modifyEduBgInfoSuccess();
                }else {
                    UiUtils.showToast(mContext,msg);
                }
            }

            @Override
            public void onFailure(String message) {
                modifyEduBgInfoView.showError(message);
            }
        });

    }
}
