package com.penglai.kjds.presenter.implView;

import com.penglai.kjds.model.user.CollectInfo;

import java.util.List;

/**
 * Created by m199 on 2017/6/26.
 */

public interface GetFavoriteListView {
    //显示错误信息
    void showError(String error);

    void getFavoriteListSuccess(List<CollectInfo> collectInfoList);
}
