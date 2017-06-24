package com.penglai.kjds.presenter.impl;

import android.content.Context;

import com.penglai.kjds.http.RequestCallback;
import com.penglai.kjds.http.api.index.IndexService;
import com.penglai.kjds.model.BaseRes;
import com.penglai.kjds.model.index.Company;
import com.penglai.kjds.presenter.Presenter;
import com.penglai.kjds.presenter.implView.GetCompanyInfoView;
import com.penglai.kjds.utils.LogUtils;
import com.penglai.kjds.utils.UiUtils;

/**
 * Created by m199 on 2017/6/24.
 */

public class GetCompanyInfoPresenterImpl implements Presenter {
    private Context mContext;
    private GetCompanyInfoView companyInfoView;

    public GetCompanyInfoPresenterImpl(Context mContext, GetCompanyInfoView companyInfoView) {
        this.mContext = mContext;
        this.companyInfoView = companyInfoView;
    }

    @Override
    public void initialized() {

    }

    public void getCompanyInfo(String opSign, String strJson){
        IndexService.getCompanyInfo(opSign, strJson, new RequestCallback<BaseRes<Company>>() {
            @Override
            public void onSuccess(BaseRes<Company> companyBaseRes) {
                if(companyBaseRes ==null){
                    return;
                }
                int code = companyBaseRes.getCode();
                String msg = companyBaseRes.getMsg();
                Company company = companyBaseRes.getData();
                if(code == 0){        //是否成功登陆
                    LogUtils.error("data 中的数值"+company);

                    companyInfoView.getCompanyInfoSuccess(company);
                }else{
                    UiUtils.showToast(mContext,msg);
                }
            }

            @Override
            public void onFailure(String message) {
                companyInfoView.showError(message);
            }
        });

    }
}
