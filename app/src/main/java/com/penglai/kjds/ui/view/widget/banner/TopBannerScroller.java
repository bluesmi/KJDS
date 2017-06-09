package com.penglai.kjds.ui.view.widget.banner;

import android.content.Context;
import android.widget.Scroller;

/**
 *  * 作者：朋来-GZQ on 2017/1/8 13:13
 *  * 邮箱：gongzhiqing@xiyundata.com
 *  
 */
public class TopBannerScroller  extends Scroller {
    private int mDuration = 1000;

    public TopBannerScroller(Context context, int duration) {
        super(context);
        mDuration = duration;
    }

    @Override
    public void startScroll(int startX, int startY, int dx, int dy) {
        super.startScroll(startX, startY, dx, dy, mDuration);
    }

    @Override
    public void startScroll(int startX, int startY, int dx, int dy, int duration) {
        super.startScroll(startX, startY, dx, dy, mDuration);
    }
}