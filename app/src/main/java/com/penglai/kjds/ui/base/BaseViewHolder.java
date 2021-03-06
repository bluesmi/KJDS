package com.penglai.kjds.ui.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.penglai.kjds.ui.view.listener.OnItemClickListener;

import butterknife.ButterKnife;


/**
 *  * 作者：朋来-GZQ on 2017/1/17 14:59
 *  * 邮箱：gongzhiqing@xiyundata.com
 *  
 */
public abstract class BaseViewHolder<V> extends RecyclerView.ViewHolder {

    public BaseViewHolder(Context context, ViewGroup root, int layoutRes) {
        super(LayoutInflater.from(context).inflate(layoutRes, root, false));
        //使用ButterKnife来进行控件的绑定
        ButterKnife.bind(this, itemView);
    }

    /**
     * 方便其子类进行一些需要Context的操作.
     * @return 调用者的Context
     */
    public Context getContext() {
        return itemView.getContext();
    }

    /**
     * 用于传递数据和信息
     * @param itemValue
     * @param position
     * @param listener
     */
    public void setData(V  itemValue, int position, OnItemClickListener listener) {
        bindData(itemValue, position, listener);
    }

    /**
     * 抽象方法，绑定数据.
     * 让子类自行对数据和view进行绑定
     * @param itemValue Item的数据
     * @param position 当前item的position
     * @param listener 点击事件监听者
     */
    protected abstract void bindData(V itemValue, int position, OnItemClickListener listener);

}
