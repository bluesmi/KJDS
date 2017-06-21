package com.penglai.kjds.presenter.impl;

import android.content.Context;

import com.penglai.kjds.http.RequestCallback;
import com.penglai.kjds.http.api.resume.ResumeService;
import com.penglai.kjds.model.BaseRes;
import com.penglai.kjds.presenter.Presenter;
import com.penglai.kjds.presenter.implView.ModifyAssessInfoView;
import com.penglai.kjds.utils.LogUtils;
import com.penglai.kjds.utils.UiUtils;

/**
 * Created by m199 on 2017/6/21.
 */

public class ModifyAssessInfoPresenterImpl implements Presenter {

    private Context mContext;
    private ModifyAssessInfoView modifyAssessInfoView;

    public ModifyAssessInfoPresenterImpl(Context mContext, ModifyAssessInfoView modifyAssessInfoView) {
        this.mContext = mContext;
        this.modifyAssessInfoView = modifyAssessInfoView;
    }

    @Override
    public void initialized() {

    }

    public void modifyAssessInfo(String opSign,String strJson){
        ResumeService.modifyAssessInfo(opSign, strJson, new RequestCallback<BaseRes<String>>() {
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
                    //存储用户id和用户名
                    modifyAssessInfoView.modifyAssessSuccess();
                }else{
                    UiUtils.showToast(mContext,msg);
                }
            }

            @Override
            public void onFailure(String message) {
                modifyAssessInfoView.showError(message);
            }
        });
    }
}
