package com.penglai.kjds.ui.view.widget;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;


import com.penglai.kjds.R;



/**
 * Created by m199 on 2017/3/23.
 */

public class PopWindowView extends PopupWindow {
    public final static  String TAG = PopWindowView.class.getSimpleName();
    private Context mContext;
    private Activity activity;
    public PopWindowView(Context context, Activity activity,View contentView) {
        super(context);
        this.mContext = context;
        this.activity = activity;
        showPopupWindow(contentView);

    }

    private void showPopupWindow(View contentView) {
        this.setContentView(contentView);
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        ColorDrawable dw = new ColorDrawable(0x00000000);
        this.setBackgroundDrawable(dw);
        this.backgroundAlpha(0.5f);
        this.setFocusable(true);

        backgroundAlpha(0.5f);
        setAnimationStyle(R.style.pop_window_anim_style);
    }

    public void backgroundAlpha(float bgAlpha)
    {
        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
        lp.alpha = bgAlpha;
        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        activity.getWindow().setAttributes(lp);
    }

    @Override
    public void dismiss() {
        super.dismiss();
        backgroundAlpha(1f);
    }


}
