package com.penglai.kjds.ui.resume;

import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.penglai.kjds.R;
import com.penglai.kjds.model.resume.AssessInfoReq;
import com.penglai.kjds.model.resume.AssessInfoRes;
import com.penglai.kjds.presenter.impl.ModifyAssessInfoPresenterImpl;
import com.penglai.kjds.presenter.implView.ModifyAssessInfoView;
import com.penglai.kjds.ui.base.BaseActivity;
import com.penglai.kjds.utils.SettingPrefUtils;

import butterknife.BindColor;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 自我评价
 *  * 作者：朋来-GZQ on 2017/1/16 14:35
 *  * 邮箱：gongzhiqing@xiyundata.com
 *  
 */
public class EvaluationActivity extends BaseActivity implements ModifyAssessInfoView{

    @BindView(R.id.index_top_layout)
    LinearLayout indexTopLayout;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.common_top_layout)
    RelativeLayout commonTopLayout;
    @BindView(R.id.et_content)
    EditText etContent;
    @BindColor(R.color.blue_top_bg)
    int topBackgroundColor;
    @BindColor(R.color.white)
    int topColor;

    @BindString(R.string.base_info)
    String title;

    private AssessInfoReq assessInfoReq;
    private ModifyAssessInfoPresenterImpl modifyAssessInfoPresenter;

    @Override
    protected View getContentView() {
        return inflateView(R.layout.activity_evaluation);
    }

    @Override
    protected void setContentViewAfter(View contentView) {
        ButterKnife.bind(EvaluationActivity.this);
        //绑定view
        initData();
    }

    protected void initData() {
        modifyAssessInfoPresenter = new ModifyAssessInfoPresenterImpl(mContext,this);
        //初始化标题栏布局
        indexTopLayout.setVisibility(View.GONE);
        commonTopLayout.setVisibility(View.VISIBLE);
        commonTopLayout.setBackgroundColor(topBackgroundColor);
        tvTitle.setTextColor(topColor);
        tvTitle.setText(title);
        Intent intent = getIntent();
        AssessInfoRes assessInfoRes = (AssessInfoRes) intent.getSerializableExtra("assessInfoRes");
        assessInfoReq = new AssessInfoReq();
        String userId = SettingPrefUtils.getUid();
        if(null != userId && !"".equals(userId)){
            assessInfoReq.setUserId(userId);
        }
        if(null != assessInfoRes){
            assessInfoReq.setAssessId(assessInfoRes.getAssessId());
            assessInfoReq.setContent(assessInfoRes.getContent());
            etContent.setText(assessInfoRes.getContent());
        }else {
            assessInfoReq.setAssessId("");
        }
    }

    @OnClick({R.id.btn_back, R.id.btn_submit_evaluation})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:                                                     //返回
                Intent mIntent = new Intent(mContext,ResumeFragment.class);
                setResult(RESULT_OK,mIntent);

                break;

            case R.id.btn_submit_evaluation:                             //提交评价
                resetAssessInfo();
                modifyAssessInfoPresenter.modifyAssessInfo("modifyAssessInfo", JSON.toJSONString(assessInfoReq));
                break;
        }
    }

    private void resetAssessInfo() {
        assessInfoReq.setContent(etContent.getText().toString());
    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void modifyAssessSuccess() {
        Intent mIntent = new Intent(mContext,ResumeFragment.class);
        setResult(RESULT_OK,mIntent);
        finish();
    }
}
