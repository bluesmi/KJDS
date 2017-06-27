package com.penglai.kjds.ui.resume;

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
import com.penglai.kjds.model.resume.DelEduBgReq;
import com.penglai.kjds.model.resume.DelWorkExpReq;
import com.penglai.kjds.model.resume.WorkExpInfoReq;
import com.penglai.kjds.model.user.UserInfoReq;
import com.penglai.kjds.presenter.impl.DelWorkExpPresenterImpl;
import com.penglai.kjds.presenter.impl.GetWorkExpListPresenterImpl;
import com.penglai.kjds.presenter.implView.DelWorkExpView;
import com.penglai.kjds.presenter.implView.GetWorkExpListView;
import com.penglai.kjds.ui.adapter.WorkExpInfoAdapter;
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
 * 实习/工作经历
 * <p>
 *  * 作者：朋来-GZQ on 2017/1/16 14:34
 *  * 邮箱：gongzhiqing@xiyundata.com
 *  
 */
public class WorkExperienceActivity extends BaseActivity implements GetWorkExpListView,DelWorkExpView{

    private static final int WORK_EXP_INFO = 0;
    private static final int MOFIFY_WORK_EXP_INFO = 1;
    @BindView(R.id.index_top_layout)
    LinearLayout indexTopLayout;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.common_top_layout)
    RelativeLayout commonTopLayout;
/*    @BindView(R.id.tv_job_name)
    TextView tvJobName;
    @BindView(R.id.tv_verify)
    TextView tvVerify;
    @BindView(R.id.verify_layout)
    LinearLayout verifyLayout;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv_company_info)
    TextView tvCompanyInfo;*/

    @BindView(R.id.xrv_view)
    XRecyclerView mRecyclerView;

    @BindColor(R.color.blue_top_bg)
    int topBackgroundColor;

    @BindString(R.string.work_experience)
    String title;
    /**
     * 工作经历
     */
    private List<WorkExpInfoReq> workExpInfoReqList;

    private WorkExpInfoAdapter adapter;

    private GetWorkExpListPresenterImpl workExpListPresenter;
    private DelWorkExpPresenterImpl delWorkExpresenter;
    private int myPosition;

    @Override
    protected View getContentView() {
        return inflateView(R.layout.activity_work_exp);
    }

    @Override
    protected void setContentViewAfter(View contentView) {
        ButterKnife.bind(WorkExperienceActivity.this);
        //绑定view
        initData();
    }

    protected void initData() {
        initXRecyclerView();

        workExpListPresenter = new GetWorkExpListPresenterImpl(mContext,this);
        delWorkExpresenter = new DelWorkExpPresenterImpl(mContext,this);
        //初始化标题栏布局
        indexTopLayout.setVisibility(View.GONE);
        commonTopLayout.setVisibility(View.VISIBLE);
        commonTopLayout.setBackgroundColor(topBackgroundColor);
        tvTitle.setText(title);

        Intent intent = getIntent();
        workExpInfoReqList = (List<WorkExpInfoReq>) intent.getSerializableExtra("workExpInfoReqList");
        if (adapter == null) {
            adapter = new WorkExpInfoAdapter();
        }
        //设置适配器
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter.refreshData(workExpInfoReqList);
        //设置刷新
        mRecyclerView.refresh();
        //设置上拉刷新、下拉加载、item点击事件监听
        setEventLister();
    }

    @OnClick({R.id.btn_back, R.id.btn_add_work_exp})//, R.id.btn_enter_detail
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back://返回
                Intent intent = new Intent(mContext,ResumeFragment.class);
                setResult(RESULT_OK,intent);
                finish();
                break;

            case R.id.btn_add_work_exp:
                Intent workExpInfoIntent = new Intent(mContext,WorkExpDetailActivity.class);
                startActivityForResult(workExpInfoIntent,WORK_EXP_INFO);       //添加实习/工作经历

                break;

          /*  case R.id.btn_enter_detail:
                startActivity(new Intent(mContext,WorkExpDetailActivity.class));      //进入实习/工作经历
                break;*/
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

        adapter.setOnClickListener(new OnItemClickListener<WorkExpInfoReq>() {
            @Override
            public void onItemClick(WorkExpInfoReq itemValue, int viewID, int position) {


                myPosition = position;
                switch (viewID){
                    case R.id.btn_enter_detail:
                        //跳转至工作经历详情
                        Intent intent = new Intent(mContext, WorkExpDetailActivity.class);
                        intent.putExtra("workExpInfoReq",itemValue);
                        startActivityForResult(intent,WORK_EXP_INFO);
                        break;
                    case R.id.btn_delete:
                        delWorkExpresenter.delWorkExpInfo("delWorkExpInfo",JSON.toJSONString(new DelWorkExpReq(itemValue.getId())));
                        break;
                }
            }
        });
    }

    private void refreshData() {
        String userId = SettingPrefUtils.getUid();
        if(null != userId && !"".equals(userId)) {
            String strJson = JSON.toJSONString(new UserInfoReq(userId));
            workExpListPresenter.getWorkExpList("getWorkExpList",strJson);

        }

    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void delWorkExpSuccess() {
        workExpInfoReqList.remove(myPosition);
        //设置数据
        adapter.refreshData(workExpInfoReqList);
    }

    @Override
    public void getWorkExpListSucces(List<WorkExpInfoReq> workExpInfoReqList) {
            this.workExpInfoReqList = workExpInfoReqList;
        //设置数据
        adapter.refreshData(workExpInfoReqList);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case WORK_EXP_INFO: //修改信息返回
                if (resultCode == RESULT_OK) {
                    refreshData();
                }
                break;

        }
    }
}
