package com.penglai.kjds.ui.view.widget.transformer;

import android.support.v4.view.ViewCompat;
import android.view.View;

/**
 *  * 作者：朋来-GZQ on 2017/1/8 13:27
 *  * 邮箱：gongzhiqing@xiyundata.com
 *  
 */
public class AlphaPageTransformer extends CustomerPageTransformer{

    private float mMinScale = 0.4f;

    public AlphaPageTransformer() {
    }

    public AlphaPageTransformer(float minScale) {
        setMinScale(minScale);
    }

    @Override
    public void handleInvisiblePage(View view, float position) {
        ViewCompat.setAlpha(view, 0);
    }

    @Override
    public void handleLeftPage(View view, float position) {
        ViewCompat.setAlpha(view, mMinScale + (1 - mMinScale) * (1 + position));
    }

    @Override
    public void handleRightPage(View view, float position) {
        ViewCompat.setAlpha(view, mMinScale + (1 - mMinScale) * (1 - position));
    }

    public void setMinScale(float minScale) {
        if (minScale >= 0.0f && minScale <= 1.0f) {
            mMinScale = minScale;
        }
    }
}
