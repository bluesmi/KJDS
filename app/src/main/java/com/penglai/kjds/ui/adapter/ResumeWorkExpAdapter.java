package com.penglai.kjds.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.penglai.kjds.model.resume.WorkExpInfoReq;
import com.penglai.kjds.ui.base.BaseAdapter;
import com.penglai.kjds.ui.base.BaseViewHolder;
import com.penglai.kjds.ui.holder.ResumeWorkExpViewHolder;

/**
 * Created by m199 on 2017/6/27.
 */

public class ResumeWorkExpAdapter extends BaseAdapter<WorkExpInfoReq> {
    @Override
    protected BaseViewHolder createViewHolder(Context context, ViewGroup parent) {
        return new ResumeWorkExpViewHolder(context,parent);
    }
}
