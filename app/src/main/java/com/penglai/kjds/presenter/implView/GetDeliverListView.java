package com.penglai.kjds.presenter.implView;

import com.penglai.kjds.model.user.DeliverInfo;

import java.util.List;

/**
 * Created by m199 on 2017/6/24.
 */

public interface GetDeliverListView {
    /**
     * 显示错误信息
     * @param message
     */
    void showError(String message);

    void getDeliverListSuccess(List<DeliverInfo> deliverInfoList);
}
