package com.penglai.kjds.presenter.impl;

import android.content.Context;

import com.penglai.kjds.http.RequestCallback;
import com.penglai.kjds.http.api.resume.ResumeService;
import com.penglai.kjds.model.BaseRes;
import com.penglai.kjds.presenter.Presenter;
import com.penglai.kjds.presenter.implView.DelEduInfoView;
import com.penglai.kjds.utils.LogUtils;
import com.penglai.kjds.utils.UiUtils;

/**
 * Created by m199 on 2017/6/21.
 */

public class DelEdubgInfoPresenterImpl implements Presenter {

    private Context mContext;
    private DelEduInfoView delEduInfoView;

    public DelEdubgInfoPresenterImpl(Context mContext, DelEduInfoView delEduInfoView) {
        this.mContext = mContext;
        this.delEduInfoView = delEduInfoView;
    }

    @Override
    public void initialized() {

    }

    public void delEduBgInfo(String opSign,String strJson){
        ResumeService.delEduBgInfo(opSign, strJson, new RequestCallback<BaseRes<String>>() {
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
                    delEduInfoView.delEduInfoViewSuccess();
                }else{
                    UiUtils.showToast(mContext,msg);
                }
            }

            @Override
            public void onFailure(String message) {
                delEduInfoView.showError(message);
            }
        });
    }
}
