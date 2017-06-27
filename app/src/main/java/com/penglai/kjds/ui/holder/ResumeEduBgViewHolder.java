package com.penglai.kjds.ui.holder;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

import com.penglai.kjds.R;
import com.penglai.kjds.model.resume.EduBgInfo;
import com.penglai.kjds.ui.base.BaseViewHolder;
import com.penglai.kjds.ui.view.listener.OnItemClickListener;

import butterknife.BindView;

/**
 * Created by m199 on 2017/6/27.
 */

public class ResumeEduBgViewHolder extends BaseViewHolder<EduBgInfo> {
    @BindView(R.id.tv_school)
    TextView tvSchool;
    @BindView(R.id.tv_profession)
    TextView tvProfession;
    @BindView(R.id.tv_professional)
    TextView tvProfessional;
    @BindView(R.id.tv_enter_school_date)
    TextView tvEnterSchoolData;
    @BindView(R.id.tv_finish_school_date)
    TextView tvFinishSchoolData;

    public ResumeEduBgViewHolder(Context context, ViewGroup root) {
        super(context, root, R.layout.list_item_resume_edu_bg);
    }

    @Override
    protected void bindData(EduBgInfo itemValue, int position, OnItemClickListener listener) {
        tvSchool.setText(itemValue.getSchoolName());
        tvProfession.setText(itemValue.getProfessional());
        tvProfessional.setText(itemValue.getProfessional());
        String startTime = itemValue.getStartTime();
        String endTime = itemValue.getEndTime();
        if(null != startTime && !"".equals(startTime)){
        tvEnterSchoolData.setText(startTime.substring(0,10));
        }
        if(null != endTime && !"".equals(endTime)){
            tvFinishSchoolData.setText(endTime.substring(0,10));
        }

    }

}
