package com.penglai.kjds.presenter.implView;

import java.util.List;

/**
 * Created by m199 on 2017/6/29.
 */

public interface CarouselImageView {
    /**
     * 显示错误信息
     * @param message
     */
    void showError(String message);

    void getCarouselImageListSuccess(List<String> stringList);
}
