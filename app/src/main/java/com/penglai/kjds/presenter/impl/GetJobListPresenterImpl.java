package com.penglai.kjds.presenter.impl;

import android.content.Context;

import com.penglai.kjds.http.RequestCallback;
import com.penglai.kjds.http.api.index.IndexService;
import com.penglai.kjds.model.BaseResArray;
import com.penglai.kjds.model.index.CompanyInfo;
import com.penglai.kjds.presenter.Presenter;
import com.penglai.kjds.presenter.implView.GetJobListView;
import com.penglai.kjds.utils.LogUtils;
import com.penglai.kjds.utils.UiUtils;

import java.util.List;

/**
 * Created by m199 on 2017/6/27.
 */

public class GetJobListPresenterImpl implements Presenter {
    private Context mContext;
    private GetJobListView jobListView;

    public GetJobListPresenterImpl(Context mContext, GetJobListView jobListView) {
        this.mContext = mContext;
        this.jobListView = jobListView;
    }

    @Override
    public void initialized() {

    }

    public void getJobList(String opSign,String strJson){
        IndexService.getJobList(opSign, strJson, new RequestCallback<BaseResArray<CompanyInfo>>() {
            @Override
            public void onSuccess(BaseResArray<CompanyInfo> companyInfoBaseResArray) {
                if(companyInfoBaseResArray ==null){
                    return;
                }
                int code = companyInfoBaseResArray.getCode();
                String msg = companyInfoBaseResArray.getMsg();
                List<CompanyInfo> companyInfoList = companyInfoBaseResArray.getData();
                if(code == 0){        //是否成功登陆
                    LogUtils.error("data 中的数值"+companyInfoList.toString());
                    //存储用户id和用户名
                    jobListView.getJobListSuccess(companyInfoList);
                }else{
                    UiUtils.showToast(mContext,msg);
                }
            }

            @Override
            public void onFailure(String message) {
                jobListView.showError(message);
            }
        });
    }
}
