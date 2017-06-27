package com.penglai.kjds.presenter.impl;

import android.content.Context;

import com.penglai.kjds.http.RequestCallback;
import com.penglai.kjds.http.api.user.UserService;
import com.penglai.kjds.model.BaseResArray;
import com.penglai.kjds.model.user.MyMessage;
import com.penglai.kjds.presenter.Presenter;
import com.penglai.kjds.presenter.implView.GetMyMessageView;
import com.penglai.kjds.utils.LogUtils;
import com.penglai.kjds.utils.UiUtils;

import java.util.List;

/**
 * Created by m199 on 2017/6/27.
 */

public class GetMyMessagePresenterImpl implements Presenter {
    private Context mContext;
    private GetMyMessageView myMessageView;

    public GetMyMessagePresenterImpl(Context mContext, GetMyMessageView myMessageView) {
        this.mContext = mContext;
        this.myMessageView = myMessageView;
    }

    @Override
    public void initialized() {

    }

    public void getMessage(String opSign,String strJson){
        UserService.getMessage(opSign, strJson, new RequestCallback<BaseResArray<MyMessage>>() {
            @Override
            public void onSuccess(BaseResArray<MyMessage> myMessageBaseResArray) {
                if(myMessageBaseResArray ==null){
                    return;
                }
                int code = myMessageBaseResArray.getCode();
                String msg = myMessageBaseResArray.getMsg();
                List<MyMessage> myMessageList = myMessageBaseResArray.getData();
                if(code == 0){        //是否成功登陆
                    LogUtils.error("data 中的数值"+myMessageList.toString());

                    myMessageView.getMyMessageSuccess(myMessageList);
                }else{
                    UiUtils.showToast(mContext,msg);
                }
            }

            @Override
            public void onFailure(String message) {
                myMessageView.showError(message);
            }
        });
    }
}
