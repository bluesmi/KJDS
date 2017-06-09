package com.penglai.kjds.ui.my;

import android.content.Intent;
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
import com.penglai.kjds.utils.UiUtils;

import butterknife.BindBitmap;
import butterknife.BindColor;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by m199 on 2017/4/20.
 */

public class PersonNameActivity extends BaseActivity {
    @BindView(R.id.index_top_layout)
    LinearLayout indexTopLayout;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.common_top_layout)
    RelativeLayout commonTopLayout;
    @BindView(R.id.btn_base)
    Button btnBase;
    @BindView(R.id.person_nickname)
    EditText nickName;

    @BindString(R.string.save)
    String save;
    @BindString(R.string.update_nickname)
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
        return inflateView(R.layout.activity_edit_text);
    }

    @Override
    protected void setContentViewAfter(View contentView) {
        ButterKnife.bind(PersonNameActivity.this);
        initData();
    }
    protected void initData() {
        //初始化标题栏布局
        indexTopLayout.setVisibility(View.GONE);
        commonTopLayout.setVisibility(View.VISIBLE);
        tvTitle.setText(title);
        btnBase.setVisibility(View.VISIBLE);
        btnBase.setTextColor(txtColor);
        tvTitle.setText(title);
        tvTitle.setTextColor(txtColor);
        btnBase.setText(save);
        commonTopLayout.setBackgroundColor(topBackgroundColor);
        btnBack.setImageBitmap(commonBack);
        String strNickName = getIntent().getStringExtra("nickName");
        if(!"".equals(strNickName))
        nickName.setText(strNickName);
        UiUtils.showToast(mContext,getIntent().getExtras()+""+"更改呢称");
    }
    @OnClick({R.id.btn_back,R.id.btn_base})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:
                finish();
                break;
            case R.id.btn_base:                                                      //保存信息
                Intent intent = new Intent(mContext,PersonInfoActivity.class);
//                UiUtils.showToast(mContext,nickName.getText().toString());
//                if(!"".equals(nickName.getText().toString()))
                intent.putExtra("nickName",nickName.getText().toString());
                setResult(RESULT_OK,intent);
                finish();
                break;

        }
    }
}
