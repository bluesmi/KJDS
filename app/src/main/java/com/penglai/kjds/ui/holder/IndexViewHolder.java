package com.penglai.kjds.ui.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.penglai.kjds.R;
import com.penglai.kjds.model.index.CompanyInfo;
import com.penglai.kjds.ui.base.BaseViewHolder;
import com.penglai.kjds.ui.view.listener.OnItemClickListener;

import butterknife.BindView;

/**
 *  * 作者：朋来-GZQ on 2017/1/17 15:12
 *  * 邮箱：gongzhiqing@xiyundata.com
 *  
 */
public class IndexViewHolder extends BaseViewHolder<CompanyInfo> {

    @BindView(R.id.iv_company_logo)
    ImageView ivCompanyLogo;
    @BindView(R.id.tv_job_name)
    TextView tvJobName;
    @BindView(R.id.tv_job_type)
    TextView tvJobType;
    @BindView(R.id.tv_hot)
    TextView tvHot;
    @BindView(R.id.tv_other_info)
    TextView tvOtherInfo;
    @BindView(R.id.tv_company_info)
    TextView tvCompanyInfo;
    @BindView(R.id.tv_pay)
    TextView tvPay;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.enter_detail_layout)
    RelativeLayout enterDetailLayout;

    private Context mContext;
    public IndexViewHolder(Context context, ViewGroup root) {
        super(context, root, R.layout.list_item_index);
        this.mContext = context;
    }

    @Override
    protected void bindData(final CompanyInfo itemValue,final int position, final OnItemClickListener listener) {
        Glide.with(mContext)
                .load(itemValue.getLogoID())
                .placeholder(R.drawable.icon_user_img)
                .error(R.drawable.icon_user_img)
                .into(ivCompanyLogo);
        tvCompanyInfo.setText(itemValue.getCompanyName()+"|"+(Integer.parseInt(itemValue.getOrgProp())==1 ? "私企" : "国企"));
        tvJobName.setText(itemValue.getTitle());
        tvJobType.setText(itemValue.getTypeID());
        if("False".equals(itemValue.getIsRecommend())){
            tvHot.setVisibility(View.GONE);
        }
        tvOtherInfo.setText(itemValue.getAddress());
        tvPay.setText(itemValue.getSalary());
        String startTime = itemValue.getStartTime();
        String endTime = itemValue.getEndTime();
        if(null != startTime && null != endTime) {
            tvTime.setText(startTime.substring(0, 10) + "-" + endTime.substring(0, 10));
        }else {
            tvTime.setText(startTime+"-"+endTime);
        }
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
