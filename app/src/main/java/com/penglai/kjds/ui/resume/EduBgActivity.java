package com.penglai.kjds.ui.resume;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.widget.DefaultItemAnimator;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.penglai.kjds.R;
import com.penglai.kjds.model.resume.EduBgInfo;
import com.penglai.kjds.model.user.UserInfoReq;
import com.penglai.kjds.presenter.impl.GetEduBgListPresenterImpl;
import com.penglai.kjds.presenter.implView.GetEduBgListView;
import com.penglai.kjds.ui.adapter.EduBgAdapter;
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
 * 教育背景
 * <p>
 *  * 作者：朋来-GZQ on 2017/1/16 14:33
 *  * 邮箱：gongzhiqing@xiyundata.com
 *  
 */
public class EduBgActivity extends BaseActivity implements GetEduBgListView {

    @BindView(R.id.index_top_layout)
    LinearLayout indexTopLayout;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.common_top_layout)
    RelativeLayout commonTopLayout;
    @BindView(R.id.tv_school)
    TextView tvSchool;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.tv_other_info)
    TextView tvOtherInfo;
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
    }

    private void refreshData() {
        String userId = SettingPrefUtils.getUid();
        if(null != userId && !"".equals(userId)) {
            eduBgListPresenter.getEduBgList("getEduBgList",JSON.toJSONString(new UserInfoReq(userId)));

        }else {
            eduBgListPresenter.getEduBgList("getEduBgList",JSON.toJSONString(new UserInfoReq(userId)));
        }
        //设置数据
        adapter.refreshData(eduBgInfoList);
    }

    @OnClick({R.id.btn_back, R.id.btn_add_edu_bg, R.id.btn_enter_detail})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:                                                     //返回
                finish();
                break;

            case R.id.btn_add_edu_bg:                                        //添加教育背景
                startActivity(new Intent(mContext,EduBgDetailActivity.class));
                break;

            case R.id.btn_enter_detail:                                        //教育背景详情
                startActivity(new Intent(mContext,EduBgDetailActivity.class));
                break;
        }
    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void getEduViewSuccess(List<EduBgInfo> eduBgInfoList) {
        this.eduBgInfoList = eduBgInfoList;
    }
}
