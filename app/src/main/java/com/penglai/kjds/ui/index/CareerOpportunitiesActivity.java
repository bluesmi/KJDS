package com.penglai.kjds.ui.index;

import android.content.Intent;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.penglai.kjds.R;
import com.penglai.kjds.model.index.CompanyInfo;
import com.penglai.kjds.model.index.CompanyInfoReq;
import com.penglai.kjds.model.index.JobDetail;
import com.penglai.kjds.model.index.JobInfoReq;
import com.penglai.kjds.model.resume.JobListReq;
import com.penglai.kjds.presenter.impl.GetJobDetailPresenterImpl;
import com.penglai.kjds.presenter.impl.GetJobListPresenterImpl;
import com.penglai.kjds.presenter.implView.GetJobDetailView;
import com.penglai.kjds.presenter.implView.GetJobListView;
import com.penglai.kjds.ui.adapter.IndexAdapter;
import com.penglai.kjds.ui.base.BaseActivity;
import com.penglai.kjds.ui.view.listener.OnItemClickListener;
import com.penglai.kjds.utils.SettingPrefUtils;

import java.util.List;

import butterknife.BindColor;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by m199 on 2017/4/30.
 */

public class CareerOpportunitiesActivity extends BaseActivity implements GetJobDetailView,GetJobListView{
    @BindView(R.id.index_top_layout)
    LinearLayout indexTopLayout;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.common_top_layout)
    RelativeLayout commonTopLayout;
    @BindString(R.string.career_opportunities)
    String title;
    @BindColor(R.color.blue_top_bg)
    int topBackgroundColor;
    @BindColor(R.color.app_bg)
    int txtColor;
    @BindView(R.id.xrv_job_view)
    XRecyclerView mRecyclerView;

    private GetJobDetailPresenterImpl jobDetailPresenter;
    private IndexAdapter adapter;
    private GetJobListPresenterImpl jobListPresenter;


    @Override
    protected View getContentView() {
        return inflateView(R.layout.activity_career_opportunities);
    }

    @Override
    protected void setContentViewAfter(View contentView) {
        ButterKnife.bind(CareerOpportunitiesActivity.this);

        initData();
    }

    protected void initData() {
        initXRecyclerView();
        jobDetailPresenter = new GetJobDetailPresenterImpl(mContext,this);
        jobListPresenter = new GetJobListPresenterImpl(mContext,this);
        //初始化标题栏布局
        indexTopLayout.setVisibility(View.GONE);
        commonTopLayout.setVisibility(View.VISIBLE);
        commonTopLayout.setBackgroundColor(topBackgroundColor);
        tvTitle.setText(title);
        tvTitle.setTextColor(txtColor);
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

                jobDetailPresenter.getJobDetail("getJobDetail", JSON.toJSONString(new JobInfoReq(itemValue.getId())));
            }
        });
    }

    private void refreshData(){
        Intent intent = getIntent();
        List<CompanyInfo> companyInfoList = (List<CompanyInfo>) intent.getSerializableExtra("jobList");
        if(null != companyInfoList)
        adapter.refreshData(companyInfoList);
    }

    @OnClick({R.id.btn_back,R.id.btn_full_time,R.id.btn_part_job,R.id.btn_project})
    public void  onClick(View v) {
        String userId = SettingPrefUtils.getUid();
        switch (v.getId()) {
            case R.id.btn_back:
                finish();
                break;
            case R.id.btn_full_time:
                if(null != userId && !"".equals(userId)) {
                    jobListPresenter.getJobList("getJobList",JSON.toJSONString(new JobListReq(userId,2,"","")));
                }
                break;
            case R.id.btn_part_job:
                if(null != userId && !"".equals(userId)) {
                    jobListPresenter.getJobList("getJobList",JSON.toJSONString(new JobListReq(userId,1,"","")));
                }
                break;
            case R.id.btn_project:
                if(null != userId && !"".equals(userId)) {
                    jobListPresenter.getJobList("getJobList",JSON.toJSONString(new JobListReq(userId,3,"","")));
                }
                break;
        }
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void getJobListSuccess(List<CompanyInfo> companyInfoList) {
        adapter.refreshData(companyInfoList);
    }

    @Override
    public void getJobDetailSuccess(JobDetail jobDetail) {
        Intent intent = new Intent(mContext, JobDetailActivity.class);
        intent.putExtra("jobDetail",jobDetail);
        //跳转至职位/岗位详情
        startActivity(intent);
    }
}
