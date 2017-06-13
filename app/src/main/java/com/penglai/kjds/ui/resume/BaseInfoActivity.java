package com.penglai.kjds.ui.resume;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.penglai.kjds.R;
import com.penglai.kjds.ui.base.BaseActivity;
import com.penglai.kjds.utils.PickerUtils;

import butterknife.BindBitmap;
import butterknife.BindColor;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.qqtheme.framework.picker.DatePicker;
import cn.qqtheme.framework.picker.OptionPicker;

/**
 * 个人信息
 * <p>
 *  * 作者：朋来-GZQ on 2017/1/16 14:32
 *  * 邮箱：gongzhiqing@xiyundata.com
 *  
 */
public class BaseInfoActivity extends BaseActivity {

    @BindView(R.id.index_top_layout)
    LinearLayout indexTopLayout;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.common_top_layout)
    RelativeLayout commonTopLayout;
    @BindView(R.id.btn_base)
    Button btnBase;
    @BindView(R.id.tv_username)
    TextView tvUsername;
    @BindView(R.id.tv_school)
    TextView tvSchool;
    @BindView(R.id.tv_department)
    TextView tvDepartment;
    @BindView(R.id.tv_city)
    TextView tvCity;
    @BindView(R.id.tv_birthday)
    TextView tvBirthday;
    @BindView(R.id.tv_sex)
    TextView tvSex;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_email)
    TextView tvEmail;
    @BindView(R.id.btn_back)
    ImageButton btnBack;
    @BindColor(R.color.app_bg)
    int txtColor;
    @BindString(R.string.save)
    String save;
    @BindString(R.string.base_info)
    String title;
    @BindColor(R.color.blue_top_bg)
    int topBackgroundColor;
    @BindBitmap(R.drawable.icon_common_back)
    Bitmap commonBack;
    @BindColor(R.color.white)
    int topColor;


    @Override
    protected View getContentView() {
        return inflateView(R.layout.activity_base_info);
    }

    @Override
    protected void setContentViewAfter(View contentView) {
        ButterKnife.bind(BaseInfoActivity.this);
        //绑定view
        initData();
    }

    protected void initData() {
        //初始化标题栏布局
        indexTopLayout.setVisibility(View.GONE);
        commonTopLayout.setVisibility(View.VISIBLE);
        commonTopLayout.setBackgroundColor(topBackgroundColor);
        btnBase.setVisibility(View.VISIBLE);
        btnBase.setTextColor(txtColor);
        tvTitle.setText(title);
        tvTitle.setTextColor(topColor);
        tvBirthday.setTextColor(txtColor);
        tvSex.setTextColor(txtColor);
        btnBase.setText(save);
        btnBack.setImageBitmap(commonBack);
    }

    @OnClick({R.id.btn_back, R.id.btn_base, R.id.btn_username, R.id.btn_school,
            R.id.btn_department, R.id.btn_city, R.id.btn_birthday, R.id.btn_sex, R.id.btn_phone, R.id.btn_email})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:                                                      //返回
                finish();
                break;

            case R.id.btn_base:                                                     //保存信息
                break;

            case R.id.btn_username:                                             //姓名
                break;

            case R.id.btn_school:                                                   //学校
                break;

            case R.id.btn_department:                                         //系部
                break;

            case R.id.btn_city:                                                        //城市
                break;

            case R.id.btn_birthday:                                               //生日
                final DatePicker datePicker = PickerUtils.onYearMonthDayPicker(this,view);
                datePicker.getSubmitButton().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tvBirthday.setText(datePicker.getSelectedYear()+"-"+datePicker.getSelectedMonth()+"-"+datePicker.getSelectedDay());
                        tvBirthday.setTextColor(Color.parseColor("#24CD9E"));
                        datePicker.dismiss();
                    }
                });
                break;

            case R.id.btn_sex://性别
                OptionPicker picker = PickerUtils.onConstellationPicker(this,view);

                picker.setOnOptionPickListener(new OptionPicker.OnOptionPickListener() {
                    @Override
                    public void onOptionPicked(int index, String item) {
                        tvSex.setText(item);
                        tvSex.setTextColor(Color.parseColor("#24CD9E"));
                    }
                });
                picker.show();

                break;

            case R.id.btn_phone:                                                   //手机号码

                break;

            case R.id.btn_email:                                                     //邮箱
                break;
        }
    }
}