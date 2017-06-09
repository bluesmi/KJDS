package com.penglai.kjds.ui.resume;

import android.view.View;
import android.widget.EditText;
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
 * 自我评价
 *  * 作者：朋来-GZQ on 2017/1/16 14:35
 *  * 邮箱：gongzhiqing@xiyundata.com
 *  
 */
public class EvaluationActivity extends BaseActivity {

    @BindView(R.id.index_top_layout)
    LinearLayout indexTopLayout;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.common_top_layout)
    RelativeLayout commonTopLayout;
    @BindView(R.id.et_content)
    EditText etContent;
    @BindColor(R.color.blue_top_bg)
    int topBackgroundColor;
    @BindColor(R.color.white)
    int topColor;

    @BindString(R.string.base_info)
    String title;

    @Override
    protected View getContentView() {
        return inflateView(R.layout.activity_evaluation);
    }

    @Override
    protected void setContentViewAfter(View contentView) {
        ButterKnife.bind(EvaluationActivity.this);
        //绑定view
        initData();
    }

    protected void initData() {
        //初始化标题栏布局
        indexTopLayout.setVisibility(View.GONE);
        commonTopLayout.setVisibility(View.VISIBLE);
        commonTopLayout.setBackgroundColor(topBackgroundColor);
        tvTitle.setTextColor(topColor);
        tvTitle.setText(title);
    }

    @OnClick({R.id.btn_back, R.id.btn_submit_evaluation})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:                                                     //返回
                finish();
                break;

            case R.id.btn_submit_evaluation:                             //提交评价

                break;
        }
    }
}
