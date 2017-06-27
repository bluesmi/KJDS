package com.penglai.kjds.presenter.implView;

import com.penglai.kjds.model.user.MyMessage;

import java.util.List;

/**
 * Created by m199 on 2017/6/27.
 */

public interface GetMyMessageView {
    //显示错误信息
    void showError(String error);

    void getMyMessageSuccess(List<MyMessage> myMessageList);
}
