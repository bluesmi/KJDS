package com.penglai.kjds.ui.my;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.penglai.kjds.R;
import com.penglai.kjds.ui.base.BaseActivity;

import butterknife.BindBitmap;
import butterknife.BindColor;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 *      我的收藏
 *
 *  * 作者：朋来-GZQ on 2017/1/13 14:04
 *  * 邮箱：gongzhiqing@xiyundata.com
 *  
 */
public class MyFavoriteActivity extends BaseActivity {

    @BindView(R.id.index_top_layout)
    LinearLayout indexTopLayout;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.common_top_layout)
    RelativeLayout commonTopLayout;
    @BindString(R.string.my_favorite)
    String title;
    @BindView(R.id.iv_company_logo)
    ImageView ivCompanyLogo;
    @BindView(R.id.tv_job_name)
    TextView tvJobName;
    @BindView(R.id.tv_other_info)
    TextView tvOtherInfo;
    @BindView(R.id.tv_company_info)
    TextView tvCompanyInfo;
    @BindView(R.id.tv_pay)
    TextView tvPay;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv_job_type)
    TextView tvJobType;
    @BindView(R.id.favorite_default_content)
    LinearLayout defaultContentLayout;
    @BindView(R.id.favorite_content)
    LinearLayout contentLayout;
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
        return inflateView(R.layout.activity_my_favorite);
    }

    @Override
    protected void setContentViewAfter(View contentView) {
        ButterKnife.bind(MyFavoriteActivity.this);
        //绑定view
        initData();
    }

    protected void initData() {
        //初始化标题栏布局
        indexTopLayout.setVisibility(View.GONE);
        commonTopLayout.setVisibility(View.VISIBLE);
        commonTopLayout.setBackgroundColor(topBackgroundColor);
        btnBack.setImageBitmap(commonBack);

        tvTitle.setText(title);
        tvTitle.setTextColor(txtColor);
        defaultContentLayout.setVisibility(View.GONE);
        contentLayout.setVisibility(View.VISIBLE);
    }

    @OnClick({R.id.enter_detail_layout,R.id.btn_cancel_favorite,
            R.id.btn_send_resume,R.id.btn_back})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.enter_detail_layout:         //进入详情

            break;

            case R.id.btn_cancel_favorite:         //取消收藏

                break;

            case R.id.btn_send_resume:            //发送简历

                break;

            case R.id.btn_back:                          //返回
                finish();
                break;
        }

    }

}
