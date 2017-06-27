package com.penglai.kjds.presenter.impl;

import android.content.Context;

import com.penglai.kjds.http.RequestCallback;
import com.penglai.kjds.http.api.index.IndexService;
import com.penglai.kjds.model.BaseResArray;
import com.penglai.kjds.model.index.CompanyInfo;
import com.penglai.kjds.presenter.Presenter;
import com.penglai.kjds.presenter.implView.SearchJobView;
import com.penglai.kjds.utils.LogUtils;
import com.penglai.kjds.utils.UiUtils;

import java.util.List;

/**
 * Created by m199 on 2017/6/27.
 */

public class SearchJobPresenterImpl implements Presenter {
    private Context mContext;
    private SearchJobView searchJobView;

    public SearchJobPresenterImpl(Context mContext, SearchJobView searchJobView) {
        this.mContext = mContext;
        this.searchJobView = searchJobView;
    }

    @Override
    public void initialized() {

    }

    public void searchJobList(String opSign,String strJson){
        IndexService.searchJobList(opSign, strJson, new RequestCallback<BaseResArray<CompanyInfo>>() {
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
                    searchJobView.searchJobListSuccess(companyInfoList);
                }else{
                    UiUtils.showToast(mContext,msg);
                }
            }

            @Override
            public void onFailure(String message) {
                searchJobView.showError(message);
            }
        });
    }
}
