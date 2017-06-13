package com.penglai.kjds.presenter.impl;

import android.content.Context;

import com.penglai.kjds.http.RequestCallback;
import com.penglai.kjds.http.api.user.UserService;
import com.penglai.kjds.model.BaseRes;
import com.penglai.kjds.model.user.UserInfo;
import com.penglai.kjds.model.user.UserInfoRes;
import com.penglai.kjds.presenter.Presenter;
import com.penglai.kjds.presenter.implView.GetUserInfoView;
import com.penglai.kjds.utils.LogUtils;
import com.penglai.kjds.utils.UiUtils;

/**
 * Created by m199 on 2017/6/13.
 * 获取用户信息
 */

public class GetUserInfoPresenterImpl implements Presenter {
    private Context mContext;
    private GetUserInfoView mGetUserInfoView;

    public GetUserInfoPresenterImpl(Context mContext, GetUserInfoView mGetUserInfoView) {
        this.mContext = mContext;
        this.mGetUserInfoView = mGetUserInfoView;
    }

    @Override
    public void initialized() {

    }

    public void getUserInfo(String opSign,String strJson){
        mGetUserInfoView.showLoading();
        UserService.getUserInfo(opSign, strJson, new RequestCallback<UserInfoRes>() {
            @Override
            public void onSuccess(UserInfoRes userInfoRes) {
                if(userInfoRes ==null){
                    return;
                }
                int code = userInfoRes.getCode();
                String msg = userInfoRes.getMsg();
                UserInfo data =userInfoRes.getData();
                if(code == 0){        //是否成功登陆
                    LogUtils.error("data 中的数值"+data.toString());
                    //存储用户id和用户名
                    mGetUserInfoView.showUserInfo(data);
                }else{
                    UiUtils.showToast(mContext,msg);
                }
            }

            @Override
            public void onFailure(String message) {
                mGetUserInfoView.hideLoading();
                LogUtils.error("UserInfoRes",message);
                UiUtils.showToast(mContext,"获取信息失败");
            }
        });


    }
}
