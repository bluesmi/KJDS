package com.penglai.kjds.ui.view.widget.transformer;

import android.support.v4.view.ViewCompat;
import android.view.View;

/**
 *  * 作者：朋来-GZQ on 2017/1/8 13:36
 *  * 邮箱：gongzhiqing@xiyundata.com
 *  
 */
public class StackPageTransformer extends CustomerPageTransformer {

    @Override
    public void handleInvisiblePage(View view, float position) {
    }

    @Override
    public void handleLeftPage(View view, float position) {
    }

    @Override
    public void handleRightPage(View view, float position) {
        ViewCompat.setTranslationX(view, -view.getWidth() * position);
    }
}
