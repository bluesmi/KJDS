package com.penglai.kjds.presenter.impl;

import android.content.Context;

import com.penglai.kjds.http.RequestCallback;
import com.penglai.kjds.http.api.resume.ResumeService;
import com.penglai.kjds.model.BaseResArray;
import com.penglai.kjds.model.resume.WorkExpInfoReq;
import com.penglai.kjds.presenter.Presenter;
import com.penglai.kjds.presenter.implView.GetWorkExpListView;
import com.penglai.kjds.utils.LogUtils;
import com.penglai.kjds.utils.UiUtils;

import java.util.List;

/**
 * Created by m199 on 2017/6/22.
 */

public class GetWorkExpListPresenterImpl implements Presenter {
    private Context mContext;
    private GetWorkExpListView workExpListView;

    public GetWorkExpListPresenterImpl(Context mContext, GetWorkExpListView workExpListView) {
        this.mContext = mContext;
        this.workExpListView = workExpListView;
    }

    @Override
    public void initialized() {

    }

    public void getWorkExpList(String opSign,String strJson){
        ResumeService.getWorkExpList(opSign, strJson, new RequestCallback<BaseResArray<WorkExpInfoReq>>() {
            @Override
            public void onSuccess(BaseResArray<WorkExpInfoReq> workExpInfoReqBaseResArray) {
                if(workExpInfoReqBaseResArray ==null){
                    return;
                }
                int code = workExpInfoReqBaseResArray.getCode();
                String msg = workExpInfoReqBaseResArray.getMsg();
                List<WorkExpInfoReq> workExpInfoReqList = workExpInfoReqBaseResArray.getData();
                if(code == 0){        //是否成功登陆
                    LogUtils.error("data 中的数值"+workExpInfoReqList);

                    workExpListView.getWorkExpListSucces(workExpInfoReqList);
                }else{
                    UiUtils.showToast(mContext,msg);
                }
            }

            @Override
            public void onFailure(String message) {
                workExpListView.showError(message);
            }
        });
    }
}
