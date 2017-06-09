package com.penglai.kjds.ui.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.penglai.kjds.R;
import com.penglai.kjds.ui.base.BaseViewHolder;
import com.penglai.kjds.ui.view.listener.OnItemClickListener;

import butterknife.BindView;

/**
 *  * 作者：朋来-GZQ on 2017/1/17 15:12
 *  * 邮箱：gongzhiqing@xiyundata.com
 *  
 */
public class IndexViewHolder extends BaseViewHolder<String> {

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

    public IndexViewHolder(Context context, ViewGroup root) {
        super(context, root, R.layout.list_item_index);
    }

    @Override
    protected void bindData(final String itemValue,final int position, final OnItemClickListener listener) {
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
