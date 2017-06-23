package com.penglai.kjds.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.penglai.kjds.model.resume.WorkExpInfoReq;
import com.penglai.kjds.ui.base.BaseAdapter;
import com.penglai.kjds.ui.base.BaseViewHolder;
import com.penglai.kjds.ui.holder.WorkExpInfoViewHolder;

/**
 * Created by m199 on 2017/6/22.
 */

public class WorkExpInfoAdapter extends BaseAdapter<WorkExpInfoReq> {
    @Override
    protected BaseViewHolder createViewHolder(Context context, ViewGroup parent) {
        return new WorkExpInfoViewHolder(context,parent);
    }
}
