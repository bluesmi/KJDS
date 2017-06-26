package com.penglai.kjds.ui.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.penglai.kjds.R;
import com.penglai.kjds.model.user.CollectInfo;
import com.penglai.kjds.ui.base.BaseViewHolder;
import com.penglai.kjds.ui.view.listener.OnItemClickListener;

import butterknife.BindView;

/**
 * Created by m199 on 2017/6/26.
 */

public class FavoriteJobViewHolder extends BaseViewHolder<CollectInfo> {

    @BindView(R.id.iv_company_logo)
    ImageView ivCompanyLogo;
    @BindView(R.id.tv_job_name)
    TextView tvJobName;
    @BindView(R.id.tv_other_info)
    TextView tvOtherInfo;
    @BindView(R.id.tv_company_info)
    TextView tvCompanyInfo;
    @BindView(R.id.tv_pay)
    TextView tvPay;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv_job_type)
    TextView tvJobType;
    @BindView(R.id.enter_detail_job_layout)
    RelativeLayout enterDetailLayout;
    @BindView(R.id.btn_cancel_favorite)
    LinearLayout btnCancelFavorite;
    @BindView(R.id.btn_send_resume)
    LinearLayout btnSendResume;


    private Context mContext;
    public FavoriteJobViewHolder(Context context, ViewGroup root) {
        super(context, root,  R.layout.list_item_favorite_job);
        this.mContext = context;
    }

    @Override
    protected void bindData(final CollectInfo itemValue, final int position, final OnItemClickListener listener) {
        Glide.with(mContext)
                .load(itemValue.getLogoID())
                .placeholder(R.drawable.icon_default_logo)
                .error(R.drawable.icon_default_logo)
                .into(ivCompanyLogo);
        tvJobName.setText(itemValue.getTitle());
        tvOtherInfo.setText(itemValue.getAddress()+"  "+itemValue.getWorkExperience());
        tvJobType.setText(itemValue.getTypeID());
        tvPay.setText(itemValue.getSalary());
        tvTime.setText(itemValue.getStartTime());
        String orgProp = itemValue.getOrgProp();
        String otherInfo = itemValue.getCompanyName();
        if(null != orgProp && !"".equals(orgProp)){
            otherInfo = otherInfo +" | " +(Integer.parseInt(orgProp)==1 ? "私企" : "国企");
        }
        tvCompanyInfo.setText(otherInfo);

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
        btnCancelFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener == null) {
                    return;
                }
                listener.onItemClick(itemValue, v.getId(), position);
            }
        });

        btnSendResume.setOnClickListener(new View.OnClickListener() {
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
