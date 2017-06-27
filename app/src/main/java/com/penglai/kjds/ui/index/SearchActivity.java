package com.penglai.kjds.ui.index;

import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.penglai.kjds.R;
import com.penglai.kjds.model.index.CompanyInfo;
import com.penglai.kjds.model.index.SearchReq;
import com.penglai.kjds.presenter.impl.SearchJobPresenterImpl;
import com.penglai.kjds.presenter.implView.SearchJobView;
import com.penglai.kjds.ui.base.BaseActivity;
import com.penglai.kjds.utils.SettingPrefUtils;

import java.io.Serializable;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 *    职位搜索
 *
 *  * 作者：朋来-GZQ on 2017/1/6 17:40
 *  * 邮箱：gongzhiqing@xiyundata.com
 *  
 */
public class SearchActivity extends BaseActivity implements SearchJobView{
    @BindView(R.id.et_key_value)
    EditText etKeyValue;

    private SearchJobPresenterImpl searchJobPresenter;

    @Override
    protected View getContentView() {
        return inflateView(R.layout.activity_search_job);
    }

    @Override
    protected void setContentViewAfter(View contentView) {
        ButterKnife.bind(SearchActivity.this);
        //初始化
        initData();
    }

    protected void initData() {
        searchJobPresenter = new SearchJobPresenterImpl(mContext,this);
        etKeyValue.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId == EditorInfo.IME_ACTION_SEARCH){
// 先隐藏键盘
                    ((InputMethodManager) etKeyValue.getContext().getSystemService(Context.INPUT_METHOD_SERVICE))
                            .hideSoftInputFromWindow(
                                    SearchActivity.this.getCurrentFocus().getWindowToken(),
                                    InputMethodManager.HIDE_NOT_ALWAYS);
                    String userId = SettingPrefUtils.getUid();
                    String keyValue = etKeyValue.getText().toString();
                    if(null != userId && !"".equals(userId) && null != keyValue) {
                        searchJobPresenter.searchJobList("searchJobList", JSON.toJSONString(new SearchReq(userId,keyValue)));
                        return true;
                    }
                }
                return false;
            }
        });
    }

    @OnClick({R.id.btn_cancel})
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_cancel:
                etKeyValue.setText("");
                break;
        }
    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void searchJobListSuccess(List<CompanyInfo> companyInfoList) {
        Intent intent = new Intent(mContext,CareerOpportunitiesActivity.class);
        intent.putExtra("jobList", (Serializable) companyInfoList);
        startActivity(intent);
    }
}
