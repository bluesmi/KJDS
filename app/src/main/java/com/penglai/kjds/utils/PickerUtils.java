package com.penglai.kjds.utils;

import android.app.Activity;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


import com.penglai.kjds.R;

import java.util.Calendar;
import java.util.Locale;

import cn.qqtheme.framework.picker.DatePicker;
import cn.qqtheme.framework.picker.OptionPicker;
import cn.qqtheme.framework.widget.WheelView;

/**
 * Created by m199 on 2017/4/20.
 */

public class PickerUtils {

    //        性别选择器
    public static OptionPicker onConstellationPicker(Activity activity, View view) {
        boolean isChinese = Locale.getDefault().getDisplayLanguage().contains("中文");
        OptionPicker picker = new OptionPicker(activity,
                isChinese ? new String[]{
                        "男","女"
                } : new String[]{
                        "male", "woman"
                });
        picker.setCycleDisable(true);//不禁用循环
        picker.setTopBackgroundColor(0xFFEEEEEE);
        picker.setTopHeight(50);
        picker.setTopLineColor(0xFF33B5E5);
        picker.setTopLineHeight(1);
        picker.setTitleText(isChinese ? "请选择" : "Please pick");
        picker.setTitleTextColor(0xFF999999);
        picker.setTitleTextSize(12);
        picker.setCancelTextColor(0xFF33B5E5);
        picker.setCancelTextSize(13);
        picker.setSubmitTextColor(0xFF33B5E5);
        picker.setSubmitTextSize(13);
        picker.setTextColor(0xFFEE0000, 0xFF999999);
        WheelView.LineConfig config = new WheelView.LineConfig();
        config.setColor(0xFFEE0000);//线颜色
        config.setAlpha(140);//线透明度
        config.setRatio((float) (1.0 / 8.0));//线比率
        picker.setLineConfig(config);
        picker.setItemWidth(200);
        picker.setBackgroundColor(0xFFE1E1E1);
        picker.setSelectedIndex(0);
        return picker;
    }

    //    日期选择框
    public static DatePicker onYearMonthDayPicker(final Activity activity, View view) {
        final DatePicker picker = new DatePicker(activity);
        Calendar start = Calendar.getInstance();
        picker.setTopPadding(3);
        picker.setRangeStart(start.get(Calendar.YEAR)-100, start.get(Calendar.MONTH)+1, start.get(Calendar.DAY_OF_MONTH));
        picker.setRangeEnd(start.get(Calendar.YEAR), start.get(Calendar.MONTH)+1, start.get(Calendar.DAY_OF_MONTH));
        picker.setSelectedItem(start.get(Calendar.YEAR), start.get(Calendar.MONTH)+1, start.get(Calendar.DAY_OF_MONTH));
        picker.setOnDatePickListener(new DatePicker.OnYearMonthDayPickListener() {
            @Override
            public void onDatePicked(String year, String month, String day) {
                Toast.makeText(activity,year + "-" + month + "-" + day,Toast.LENGTH_SHORT).show();
            }
        });
        picker.setOnWheelListener(new DatePicker.OnWheelListener() {
            @Override
            public void onYearWheeled(int index, String year) {
                picker.setTitleText(year + "-" + picker.getSelectedMonth() + "-" + picker.getSelectedDay());
            }

            @Override
            public void onMonthWheeled(int index, String month) {
                picker.setTitleText(picker.getSelectedYear() + "-" + month + "-" + picker.getSelectedDay());
            }

            @Override
            public void onDayWheeled(int index, String day) {
                picker.setTitleText(picker.getSelectedYear() + "-" + picker.getSelectedMonth() + "-" + day);
            }
        });
        picker.setCancelText("取消");
        picker.setSubmitText("确定");
        picker.show();

        return  picker;
    }

    //    年月选择框
    public static DatePicker onYearMonthPicker(Activity activity, View view) {
        DatePicker picker = new DatePicker(activity, DatePicker.YEAR_MONTH);
        picker.setGravity(Gravity.CENTER | Gravity.CENTER_HORIZONTAL);
        picker.setWidth((int) (picker.getScreenWidthPixels() * 0.6));

        Calendar calendar = Calendar.getInstance();
        picker.setRangeStart(calendar.get(Calendar.YEAR)-50, calendar.get(Calendar.MONTH)+1,calendar.get(Calendar.DAY_OF_MONTH));

        if(R.id.btn_enter_school == view.getId()) {
            picker.setRangeEnd(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH));
        }else  if(R.id.btn_finish_school == view.getId()) {
            picker.setRangeEnd(calendar.get(Calendar.YEAR) + 10, calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH));
        }else{
            picker.setRangeEnd(calendar.get(Calendar.YEAR) , calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH));
        }
        picker.setSelectedItem(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH)+1);
        picker.setSubmitText("确定");
        picker.setCancelText("取消");
        picker.show();
        return  picker;
    }
}
