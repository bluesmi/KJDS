package com.penglai.kjds.presenter.impl;

import android.content.Context;

import com.penglai.kjds.http.RequestCallback;
import com.penglai.kjds.http.api.resume.ResumeService;
import com.penglai.kjds.model.BaseRes;
import com.penglai.kjds.model.resume.AssessInfoRes;
import com.penglai.kjds.presenter.Presenter;
import com.penglai.kjds.presenter.implView.GetAssessInfoView;
import com.penglai.kjds.utils.LogUtils;
import com.penglai.kjds.utils.UiUtils;


/**
 * Created by m199 on 2017/6/21.
 */

public class GetAssessInfoPresenterImpl implements Presenter {

    private Context mContext;

    private GetAssessInfoView assessInfoView;

    public GetAssessInfoPresenterImpl(Context mContext, GetAssessInfoView assessInfoView) {
        this.mContext = mContext;
        this.assessInfoView = assessInfoView;
    }

    @Override
    public void initialized() {

    }



    public  void getAssessInfo(String opSign,String strJson){
        ResumeService.getAssessInfo(opSign, strJson, new RequestCallback<BaseRes<AssessInfoRes>>() {
            @Override
            public void onSuccess(BaseRes<AssessInfoRes> assessInfoResBaseRes) {
                if(assessInfoResBaseRes ==null){
                    return;
                }
                int code = assessInfoResBaseRes.getCode();
                String msg = assessInfoResBaseRes.getMsg();
                AssessInfoRes assessInfoRes = assessInfoResBaseRes.getData();
                if(code == 0){        //是否成功登陆
                    LogUtils.error("data 中的数值"+assessInfoRes.toString());
                    //存储用户id和用户名
                    assessInfoView.getAssessInfoSuccess(assessInfoRes);
                }else{
                    UiUtils.showToast(mContext,msg);
                }
            }

            @Override
            public void onFailure(String message) {
                assessInfoView.showError(message);
            }
        });
    }
}
