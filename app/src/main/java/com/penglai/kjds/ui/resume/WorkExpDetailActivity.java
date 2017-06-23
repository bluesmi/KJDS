package com.penglai.kjds.ui.resume;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.penglai.kjds.R;
import com.penglai.kjds.model.resume.WorkExpInfoReq;
import com.penglai.kjds.presenter.impl.ModifyWorkExpInfoPresenterImpl;
import com.penglai.kjds.presenter.implView.ModifyWorkExpInfoView;
import com.penglai.kjds.ui.base.BaseActivity;
import com.penglai.kjds.utils.PickerUtils;
import com.penglai.kjds.utils.SettingPrefUtils;

import butterknife.BindColor;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.qqtheme.framework.picker.DatePicker;

/**
 * 添加工作/实习经历
 * <p>
 *  * 作者：朋来-GZQ on 2017/1/16 14:38
 *  * 邮箱：gongzhiqing@xiyundata.com
 *  
 */
public class WorkExpDetailActivity extends BaseActivity implements ModifyWorkExpInfoView{

    @BindView(R.id.index_top_layout)
    LinearLayout indexTopLayout;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.common_top_layout)
    RelativeLayout commonTopLayout;
    @BindView(R.id.btn_base)
    Button btnBase;
    @BindView(R.id.company_content)
    TextView tvCompanyName;
    @BindView(R.id.job_content)
    TextView tvJobContent;
    @BindView(R.id.tv_start_time)
    TextView tvStartTime;
    @BindView(R.id.end_time)
    TextView tvEndTime;
    @BindView(R.id.et_content)
    EditText etContent;

    @BindString(R.string.work_experience)
    String title;
    @BindColor(R.color.common_light_gray_txt)
    int txtColor;
    @BindString(R.string.save)
    String save;

    private static final int COMPANYNAME = 0;

    private WorkExpInfoReq workExpInfoReq;

    private ModifyWorkExpInfoPresenterImpl workExpInfoPresenter;

    @Override
    protected View getContentView() {
        return inflateView(R.layout.activity_add_work_exp);
    }

    @Override
    protected void setContentViewAfter(View contentView) {
        ButterKnife.bind(WorkExpDetailActivity.this);
        //绑定view
        initData();
    }

    protected void initData() {
        workExpInfoPresenter = new ModifyWorkExpInfoPresenterImpl(mContext,this);
        //初始化标题栏布局
        indexTopLayout.setVisibility(View.GONE);
        commonTopLayout.setVisibility(View.VISIBLE);
        btnBase.setVisibility(View.VISIBLE);
        btnBase.setTextColor(txtColor);
        tvTitle.setText(title);
        tvStartTime.setTextColor(txtColor);
        tvEndTime.setTextColor(txtColor);
        btnBase.setText(save);
        Intent intent = getIntent();
        workExpInfoReq = (WorkExpInfoReq) intent.getSerializableExtra("workExpInfoReq");
        if(null != workExpInfoReq){
            initWorkExpInfo();
        }else {
            workExpInfoReq = new WorkExpInfoReq();
            workExpInfoReq.setId("");
            String userId = SettingPrefUtils.getUid();
            if(null != userId && !"".equals(userId)){
                workExpInfoReq.setUserId(userId);
            }
        }

    }

    private void initWorkExpInfo() {
        tvCompanyName.setText(workExpInfoReq.getCompanyName());
        tvJobContent.setText(workExpInfoReq.getPosition());
        tvStartTime.setText(workExpInfoReq.getStartTime().substring(0,10));
        tvEndTime.setText(workExpInfoReq.getEndTime().substring(0,10));
        etContent.setText(workExpInfoReq.getWorkContent());
    }


    @OnClick({R.id.btn_back, R.id.btn_company, R.id.btn_job, R.id.btn_start_time, R.id.btn_end_time,R.id.btn_base})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:                                                     //返回
                Intent mIntent = new Intent(mContext,WorkExperienceActivity.class);
                setResult(RESULT_OK,mIntent);
                finish();
                break;

            case R.id.btn_company:                                             //公司/机构名称
                break;
            case R.id.btn_job:                                                         //职位/岗位
                break;

            case R.id.btn_start_time:                                            //开始时间
                final DatePicker datePicker = PickerUtils.onYearMonthPicker(this,view);
                datePicker.getSubmitButton().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        UiUtils.showToast(mContext);
                        tvStartTime.setText(datePicker.getSelectedYear() + "-" + datePicker.getSelectedMonth());
                        tvStartTime.setTextColor(Color.parseColor("#24CD9E"));
                        datePicker.dismiss();
                    }
                });
                break;

            case R.id.btn_end_time:                                             //结束时间
                final DatePicker endDatePicker = PickerUtils.onYearMonthPicker(this,view);
                endDatePicker.getSubmitButton().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        UiUtils.showToast(mContext);
                        tvEndTime.setText(endDatePicker.getSelectedYear() + "-" + endDatePicker.getSelectedMonth());
                        tvEndTime.setTextColor(Color.parseColor("#24CD9E"));
                        endDatePicker.dismiss();
                    }
                });
                break;
            case R.id.btn_base:
                resetWorkExpInfo();
                workExpInfoPresenter.modifyWorkExpInfo("modifyWorkExpInfo", JSON.toJSONString(workExpInfoReq));
                break;
        }
    }

    private void resetWorkExpInfo() {
        workExpInfoReq.setCompanyName(tvCompanyName.getText().toString());
        workExpInfoReq.setPosition(tvJobContent.getText().toString());
        workExpInfoReq.setEndTime(tvEndTime.getText().toString());
        workExpInfoReq.setStartTime(tvStartTime.getText().toString());
        workExpInfoReq.setPosition(tvJobContent.getText().toString());
        workExpInfoReq.setWorkContent(etContent.getText().toString());
    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void modifyWorkExpInfoSuccess() {
        Intent intent = new Intent(mContext,WorkExperienceActivity.class);
        setResult(RESULT_OK,intent);
        finish();
    }
}
