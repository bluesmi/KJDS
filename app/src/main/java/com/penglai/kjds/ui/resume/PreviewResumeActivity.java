package com.penglai.kjds.ui.resume;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.penglai.kjds.R;
import com.penglai.kjds.model.resume.Assess;
import com.penglai.kjds.model.resume.EduBgInfo;
import com.penglai.kjds.model.resume.PersionInfo;
import com.penglai.kjds.model.resume.ResumeRes;
import com.penglai.kjds.model.resume.WorkExpInfoReq;
import com.penglai.kjds.ui.adapter.ResumeEduBgAdapter;
import com.penglai.kjds.ui.adapter.ResumeWorkExpAdapter;
import com.penglai.kjds.ui.base.BaseActivity;
import com.penglai.kjds.ui.base.BaseAdapter;
import com.penglai.kjds.ui.index.CareerOpportunitiesActivity;
import com.penglai.kjds.ui.view.listener.OnItemClickListener;
import com.penglai.kjds.utils.SettingPrefUtils;

import java.util.List;

import butterknife.BindColor;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 *  * 作者：朋来-GZQ on 2017/1/16 14:51
 *  * 邮箱：gongzhiqing@xiyundata.com
 *  
 */
public class PreviewResumeActivity extends BaseActivity {
    @BindView(R.id.index_top_layout)
    LinearLayout indexTopLayout;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.common_top_layout)
    RelativeLayout commonTopLayout;
    @BindString(R.string.preview_resume)
    String title;
    @BindColor(R.color.blue_top_bg)
    int topBackgroundColor;
    @BindColor(R.color.app_bg)
    int txtColor;
    //基本信息
    @BindView(R.id.tv_base_info)
    LinearLayout tvBaseInfo;
    @BindView(R.id.iv_user_img)
    ImageView ivUserImg;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_sex)
    TextView tvSex;
    @BindView(R.id.tv_birthday)
    TextView tvBirthday;
   /* @BindView(R.id.tv_work_data)
    TextView tvWorkData;
    @BindView(R.id.tv_born_place)
    TextView tvBornPlace;
    @BindView(R.id.tv_address)
    TextView tvAddress;*/
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_email)
    TextView tvEmail;

    //教育背景
    @BindView(R.id.tv_edu_bg)
    LinearLayout tvEduBg;


    //工作经验
    @BindView(R.id.tv_work_exp)
    LinearLayout tvWorkExp;


    //自我评价
    @BindView(R.id.tv_self_evaluation)
    LinearLayout tvSelfEvaluation;
    @BindView(R.id.tv_evaluation_hint)
    TextView tvEvaluationHint;


    @BindView(R.id.xrv_view_edu_bg)
    RecyclerView eduBgRecyclerView;
    //工作经历
    @BindView(R.id.xrv_view_work_exp)
    RecyclerView workExpRecyclerView;

    private ResumeEduBgAdapter eduBgAdapter;
    private ResumeWorkExpAdapter workExpAdapter;
    private ResumeRes resumeRes;

    @Override
    protected View getContentView() {
        return inflateView(R.layout.activity_preview_resume);
    }

    @Override
    protected void setContentViewAfter(View contentView) {
        ButterKnife.bind(PreviewResumeActivity.this);
        //绑定view
        initData();
    }

    protected void initData() {
//        ButterKnife.bind(PreviewResumeActivity.this);
        initXRecyclerView(eduBgRecyclerView);
        initXRecyclerView(workExpRecyclerView);

        //初始化标题栏布局
        indexTopLayout.setVisibility(View.GONE);
        commonTopLayout.setVisibility(View.VISIBLE);
        commonTopLayout.setBackgroundColor(topBackgroundColor);
        tvTitle.setText(title);
        tvTitle.setTextColor(txtColor);

        Intent intent = getIntent();
        resumeRes = (ResumeRes) intent.getSerializableExtra("resumeRes");
        if(null != resumeRes) {
            initPersion(resumeRes.getPersion());
            initEduBg(resumeRes.getEduBgInfoList());
            initWorkExp(resumeRes.getWorkExp());
            initAssess(resumeRes.getAssess());
        }

    }

    private void initAssess(Assess assess) {
        if(null == assess){
            tvSelfEvaluation.setVisibility(View.GONE);
        }else {
            tvSelfEvaluation.setVisibility(View.VISIBLE);
            tvEvaluationHint.setText(assess.getContent());
        }
    }

    private void initWorkExp(List<WorkExpInfoReq> workExp) {
        if(null == workExp){
            tvWorkExp.setVisibility(View.GONE);
        }else {
            tvWorkExp.setVisibility(View.VISIBLE);
            if (workExpAdapter == null) {
                workExpAdapter = new ResumeWorkExpAdapter();
            }
            //设置适配器
            workExpRecyclerView.setAdapter(workExpAdapter);
            workExpRecyclerView.setItemAnimator(new DefaultItemAnimator());
            workExpAdapter.refreshData(workExp);
            //设置刷新
//            workExpRecyclerView.refresh();
            //设置上拉刷新、下拉加载、item点击事件监听
//            setEventLister(workExpRecyclerView);
        }
    }

    private void initEduBg(List<EduBgInfo> eduBgInfoList) {
        if(null == eduBgInfoList){
            tvEduBg.setVisibility(View.GONE);
        }else {
            tvEduBg.setVisibility(View.VISIBLE);
            if (eduBgAdapter == null) {
                eduBgAdapter = new ResumeEduBgAdapter();
            }
            //设置适配器
            eduBgRecyclerView.setAdapter(eduBgAdapter);
            eduBgRecyclerView.setItemAnimator(new DefaultItemAnimator());
            eduBgAdapter.refreshData(eduBgInfoList);
            //设置刷新
//            eduBgRecyclerView.refresh();
            //设置上拉刷新、下拉加载、item点击事件监听
//            setEventLister(eduBgRecyclerView);
        }
    }

    private void initPersion(PersionInfo persion) {
        Glide.with(mContext)
                .load(persion.getHeadPicID())
                .asBitmap()
                .placeholder(R.drawable.icon_user_img)
                .error(R.drawable.icon_user_img)
                .diskCacheStrategy(DiskCacheStrategy.ALL) //设置缓存
                .into(new BitmapImageViewTarget(ivUserImg) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(mContext.getResources(), resource);
                        circularBitmapDrawable.setCircular(true);
                        ivUserImg.setImageDrawable(circularBitmapDrawable);
                    }
                });
        tvName.setText(persion.getTrueName());
        if(null != persion.getGender() && !"".equals(persion.getGender())) {
            int sex = Integer.parseInt(persion.getGender());
            if (0 == sex || 1 == sex) {
                String userSex = sex == 0 ? "男" : "女";
                tvSex.setText(userSex);
            }
        }
        String birthday = persion.getBirthDate();
        if(null != birthday && !"".equals(birthday)){
            tvBirthday.setText(birthday.substring(0,10));
        }
        tvPhone.setText(persion.getPhone());
        tvEmail.setText(persion.getEmail());
    }

    @OnClick({R.id.btn_back})
    public void  onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_back:
                Intent intent = new Intent(mContext,ResumeFragment.class);
                setResult(RESULT_OK,intent);
                finish();
                break;
        }
    }

    /**
     * 初始化XRecyclerView
     */
    private void initXRecyclerView(RecyclerView mRecyclerView) {
        //初始化XRecyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        //添加刷新和加载更多样式
       /* mRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        mRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.Pacman);
        mRecyclerView.setArrowImageView(R.drawable.icon_down_grey);*/
    }

    /**
     * 设置上拉刷新、下拉加载、item点击事件监听
     */
    private void setEventLister(final XRecyclerView mRecyclerView) {
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
        if(null != userId && !"".equals(userId)) {


        }

    }
}
