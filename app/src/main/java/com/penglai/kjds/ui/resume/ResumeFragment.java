package com.penglai.kjds.ui.resume;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.penglai.kjds.R;
import com.penglai.kjds.model.resume.EduBgInfo;
import com.penglai.kjds.model.resume.PersionInfo;
import com.penglai.kjds.model.user.UserInfoReq;
import com.penglai.kjds.presenter.impl.GetEduBgListPresenterImpl;
import com.penglai.kjds.presenter.impl.GetPersionInfoPresenter;
import com.penglai.kjds.presenter.implView.GetEduBgListView;
import com.penglai.kjds.presenter.implView.GetPersionInfoView;
import com.penglai.kjds.ui.base.BaseFragment;
import com.penglai.kjds.ui.view.widget.CircleImageView;
import com.penglai.kjds.utils.SettingPrefUtils;

import java.io.Serializable;
import java.util.List;

import butterknife.BindColor;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.app.Activity.RESULT_OK;

/**
 * 简历
 * <p>
 *  * 作者：朋来-GZQ on 2017/1/6 15:34
 *  * 邮箱：gongzhiqing@xiyundata.com
 *  
 */
public class ResumeFragment extends BaseFragment implements GetPersionInfoView,GetEduBgListView{

    public final static String TAG = ResumeFragment.class.getSimpleName();
    private static final int MOFIFY_PERSION_INFO = 0;
    private static final int GET_EDU_BG_LIST = 1;
    private static ResumeFragment instance;
    private View contentView;

    @BindView(R.id.iv_user_img)
    CircleImageView ivUserImg;
    @BindView(R.id.tv_username)
    TextView tvUsername;
    @BindView(R.id.tv_other_info)
    TextView tvOtherInfo;
    @BindView(R.id.tv_integrity1)
    TextView tvIntegrity1;
    @BindView(R.id.tv_integrity2)
    TextView tvIntegrity2;
    @BindView(R.id.tv_integrity3)
    TextView tvIntegrity3;
    @BindView(R.id.tv_integrity4)
    TextView tvIntegrity4;
    @BindView(R.id.index_top_layout)
    LinearLayout indexTopLayout;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.common_top_layout)
    RelativeLayout commonTopLayout;
    @BindView(R.id.btn_back)
    ImageButton btnBack;

    @BindString(R.string.resume_text)
    String title;
    @BindColor(R.color.blue_top_bg)
    int topBg;
    @BindColor(R.color.white)
    int titleBg;

    /**
     * 简历中个人信息
     */
    private GetPersionInfoPresenter persionInfoPresenter;

    /**
     * 获取教育背景
     */
    private GetEduBgListPresenterImpl eduBgListPresenter;

    /**
     * 基本信息
     */
    private PersionInfo persionInfo;

    private List<EduBgInfo> eduBgInfoList;
    public ResumeFragment() {
        super();
    }

    public static ResumeFragment getInstance() {
        if (instance == null) {
            instance = new ResumeFragment();
        }
        return instance;
    }

    @Override
    public View initViews() {
        // 防止多次new出片段对象，造成图片错乱问题
        if (contentView == null) {
            contentView = mInflater.inflate(R.layout.fragment_resume, container,false);
        }
        //绑定view
        ButterKnife.bind(ResumeFragment.this, contentView);
        return contentView;
    }

    @Override
    public void initData() {
        persionInfoPresenter = new GetPersionInfoPresenter(mContext,this);
        eduBgListPresenter = new GetEduBgListPresenterImpl(mContext,this);
        indexTopLayout.setVisibility(View.GONE);
        commonTopLayout.setVisibility(View.VISIBLE);
        commonTopLayout.setBackgroundColor(topBg);
        btnBack.setVisibility(View.GONE);
        tvTitle.setTextColor(titleBg);
        tvTitle.setText(title);

        String userId = SettingPrefUtils.getUid();
        if(null != userId && !"".equals(userId)){
            persionInfoPresenter.getPersionInfo("getPersionInfo", JSON.toJSONString(new UserInfoReq(userId)));
            eduBgListPresenter.getEduBgList("getEduBgList",JSON.toJSONString(new UserInfoReq(userId)));
        }
    }

    //点击事件
    @OnClick({R.id.btn_refresh_resume, R.id.btn_preview_resume, R.id.btn_base_info,
            R.id.btn_edu_bg, R.id.btn_work_experience, R.id.btn_evaluation})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_refresh_resume:                                  //刷新简历

                break;

            case R.id.btn_preview_resume:                                //预览简历
                startActivity(new Intent(mContext,PreviewResumeActivity.class));
                break;

            case R.id.btn_base_info:                                             //基本信息
                Intent intent = new Intent(mContext,BaseInfoActivity.class);
                intent.putExtra("persionInfo",persionInfo);
                startActivityForResult(intent,MOFIFY_PERSION_INFO);
                break;

            case R.id.btn_edu_bg:                                                //教育背景

                    Intent eduBgIntent = new Intent(mContext,EduBgActivity.class);
                    eduBgIntent.putExtra("eduBgInfoList", (Serializable) eduBgInfoList);

                    startActivityForResult(eduBgIntent,GET_EDU_BG_LIST);
                break;

            case R.id.btn_work_experience:                               //实习/工作经历
                startActivity(new Intent(mContext,WorkExperienceActivity.class));
                break;

            case R.id.btn_evaluation:                                           //自我评价
                startActivity(new Intent(mContext,EvaluationActivity.class));
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }





    @Override
    public void showError(String error) {

    }

    @Override
    public void getEduViewSuccess(List<EduBgInfo> eduBgInfoList) {
        this.eduBgInfoList = eduBgInfoList;
    }

    @Override
    public void showPersionInfo(PersionInfo persionInfo) {
        this.persionInfo = persionInfo;
        showOtherInfo(persionInfo);
    }
    private void showOtherInfo(PersionInfo persionInfo){
        String userName = persionInfo.getTrueName();
        if(userName != null && !"".equals(userName))
            tvUsername.setText(userName);
        Glide.with(mContext)
                .load(persionInfo.getHeadPicID())
                .placeholder(R.drawable.icon_user_img)
                .error(R.drawable.icon_user_img)
                .into(ivUserImg);
        String sex = persionInfo.getGender();
        String education = persionInfo.getEducation();
        if(null != sex && !"".equals(sex) && null != education && !"".equals(education)) {
            sex = Integer.parseInt(sex) == 0 ? "男" : "女";
            tvOtherInfo.setText(sex+" | "+education);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case MOFIFY_PERSION_INFO: //修改信息返回
                if (resultCode == RESULT_OK) {
                    String userId = SettingPrefUtils.getUid();
                    if (null != userId && !"".equals(userId)) {
                        persionInfoPresenter.getPersionInfo("getPersionInfo", JSON.toJSONString(new UserInfoReq(userId)));
                    }
                }
                break;
            case GET_EDU_BG_LIST: //刷新教育背景
                if (resultCode == RESULT_OK) {
                    String userId = SettingPrefUtils.getUid();
                    if (null != userId && !"".equals(userId)) {
                        eduBgListPresenter.getEduBgList("getEduBgList",JSON.toJSONString(new UserInfoReq(userId)));
                    }
                }
                break;
        }
    }
}
