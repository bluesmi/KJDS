package com.penglai.kjds.utils;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.penglai.kjds.R;

/**
 *     View相关的工具类
 *
 *  * 作者：朋来-GZQ on 2017/1/6 17:43
 *  * 邮箱：gongzhiqing@xiyundata.com
 *  
 */
public class UiUtils {

    public static Toast mToast;
    public static Toast mImgToast;
    /**
     * 自定义
     *
     * @param context
     * @param text
     */
    public static void showToast(Context context, String text) {
        if (null != mToast) {
            mToast.setText(text);
        } else {
            mToast = Toast.makeText(context, text, Toast.LENGTH_SHORT);
        }
        mToast.setGravity(Gravity.CENTER, 0, 0);
        mToast.show();
    }
    /**
     * 显示带图片的Toast
     * @param mContext
     * @param text
     * @param icon
     */
    public static void showImgToast(Context mContext,String text, int icon) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.collect_toast,
                null);
        view.setMinimumWidth(300);
        view.setMinimumHeight(100);
        ImageView img_logo = (ImageView) view.findViewById(R.id.toast_iv);
        TextView tv_msg = (TextView) view.findViewById(R.id.toast_tv);
        img_logo.setImageResource(icon);
        tv_msg.setText(text);
        if(null == mImgToast) {
            mImgToast = new Toast(mContext);
        }
        mImgToast.setView(view);

        mImgToast.setGravity(Gravity.CENTER, 0, 0);
        mImgToast.setDuration(Toast.LENGTH_SHORT);
        mImgToast.show();
    }


}
