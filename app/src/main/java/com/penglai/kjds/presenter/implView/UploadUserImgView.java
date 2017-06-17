package com.penglai.kjds.presenter.implView;

/**
 * Created by m199 on 2017/6/16.
 */

public interface UploadUserImgView {

    /**
     * 显示错误信息
     * @param error 错误信息
     */
    void showError(String error);

    void saveUserImgPath(String path);
}
