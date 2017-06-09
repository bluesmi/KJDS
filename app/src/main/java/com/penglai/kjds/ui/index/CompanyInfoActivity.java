package com.penglai.kjds.ui.index;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.penglai.kjds.R;
import com.penglai.kjds.ui.base.BaseActivity;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 公司信息
 * <p>
 *  * 作者：朋来-GZQ on 2017/1/12 10:28
 *  * 邮箱：gongzhiqing@xiyundata.com
 *  
 */
public class CompanyInfoActivity extends BaseActivity {

    public final static  String TAG = CompanyInfoActivity.class.getSimpleName();

    @BindView(R.id.index_top_layout)
    LinearLayout indexTopLayout;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.common_top_layout)
    RelativeLayout commonTopLayout;
    @BindString(R.string.company_info)
    String companyInfo;
    @BindView(R.id.iv_logo)
    ImageView ivLogo;
    @BindView(R.id.tv_company_info)
    TextView tvCompanyInfo;
    @BindView(R.id.tv_industry)
    TextView tvIndustry;
    @BindView(R.id.tv_company_type)
    TextView tvCompanyType;
    @BindView(R.id.tv_company_size)
    TextView tvCompanySize;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.tv_telphone)
    TextView tvTelphone;
    @BindView(R.id.iv_more)
    ImageView ivMore;
    @BindView(R.id.tv_more)
    TextView tvMore;
    @BindView(R.id.tv_company_desc)
    TextView tvCompanyDesc;

    @Override
    protected View getContentView() {
        return inflateView(R.layout.activity_company_info);
    }

    @Override
    protected void setContentViewAfter(View contentView) {
        ButterKnife.bind(CompanyInfoActivity.this);
        //绑定view
        initData();
    }

    protected void initData() {
        indexTopLayout.setVisibility(View.GONE);
        commonTopLayout.setVisibility(View.VISIBLE);
        tvTitle.setText(companyInfo);
    }

    @OnClick(R.id.btn_back)
    public void onClick(View view) {
        finish();
    }


}
