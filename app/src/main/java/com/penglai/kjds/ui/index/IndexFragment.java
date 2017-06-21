package com.penglai.kjds.ui.index;

import android.content.Intent;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.penglai.kjds.R;
import com.penglai.kjds.model.index.CompanyInfo;
import com.penglai.kjds.model.index.CompanyInfoReq;
import com.penglai.kjds.presenter.impl.GetHotRecommendPresenterImpl;
import com.penglai.kjds.presenter.implView.GetHotRecommendView;
import com.penglai.kjds.ui.activity.LoginActivity;
import com.penglai.kjds.ui.adapter.IndexAdapter;
import com.penglai.kjds.ui.base.BaseFragment;
import com.penglai.kjds.ui.view.listener.OnItemClickListener;
import com.penglai.kjds.ui.view.widget.banner.CustomerTopBanner;
import com.penglai.kjds.utils.SettingPrefUtils;
import com.penglai.kjds.utils.UiUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.app.Activity.RESULT_OK;

/**
 * 首页
 * <p/>
 *  * 作者：朋来-GZQ on 2017/1/6 15:21
 *  * 邮箱：gongzhiqing@xiyundata.com
 *  
 */
public class IndexFragment extends BaseFragment implements View.OnClickListener,GetHotRecommendView {

    @BindView(R.id.index_top_layout)
    LinearLayout indexTopLayout;
    @BindView(R.id.common_top_layout)
    RelativeLayout commonTopLayout;
    @BindView(R.id.search_layout)
    public LinearLayout mSearchLayout;
    @BindView(R.id.btn_login)
    public TextView mBtnLogin;
    @BindView(R.id.xrv_view)
    XRecyclerView mRecyclerView;

    private View contentView;
    private static IndexFragment instance;
    private IndexAdapter adapter;
    /**
     * 热门推荐
     */
    private GetHotRecommendPresenterImpl hotRecommendPresenter;


    private List<CompanyInfo> companyInfoList;

    private static final int LOGIN_RESULT = 0;
    public IndexFragment() {
        super();
    }

    public static IndexFragment getInstance() {
        if (instance == null) {
            instance = new IndexFragment();
        }
        return instance;
    }

    @Override
    public View initViews() {
        // 防止多次new出片段对象，造成图片错乱问题
        if (contentView == null) {
            contentView = mInflater.inflate(R.layout.fragment_index,  container,false);
        }
        //绑定view
        unbinder = ButterKnife.bind(IndexFragment.this, contentView);
        return contentView;
    }

    @Override
    public void initData() {
        hotRecommendPresenter = new GetHotRecommendPresenterImpl(mContext,this);

        indexTopLayout.setVisibility(View.VISIBLE);
        commonTopLayout.setVisibility(View.GONE);
        //初始化XRecyclerView
        initXRecyclerView();
        //初始化banner
        initTopBanner();
        //初始化标题
        initJobTitle();
        if (adapter == null) {
            adapter = new IndexAdapter();
        }
        //设置适配器
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        refreshData();
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

    /***
     * 初始化标题
     */
    private void initJobTitle() {
        //添加类别布局
        View jobTitleView = mInflater.inflate(R.layout.view_title_header, container,false);
        mRecyclerView.addHeaderView(jobTitleView);
        jobTitleView.findViewById(R.id.btn_all_job).setOnClickListener(this);
        jobTitleView.findViewById(R.id.btn_pt_job).setOnClickListener(this);
        jobTitleView.findViewById(R.id.btn_fl_job).setOnClickListener(this);
        jobTitleView.findViewById(R.id.btn_project).setOnClickListener(this);
    }

    /***
     * 初始化banner
     */
    private void initTopBanner() {
        //添加banner头布局
        View headerView = mInflater.inflate(R.layout.view_custom_header, container,false);
        mRecyclerView.addHeaderView(headerView);
        CustomerTopBanner mTopBanner = (CustomerTopBanner) headerView.findViewById(R.id.banner);
        //设置Banner的监听事件,并初始化
        mTopBanner.setAdapter(new CustomerTopBanner.Adapter<ImageView, String>() {
            @Override
            public void fillBannerItem(CustomerTopBanner banner, ImageView itemView, String model, int position) {
                Glide.with(itemView.getContext())
                        .load(model)
                        .placeholder(R.drawable.icon_default)
                        .error(R.drawable.icon_default)
                        .dontAnimate()
                        .centerCrop()
                        .into(itemView);
            }
        });
        int[] mView = {R.drawable.icon_default, R.drawable.icon_default, R.drawable.icon_default};
        //设置数据
        mTopBanner.setData(mView);
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

        adapter.setOnClickListener(new OnItemClickListener<CompanyInfo>() {
            @Override
            public void onItemClick(CompanyInfo itemValue, int viewID, int position) {
                //跳转至职位/岗位详情
                startActivity(new Intent(mContext, JobDetailActivity.class));
            }
        });
    }

    private void refreshData(){
        String userId = SettingPrefUtils.getUid();
        if(null != userId && !"".equals(userId)) {
            hotRecommendPresenter.getHotRecommend("getHotRecommend", JSON.toJSONString(new CompanyInfoReq(userId,0,0)));

        }else {
            hotRecommendPresenter.getHotRecommend("getHotRecommend", JSON.toJSONString(new CompanyInfoReq("",0,0)));
        }
        //设置数据
        adapter.refreshData(companyInfoList);
    }
    @OnClick({R.id.btn_login, R.id.search_layout})
    public void skipToClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:                    //用户登陆
                UiUtils.showToast(mContext, "登陆");
                startActivityForResult(new Intent(mContext, LoginActivity.class),LOGIN_RESULT);
                break;

            case R.id.search_layout:            //搜索
                UiUtils.showToast(mContext, "搜索");
                startActivity(new Intent(mContext, SearchActivity.class));
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_all_job:                    //全部
                UiUtils.showToast(mContext, "全部");
                startActivity(new Intent(mContext,CareerOpportunitiesActivity.class));
                break;

            case R.id.btn_pt_job:                     //兼职
                UiUtils.showToast(mContext, "兼职");
                break;

            case R.id.btn_fl_job:                      //全职
                UiUtils.showToast(mContext, "全职");
                break;

            case R.id.btn_project:                    //项目
                UiUtils.showToast(mContext, "项目");
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //释放
        unbinder.unbind();
        if (instance != null) {
            instance = null;
        }
    }

    @Override
    public void showError(String error) {

    }


    @Override
    public void showHotCompany(List<CompanyInfo> companyInfoList) {
           this.companyInfoList = companyInfoList;
        //设置数据
        adapter.refreshData(this.companyInfoList);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case LOGIN_RESULT: //调用系统相机返回
                if (resultCode == RESULT_OK) {
                    refreshData();
                }
                break;
        }
    }
}
