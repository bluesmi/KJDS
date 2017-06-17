package com.penglai.kjds.presenter.impl;

import android.content.Context;

import com.penglai.kjds.http.RequestCallback;
import com.penglai.kjds.http.api.resume.ResumeService;
import com.penglai.kjds.model.resume.PersionInfo;
import com.penglai.kjds.model.resume.PersionInfoRes;
import com.penglai.kjds.presenter.Presenter;
import com.penglai.kjds.presenter.implView.GetPersionInfoView;
import com.penglai.kjds.utils.LogUtils;
import com.penglai.kjds.utils.UiUtils;

/**
 * Created by m199 on 2017/6/16.
 */

public class GetPersionInfoPresenter implements Presenter {
    private Context mContext;
    private GetPersionInfoView persionInfoView;

    public GetPersionInfoPresenter(Context mContext, GetPersionInfoView persionInfoView) {
        this.mContext = mContext;
        this.persionInfoView = persionInfoView;
    }

    @Override
    public void initialized() {

    }

    public void getPersionInfo(String opSign,String strJson){
        ResumeService.getPersionInfo(opSign, strJson, new RequestCallback<PersionInfoRes>() {
            @Override
            public void onSuccess(PersionInfoRes persionInfoRes) {
                if(persionInfoRes ==null){
                    return;
                }
                int code = persionInfoRes.getCode();
                String msg = persionInfoRes.getMsg();
                PersionInfo data =persionInfoRes.getPersionInfo();
                if(code == 0){        //是否成功登陆
                    LogUtils.error("data 中的数值"+data.toString());
                    //存储用户id和用户名
                    persionInfoView.showPersionInfo(data);
                }else{
                    UiUtils.showToast(mContext,msg);
                }
            }

            @Override
            public void onFailure(String message) {
                LogUtils.error("persionInfoRes",message);
//                UiUtils.showToast(mContext,"获取信息失败");
            }
        });
    }
}
