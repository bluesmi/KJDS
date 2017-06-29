package com.penglai.kjds.ui.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.penglai.kjds.R;
import com.penglai.kjds.model.user.DeliverInfo;
import com.penglai.kjds.ui.base.BaseViewHolder;
import com.penglai.kjds.ui.view.listener.OnItemClickListener;

import butterknife.BindView;

/**
 * Created by m199 on 2017/6/26.
 */

public class ResumePostViewHolder extends BaseViewHolder<DeliverInfo> {
    @BindView(R.id.img_company_logo)
    ImageView ivCompanyLogo;
    @BindView(R.id.tv_recommend)
    TextView tvRecommend;
    @BindView(R.id.tv_job_name)
    TextView tvJobName;
    //类型
    @BindView(R.id.tv_item_pt)
    TextView tvItemPt;
    //信息：公司名+（国营、民营）
    @BindView(R.id.tv_company_detail)
    TextView tvCompanyDetail;
    //工作地点-工作经验要求-学历要求
    @BindView(R.id.tv_job_require)
    TextView tvJobRequire;
    //pay：薪资待遇
    @BindView(R.id.tv_company_condition)
    TextView tvCompanyCondition;
    //开始时间
    @BindView(R.id.tv_publish_time)
    TextView tvPublishTime;
    @BindView(R.id.btn_enter_detail)
    LinearLayout enterDetailLayout;

    private Context mContext;
    public ResumePostViewHolder(Context context, ViewGroup root) {
        super(context, root, R.layout.list_item_post);
        this.mContext = context;
    }

    @Override
    protected void bindData(final DeliverInfo itemValue, final int position, final OnItemClickListener listener) {
        Glide.with(mContext)
                .load(itemValue.getLogoID())
                .placeholder(R.drawable.icon_default_logo)
                .error(R.drawable.icon_default_logo)
                .into(ivCompanyLogo);
        String  recommend = itemValue.getIsRecommend();
        if(null !=  recommend && !"".equals(recommend) && Integer.parseInt(recommend) == 0){
            tvRecommend.setVisibility(View.GONE);
        }
        tvJobName.setText(itemValue.getTitle());
        //类型
//        String typeId = itemValue.getTypeID();
        tvItemPt.setText(getTypeID(itemValue.getTypeID()));
        tvCompanyDetail.setText(itemValue.getAddress()+"|"+itemValue.getCompanyName());
        tvCompanyCondition.setText(itemValue.getSalary());
        tvPublishTime.setText(itemValue.getStartTime());
        tvJobRequire.setVisibility(View.GONE);
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

    private String getTypeID(String typeId) {
        String type = null;
        if(null != typeId && !"".equals(typeId)){
            int id = Integer.parseInt(typeId);
            switch (id){
                case 0 :
                    type = "全部";
                    break;
                case 1 :
                    type = "兼职";
                    break;
                case 2 :
                    type = "全职";
                    break;
                case 3 :
                    type = "项目";
                    break;

            }
        }

        return type;
    }

}
