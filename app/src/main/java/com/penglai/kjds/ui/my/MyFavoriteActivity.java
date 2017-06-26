package com.penglai.kjds.ui.my;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.penglai.kjds.R;
import com.penglai.kjds.model.index.JobDetail;
import com.penglai.kjds.model.index.JobInfoReq;
import com.penglai.kjds.model.resume.ResumeInfoReq;
import com.penglai.kjds.model.user.CollectInfo;
import com.penglai.kjds.model.user.UserInfoReq;
import com.penglai.kjds.presenter.impl.GetFavoriteListPresenterImpl;
import com.penglai.kjds.presenter.impl.GetJobDetailPresenterImpl;
import com.penglai.kjds.presenter.impl.JobFavoritePresenterImpl;
import com.penglai.kjds.presenter.impl.SendResumeInfoPresenterImpl;
import com.penglai.kjds.presenter.implView.GetFavoriteListView;
import com.penglai.kjds.presenter.implView.GetJobDetailView;
import com.penglai.kjds.presenter.implView.JobFavoriteView;
import com.penglai.kjds.presenter.implView.SendResumeInfoView;
import com.penglai.kjds.ui.adapter.FavoriteJobAdapter;
import com.penglai.kjds.ui.base.BaseActivity;
import com.penglai.kjds.ui.index.JobDetailActivity;
import com.penglai.kjds.ui.view.listener.OnItemClickListener;
import com.penglai.kjds.utils.PopWindowUtil;
import com.penglai.kjds.utils.SettingPrefUtils;
import com.penglai.kjds.utils.UiUtils;

import java.util.List;

import butterknife.BindBitmap;
import butterknife.BindColor;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 *      我的收藏
 *
 *  * 作者：朋来-GZQ on 2017/1/13 14:04
 *  * 邮箱：gongzhiqing@xiyundata.com
 *  
 */
public class MyFavoriteActivity extends BaseActivity implements GetFavoriteListView,SendResumeInfoView,JobFavoriteView,GetJobDetailView{

    @BindView(R.id.index_top_layout)
    LinearLayout indexTopLayout;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.common_top_layout)
    RelativeLayout commonTopLayout;
    @BindString(R.string.my_favorite)
    String title;

    @BindView(R.id.favorite_default_content)
    LinearLayout defaultContentLayout;
    @BindView(R.id.favorite_content)
    LinearLayout contentLayout;
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

    private List<CollectInfo> collectInfoList;
    private FavoriteJobAdapter adapter;


    private GetFavoriteListPresenterImpl favoriteListPresenter;
    private SendResumeInfoPresenterImpl sendResumeInfoPresenter;
    private JobFavoritePresenterImpl jobFavoritePresenter;
    private GetJobDetailPresenterImpl jobDetailPresenter;



    @Override
    protected View getContentView() {
        return inflateView(R.layout.activity_my_favorite);
    }

    @Override
    protected void setContentViewAfter(View contentView) {
        ButterKnife.bind(MyFavoriteActivity.this);
        //绑定view
        initData();
    }

    protected void initData() {
        //初始化XRecyclerView
        initXRecyclerView();
        favoriteListPresenter = new GetFavoriteListPresenterImpl(mContext,this);
        sendResumeInfoPresenter = new SendResumeInfoPresenterImpl(mContext,this);
        jobFavoritePresenter = new JobFavoritePresenterImpl(mContext,this);
        jobDetailPresenter = new GetJobDetailPresenterImpl(mContext,this);
        //初始化标题栏布局
        indexTopLayout.setVisibility(View.GONE);
        commonTopLayout.setVisibility(View.VISIBLE);
        commonTopLayout.setBackgroundColor(topBackgroundColor);
        btnBack.setImageBitmap(commonBack);

        tvTitle.setText(title);
        tvTitle.setTextColor(txtColor);

        Intent intent = getIntent();
        collectInfoList = (List<CollectInfo>) intent.getSerializableExtra("collectInfoList");
        if(null != collectInfoList && !collectInfoList.isEmpty()){
            defaultContentLayout.setVisibility(View.GONE);
            contentLayout.setVisibility(View.VISIBLE);
            if (adapter == null) {
                adapter = new FavoriteJobAdapter();
                //设置适配器
                mRecyclerView.setAdapter(adapter);
                mRecyclerView.setItemAnimator(new DefaultItemAnimator());
                adapter.refreshData(collectInfoList);
                //设置刷新
                mRecyclerView.refresh();
                //设置上拉刷新、下拉加载、item点击事件监听
                setEventLister();
            }
        }else {
            defaultContentLayout.setVisibility(View.VISIBLE);
            contentLayout.setVisibility(View.GONE);
        }
    }

    @OnClick({R.id.btn_back})//R.id.enter_detail_layout,R.id.btn_cancel_favorite,R.id.btn_send_resume,
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_back:                          //返回
                Intent intent = new Intent(mContext,MyFragment.class);
                setResult(RESULT_OK,intent);
//                finish();
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

        adapter.setOnClickListener(new OnItemClickListener<CollectInfo>() {
            @Override
            public void onItemClick(CollectInfo itemValue, int viewID, int position) {
                String userId = SettingPrefUtils.getUid();
                switch (viewID){
                    case R.id.enter_detail_layout:         //进入详情
                        jobDetailPresenter.getJobDetail("getJobDetail",JSON.toJSONString(new JobInfoReq(itemValue.getiD())));
                    break;
                    case R.id.btn_cancel_favorite:         //取消收藏
                        if(null != userId && !"".equals(userId)) {
                            String strJson = JSON.toJSONString(new ResumeInfoReq(itemValue.getiD(),userId ));
                            jobFavoritePresenter.jobFavorite("JobFavorite",strJson);
                        }
                    break;
                    case R.id.btn_send_resume:            //发送简历
                        if(null != userId && !"".equals(userId)) {
                            String strJson = JSON.toJSONString(new ResumeInfoReq(itemValue.getiD(),userId ));
                            PopWindowUtil.confirmSendResume(mContext, getContentView(), MyFavoriteActivity.this, sendResumeInfoPresenter,strJson);
                        }
                    break;
                }

            }
        });
    }


    @Override
    public void showError(String error) {

    }

    @Override
    public void getJobDetailSuccess(JobDetail jobDetail) {
        Intent intent = new Intent(mContext, JobDetailActivity.class);
        intent.putExtra("jobDetail",jobDetail);
        //跳转至职位/岗位详情
        startActivity(intent);
    }

    @Override
    public void sendResumeSuccess(String message) {
        UiUtils.showToast(mContext,message);
    }

    @Override
    public void collectSuccess(String message) {
        UiUtils.showImgToast(mContext,message+"",R.drawable.icon_confirm_collect);
        refreshData();
    }

    @Override
    public void getFavoriteListSuccess(List<CollectInfo> collectInfoList) {
        this.collectInfoList = collectInfoList;
        adapter.refreshData(collectInfoList);
    }


    private void refreshData() {
        String userId = SettingPrefUtils.getUid();
        if(null != userId && !"".equals(userId)) {
            favoriteListPresenter.getFavoriteList("getFavoriteList", JSON.toJSONString(new UserInfoReq(userId)));
        }
    }
}
