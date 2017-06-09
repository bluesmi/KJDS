package com.penglai.kjds.ui.resume;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.penglai.kjds.R;
import com.penglai.kjds.ui.base.BaseActivity;
import com.penglai.kjds.ui.index.CareerOpportunitiesActivity;

import butterknife.BindColor;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 *  * 作者：朋来-GZQ on 2017/1/16 14:51
 *  * 邮箱：gongzhiqing@xiyundata.com
 *  
 */
public class PreviewResumeActivity extends BaseActivity {
    @BindView(R.id.index_top_layout)
    LinearLayout indexTopLayout;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.common_top_layout)
    RelativeLayout commonTopLayout;
    @BindString(R.string.preview_resume)
    String title;
    @BindColor(R.color.blue_top_bg)
    int topBackgroundColor;
    @BindColor(R.color.app_bg)
    int txtColor;
    //基本信息
    @BindView(R.id.tv_base_info)
    LinearLayout tvBaseInfo;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_sex)
    TextView tvSex;
    @BindView(R.id.tv_birthday)
    TextView tvBirthday;
    @BindView(R.id.tv_work_data)
    TextView tvWorkData;
    @BindView(R.id.tv_born_place)
    TextView tvBornPlace;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_email)
    TextView tvEmail;

    //教育背景
    @BindView(R.id.tv_edu_bg)
    LinearLayout tvEduBg;
    @BindView(R.id.tv_school)
    TextView tvSchool;
    @BindView(R.id.tv_profession)
    TextView tvProfession;
    @BindView(R.id.tv_degree)
    TextView tvDgree;
    @BindView(R.id.tv_enter_school_date)
    TextView tvEnterSchoolData;
    @BindView(R.id.tv_finish_school_date)
    TextView tvFinishSchoolData;

    //工作经验
    @BindView(R.id.tv_work_exp)
    LinearLayout tvWorkExp;
    @BindView(R.id.tv_company_name)
    TextView tvCompanyName;
    @BindView(R.id.tv_start_time)
    TextView tvStartTime;
    @BindView(R.id.tv_end_time)
    TextView  tvEndTime;
    @BindView(R.id.tv_job_type)
    TextView tvJobType;
    @BindView(R.id.tv_job_name)
    TextView tvJobName;
    @BindView(R.id.tv_pay)
    TextView tvPay;

    //自我评价
    @BindView(R.id.tv_self_evaluation)
    LinearLayout tvSelfEvaluation;
    @BindView(R.id.tv_evaluation_hint)
    TextView tvEvaluationHint;

    @Override
    protected View getContentView() {
        return inflateView(R.layout.activity_preview_resume);
    }

    @Override
    protected void setContentViewAfter(View contentView) {
        ButterKnife.bind(PreviewResumeActivity.this);
        //绑定view
        initData();
    }

    protected void initData() {
        ButterKnife.bind(PreviewResumeActivity.this);
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
