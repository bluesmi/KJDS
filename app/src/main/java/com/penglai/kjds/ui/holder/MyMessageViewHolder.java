package com.penglai.kjds.ui.holder;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.penglai.kjds.R;
import com.penglai.kjds.model.user.MyMessage;
import com.penglai.kjds.ui.base.BaseViewHolder;
import com.penglai.kjds.ui.view.listener.OnItemClickListener;

import butterknife.BindView;

/**
 * Created by m199 on 2017/6/27.
 */

public class MyMessageViewHolder extends BaseViewHolder<MyMessage> {
    @BindView(R.id.iv_img)
    ImageView ivMessageLogo;
    @BindView(R.id.tv_company_info)
    TextView tvMessageTitle;
    @BindView(R.id.tv_other_info)
    TextView tvMessageContent;
    @BindView(R.id.tv_time)
    TextView tvPublishTime;

    public MyMessageViewHolder(Context context, ViewGroup root) {
        super(context, root, R.layout.list_item_my_message);
    }

    @Override
    protected void bindData(MyMessage itemValue, int position, OnItemClickListener listener) {
        tvMessageTitle.setText(itemValue.getTitle());
        tvMessageContent.setText(itemValue.getContent());
        tvPublishTime.setText(itemValue.getSendTime());
    }
}
