package com.penglai.kjds.ui.resume;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.penglai.kjds.R;
import com.penglai.kjds.ui.base.BaseActivity;
import com.penglai.kjds.utils.PickerUtils;
import com.penglai.kjds.utils.UiUtils;

import java.util.Calendar;

import butterknife.BindBitmap;
import butterknife.BindColor;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.qqtheme.framework.picker.DatePicker;

/**
 * 添加教育背景
 * <p>
 *  * 作者：朋来-GZQ on 2017/1/16 14:36
 *  * 邮箱：gongzhiqing@xiyundata.com
 *  
 */
public class EduBgDetailActivity extends BaseActivity {

    @BindView(R.id.index_top_layout)
    LinearLayout indexTopLayout;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.common_top_layout)
    RelativeLayout commonTopLayout;
    @BindView(R.id.tv_school)
    TextView tvSchool;
    @BindView(R.id.tv_degree)
    TextView tvDegree;
    @BindView(R.id.tv_profession)
    TextView tvProfession;
    @BindView(R.id.tv_enter_school_date)
    TextView tvEnterSchoolDate;
    @BindView(R.id.tv_finish_school_date)
    TextView tvFinishSchoolDate;
    @BindView(R.id.btn_base)
    Button btnBase;
    @BindColor(R.color.blue_top_bg)
    int topBackgroundColor;
    @BindColor(R.color.white)
    int topColor;

    @BindString(R.string.work_experience)
    String title;
    @BindColor(R.color.common_light_gray_txt)
    int txtColor;
    @BindString(R.string.save)
    String save;

    @Override
    protected View getContentView() {
        return inflateView(R.layout.activity_add_edu_bg);
    }

    @Override
    protected void setContentViewAfter(View contentView) {
        ButterKnife.bind(EduBgDetailActivity.this);
        //绑定view
        initData();
    }

    protected void initData() {
        //初始化标题栏布局
        indexTopLayout.setVisibility(View.GONE);
        commonTopLayout.setVisibility(View.VISIBLE);
        commonTopLayout.setBackgroundColor(topBackgroundColor);
        btnBase.setVisibility(View.VISIBLE);
        btnBase.setTextColor(Color.parseColor("#EFEFEF"));
        tvEnterSchoolDate.setTextColor(txtColor);
        tvFinishSchoolDate.setTextColor(txtColor);
        tvTitle.setText(title);
        tvTitle.setTextColor(topColor);
        btnBase.setText(save);
    }

    @OnClick({R.id.btn_back, R.id.btn_school, R.id.btn_degree, R.id.btn_profession,
            R.id.btn_enter_school, R.id.btn_finish_school})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:                                                     //返回
                finish();
                break;

            case R.id.btn_school:                                                  //学校/机构
                break;

            case R.id.btn_degree:                                                 //学历/学位
                break;

            case R.id.btn_profession:                                           //专业/课程
                break;

            case R.id.btn_enter_school:                                      //入学时间
                final DatePicker datePicker = PickerUtils.onYearMonthPicker(this,view);
                datePicker.getSubmitButton().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        UiUtils.showToast(mContext);
                        tvEnterSchoolDate.setText(datePicker.getSelectedYear() + "-" + datePicker.getSelectedMonth());
                        tvEnterSchoolDate.setTextColor(Color.parseColor("#24CD9E"));
                        datePicker.dismiss();
                    }
                });

                break;

            case R.id.btn_finish_school:                                       //毕业时间
                final DatePicker finishSchoolPicker = PickerUtils.onYearMonthPicker(this,view);
                finishSchoolPicker.getSubmitButton().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
//                        UiUtils.showToast(mContext);
                        tvFinishSchoolDate.setText(finishSchoolPicker.getSelectedYear() + "-" + finishSchoolPicker.getSelectedMonth());
                        tvFinishSchoolDate.setTextColor(Color.parseColor("#24CD9E"));
                        finishSchoolPicker.dismiss();
                    }
                });
                break;
        }
    }
}
