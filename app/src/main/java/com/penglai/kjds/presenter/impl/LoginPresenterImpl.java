package com.penglai.kjds.presenter.impl;

import android.content.Context;

import com.penglai.kjds.http.RequestCallback;
import com.penglai.kjds.http.api.user.UserService;
import com.penglai.kjds.model.user.LoginRes;
import com.penglai.kjds.model.user.UserData;
import com.penglai.kjds.presenter.Presenter;
import com.penglai.kjds.presenter.implView.LoginView;
import com.penglai.kjds.utils.LogUtils;
import com.penglai.kjds.utils.SettingPrefUtils;
import com.penglai.kjds.utils.UiUtils;

/**
 *  * 作者：朋来-GZQ on 2017/2/4 10:13
 *  * 邮箱：gongzhiqing@xiyundata.com
 *  
 */
public class LoginPresenterImpl implements Presenter {

    private Context  mContext;

    private LoginView mLoginView;

    public LoginPresenterImpl(Context mContext, LoginView mLoginView) {
        this.mContext = mContext;
        this.mLoginView = mLoginView;
    }

    @Override
    public void initialized() {

    }

    /**
     * 用户登陆
     * @param opSign
     *                                    op参数
     * @param strJson
     *                                   json字符串
     */
    public void login(final String opSign,String strJson){
        mLoginView.showLoading();
        UserService.login(opSign, strJson, new RequestCallback<LoginRes>() {
            @Override
            public void onSuccess(LoginRes loginRes) {
                if(loginRes ==null){
                    return;
                }
                int code = loginRes.getCode();
                String msg = loginRes.getMsg();
                UserData data =loginRes.getData();

                if(data == null){
                    return  ;
                }
                if(code == 0){        //是否成功登陆
                    LogUtils.error("data 中的数值"+data.getUserName()+data.getUserId()+data.getToken());
                    //存储用户id和用户名
                    try {
                        SettingPrefUtils.saveUid(data.getUserId());
                        SettingPrefUtils.saveUserName(data.getUserName());
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    mLoginView.loginSuccess();
                }else{
                    UiUtils.showToast(mContext,msg);
                }
                mLoginView.hideLoading();
            }

            @Override
            public void onFailure(String message) {
                mLoginView.hideLoading();
                LogUtils.error("loginResp",message);
                UiUtils.showToast(mContext,"登陆失败");
            }
        });
    }
}
