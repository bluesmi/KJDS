package com.penglai.kjds.presenter.impl;

import android.content.Context;

import com.penglai.kjds.http.RequestCallback;
import com.penglai.kjds.http.api.user.UserService;
import com.penglai.kjds.model.BaseRes;
import com.penglai.kjds.model.user.UserImagePath;
import com.penglai.kjds.presenter.Presenter;
import com.penglai.kjds.presenter.implView.UploadUserImgView;
import com.penglai.kjds.utils.LogUtils;
import com.penglai.kjds.utils.UiUtils;

import java.io.File;

/**
 * Created by m199 on 2017/6/16.
 */

public class UploadUserImgPresenterImpl implements Presenter {
    private Context mContext;
    private UploadUserImgView uploadUserImgView;
    @Override
    public void initialized() {

    }

    public UploadUserImgPresenterImpl(Context mContext, UploadUserImgView uploadUserImgView) {
        this.mContext = mContext;
        this.uploadUserImgView = uploadUserImgView;
    }

   public void uploadUserImg(String opSign,File img){
       UserService.uploadUserImg("uploadUserImg", img, new RequestCallback<BaseRes<UserImagePath>>() {
           @Override
           public void onSuccess(BaseRes<UserImagePath> baseRes) {
               if(baseRes ==null){
                   return;
               }
               int code = baseRes.getCode();
               String msg = baseRes.getMsg();
               LogUtils.error("code","响应码"+code);
               if(code == 0){        //是否成功登陆
                   uploadUserImgView.saveUserImgPath(baseRes.getData().getPath());
               }else{
                   UiUtils.showToast(mContext,msg);
               }
           }

           @Override
           public void onFailure(String message) {
                uploadUserImgView.showError(message);
           }
       });
   }
}
