package com.penglai.kjds.presenter.implView;

/**
 *  * 作者：朋来-GZQ on 2017/2/4 10:15
 *  * 邮箱：gongzhiqing@xiyundata.com
 *     用户登陆的帮助view
 */
public interface LoginView {

    //显示
    void showLoading();

    //隐藏
    void hideLoading();

    //显示用户名错误
    void showUserNameError(String error);

    //显示密码错误
    void showPassWordError(String error);

    //登陆成功
    void loginSuccess();

}
