package com.penglai.kjds.ui.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Unbinder;

/**
 * fragment的基类
 * <p/>
 *  * 作者：朋来-GZQ on 2017/1/6 15:21
 *  * 邮箱：gongzhiqing@xiyundata.com
 *  
 */
public abstract class BaseFragment extends Fragment {

    protected LayoutInflater mInflater;
    protected FragmentActivity mContext;
    public Unbinder unbinder;
    public  ViewGroup container;

    // fragment创建
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
        /*mInflater = (LayoutInflater) mContext.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);*/
        mInflater = LayoutInflater.from(mContext);
    }

    //跳转到活跃状态调用的方法
    @Override
    public void onResume() {
        super.onResume();
    }

    // 处理fragment的布局
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.container = container;
        return initViews();
    }

    // 依附的activity创建完成
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();

    }

    // 子类必须实现初始化布局的方法
    public abstract View initViews();

    // 初始化数据
    public abstract void initData();


}
