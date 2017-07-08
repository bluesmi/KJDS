package com.penglai.kjds.presenter.impl;

import android.content.Context;

import com.penglai.kjds.http.RequestCallback;
import com.penglai.kjds.http.api.index.IndexService;
import com.penglai.kjds.model.BaseResArray;
import com.penglai.kjds.model.index.TrainInfo;
import com.penglai.kjds.presenter.Presenter;
import com.penglai.kjds.presenter.implView.GetTrainListView;
import com.penglai.kjds.utils.LogUtils;
import com.penglai.kjds.utils.UiUtils;

import java.util.List;

/**
 * Created by m199 on 2017/7/8.
 */

public class GetTrainListPresenterImpl implements Presenter {
    private Context mContext;
    private GetTrainListView trainListView;

    public GetTrainListPresenterImpl(Context mContext, GetTrainListView trainListView) {
        this.mContext = mContext;
        this.trainListView = trainListView;
    }

    @Override
    public void initialized() {

    }

    public void getTrainList(String opSign,String strJson){
        IndexService.getTrainList(opSign, strJson, new RequestCallback<BaseResArray<TrainInfo>>() {
            @Override
            public void onSuccess(BaseResArray<TrainInfo> trainInfoBaseResArray) {
                if(trainInfoBaseResArray ==null){
                    return;
                }
                int code = trainInfoBaseResArray.getCode();
                String msg = trainInfoBaseResArray.getMsg();
                List<TrainInfo> tainInfoList = trainInfoBaseResArray.getData();
                if(code == 0){        //是否成功登陆
                    LogUtils.error("data 中的数值"+tainInfoList.toString());
                    trainListView.getTrainListSuccess(tainInfoList);
                }else{
                    UiUtils.showToast(mContext,msg);
                }
            }

            @Override
            public void onFailure(String message) {
                trainListView.showError(message);
            }
        });
    }
}
