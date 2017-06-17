package com.penglai.kjds.presenter.impl;

import android.content.Context;

import com.penglai.kjds.http.RequestCallback;
import com.penglai.kjds.http.api.index.IndexService;
import com.penglai.kjds.model.BaseResArray;
import com.penglai.kjds.model.index.CompanyInfo;
import com.penglai.kjds.presenter.Presenter;
import com.penglai.kjds.presenter.implView.GetHotRecommendView;
import com.penglai.kjds.utils.LogUtils;
import com.penglai.kjds.utils.UiUtils;

import java.util.List;

/**
 * Created by m199 on 2017/6/17.
 */

public class GetHotRecommendPresenterImpl implements Presenter {
    private Context mContext;
    private GetHotRecommendView mRecommendView;

    public GetHotRecommendPresenterImpl(Context mContext, GetHotRecommendView mRecommendView) {
        this.mContext = mContext;
        this.mRecommendView = mRecommendView;
    }

    @Override
    public void initialized() {

    }

    public void getHotRecommend(String opSign,String strJson){
        IndexService.getHotRecommend(opSign, strJson, new RequestCallback<BaseResArray<CompanyInfo>>() {
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
                    mRecommendView.showHotCompany(companyInfoList);
                }else{
                    UiUtils.showToast(mContext,msg);
                }
            }

            @Override
            public void onFailure(String message) {
                mRecommendView.showError(message);
            }
        });
    }
}
