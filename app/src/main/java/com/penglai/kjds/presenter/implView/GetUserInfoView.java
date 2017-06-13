package com.penglai.kjds.presenter.implView;

import com.penglai.kjds.model.user.UserInfo;

/**
 * Created by m199 on 2017/6/13.
 * 获取用户信息帮助view
 */

public interface GetUserInfoView {
    //显示
    void showLoading();

    //隐藏
    void hideLoading();

    //显示错误信息
    void showError(String error);

    /**
     * 显示用户信息
     * @param userInfo 用户信息对象
     */
    void showUserInfo(UserInfo userInfo);
}
