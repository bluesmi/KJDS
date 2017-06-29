package com.penglai.kjds.ui.resume;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.penglai.kjds.R;
import com.penglai.kjds.model.resume.AssessInfoRes;
import com.penglai.kjds.model.resume.EduBgInfo;
import com.penglai.kjds.model.resume.PersionInfo;
import com.penglai.kjds.model.resume.ResumeRes;
import com.penglai.kjds.model.resume.WorkExpInfoReq;
import com.penglai.kjds.model.user.UserInfoReq;
import com.penglai.kjds.presenter.impl.GetAssessInfoPresenterImpl;
import com.penglai.kjds.presenter.impl.GetEduBgListPresenterImpl;
import com.penglai.kjds.presenter.impl.GetPersionInfoPresenter;
import com.penglai.kjds.presenter.impl.GetResumeInfoPresenterImpl;
import com.penglai.kjds.presenter.impl.GetWorkExpListPresenterImpl;
import com.penglai.kjds.presenter.implView.GetAssessInfoView;
import com.penglai.kjds.presenter.implView.GetEduBgListView;
import com.penglai.kjds.presenter.implView.GetPersionInfoView;
import com.penglai.kjds.presenter.implView.GetResumeInfoView;
import com.penglai.kjds.presenter.implView.GetWorkExpListView;
import com.penglai.kjds.ui.base.BaseFragment;
import com.penglai.kjds.ui.view.widget.CircleImageView;
import com.penglai.kjds.utils.SettingPrefUtils;
import com.penglai.kjds.utils.UiUtils;

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
public class ResumeFragment extends BaseFragment implements GetPersionInfoView,GetEduBgListView,GetAssessInfoView,GetWorkExpListView,GetResumeInfoView{

    public final static String TAG = ResumeFragment.class.getSimpleName();
    private static final int MOFIFY_PERSION_INFO = 0;
    private static final int GET_EDU_BG_LIST = 1;
    private static final int GET_ASSESS_INFO = 2;
    private static final int WORK_EXP_INFO_LIST = 3;
    private static final int LOOK_RESUME = 4;
    private static ResumeFragment instance;
    private View contentView;

    @BindView(R.id.iv_user_img)
    CircleImageView ivUserImg;
    @BindView(R.id.tv_username)
    TextView tvUsername;
    @BindView(R.id.tv_other_info)
    TextView tvOtherInfo;
//    @BindView(R.id.tv_integrity1)
/*    TextView tvIntegrity1;
    @BindView(R.id.tv_integrity2)
    TextView tvIntegrity2;
    @BindView(R.id.tv_integrity3)
    TextView tvIntegrity3;
    @BindView(R.id.tv_integrity4)
    TextView tvIntegrity4;*/
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
     * 获取自我评价
     */
    private GetAssessInfoPresenterImpl assessInfoPresenter;
    /**
     * 获取工作经历
     */
    private GetWorkExpListPresenterImpl workExpInfoListPresenter;

    /**
     * 获取简历信息
     */
    private GetResumeInfoPresenterImpl resumeInfoPresenter;

    /**
     * 基本信息
     */
    private PersionInfo persionInfo;

    private List<EduBgInfo> eduBgInfoList;
    /**
     * 自我评价
     */
    private AssessInfoRes assessInfoRes;
    /**
     * 工作经历
     */
    private List<WorkExpInfoReq> workExpInfoReqList;
    private ResumeRes resumeRes;
    /**
     * 刷新简历
     */
    private boolean isRefreshResume;
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
        assessInfoPresenter = new GetAssessInfoPresenterImpl(mContext,this);
        workExpInfoListPresenter = new GetWorkExpListPresenterImpl(mContext,this);
        resumeInfoPresenter = new GetResumeInfoPresenterImpl(mContext,this);
        isRefreshResume = true;

