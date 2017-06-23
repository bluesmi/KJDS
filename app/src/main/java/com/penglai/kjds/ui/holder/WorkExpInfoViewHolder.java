package com.penglai.kjds.ui.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.penglai.kjds.R;
import com.penglai.kjds.model.resume.WorkExpInfoReq;
import com.penglai.kjds.ui.base.BaseViewHolder;
import com.penglai.kjds.ui.view.listener.OnItemClickListener;

import butterknife.BindString;
import butterknife.BindView;

/**
 * Created by m199 on 2017/6/22.
 */

public class WorkExpInfoViewHolder extends BaseViewHolder<WorkExpInfoReq> {
    @BindView(R.id.tv_job_name)
    TextView tvJobName;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv_company_info)
    TextView tvCompanyInfo;
    //是否核实
    @BindView(R.id.tv_verify)
    TextView tvVerify;
    @BindString(R.string.already_verify)
    String alreadyVerify;
    @BindView(R.id.btn_enter_detail)
    RelativeLayout enterDetailLayout;

    public WorkExpInfoViewHolder(Context context, ViewGroup root) {
        super(context, root, R.layout.list_item_work_exp_info);
    }

    @Override
    protected void bindData(final WorkExpInfoReq itemValue, final int position, final OnItemClickListener listener) {
        tvJobName.setText(itemValue.getPosition());
        tvCompanyInfo.setText(itemValue.getCompanyName());
        tvTime.setText(itemValue.getStartTime().substring(0,7)+"--"+itemValue.getEndTime().substring(0,7));
        //点击item事件
        enterDetailLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener == null) {
                    return;
                }
                listener.onItemClick(itemValue, v.getId(), position);
            }
        });
    }
}
