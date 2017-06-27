package com.penglai.kjds.presenter.implView;

/**
 * Created by m199 on 2017/6/27.
 */

public interface FeedBackView {
    /**
     * 显示错误信息
     * @param message
     */
    void showError(String message);

    void feedBackSuccess(String message);
}
