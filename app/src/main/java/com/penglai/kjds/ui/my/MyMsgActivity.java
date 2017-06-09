package com.penglai.kjds.ui.my;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageButton;
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
 *   我的消息
 *
 *  * 作者：朋来-GZQ on 2017/1/13 14:04
 *  * 邮箱：gongzhiqing@xiyundata.com
 *  
 */
public class MyMsgActivity extends BaseActivity {

    @BindView(R.id.index_top_layout)
    LinearLayout indexTopLayout;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.common_top_layout)
    RelativeLayout commonTopLayout;
    @BindString(R.string.my_msg)
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
        return inflateView(R.layout.activity_my_msg);
    }

    @Override
    protected void setContentViewAfter(View contentView) {
        ButterKnife.bind(MyMsgActivity.this);
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
    }

    @OnClick({R.id.btn_back})
    public void  onClick(View v){
        switch (v.getId()){
            case R.id.btn_back:
                finish();
            break;
        }
    }
}
