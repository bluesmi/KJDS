package com.penglai.kjds.ui.my.changeview;

/**
 * Created by m199 on 2017/6/17.
 */

public interface SettingChargeView {

    /**
     * 确定更改
     */
    void onSuccess();

    /**
     * 不更改
     * @param message
     */
    void onFailure(String message);
}
