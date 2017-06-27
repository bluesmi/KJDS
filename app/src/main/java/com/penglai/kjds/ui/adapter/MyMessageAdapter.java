package com.penglai.kjds.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.penglai.kjds.model.user.MyMessage;
import com.penglai.kjds.ui.base.BaseAdapter;
import com.penglai.kjds.ui.base.BaseViewHolder;
import com.penglai.kjds.ui.holder.MyMessageViewHolder;

/**
 * Created by m199 on 2017/6/27.
 */

public class MyMessageAdapter extends BaseAdapter<MyMessage> {
    @Override
    protected BaseViewHolder createViewHolder(Context context, ViewGroup parent) {
        return new MyMessageViewHolder(context,parent);
    }
}
