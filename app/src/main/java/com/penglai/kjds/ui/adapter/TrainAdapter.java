package com.penglai.kjds.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.penglai.kjds.model.index.TrainInfo;
import com.penglai.kjds.ui.base.BaseAdapter;
import com.penglai.kjds.ui.base.BaseViewHolder;
import com.penglai.kjds.ui.holder.TrainViewHolder;

/**
 * Created by m199 on 2017/7/8.
 */

public class TrainAdapter extends BaseAdapter<TrainInfo> {
    @Override
    protected BaseViewHolder createViewHolder(Context context, ViewGroup parent) {
        return new TrainViewHolder(context,parent);
    }
}
