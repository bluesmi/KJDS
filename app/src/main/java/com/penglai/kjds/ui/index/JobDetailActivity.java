package com.penglai.kjds.ui.index;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.penglai.kjds.R;
import com.penglai.kjds.model.index.CompanyInfo;
import com.penglai.kjds.model.index.JobDetail;
import com.penglai.kjds.ui.base.BaseActivity;
import com.penglai.kjds.utils.PopWindowUtil;
import com.penglai.kjds.utils.UiUtils;

import butterknife.BindColor;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 职位/岗位详情
 *  * 作者：朋来-GZQ on 2017/1/17 16:11
 *  * 邮箱：gongzhiqing@xiyundata.com
 *  
 */
public class JobDetailActivity extends BaseActivity {

    public final static String TAG = JobDetailActivity.class.getSimpleName();

    @BindView(R.id.index_top_layout)
    LinearLayout indexTopLayout;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.common_top_layout)
    RelativeLayout commonTopLayout;
    @BindString(R.string.job_info)
    String jobInfo;
    @BindView(R.id.search_layout)
    LinearLayout searchLayout;
//    @BindView(R.id.btn_send_resume)
//    LinearLayout sendResume;
    @BindView(R.id.btn_login)
    TextView btnLogin;
    @BindView(R.id.tv_job_name)
    TextView tvJobName;
    @BindView(R.id.tv_pay)
    TextView tvPay;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.tv_experience)
    TextView tvExperience;
    @BindView(R.id.tv_degree)
    TextView tvDegree;
    @BindView(R.id.tv_employ_type)
    TextView tvEmployType;
    @BindView(R.id.tv_employ_num)
    TextView tvEmployNum;
    @BindView(R.id.tv_job_profit)
    TextView tvJobProfit;
    @BindView(R.id.tv_work_address)
    TextView tvWorkAddress;
    @BindView(R.id.iv_company_logo)
    ImageView ivCompanyLogo;
    @BindView(R.id.tv_company_info)
    TextView tvCompanyInfo;
    @BindView(R.id.tv_company_desc)
    TextView tvCompanyDesc;
    @BindView(R.id.tv_job_desc)
    TextView tvJobDesc;


    @BindColor(R.color.blue_top_bg)
    int topBackgroundColor;
    @BindColor(R.color.app_bg)
    int txtColor;

    private JobDetail jobDetail;
    @Override
    protected View getContentView() {
        return inflateView(R.layout.activity_job_detail);
    }

    @Override
    protected void setContentViewAfter(View contentView) {
        ButterKnife.bind(JobDetailActivity.this);
        //初始化
        initData();
    }

    protected void initData() {
        indexTopLayout.setVisibility(View.GONE);
        commonTopLayout.setVisibility(View.VISIBLE);
        tvTitle.setText(jobInfo);
        commonTopLayout.setBackgroundColor(topBackgroundColor);
        tvTitle.setText(jobInfo);
        tvTitle.setTextColor(txtColor);
        Intent intent = getIntent();
        jobDetail = (JobDetail) intent.getSerializableExtra("jobDetail");
        if(null != jobDetail){
            initJobDetailInterface();
        }
    }

    private void initJobDetailInterface() {
        tvJobName.setText(jobDetail.getTitle());
        tvPay.setText(jobDetail.getSalary());
        //表示当前定位的地点，而不是工作地点，当前先用工作地点
        tvAddress.setText(jobDetail.getAddress());
        tvExperience.setText(jobDetail.getWorkExperience());
        tvDegree.setText(jobDetail.getEduRequire());
        tvEmployType.setText(jobDetail.getTypeID());
//        tvJobProfit.setText(jobDetail.);
        tvWorkAddress.setText(jobDetail.getAddress());
        Glide.with(mContext)
                .load(jobDetail.getLogoID())
                .placeholder(R.drawable.icon_user_img)
                .error(R.drawable.icon_user_img)
                .into(ivCompanyLogo);
        tvCompanyInfo.setText(jobDetail.getCompanyName());
        String comPanyDesc = (Integer.parseInt(jobDetail.getOrgProp()) == 1 ? "私企" : "国企")+"/"+jobDetail.getCompanyNumber();
        tvCompanyDesc.setText(comPanyDesc);

    }

    @OnClick({R.id.btn_back, R.id.btn_company_info,R.id.btn_send_resume,R.id.btn_collect_job})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:                                                     //返回

                finish();
                break;

            case R.id.btn_company_info:
                   startActivity(new Intent(mContext, CompanyInfoActivity.class));
                    finish();
                break;
            case R.id.btn_collect_job:
//                show(this,R.layout.collect_toast);
//                UiUtils.showToast(JobDetailActivity.this,"已收藏");
//                AppUtils.init(mContext);
                UiUtils.showImgToast(mContext,"已收藏",R.drawable.icon_confirm_collect);
//                midToast2("已收藏",Toast.LENGTH_LONG);
                break;
            case R.id.btn_send_resume:
                UiUtils.showToast(mContext,"简历以发送");
//                showNormalDailog();
//                confirmSendResume();
                PopWindowUtil.confirmSendResume(mContext,getContentView(),this);
                break;
        }
    }






}
