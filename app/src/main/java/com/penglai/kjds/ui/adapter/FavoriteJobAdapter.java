package com.penglai.kjds.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.penglai.kjds.R;
import com.penglai.kjds.model.user.CollectInfo;
import com.penglai.kjds.ui.base.BaseAdapter;
import com.penglai.kjds.ui.base.BaseViewHolder;
import com.penglai.kjds.ui.holder.FavoriteJobViewHolder;

/**
 * Created by m199 on 2017/6/26.
 */

public class FavoriteJobAdapter extends BaseAdapter<CollectInfo> {
    @Override
    protected BaseViewHolder createViewHolder(Context context, ViewGroup parent) {
        return new FavoriteJobViewHolder(context,parent);
    }
}
