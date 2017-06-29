package com.penglai.kjds.ui.my;

import android.content.Intent;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.penglai.kjds.R;
import com.penglai.kjds.model.user.MyMessage;
import com.penglai.kjds.ui.base.BaseActivity;

import butterknife.BindBitmap;
import butterknife.BindColor;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by m199 on 2017/6/29.
 */

public class MyMessageDetailActivity extends BaseActivity {
    @BindView(R.id.index_top_layout)
    LinearLayout indexTopLayout;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.common_top_layout)
    RelativeLayout commonTopLayout;
    @BindString(R.string.my_msg_detail)
    String title;
    @BindColor(R.color.app_bg)
    int txtColor;
    @BindView(R.id.btn_back)
    ImageButton btnBack;
    @BindColor(R.color.blue_top_bg)
    int topBackgroundColor;
    @BindBitmap(R.drawable.icon_common_back)
    Bitmap commonBack;
    @BindView(R.id.et_title)
    EditText etTitle;
    @BindView(R.id.et_content)
    EditText etContent;


    @Override
    protected View getContentView() {
        return inflateView(R.layout.activity_my_message_detail);
    }

    @Override
    protected void setContentViewAfter(View contentView) {
        ButterKnife.bind(MyMessageDetailActivity.this);
        //绑定view
        initData();
    }

    private void initData() {
        //初始化标题栏布局
        indexTopLayout.setVisibility(View.GONE);
        commonTopLayout.setVisibility(View.VISIBLE);
        commonTopLayout.setBackgroundColor(topBackgroundColor);
        btnBack.setImageBitmap(commonBack);
        tvTitle.setText(title);
        tvTitle.setTextColor(txtColor);

        Intent intent = getIntent();
        MyMessage myMessage = (MyMessage) intent.getSerializableExtra("myMessage");
        if(null != myMessage){
            showMyMessageInfo(myMessage);
        }
    }

    private void showMyMessageInfo(MyMessage myMessage) {
        etTitle.setText(myMessage.getTitle());
        etContent.setText(myMessage.getContent());
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
