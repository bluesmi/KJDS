package com.penglai.kjds.ui.resume;

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
import com.penglai.kjds.model.index.CompanyInfo;
import com.penglai.kjds.model.resume.EduBgInfo;
import com.penglai.kjds.model.user.UserInfoReq;
import com.penglai.kjds.presenter.impl.GetEduBgListPresenterImpl;
import com.penglai.kjds.presenter.implView.GetEduBgListView;
import com.penglai.kjds.ui.adapter.EduBgAdapter;
import com.penglai.kjds.ui.base.BaseActivity;
import com.penglai.kjds.ui.view.listener.OnItemClickListener;
import com.penglai.kjds.utils.SettingPrefUtils;

import java.util.List;

import butterknife.BindBitmap;
import butterknife.BindColor;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 教育背景
 * <p>
 *  * 作者：朋来-GZQ on 2017/1/16 14:33
 *  * 邮箱：gongzhiqing@xiyundata.com
 *  
 */
public class EduBgActivity extends BaseActivity implements GetEduBgListView{

    private static final int EDU_BG_DETAIL_INFO = 0 ;
    @BindView(R.id.index_top_layout)
    LinearLayout indexTopLayout;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.common_top_layout)
    RelativeLayout commonTopLayout;
 /*   @BindView(R.id.tv_school)
    TextView tvSchool;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv_other_info)
    TextView tvOtherInfo;*/
    @BindView(R.id.btn_back)
    ImageButton btnBack;
    @BindColor(R.color.blue_top_bg)
    int topBackgroundColor;
    @BindBitmap(R.drawable.icon_common_back)
    Bitmap commonBack;
    @BindString(R.string.edu_bg)
    String title;
    @BindColor(R.color.app_bg)
    int txtColor;
    @BindView(R.id.xrv_view)
    XRecyclerView mRecyclerView;


    /**
     * 教育背景列表
     */
    private List<EduBgInfo> eduBgInfoList;

    private EduBgAdapter adapter;

    private GetEduBgListPresenterImpl eduBgListPresenter;

    @Override
    protected View getContentView() {
        return inflateView(R.layout.activity_edu_bg);
    }

    @Override
    protected void setContentViewAfter(View contentView) {
        ButterKnife.bind(EduBgActivity.this);
        //绑定view
        initData();
    }

    protected void initData() {
        //初始化XRecyclerView
        initXRecyclerView();

        eduBgListPresenter = new GetEduBgListPresenterImpl(mContext,this);
       //初始化标题栏布局
        indexTopLayout.setVisibility(View.GONE);
        commonTopLayout.setVisibility(View.VISIBLE);
        commonTopLayout.setBackgroundColor(topBackgroundColor);
        tvTitle.setText(title);
        tvTitle.setTextColor(txtColor);
        btnBack.setImageBitmap(commonBack);

        Intent intent = getIntent();
        eduBgInfoList = (List<EduBgInfo>) intent.getSerializableExtra("eduBgInfoList");
        if (adapter == null) {
            adapter = new EduBgAdapter();
        }
        //设置适配器
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter.refreshData(eduBgInfoList);
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

        adapter.setOnClickListener(new OnItemClickListener<EduBgInfo>() {
            @Override
            public void onItemClick(EduBgInfo itemValue, int viewID, int position) {
                //跳转至教育背景详情
                Intent intent = new Intent(mContext, EduBgDetailActivity.class);
                intent.putExtra("eduBgInfo",itemValue);
                startActivityForResult(intent,EDU_BG_DETAIL_INFO);
            }
        });
    }

    private void refreshData() {
        String userId = SettingPrefUtils.getUid();
        if(null != userId && !"".equals(userId)) {
            eduBgListPresenter.getEduBgList("getEduBgList",JSON.toJSONString(new UserInfoReq(userId)));

        }

    }

    @OnClick({R.id.btn_back, R.id.btn_add_edu_bg})//R.id.btn_enter_detail
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:                                                     //返回
                Intent intent = new Intent(mContext,ResumeFragment.class);
                setResult(RESULT_OK,intent);
                finish();
                break;

            case R.id.btn_add_edu_bg:                                        //添加教育背景
                Intent eduBgIntent = new Intent(mContext,EduBgDetailActivity.class);

                startActivityForResult(eduBgIntent,EDU_BG_DETAIL_INFO);
                break;

            /*case R.id.btn_enter_detail:                                        //教育背景详情
                startActivity(new Intent(mContext,EduBgDetailActivity.class));
                break;*/
        }
    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void getEduViewSuccess(List<EduBgInfo> eduBgInfoList) {
        this.eduBgInfoList = eduBgInfoList;
        //设置数据
        adapter.refreshData(eduBgInfoList);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case EDU_BG_DETAIL_INFO: //修改信息返回
                if (resultCode == RESULT_OK) {
                    refreshData();
                }
                break;
        }
    }
}
