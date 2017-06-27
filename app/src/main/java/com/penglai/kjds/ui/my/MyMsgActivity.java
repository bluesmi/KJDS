package com.penglai.kjds.ui.my;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.penglai.kjds.R;
import com.penglai.kjds.model.user.MyMessage;
import com.penglai.kjds.model.user.UserInfoReq;
import com.penglai.kjds.presenter.impl.GetMyMessagePresenterImpl;
import com.penglai.kjds.presenter.implView.GetMyMessageView;
import com.penglai.kjds.ui.adapter.MyMessageAdapter;
import com.penglai.kjds.ui.base.BaseActivity;
import com.penglai.kjds.utils.SettingPrefUtils;

import java.util.List;

import butterknife.BindBitmap;
import butterknife.BindColor;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 *   我的消息
 *
 *  * 作者：朋来-GZQ on 2017/1/13 14:04
 *  * 邮箱：gongzhiqing@xiyundata.com
 *  
 */
public class MyMsgActivity extends BaseActivity implements GetMyMessageView {

    @BindView(R.id.index_top_layout)
    LinearLayout indexTopLayout;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.common_top_layout)
    RelativeLayout commonTopLayout;
    @BindString(R.string.my_msg)
    String title;
    @BindColor(R.color.app_bg)
    int txtColor;
    @BindView(R.id.btn_back)
    ImageButton btnBack;
    @BindColor(R.color.blue_top_bg)
    int topBackgroundColor;
    @BindBitmap(R.drawable.icon_common_back)
    Bitmap commonBack;
    @BindView(R.id.xrv_view)
    XRecyclerView mRecyclerView;

    private GetMyMessagePresenterImpl messagePresenter;

    private MyMessageAdapter adapter;
    private List<MyMessage> myMessageList;

    @Override
    protected View getContentView() {
        return inflateView(R.layout.activity_my_msg);
    }

    @Override
    protected void setContentViewAfter(View contentView) {
        ButterKnife.bind(MyMsgActivity.this);
        //绑定view
        initData();
    }

    protected void initData() {
        initXRecyclerView();
        messagePresenter = new GetMyMessagePresenterImpl(mContext,this);
       //初始化标题栏布局
        indexTopLayout.setVisibility(View.GONE);
        commonTopLayout.setVisibility(View.VISIBLE);
        commonTopLayout.setBackgroundColor(topBackgroundColor);
        btnBack.setImageBitmap(commonBack);
        tvTitle.setText(title);
        tvTitle.setTextColor(txtColor);
        Intent intent = getIntent();
        myMessageList = (List<MyMessage>) intent.getSerializableExtra("myMessageList");
        if (adapter == null) {
            adapter = new MyMessageAdapter();
        }
        //设置适配器
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter.refreshData(myMessageList);
        //设置刷新
        mRecyclerView.refresh();
        //设置上拉刷新、下拉加载、item点击事件监听
        setEventLister();
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


    }

    private void refreshData() {
        String userId = SettingPrefUtils.getUid();
        if(null != userId && !"".equals(userId)){
//            deliverListPresenter.getDeliverList("getDeliverList", JSON.toJSONString(new DeliverInfoReq(userId,0)));
            messagePresenter.getMessage("getMessage",JSON.toJSONString(new UserInfoReq(userId)));
        }
    }


    @OnClick({R.id.btn_back})
    public void  onClick(View v){
        switch (v.getId()){
            case R.id.btn_back:
                finish();
            break;
        }
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void getMyMessageSuccess(List<MyMessage> myMessageList) {
        this.myMessageList = myMessageList;
        adapter.refreshData(myMessageList);
    }
}
