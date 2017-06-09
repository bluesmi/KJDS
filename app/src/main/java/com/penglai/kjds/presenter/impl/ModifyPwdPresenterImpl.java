package com.penglai.kjds.presenter.impl;

import android.content.Context;

import com.penglai.kjds.http.RequestCallback;
import com.penglai.kjds.http.api.user.UserService;
import com.penglai.kjds.model.BaseRes;
import com.penglai.kjds.presenter.Presenter;
import com.penglai.kjds.presenter.implView.ModifyPwdView;
import com.penglai.kjds.utils.LogUtils;
import com.penglai.kjds.utils.UiUtils;

/**
 *  * 作者：朋来-GZQ on 2017/2/8 14:44
 *  * 邮箱：gongzhiqing@xiyundata.com
 *     修改
 */
public class ModifyPwdPresenterImpl implements Presenter {

    private Context mContext;
    private ModifyPwdView mModifyPwdView;

    public ModifyPwdPresenterImpl(Context mContext, ModifyPwdView modifyPwdView) {
        this.mContext = mContext;
        this.mModifyPwdView = modifyPwdView;
    }

    @Override
    public void initialized() {


    }

    /**
     * 修改密码
     * @param opSign
     * @param strJson
     */
    public void ModifyPwd(final String opSign,String strJson){
        mModifyPwdView.showLoading();
        UserService.modifyPwd(opSign, strJson, new RequestCallback<BaseRes>() {
            @Override
            public void onSuccess(BaseRes baseRes) {
                if(baseRes ==null){
                    return;
                }
                int code = baseRes.getCode();
                String msg = baseRes.getMsg();
                LogUtils.error("code","响应码"+code);
                if(code == 0){        //是否成功登陆
                    mModifyPwdView.modifySuccess();
                }else{
                    UiUtils.showToast(mContext,msg);
                }
                mModifyPwdView.hideLoading();
            }

            @Override
            public void onFailure(String message) {
                mModifyPwdView.showError(message);
                mModifyPwdView.hideLoading();
            }
        });
    }


}
