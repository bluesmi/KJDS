package com.penglai.kjds.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.penglai.kjds.model.index.CompanyInfo;
import com.penglai.kjds.ui.base.BaseAdapter;
import com.penglai.kjds.ui.base.BaseViewHolder;
import com.penglai.kjds.ui.holder.IndexViewHolder;

/**
 *  * 作者：朋来-GZQ on 2017/1/17 15:11
 *  * 邮箱：gongzhiqing@xiyundata.com
 *  
 */
public class IndexAdapter extends BaseAdapter <CompanyInfo>{

    @Override
    protected BaseViewHolder createViewHolder(Context context, ViewGroup parent) {
        return new IndexViewHolder(context, parent);
    }
}
