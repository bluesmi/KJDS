package com.penglai.kjds.ui.resume;

import android.content.Intent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.penglai.kjds.R;
import com.penglai.kjds.ui.base.BaseFragment;
import com.penglai.kjds.ui.view.widget.CircleImageView;

import butterknife.BindColor;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 简历
 * <p>
 *  * 作者：朋来-GZQ on 2017/1/6 15:34
 *  * 邮箱：gongzhiqing@xiyundata.com
 *  
 */
public class ResumeFragment extends BaseFragment {

    public final static String TAG = ResumeFragment.class.getSimpleName();
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
        indexTopLayout.setVisibility(View.GONE);
        commonTopLayout.setVisibility(View.VISIBLE);
        commonTopLayout.setBackgroundColor(topBg);
        btnBack.setVisibility(View.GONE);
        tvTitle.setTextColor(titleBg);
        tvTitle.setText(title);

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
                startActivity(new Intent(mContext,BaseInfoActivity.class));
                break;

            case R.id.btn_edu_bg:                                                //教育背景
                startActivity(new Intent(mContext,EduBgActivity.class));
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

}