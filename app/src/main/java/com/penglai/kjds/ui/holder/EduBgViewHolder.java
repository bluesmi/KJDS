package com.penglai.kjds.ui.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.penglai.kjds.R;
import com.penglai.kjds.model.resume.EduBgInfo;
import com.penglai.kjds.ui.base.BaseViewHolder;
import com.penglai.kjds.ui.view.listener.OnItemClickListener;

import butterknife.BindView;

/**
 * Created by m199 on 2017/6/20.
 */

public class EduBgViewHolder extends BaseViewHolder<EduBgInfo> {

    @BindView(R.id.tv_school)
    TextView tvSchool;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv_other_info)
    TextView tvOtherInfo;
    @BindView(R.id.btn_enter_detail)
    RelativeLayout enterDetailLayout;
    @BindView(R.id.btn_delete)
    TextView btnDelete;

    private Context mContext;
    public EduBgViewHolder(Context context, ViewGroup root) {
        super(context, root, R.layout.list_item_edu_bg);
        this.mContext = context;
    }

    @Override
    protected void bindData(final EduBgInfo itemValue, final int position, final OnItemClickListener listener) {
        tvSchool.setText(itemValue.getSchoolName());
        String startTime = itemValue.getStartTime();
        String endTime = itemValue.getEndTime();
        if(null != startTime && null != endTime) {
            tvTime.setText(startTime.substring(0, 10) + "-" + endTime.substring(0, 10));
        }else {
            tvTime.setText("");
        }
        tvOtherInfo.setText(itemValue.getAcademy()+"|"+itemValue.getProfessional());
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
        btnDelete.setOnClickListener(new View.OnClickListener() {
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
