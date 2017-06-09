package com.penglai.kjds.presenter.implView;

/**
 *  * 作者：朋来-GZQ on 2017/2/8 14:49
 *  * 邮箱：gongzhiqing@xiyundata.com
 *    修改密码帮助view
 */
public interface ModifyPwdView {

    //显示
    void showLoading();

    //隐藏
    void hideLoading();

    //显示错误信息
    void showError(String error);

    //登陆成功
    void modifySuccess();

}
