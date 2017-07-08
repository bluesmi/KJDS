package com.penglai.kjds.ui.holder;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.penglai.kjds.R;
import com.penglai.kjds.model.index.TrainInfo;
import com.penglai.kjds.ui.base.BaseViewHolder;
import com.penglai.kjds.ui.view.listener.OnItemClickListener;

import butterknife.BindView;

/**
 * Created by m199 on 2017/7/8.
 */

public class TrainViewHolder extends BaseViewHolder<TrainInfo> {

    @BindView(R.id.img_train_introduce)
    ImageView imgTrainIntroduce;
    @BindView(R.id.tv_train_name)
    TextView tvTrainName;
    @BindView(R.id.tv_finish_apply)
    TextView tvFinishApply;
    //承办单位
    @BindView(R.id.tv_host)
    TextView tvHost;
    @BindView(R.id.tv_train_desc)
    TextView tvTrainDesc;
    //已报名人数
    @BindView(R.id.tv_part_number)
    TextView tvPartNumber;
    @BindView(R.id.tv_limit_number)
    TextView tvLimitNumber;
    @BindView(R.id.tv_apply_time)
    TextView tvApplyTime;
    @BindView(R.id.tv_train_time)
    TextView tvTrainTime;
    @BindView(R.id.tv_train_address)
    TextView tvTrainAddress;

    @BindView(R.id.btn_apply)
    TextView btnApply;


    private final Context mContext;

    public TrainViewHolder(Context context, ViewGroup root) {
        super(context, root, R.layout.list_item_train);
        this.mContext = context;
    }

    @Override
    protected void bindData(TrainInfo itemValue, int position, OnItemClickListener listener) {
        Glide.with(mContext)
                .load(itemValue.getPhotoId())
                .placeholder(R.drawable.icon_default_logo)
                .error(R.drawable.icon_default_logo)
                .into(imgTrainIntroduce);
        tvTrainName.setText(itemValue.getTrainTitle());
        String isFinish = itemValue.getStatusCode();
        if(null != isFinish && isFinish.length() != 0){
            int flag = Integer.parseInt(isFinish);
            if(1 == flag){
                btnApply.setBackgroundResource(R.drawable.btn_gray_bg_shape);
                btnApply.setTextColor(mContext.getResources().getColor(R.color.blue_top_bg));
            }
            tvFinishApply.setText( flag == 0 ? "报名中" : "已结束");
        }
        tvHost.setText(itemValue.getHost());
        tvTrainDesc.setText(itemValue.getContent());
        tvPartNumber.setText(itemValue.getPartNumber()+"");
        tvLimitNumber.setText(itemValue.getLimitNumber()+"");

        String applyStartTime = itemValue.getApplySTime();
        String applyEndTime = itemValue.getApplyETime();
        if (null != applyStartTime && 0 != applyStartTime.length() &&
                null != applyEndTime && 0 != applyEndTime.length()){
            tvApplyTime.setText(applyStartTime.substring(0,10)+" 至 "+applyEndTime.substring(0,10));
        }

        String startTime = itemValue.getStartTime();
        String endTime = itemValue.getEndTime();
        if (null != startTime && 0 != startTime.length() &&
                null != endTime && 0 != endTime.length()){
            tvTrainTime.setText(startTime.substring(0,10)+" 至 "+endTime.substring(0,10));
        }
        tvTrainAddress.setText(itemValue.getAddress());


    }
}
