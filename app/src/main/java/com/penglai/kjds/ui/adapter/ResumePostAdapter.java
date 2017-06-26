package com.penglai.kjds.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.penglai.kjds.model.user.DeliverInfo;
import com.penglai.kjds.ui.base.BaseAdapter;
import com.penglai.kjds.ui.base.BaseViewHolder;
import com.penglai.kjds.ui.holder.ResumePostViewHolder;

/**
 * Created by m199 on 2017/6/26.
 */

public class ResumePostAdapter extends BaseAdapter<DeliverInfo> {
    @Override
    protected BaseViewHolder createViewHolder(Context context, ViewGroup parent) {
        return new ResumePostViewHolder(context,parent);
    }
}
