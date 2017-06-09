package com.penglai.kjds.ui.resume;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.penglai.kjds.R;
import com.penglai.kjds.ui.base.BaseActivity;
import com.penglai.kjds.utils.PickerUtils;

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
public class WorkExpDetailActivity extends BaseActivity {

    @BindView(R.id.index_top_layout)
    LinearLayout indexTopLayout;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.common_top_layout)
    RelativeLayout commonTopLayout;
    @BindView(R.id.btn_base)
    Button btnBase;
    /*@BindView(R.id.tv_company_name)
    TextView tvCompanyName;*/
    @BindView(R.id.tv_start_time)
    TextView tvStartTime;
    @BindView(R.id.end_time)
    TextView endTime;
    @BindView(R.id.et_content)
    EditText etContent;

    @BindString(R.string.work_experience)
    String title;
    @BindColor(R.color.common_light_gray_txt)
    int txtColor;
    @BindString(R.string.save)
    String save;

    private static final int COMPANYNAME = 0;

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
        //初始化标题栏布局
        indexTopLayout.setVisibility(View.GONE);
        commonTopLayout.setVisibility(View.VISIBLE);
        btnBase.setVisibility(View.VISIBLE);
        btnBase.setTextColor(txtColor);
        tvTitle.setText(title);
        tvStartTime.setTextColor(txtColor);
        endTime.setTextColor(txtColor);
        btnBase.setText(save);
    }


    @OnClick({R.id.btn_back, R.id.btn_company, R.id.btn_job, R.id.btn_start_time, R.id.btn_end_time})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:                                                     //返回
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
                        endTime.setText(endDatePicker.getSelectedYear() + "-" + endDatePicker.getSelectedMonth());
                        endTime.setTextColor(Color.parseColor("#24CD9E"));
                        endDatePicker.dismiss();
                    }
                });
                break;
        }
    }
}
