package com.penglai.kjds.ui.my;

import android.graphics.Bitmap;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
 *      意见反馈
 *
 *  * 作者：朋来-GZQ on 2017/1/13 15:06
 *  * 邮箱：gongzhiqing@xiyundata.com
 *  
 */
public class FeedBackActivity extends BaseActivity {

    @BindView(R.id.index_top_layout)
    LinearLayout indexTopLayout;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.common_top_layout)
    RelativeLayout commonTopLayout;
    @BindString(R.string.feedback)
    String title;
    @BindView(R.id.et_title)
    EditText etTitle;
    @BindView(R.id.et_content)
    EditText etContent;


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
        return inflateView(R.layout.activity_feedback);
    }

    @Override
    protected void setContentViewAfter(View contentView) {
        ButterKnife.bind(FeedBackActivity.this);
        //绑定view
        initData();
    }

    protected void initData() {
        indexTopLayout.setVisibility(View.GONE);
        commonTopLayout.setVisibility(View.VISIBLE);
        commonTopLayout.setBackgroundColor(topBackgroundColor);

        tvTitle.setText(title);
        tvTitle.setTextColor(txtColor);
        btnBack.setImageBitmap(commonBack);
    }

    @OnClick({R.id.btn_submit_question,R.id.btn_back})
    public void onClick(View v ){
        switch (v.getId()){
            case R.id.btn_submit_question:          //问题提交

                break;

            case R.id.btn_back:                               //返回
                finish();
                break;
        }
    }
}
