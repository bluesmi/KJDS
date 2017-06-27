package com.penglai.kjds.ui.my;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.penglai.kjds.R;
import com.penglai.kjds.ui.base.BaseActivity;
import com.penglai.kjds.ui.my.changeview.SettingChargeView;
import com.penglai.kjds.utils.DataCleanManagerUtils;
import com.penglai.kjds.utils.PopWindowUtil;

import butterknife.BindBitmap;
import butterknife.BindColor;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 *      设置
 *
 *  * 作者：朋来-GZQ on 2017/1/13 14:05
 *  * 邮箱：gongzhiqing@xiyundata.com
 *  
 */
public class SettingActivity extends BaseActivity implements SettingChargeView{

    @BindView(R.id.index_top_layout)
    LinearLayout indexTopLayout;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.common_top_layout)
    RelativeLayout commonTopLayout;
    @BindView(R.id.tv_cache)
    TextView tvCache;
    @BindView(R.id.tv_update_version)
    TextView tvUpdateVersion;
    @BindString(R.string.setting)
    String title;
    @BindColor(R.color.app_bg)
    int txtColor;
    @BindView(R.id.btn_back)
    ImageButton btnBack;
    @BindColor(R.color.blue_top_bg)
    int topBackgroundColor;
    @BindBitmap(R.drawable.icon_common_back)
    Bitmap commonBack;
    @Override
    protected View getContentView() {
        return inflateView(R.layout.activity_setting);
    }

    @Override
    protected void setContentViewAfter(View contentView) {
        ButterKnife.bind(SettingActivity.this);
        //绑定view
        initData();
    }

    protected void initData() {
        indexTopLayout.setVisibility(View.GONE);
        commonTopLayout.setVisibility(View.VISIBLE);
        tvTitle.setText(title);
        tvTitle.setTextColor(txtColor);
        commonTopLayout.setBackgroundColor(topBackgroundColor);
        btnBack.setImageBitmap(commonBack);
        String cache = "0KB";
        try {
            cache = DataCleanManagerUtils.getTotalCacheSize(mContext);
        } catch (Exception e) {
            e.printStackTrace();
        }
        tvCache.setText(cache);
    }

    @OnClick({R.id.clear_cache_layout, R.id.update_version_layout,R.id.btn_user_logout,
            R.id.feedback_layout, R.id.modify_pwd_layout,R.id.btn_back})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.clear_cache_layout:                          //清除缓存
                PopWindowUtil.confirmCleanCache(mContext,getContentView(),this,this);

                break;
            case R.id.update_version_layout:                   //版本更新
                PopWindowUtil.checkUpdateSystem(mContext,getContentView(),this);
                break;
            case R.id.feedback_layout:                             //意见反馈
                startActivity(new Intent(mContext,FeedBackActivity.class));
                break;

//            case R.id.about_kjds_layout:                         //关于平台
//                startActivity(new Intent(mContext,AboutKJDSActivity.class));
//                break;

            case R.id.modify_pwd_layout:                      //修改密码
                startActivity(new Intent(mContext,ModifyPwdActivity.class));
                break;

            case R.id.btn_user_logout:                            //退出登陆
                PopWindowUtil.loginOut(mContext,getContentView(),this);
                break;

            case R.id.btn_back:                                         //返回
                finish();
                break;
        }

    }

    @Override
    public void onSuccess() {
        String cache = "0KB";
        try {
            cache = DataCleanManagerUtils.getTotalCacheSize(mContext);
        } catch (Exception e) {
            e.printStackTrace();
        }
        tvCache.setText(cache);
    }

    @Override
    public void onFailure(String message) {

    }
}
