package com.penglai.kjds.presenter.impl;

import android.content.Context;

import com.penglai.kjds.http.RequestCallback;
import com.penglai.kjds.http.api.user.UserService;
import com.penglai.kjds.model.BaseResArray;
import com.penglai.kjds.model.user.DeliverInfo;
import com.penglai.kjds.presenter.Presenter;
import com.penglai.kjds.presenter.implView.GetDeliverListView;
import com.penglai.kjds.utils.LogUtils;
import com.penglai.kjds.utils.UiUtils;

import java.util.List;

/**
 * Created by m199 on 2017/6/24.
 */

public class GetDeliverListPresenterImpl implements Presenter {
    private Context mContext;
    private GetDeliverListView deliverListView;

    public GetDeliverListPresenterImpl(Context mContext, GetDeliverListView deliverListView) {
        this.mContext = mContext;
        this.deliverListView = deliverListView;
    }

    @Override
    public void initialized() {

    }

    public void getDeliverList(String opSign, String strJson){
        UserService.getDeliverList(opSign, strJson, new RequestCallback<BaseResArray<DeliverInfo>>() {
            @Override
            public void onSuccess(BaseResArray<DeliverInfo> deliverInfoBaseResArray) {
                if(deliverInfoBaseResArray ==null){
                    return;
                }
                int code = deliverInfoBaseResArray.getCode();
                String msg = deliverInfoBaseResArray.getMsg();
                List<DeliverInfo> companyInfoList = deliverInfoBaseResArray.getData();
                if(code == 0){        //是否成功登陆
                    LogUtils.error("data 中的数值"+companyInfoList.toString());
                    //存储用户id和用户名
                    deliverListView.getDeliverListSuccess(companyInfoList);
                }else{
                    UiUtils.showToast(mContext,msg);
                }
            }

            @Override
            public void onFailure(String message) {
                deliverListView.showError(message);
            }
        });

    }
}
