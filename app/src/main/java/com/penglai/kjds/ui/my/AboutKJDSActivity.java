package com.penglai.kjds.ui.my;

import android.view.View;

import com.penglai.kjds.R;
import com.penglai.kjds.ui.base.BaseActivity;

import butterknife.ButterKnife;

/**
 *    关于平台
 *
 *  * 作者：朋来-GZQ on 2017/1/13 15:07
 *  * 邮箱：gongzhiqing@xiyundata.com
 *  
 */
public class AboutKJDSActivity extends BaseActivity {

    @Override
    protected View getContentView() {
        return inflateView(R.layout.activity_about_kjds);
    }

    @Override
    protected void setContentViewAfter(View contentView) {
        ButterKnife.bind(AboutKJDSActivity.this);
        //绑定view
        initData();
    }

    protected void initData() {

    }
}
