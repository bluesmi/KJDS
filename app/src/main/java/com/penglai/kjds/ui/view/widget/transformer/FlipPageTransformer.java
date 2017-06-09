package com.penglai.kjds.ui.view.widget.transformer;

import android.support.v4.view.ViewCompat;
import android.view.View;

/**
 *  * 作者：朋来-GZQ on 2017/1/8 13:32
 *  * 邮箱：gongzhiqing@xiyundata.com
 *  
 */
public class FlipPageTransformer extends CustomerPageTransformer{
    private static final float ROTATION = 180.0f;

    @Override
    public void handleInvisiblePage(View view, float position) {
    }

    @Override
    public void handleLeftPage(View view, float position) {
        ViewCompat.setTranslationX(view, -view.getWidth() * position);
        float rotation = (ROTATION * position);
        ViewCompat.setRotationY(view, rotation);

        if (position > -0.5) {
            view.setVisibility(View.VISIBLE);
        } else {
            view.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void handleRightPage(View view, float position) {
        ViewCompat.setTranslationX(view, -view.getWidth() * position);
        float rotation = (ROTATION * position);
        ViewCompat.setRotationY(view, rotation);

        if (position < 0.5) {
            view.setVisibility(View.VISIBLE);
        } else {
            view.setVisibility(View.INVISIBLE);
        }
    }

}
