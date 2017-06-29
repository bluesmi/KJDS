package com.penglai.kjds.ui.my;

import android.content.Intent;
import android.graphics.Bitmap;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.penglai.kjds.R;
import com.penglai.kjds.model.user.ModifyPwdReq;
import com.penglai.kjds.presenter.impl.ModifyPwdPresenterImpl;
import com.penglai.kjds.presenter.implView.ModifyPwdView;
import com.penglai.kjds.ui.MainActivity;
import com.penglai.kjds.ui.activity.LoginActivity;
import com.penglai.kjds.ui.base.BaseActivity;
import com.penglai.kjds.utils.PrefUtils;
import com.penglai.kjds.utils.SettingPrefUtils;
import com.penglai.kjds.utils.UiUtils;

import butterknife.BindBitmap;
import butterknife.BindColor;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 修改密码
 * <p>
 *  * 作者：朋来-GZQ on 2017/1/13 15:08
 *  * 邮箱：gongzhiqing@xiyundata.com
 *  
 */
public class ModifyPwdActivity extends BaseActivity  implements ModifyPwdView{

    @BindView(R.id.index_top_layout)
    LinearLayout indexTopLayout;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.common_top_layout)
    RelativeLayout commonTopLayout;
    @BindString(R.string.modify_pwd)
    String modifyPwd;
    @BindView(R.id.iv_username)
    ImageView ivUsername;
    @BindView(R.id.tv_username)
    TextView tvUsername;
    @BindView(R.id.iv_clear_username)
    ImageView ivClearUsername;
    @BindView(R.id.iv_pwd)
    ImageView ivPwd;
    @BindView(R.id.et_pwd)
    EditText etPwd;
    @BindView(R.id.iv_view_pwd)
    ImageView ivViewPwd;
    @BindView(R.id.iv_repwd)
    ImageView ivRepwd;
    @BindView(R.id.et_new_pwd)
    EditText etNewpwd;
    @BindView(R.id.iv_view_repwd)
    ImageView ivViewRepwd;
    @BindColor(R.color.app_bg)
    int txtColor;
    @BindView(R.id.btn_back)
    ImageButton btnBack;
    @BindColor(R.color.blue_top_bg)
    int topBackgroundColor;
    @BindBitmap(R.drawable.icon_common_back)
    Bitmap commonBack;

    private boolean isHidden;         //是否显示密码
    private boolean isReHidden;      //是否显示再次密码
    private Intent intent;
    private String  userName;
    private String uid;
    private ModifyPwdPresenterImpl modifyPwdPresenter;

    @Override
    protected View getContentView() {
        return inflateView(R.layout.activity_modify_pwd);
    }

    @Override
    protected void setContentViewAfter(View contentView) {
        ButterKnife.bind(ModifyPwdActivity.this);
        //绑定view
        initData();
    }

    protected void initData() {
        intent = getIntent();
        try {
            uid = SettingPrefUtils.getUid();
        }catch (Exception e){
            e.printStackTrace();
        }
        if(intent != null){

                userName = SettingPrefUtils.getUserName();
                if (null != userName && !"".equals(userName)) {            //非空判定
                    tvUsername.setText("当前账户：" + userName);
                    tvUsername.setTextColor(topBackgroundColor);
                }

        }

        indexTopLayout.setVisibility(View.GONE);
        commonTopLayout.setVisibility(View.VISIBLE);
        tvTitle.setText(modifyPwd);
        commonTopLayout.setBackgroundColor(topBackgroundColor);
        btnBack.setImageBitmap(commonBack);
        tvTitle.setTextColor(txtColor);
        modifyPwdPresenter  = new ModifyPwdPresenterImpl(this,this);

        etPwd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    @OnClick({R.id.btn_back, R.id.btn_confirm_modify,R.id.iv_view_repwd,R.id.iv_view_pwd})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_back:                                                     //返回
                finish();
                break;

            case R.id.iv_view_pwd:                                                 //查看旧密码
                isPassHide();
                break;

            case R.id.iv_view_repwd:                                            //查看新密码
                isNewPassHide();
                break;

            case R.id.btn_confirm_modify:                                  //确认修改
                confirmModifyPwd();
                break;
        }
    }

    /**
     * 密码的显示与隐藏
     */
    private void isPassHide() {
        isHidden = !isHidden;
        if (isHidden) {
            //设置EditText文本为可见的
            etPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            ivViewPwd.setImageResource(R.drawable.open_eye);
        } else {
            //设置EditText文本为隐藏的
            etPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
            ivViewPwd.setImageResource(R.drawable.close_eyes);
        }
        etPwd.postInvalidate();
        //切换后将EditText光标置于末尾
        CharSequence charSequence = etPwd.getText();
        if (charSequence instanceof Spannable) {
            Spannable spanText = (Spannable) charSequence;
            Selection.setSelection(spanText, charSequence.length());
        }
    }

    /**
     * 新密码的显示与隐藏
     */
    private void isNewPassHide() {
        isReHidden = !isReHidden;
        if (isReHidden) {
            //设置EditText文本为可见的
            etNewpwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            ivViewRepwd.setImageResource(R.drawable.open_eye);
        } else {
            //设置EditText文本为隐藏的
            etNewpwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
            ivViewRepwd.setImageResource(R.drawable.close_eyes);
        }
        etNewpwd.postInvalidate();
        //切换后将EditText光标置于末尾
        CharSequence charSequence = etNewpwd.getText();
        if (charSequence instanceof Spannable) {
            Spannable spanText = (Spannable) charSequence;
            Selection.setSelection(spanText, charSequence.length());
        }
    }

    /**
     * 确认修改
     */
    private void confirmModifyPwd() {
        String pwd = etPwd.getText().toString().trim();
        String newPwd = etNewpwd.getText().toString().trim();

        if(TextUtils.isEmpty(pwd) || TextUtils.isEmpty(newPwd)){
            UiUtils.showToast(mContext,"密码不能为空！");
            return;
        }

        //请求网络
        modifyPwdPresenter.ModifyPwd("modifyPwd", JSON.toJSONString(
                new ModifyPwdReq(userName,pwd,newPwd,uid)));
    }

        @Override
        public void showLoading() {

        }

        @Override
        public void showError(String error) {
            UiUtils.showToast(mContext,error);
        }

        @Override
        public void modifySuccess() {
            PrefUtils.clearAll();
            Intent intent = new Intent(mContext, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }

        @Override
        public void hideLoading() {

        }

}
