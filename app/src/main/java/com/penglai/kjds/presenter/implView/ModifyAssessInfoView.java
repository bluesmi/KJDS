package com.penglai.kjds.presenter.implView;

/**
 * Created by m199 on 2017/6/21.
 */

public interface ModifyAssessInfoView {
    /**
     * 显示错误信息
     * @param message
     */
    void showError(String message);

    /**
     * 新增、修改个人评价成功
     */
    void modifyAssessSuccess();
}
