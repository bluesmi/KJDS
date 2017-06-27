package com.penglai.kjds.ui.holder;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.penglai.kjds.R;
import com.penglai.kjds.model.resume.WorkExpInfoReq;
import com.penglai.kjds.ui.base.BaseViewHolder;
import com.penglai.kjds.ui.view.listener.OnItemClickListener;

import butterknife.BindView;

/**
 * Created by m199 on 2017/6/27.
 */

public class ResumeWorkExpViewHolder extends BaseViewHolder<WorkExpInfoReq> {
    //工作经验

    @BindView(R.id.tv_company_name)
    TextView tvCompanyName;
    @BindView(R.id.tv_start_time)
    TextView tvStartTime;
    @BindView(R.id.tv_end_time)
    TextView  tvEndTime;
   /* @BindView(R.id.tv_job_type)
    TextView tvJobType;*/
    @BindView(R.id.tv_job_name)
    TextView tvJobName;
    @BindView(R.id.tv_job_require)
    TextView tvJobRequire;

    private Context mContext;

    public ResumeWorkExpViewHolder(Context context, ViewGroup root) {
        super(context, root, R.layout.list_item_resume_work_exp);
        this.mContext = context;
    }

    @Override
    protected void bindData(WorkExpInfoReq itemValue, int position, OnItemClickListener listener) {
        tvCompanyName.setText(itemValue.getCompanyName());

        tvJobRequire.setText(itemValue.getWorkContent());
        String startTime = itemValue.getStartTime();
        String endTime = itemValue.getEndTime();
        tvJobName.setText(itemValue.getPosition());
        if(null != startTime && !"".equals(startTime))
            tvStartTime.setText(startTime.substring(0,7));
        if(null != endTime && !"".equals(endTime))
            tvEndTime.setText(endTime.substring(0,7));
    }
}
