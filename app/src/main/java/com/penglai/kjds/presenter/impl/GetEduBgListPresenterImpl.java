package com.penglai.kjds.presenter.impl;

import android.content.Context;

import com.penglai.kjds.http.RequestCallback;
import com.penglai.kjds.http.api.resume.ResumeService;
import com.penglai.kjds.model.BaseResArray;
import com.penglai.kjds.model.resume.EduBgInfo;
import com.penglai.kjds.presenter.Presenter;
import com.penglai.kjds.presenter.implView.GetEduBgListView;
import com.penglai.kjds.utils.LogUtils;
import com.penglai.kjds.utils.UiUtils;

import java.util.List;

/**
 * Created by m199 on 2017/6/20.
 */

public class GetEduBgListPresenterImpl implements Presenter {
    private Context mContext;
    private GetEduBgListView eduBgListView;

    public GetEduBgListPresenterImpl(Context mContext, GetEduBgListView eduBgListView) {
        this.mContext = mContext;
        this.eduBgListView = eduBgListView;
    }

    @Override
    public void initialized() {

    }

    public void getEduBgList(String opSign,String strJson){
        ResumeService.getEduBgList(opSign, strJson, new RequestCallback<BaseResArray<EduBgInfo>>() {
            @Override
            public void onSuccess(BaseResArray<EduBgInfo> eduBgInfoBaseResArray) {
                if(eduBgInfoBaseResArray ==null){
                    return;
                }
                int code = eduBgInfoBaseResArray.getCode();
                String msg = eduBgInfoBaseResArray.getMsg();
                List<EduBgInfo> eduBgInfoList = eduBgInfoBaseResArray.getData();
                if(code == 0){        //是否成功登陆
                    LogUtils.error("data 中的数值"+eduBgInfoList.toString());
                    //存储用户id和用户名
                    eduBgListView.getEduViewSuccess(eduBgInfoList);
                }else{
                    UiUtils.showToast(mContext,msg);
                }
            }

            @Override
            public void onFailure(String message) {
                eduBgListView.showError(message);
            }
        });
    }
}
