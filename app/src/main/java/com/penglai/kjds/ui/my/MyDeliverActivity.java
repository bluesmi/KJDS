package com.penglai.kjds.ui.my;

import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.penglai.kjds.R;
import com.penglai.kjds.ui.base.BaseActivity;

import butterknife.BindColor;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 *    我的投递
 *
 *  * 作者：朋来-GZQ on 2017/1/13 14:03
 *  * 邮箱：gongzhiqing@xiyundata.com
 *  
 */
public class MyDeliverActivity extends BaseActivity {

    @BindView(R.id.index_top_layout)
    LinearLayout indexTopLayout;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.common_top_layout)
    RelativeLayout commonTopLayout;
    @BindString(R.string.my_deliver)
    String title;
    @BindColor(R.color.blue_top_bg)
    int topBackgroundColor;
    @BindColor(R.color.app_bg)
    int txtColor;

    @Override
    protected View getContentView() {
        return inflateView(R.layout.activity_my_deliver);
    }

    @Override
    protected void setContentViewAfter(View contentView) {
        ButterKnife.bind(MyDeliverActivity.this);
        //绑定view
        initData();
    }

    protected void initData() {
       //初始化标题栏布局
        indexTopLayout.setVisibility(View.GONE);
        commonTopLayout.setVisibility(View.VISIBLE);
        commonTopLayout.setBackgroundColor(topBackgroundColor);
        tvTitle.setText(title);
        tvTitle.setTextColor(txtColor);
    }

    @OnClick({R.id.btn_back})
    public void  onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back:
                finish();
                break;
        }
    }
}
