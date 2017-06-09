package com.penglai.kjds.utils;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.penglai.kjds.R;
import com.penglai.kjds.ui.view.widget.PopWindowView;

import butterknife.BindView;

/**
 * Created by m199 on 2017/4/29.
 */

public class PopWindowUtil {
    private static PopupWindow mPopWindow;
    private static TextView tvTitle;
    private static TextView tvContent;
    private static TextView btnWrong;
    private static TextView btnRight;
    private static View contentView;
    private static void init(Context mContext){
        contentView = LayoutInflater.from(mContext).inflate(R.layout.pop_send_confirm,null);
        tvTitle = (TextView) contentView.findViewById(R.id.tv_pop_title);
        tvContent= (TextView) contentView.findViewById(R.id.tv_pop_content);
        btnWrong= (TextView) contentView.findViewById(R.id.btn_config_wrong);
        btnRight= (TextView) contentView.findViewById(R.id.btn_config_right);
    }
    public static void confirmSendResume(final Context mContext, View view, Activity activity){

        init(mContext);
        tvTitle.setText("发送确认");
        tvContent.setText("发送后不可撤回，是否发送？");
        btnWrong.setText("再考虑下");
        btnRight.setText("立即发送");
        mPopWindow = new PopWindowView(activity,activity,contentView);
        //设置监听
        mPopWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_OUTSIDE ) {
                    //如果焦点不在popupWindow上，且点击了外面，不再往下dispatch事件：
                    //不做任何响应,不 dismiss popupWindow
                    UiUtils.showToast(mContext,"dicbdcv ");
                    return true;
                }
                //否则default，往下dispatch事件:关掉popupWindow，

                return false;
            }
        });
        mPopWindow.showAtLocation(view, Gravity.CENTER_VERTICAL,0,0);


        btnWrong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UiUtils.showToast(mContext,"再想一想");

                mPopWindow.dismiss();
            }
        });
        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UiUtils.showToast(mContext,"立即发送");
                //权限判断

                mPopWindow.dismiss();
            }
        });

    }
    public static void confirmCleanCache(final Context mContext, View view, Activity activity){
        init(mContext);
        tvTitle.setText("清除缓存");
        tvContent.setText("删除应用缓存\n" + "不会删除个人信息和设置");
        btnWrong.setText("取消");
        btnRight.setText("确定");
        mPopWindow = new PopWindowView(activity,activity,contentView);
        //设置监听
        mPopWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_OUTSIDE ) {
                    //如果焦点不在popupWindow上，且点击了外面，不再往下dispatch事件：
                    //不做任何响应,不 dismiss popupWindow
                    UiUtils.showToast(mContext,"dicbdcv ");
                    return true;
                }
                //否则default，往下dispatch事件:关掉popupWindow，

                return false;
            }
        });
        mPopWindow.showAtLocation(view, Gravity.CENTER_VERTICAL,0,0);
        btnWrong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UiUtils.showToast(mContext,"不删除缓存");

                mPopWindow.dismiss();
            }
        });
        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UiUtils.showToast(mContext,"确定删除缓存");
                //权限判断

                mPopWindow.dismiss();
            }
        });
    }

    public static void checkUpdateSystem(final Context mContext, View view, Activity activity){
        init(mContext);
        tvTitle.setText("检查更新");
        tvContent.setText("发现新版本，是否更新？");
        btnWrong.setText("取消");
        btnRight.setText("确定");
        mPopWindow = new PopWindowView(activity,activity,contentView);
        //设置监听
        mPopWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_OUTSIDE ) {
                    //如果焦点不在popupWindow上，且点击了外面，不再往下dispatch事件：
                    //不做任何响应,不 dismiss popupWindow
                    UiUtils.showToast(mContext,"dicbdcv ");
                    return true;
                }
                //否则default，往下dispatch事件:关掉popupWindow，

                return false;
            }
        });
        mPopWindow.showAtLocation(view, Gravity.CENTER_VERTICAL,0,0);
        btnWrong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UiUtils.showToast(mContext,"不更新");

                mPopWindow.dismiss();
            }
        });
        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UiUtils.showToast(mContext,"更新");
                //权限判断

                mPopWindow.dismiss();
            }
        });
    }

    public static void loginOut(final Context mContext, View view, Activity activity){
        init(mContext);
        tvTitle.setText("退出登录");
        tvContent.setText("退出后，您将不能接受到消息\n是否确认退出？");
        btnWrong.setText("取消");
        btnRight.setText("确定");
        mPopWindow = new PopWindowView(activity,activity,contentView);
        //设置监听
        mPopWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_OUTSIDE ) {
                    //如果焦点不在popupWindow上，且点击了外面，不再往下dispatch事件：
                    //不做任何响应,不 dismiss popupWindow
                    UiUtils.showToast(mContext,"dicbdcv ");
                    return true;
                }
                //否则default，往下dispatch事件:关掉popupWindow，

                return false;
            }
        });
        mPopWindow.showAtLocation(view, Gravity.CENTER_VERTICAL,0,0);
        btnWrong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UiUtils.showToast(mContext,"不更新");

                mPopWindow.dismiss();
            }
        });
        btnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UiUtils.showToast(mContext,"更新");
                //权限判断

                mPopWindow.dismiss();
            }
        });
    }

}
