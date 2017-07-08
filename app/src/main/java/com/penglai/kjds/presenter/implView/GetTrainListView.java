package com.penglai.kjds.presenter.implView;

import com.penglai.kjds.model.index.TrainInfo;

import java.util.List;

/**
 * Created by m199 on 2017/7/8.
 */

public interface GetTrainListView {
    //显示错误信息
    void showError(String error);

    void  getTrainListSuccess(List<TrainInfo> trainInfoList);
}