        indexTopLayout.setVisibility(View.GONE);
        commonTopLayout.setVisibility(View.VISIBLE);
        commonTopLayout.setBackgroundColor(topBg);
        btnBack.setVisibility(View.GONE);
        tvTitle.setTextColor(titleBg);
        tvTitle.setText(title);
        String userId = SettingPrefUtils.getUid();
        String strJson = JSON.toJSONString(new UserInfoReq(userId));
        if(null != userId && !"".equals(userId)){

            persionInfoPresenter.getPersionInfo("getPersionInfo",strJson );
        }





    }

    //点击事件
    @OnClick({R.id.btn_refresh_resume, R.id.btn_preview_resume, R.id.btn_base_info,
            R.id.btn_edu_bg, R.id.btn_work_experience, R.id.btn_evaluation})
    public void onClick(View view) {
        String userId = SettingPrefUtils.getUid();
        String strJson = JSON.toJSONString(new UserInfoReq(userId));
        switch (view.getId()) {
            case R.id.btn_refresh_resume:                                  //刷新简历
                if(null != userId && !"".equals(userId)){
                 /*   persionInfoPresenter.getPersionInfo("getPersionInfo",strJson );
                    eduBgListPresenter.getEduBgList("getEduBgList",strJson);
                    assessInfoPresenter.getAssessInfo("getAssessInfo",strJson);
                    workExpInfoListPresenter.getWorkExpList("getWorkExpList",strJson);*/
                    isRefreshResume = false;
                    resumeInfoPresenter.getResumeInfo("getResumeInfo",strJson);
                }
                UiUtils.showToast(mContext,"刷新成功");
                break;

            case R.id.btn_preview_resume:                                //预览简历
                if(null != userId && !"".equals(userId)) {
                    isRefreshResume = true;
                    resumeInfoPresenter.getResumeInfo("getResumeInfo",strJson);
                }
                break;

            case R.id.btn_base_info:                                             //基本信息

                Intent intent = new Intent(mContext,BaseInfoActivity.class);
                intent.putExtra("persionInfo",persionInfo);
                startActivityForResult(intent,MOFIFY_PERSION_INFO);
                break;

            case R.id.btn_edu_bg:                                                //教育背景
                if(null != userId && !"".equals(userId)) {
                    eduBgListPresenter.getEduBgList("getEduBgList", strJson);
                }

                break;

            case R.id.btn_work_experience:                               //实习/工作经历
                if(null != userId && !"".equals(userId)) {
                    workExpInfoListPresenter.getWorkExpList("getWorkExpList",strJson);
                }

                break;

            case R.id.btn_evaluation:                                           //自我评价
                if(null != userId && !"".equals(userId)) {
                    assessInfoPresenter.getAssessInfo("getAssessInfo",strJson);
                }
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
    public void getResumeInfoSuccess(ResumeRes resumeRes) {
        this.resumeRes = resumeRes;
        if(isRefreshResume) {
            if (null != resumeRes.getPersion()) {
                Intent resumeIntent = new Intent(mContext, PreviewResumeActivity.class);
                resumeIntent.putExtra("resumeRes", resumeRes);
                startActivityForResult(resumeIntent, LOOK_RESUME);
            } else {
                UiUtils.showToast(mContext, "请先完善您的简历");
            }
        }
    }

    @Override
    public void getWorkExpListSucces(List<WorkExpInfoReq> workExpInfoReqList) {
        this.workExpInfoReqList = workExpInfoReqList;
        Intent workExpIntent = new Intent(mContext,WorkExperienceActivity.class);
        workExpIntent.putExtra("workExpInfoReqList", (Serializable) workExpInfoReqList);
        startActivityForResult(workExpIntent,WORK_EXP_INFO_LIST);
    }

    @Override
    public void getAssessInfoSuccess(AssessInfoRes assessInfoRes) {
        this.assessInfoRes = assessInfoRes;
        Intent assessIntent = new Intent(mContext,EvaluationActivity.class);
        assessIntent.putExtra("assessInfoRes",assessInfoRes);
        startActivity(assessIntent);
    }

    @Override
    public void getEduViewSuccess(List<EduBgInfo> eduBgInfoList) {
        Intent eduBgIntent = new Intent(mContext,EduBgActivity.class);
        eduBgIntent.putExtra("eduBgInfoList", (Serializable) eduBgInfoList);
        startActivityForResult(eduBgIntent,GET_EDU_BG_LIST);
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
//                if (resultCode == RESULT_OK) {
//                    String userId = SettingPrefUtils.getUid();
//                    if (null != userId && !"".equals(userId)) {
//                        eduBgListPresenter.getEduBgList("getEduBgList",JSON.toJSONString(new UserInfoReq(userId)));
//                    }
//                }
                break;
            case GET_ASSESS_INFO: //刷新教育背景
//                if (resultCode == RESULT_OK) {
//                    String userId = SettingPrefUtils.getUid();
//                    if (null != userId && !"".equals(userId)) {
//                        assessInfoPresenter.getAssessInfo("getAssessInfo",JSON.toJSONString(new UserInfoReq(userId)));
//                    }
//                }
                break;
            case WORK_EXP_INFO_LIST:
//                if (resultCode == RESULT_OK) {
//                    String userId = SettingPrefUtils.getUid();
//                    if (null != userId && !"".equals(userId)) {
//                        workExpInfoListPresenter.getWorkExpList("getWorkExpList",JSON.toJSONString(new UserInfoReq(userId)));
//                    }
//                }
                break;
            case LOOK_RESUME:
//                if (resultCode == RESULT_OK) {
//                    String userId = SettingPrefUtils.getUid();
//                    if (null != userId && !"".equals(userId)) {
//                        resumeInfoPresenter.getResumeInfo("getResumeInfo",JSON.toJSONString(new UserInfoReq(userId)));
//                    }
//                }
                break;
        }
    }
}
