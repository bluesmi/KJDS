package com.penglai.kjds.presenter.impl;

import android.content.Context;

import com.penglai.kjds.http.RequestCallback;
import com.penglai.kjds.http.api.user.UserService;
import com.penglai.kjds.model.BaseResArray;
import com.penglai.kjds.model.user.CollectInfo;
import com.penglai.kjds.presenter.Presenter;
import com.penglai.kjds.presenter.implView.GetFavoriteListView;
import com.penglai.kjds.utils.LogUtils;
import com.penglai.kjds.utils.UiUtils;

import java.util.List;

/**
 * Created by m199 on 2017/6/26.
 */

public class GetFavoriteListPresenterImpl implements Presenter {
    private Context mContext;
    private GetFavoriteListView favoriteListView;

    public GetFavoriteListPresenterImpl(Context mContext, GetFavoriteListView favoriteListView) {
        this.mContext = mContext;
        this.favoriteListView = favoriteListView;
    }

    @Override
    public void initialized() {

    }
    public void getFavoriteList(String opSign, String strJson){
        UserService.getFavoriteList(opSign, strJson, new RequestCallback<BaseResArray<CollectInfo>>() {
            @Override
            public void onSuccess(BaseResArray<CollectInfo> collectInfoBaseResArray) {
                if(collectInfoBaseResArray ==null){
                    return;
                }
                int code = collectInfoBaseResArray.getCode();
                String msg = collectInfoBaseResArray.getMsg();
                List<CollectInfo> collectInfoList = collectInfoBaseResArray.getData();
                if(code == 0){        //是否成功登陆
                    LogUtils.error("data 中的数值"+collectInfoList.toString());
                    //存储用户id和用户名
                    favoriteListView.getFavoriteListSuccess(collectInfoList);
                }else{
                    UiUtils.showToast(mContext,msg);
                }
            }

            @Override
            public void onFailure(String message) {
                favoriteListView.showError(message);
            }
        });

    }
}
