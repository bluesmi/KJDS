package com.penglai.kjds.ui.resume;

import android.content.Intent;
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
 * 实习/工作经历
 * <p>
 *  * 作者：朋来-GZQ on 2017/1/16 14:34
 *  * 邮箱：gongzhiqing@xiyundata.com
 *  
 */
public class WorkExperienceActivity extends BaseActivity {

    @BindView(R.id.index_top_layout)
    LinearLayout indexTopLayout;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.common_top_layout)
    RelativeLayout commonTopLayout;
    @BindView(R.id.tv_job_name)
    TextView tvJobName;
    @BindView(R.id.tv_verify)
    TextView tvVerify;
    @BindView(R.id.verify_layout)
    LinearLayout verifyLayout;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv_company_info)
    TextView tvCompanyInfo;
    @BindColor(R.color.blue_top_bg)
    int topBackgroundColor;

    @BindString(R.string.work_experience)
    String title;

    @Override
    protected View getContentView() {
        return inflateView(R.layout.activity_work_exp);
    }

    @Override
    protected void setContentViewAfter(View contentView) {
        ButterKnife.bind(WorkExperienceActivity.this);
        //绑定view
        initData();
    }

    protected void initData() {
        //初始化标题栏布局
        indexTopLayout.setVisibility(View.GONE);
        commonTopLayout.setVisibility(View.VISIBLE);
        commonTopLayout.setBackgroundColor(topBackgroundColor);
        tvTitle.setText(title);
    }

    @OnClick({R.id.btn_back, R.id.btn_add_work_exp, R.id.btn_enter_detail})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:                                                                                           //返回
                finish();
                break;

            case R.id.btn_add_work_exp:
                startActivity(new Intent(mContext,WorkExpDetailActivity.class));       //添加实习/工作经历
                break;

            case R.id.btn_enter_detail:
                startActivity(new Intent(mContext,WorkExpDetailActivity.class));      //进入实习/工作经历
                break;
        }
    }
}
