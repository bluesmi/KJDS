package com.penglai.kjds.ui.view.widget.transformer;

import android.support.v4.view.ViewCompat;
import android.view.View;

/**
 *  * 作者：朋来-GZQ on 2017/1/8 13:33
 *  * 邮箱：gongzhiqing@xiyundata.com
 *  
 */
public class ZoomFadePageTransformer extends CustomerPageTransformer{

    @Override
    public void handleInvisiblePage(View view, float position) {
    }

    @Override
    public void handleLeftPage(View view, float position) {
        ViewCompat.setTranslationX(view, -view.getWidth() * position);

        ViewCompat.setPivotX(view, view.getWidth() * 0.5f);
        ViewCompat.setPivotY(view, view.getHeight() * 0.5f);
        ViewCompat.setScaleX(view, 1 + position);
        ViewCompat.setScaleY(view, 1 + position);

        ViewCompat.setAlpha(view, 1 + position);
    }

    @Override
    public void handleRightPage(View view, float position) {
        ViewCompat.setTranslationX(view, -view.getWidth() * position);

        ViewCompat.setPivotX(view, view.getWidth() * 0.5f);
        ViewCompat.setPivotY(view, view.getHeight() * 0.5f);
        ViewCompat.setScaleX(view, 1 - position);
        ViewCompat.setScaleY(view, 1 - position);
        ViewCompat.setAlpha(view, 1 - position);
    }
}
