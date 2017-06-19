package com.penglai.kjds.presenter.impl;

import android.content.Context;

import com.penglai.kjds.http.RequestCallback;
import com.penglai.kjds.http.api.user.UserService;
import com.penglai.kjds.model.BaseRes;
import com.penglai.kjds.presenter.Presenter;
import com.penglai.kjds.presenter.implView.ModifyUserInfoView;
import com.penglai.kjds.utils.LogUtils;
import com.penglai.kjds.utils.UiUtils;

/**
 * Created by m199 on 2017/6/19.
 */

public class ModifyUserInfoPresenterImpl implements Presenter {
    private Context mContext;
    private ModifyUserInfoView modifyUserInfoView;

    public ModifyUserInfoPresenterImpl(Context mContext, ModifyUserInfoView modifyUserInfoView) {
        this.mContext = mContext;
        this.modifyUserInfoView = modifyUserInfoView;
    }

    @Override
    public void initialized() {

    }

    public void modifyUserInfo(String opSign, String strJson){
        UserService.modifyUserInfo(opSign, strJson, new RequestCallback<BaseRes<String>>() {
            @Override
            public void onSuccess(BaseRes<String> stringBaseRes) {
                if(stringBaseRes ==null){
                    return;
                }
                int code = stringBaseRes.getCode();
                String msg = stringBaseRes.getMsg();
                LogUtils.error("code","响应码"+code);
                if(0 == code){
                    modifyUserInfoView.modifySuccess();
                }else {
                    UiUtils.showToast(mContext,msg);
                }
            }

            @Override
            public void onFailure(String message) {
                modifyUserInfoView.showError(message);
            }
        });
    }
}
