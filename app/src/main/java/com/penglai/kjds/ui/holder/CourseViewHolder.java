package com.penglai.kjds.ui.holder;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.penglai.kjds.R;
import com.penglai.kjds.model.index.Course;
import com.penglai.kjds.ui.base.BaseViewHolder;
import com.penglai.kjds.ui.view.listener.OnItemClickListener;

import butterknife.BindView;

/**
 * Created by m199 on 2017/7/8.
 */

public class CourseViewHolder extends BaseViewHolder<Course> {

    @BindView(R.id.img_course_introduce)
    ImageView imgCourseIntroduce;
    @BindView(R.id.tv_course_name)
    TextView tvCourseName;
    @BindView(R.id.tv_grade)
    TextView tvGrade;
    @BindView(R.id.tv_teacher_name)
    TextView tvTeacherName;
    @BindView(R.id.tv_course_desc)
    TextView tvCourseDesc;
    @BindView(R.id.tv_course_time)
    TextView tvCourseTime;
    private Context mContext;

    public CourseViewHolder(Context context, ViewGroup root) {
        super(context, root, R.layout.list_item_course);
        this.mContext = context;
    }


    @Override
    protected void bindData(Course itemValue, int position, OnItemClickListener listener) {
        Glide.with(mContext)
                .load(itemValue.getPhotoId())
                .placeholder(R.drawable.icon_default_logo)
                .error(R.drawable.icon_default_logo)
                .into(imgCourseIntroduce);
        tvCourseName.setText(itemValue.getCourseName());
        String levelId = itemValue.getLevelId();
        if(null != levelId && 0 != levelId.length()){
            int levelFlag = Integer.parseInt(levelId);
            tvGrade.setText(getLevelId(levelFlag));
        }
        tvTeacherName.setText(itemValue.getCreateCourseUser());
        tvCourseDesc.setText(itemValue.getDesc());
        String startTime = itemValue.getStartTime();
        String endTime = itemValue.getEndTime();

        if (null != startTime && 0 != startTime.length() &&
            null != endTime && 0 != startTime.length()){
            tvCourseTime.setText(startTime.substring(0,10)+" -- "+endTime.substring(0,10));
        }

    }

    private String getLevelId(int levelFlag) {
        String level = "";
        switch (levelFlag) {
            case 0:
                 level = "初级";
                break;
            case 1:
                level = "中级";
                break;
            case 2:
                level = "高级";
                break;
        }
        return level;
    }
}
