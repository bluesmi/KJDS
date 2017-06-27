package com.penglai.kjds.presenter.impl;

import android.content.Context;

import com.penglai.kjds.http.RequestCallback;
import com.penglai.kjds.http.api.user.UserService;
import com.penglai.kjds.model.BaseRes;
import com.penglai.kjds.presenter.Presenter;
import com.penglai.kjds.presenter.implView.FeedBackView;
import com.penglai.kjds.utils.LogUtils;
import com.penglai.kjds.utils.UiUtils;

/**
 * Created by m199 on 2017/6/27.
 */

public class FeedBackPresenterImpl implements Presenter {
    private Context mContext;
    private FeedBackView feedBackView;

    public FeedBackPresenterImpl(Context mContext, FeedBackView feedBackView) {
        this.mContext = mContext;
        this.feedBackView = feedBackView;
    }

    @Override
    public void initialized() {

    }

    public void feedBack(String opSign,String strJson){
        UserService.feedBack(opSign, strJson, new RequestCallback<BaseRes<String>>() {
            @Override
            public void onSuccess(BaseRes<String> stringBaseRes) {
                if(stringBaseRes ==null){
                    return;
                }
                int code = stringBaseRes.getCode();
                String msg = stringBaseRes.getMsg();
                String data = stringBaseRes.getData();
                if(code == 0){        //是否成功登陆
                    LogUtils.error("data 中的数值"+msg);
                    //存储用户id和用户名
                    feedBackView.feedBackSuccess(msg);
                }else{
                    UiUtils.showToast(mContext,msg);
                }
            }

            @Override
            public void onFailure(String message) {
                feedBackView.showError(message);
            }
        });
    }
}
