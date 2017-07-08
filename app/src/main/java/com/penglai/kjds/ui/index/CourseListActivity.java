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
import com.penglai.kjds.model.index.Course;
import com.penglai.kjds.model.user.EmptyEntity;
import com.penglai.kjds.presenter.impl.GetCourseListPresenterImpl;
import com.penglai.kjds.presenter.implView.GetCourseListView;
import com.penglai.kjds.ui.adapter.CourseAdapter;
import com.penglai.kjds.ui.base.BaseActivity;


import java.util.List;

import butterknife.BindColor;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by m199 on 2017/7/7.
 */

public class CourseListActivity extends BaseActivity implements GetCourseListView{
    @BindView(R.id.index_top_layout)
    LinearLayout indexTopLayout;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.common_top_layout)
    RelativeLayout commonTopLayout;
    @BindString(R.string.course_list_title)
    String title;
    @BindColor(R.color.blue_top_bg)
    int topBackgroundColor;
    @BindColor(R.color.app_bg)
    int txtColor;
    @BindView(R.id.xrv_job_view)
    XRecyclerView mRecyclerView;

    // 课程适配器
    private CourseAdapter adapter;

    private GetCourseListPresenterImpl coursePresenter;

    @Override
    protected View getContentView() {
        return inflateView(R.layout.activity_course_list);
    }

    @Override
    protected void setContentViewAfter(View contentView) {
        ButterKnife.bind(CourseListActivity.this);

        initData();
    }

    private void initData() {
        initXRecyclerView();

        coursePresenter = new GetCourseListPresenterImpl(mContext,this);
        //初始化标题栏布局
        indexTopLayout.setVisibility(View.GONE);
        commonTopLayout.setVisibility(View.VISIBLE);
        commonTopLayout.setBackgroundColor(topBackgroundColor);
        tvTitle.setText(title);
        tvTitle.setTextColor(txtColor);
        if (adapter == null) {
            adapter = new CourseAdapter();
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

            }

            @Override
            public void onLoadMore() {             //上拉加载
                //结束加载更多
                mRecyclerView.loadMoreComplete();
            }
        });
    //   下面设置点击事件

    }

    private void refreshData() {

        Intent intent = getIntent();
        List<Course> courseList = (List<Course>) intent.getSerializableExtra("courseList");
        if (null != courseList) {
            adapter.refreshData(courseList);
        }else {
            coursePresenter.getCourseList("getCourseList", JSON.toJSONString(new EmptyEntity()));
        }
    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void getCourseListSuccess(List<Course> courseList) {
        adapter.refreshData(courseList);
    }

    @OnClick(R.id.btn_back)
    public void onClick(View view) {
        finish();
    }
}
