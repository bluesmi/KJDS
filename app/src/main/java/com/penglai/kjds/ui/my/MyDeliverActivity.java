package com.penglai.kjds.ui.my;


import android.content.Intent;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.penglai.kjds.R;
import com.penglai.kjds.model.user.DeliverInfo;
import com.penglai.kjds.ui.adapter.ResumePostAdapter;
import com.penglai.kjds.ui.base.BaseActivity;
import com.penglai.kjds.ui.view.listener.OnItemClickListener;


import java.util.List;

import butterknife.BindColor;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 *    我的投递
 *
 *  * 作者：朋来-GZQ on 2017/1/13 14:03
 *  * 邮箱：gongzhiqing@xiyundata.com
 *  
 */
public class MyDeliverActivity extends BaseActivity {

    @BindView(R.id.index_top_layout)
    LinearLayout indexTopLayout;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.common_top_layout)
    RelativeLayout commonTopLayout;
    @BindString(R.string.my_deliver)
    String title;
    @BindColor(R.color.blue_top_bg)
    int topBackgroundColor;
    @BindColor(R.color.app_bg)
    int txtColor;

    @BindView(R.id.xrv_view)
    XRecyclerView mRecyclerView;
    private ResumePostAdapter adapter;
    private List<DeliverInfo> deliverInfoList;
    @Override
    protected View getContentView() {
        return inflateView(R.layout.activity_my_deliver);
    }

    @Override
    protected void setContentViewAfter(View contentView) {
        ButterKnife.bind(MyDeliverActivity.this);
        //绑定view
        initData();
    }

    protected void initData() {
        //初始化XRecyclerView
        initXRecyclerView();
       //初始化标题栏布局
        indexTopLayout.setVisibility(View.GONE);
        commonTopLayout.setVisibility(View.VISIBLE);
        commonTopLayout.setBackgroundColor(topBackgroundColor);
        tvTitle.setText(title);
        tvTitle.setTextColor(txtColor);
        Intent intent = getIntent();
        deliverInfoList = (List<DeliverInfo>) intent.getSerializableExtra("deliverInfoList");
        if (adapter == null) {
            adapter = new ResumePostAdapter();
        }
        //设置适配器
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter.refreshData(deliverInfoList);
        //设置刷新
        mRecyclerView.refresh();
        //设置上拉刷新、下拉加载、item点击事件监听
        setEventLister();
    }

    @OnClick({R.id.btn_back})
    public void  onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back:
                finish();
                break;
        }
    }

    /**
     * 初始化XRecyclerView
     */
    private void initXRecyclerView() {
        //初始化XRecyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        //添加刷新和加载更多样式
        mRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.Pacman);
        mRecyclerView.setArrowImageView(R.drawable.icon_down_grey);
    }

    /**
     * 设置上拉刷新、下拉加载、item点击事件监听
     */
    private void setEventLister() {
        mRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {                 //下拉刷新
                refreshData();
                //结束刷新
                mRecyclerView.refreshComplete();
                //通知更新
                //mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onLoadMore() {             //上拉加载
                //结束加载更多
                mRecyclerView.loadMoreComplete();
                //通知更新
                //mAdapter.notifyDataSetChanged();
                //暂无更多数据
                //mRecyclerView.setNoMore(true);
            }
        });

        adapter.setOnClickListener(new OnItemClickListener<DeliverInfo>() {
            @Override
            public void onItemClick(DeliverInfo itemValue, int viewID, int position) {

            }
        });
    }

    private void refreshData() {

    }
}
