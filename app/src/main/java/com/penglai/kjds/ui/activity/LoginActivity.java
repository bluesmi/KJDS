package com.penglai.kjds.ui.activity;

import android.content.Intent;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.alibaba.fastjson.JSON;
import com.penglai.kjds.R;
import com.penglai.kjds.model.user.LoginReq;
import com.penglai.kjds.presenter.impl.LoginPresenterImpl;
import com.penglai.kjds.ui.MainActivity;
import com.penglai.kjds.ui.base.BaseActivity;
import com.penglai.kjds.ui.my.ModifyPwdActivity;
import com.penglai.kjds.presenter.implView.LoginView;
import com.penglai.kjds.utils.UiUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 *  * 作者：朋来-GZQ on 2017/2/4 15:07
 *  * 邮箱：gongzhiqing@xiyundata.com
 *     用户登录
 */
public class LoginActivity extends BaseActivity implements LoginView {

    public final static String TAG = LoginActivity.class.getSimpleName();
    @BindView(R.id.iv_app_logo)
    ImageView ivAppLogo;
    @BindView(R.id.iv_username)
    ImageView ivUsername;
    @BindView(R.id.et_username)
    EditText etUsername;
    @BindView(R.id.iv_pwd)
    ImageView ivPwd;
    @BindView(R.id.et_pwd)
    EditText etPwd;
    @BindView(R.id.iv_view_pwd)
    ImageView ivViewPwd;


    private LoginPresenterImpl presenter;
    private boolean isHidden;

    @Override
    protected View getContentView() {
        return inflateView(R.layout.activity_login);
    }

    @Override
    protected void setContentViewAfter(View contentView) {
        //绑定View
        ButterKnife.bind(LoginActivity.this);
        //初始化
        initData();
    }

    protected void initData() {
        presenter = new LoginPresenterImpl(mContext, this);

        etUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ivUsername.setImageResource(R.drawable.icon_blue_user);
                ivPwd.setImageResource(R.drawable.icon_gray_pwd);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        etPwd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ivUsername.setImageResource(R.drawable.icon_gray_user);
                ivPwd.setImageResource(R.drawable.icon_blue_pwd);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showUserNameError(String error) {
        etUsername.setError(error);
    }

    @Override
    public void showPassWordError(String error) {
        etPwd.setError(error);
    }

    @Override
    public void loginSuccess() {
        UiUtils.showToast(mContext,"登录成功");

        //跳转至主页面
        Intent intent = new Intent(mContext, MainActivity.class);
        startActivity(intent);
//        setResult(RESULT_OK,intent);
//        startActivityForResult(,0);

        finish();
    }


    @OnClick({R.id.btn_modify_pwd, R.id.btn_login, R.id.iv_view_pwd})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_modify_pwd:          //修改密码
                if(!TextUtils.isEmpty(etUsername.getText().toString().trim())){
                    Intent intent =new Intent(mContext, ModifyPwdActivity.class);
                    intent.putExtra("userName",etUsername.getText().toString().trim());
                    startActivity(intent);
                    finish();
                }else{
                    UiUtils.showToast(mContext,"请先填写账户名！");
                }
                break;

            case R.id.iv_view_pwd:                //查看密码
                isPassHide();
                break;

            case R.id.btn_login:                      //用户登陆
                userLogin();
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

    private void userLogin() {
        String userName = etUsername.getText().toString().trim();
        String password = etPwd.getText().toString().trim();
        if (TextUtils.isEmpty(userName)) {
            UiUtils.showToast(mContext, "用户名不能为空！");
            return;
        }
        if (TextUtils.isEmpty(password)) {
            UiUtils.showToast(mContext, "密码不能为空！");
            return;
        }
        String loginJson = JSON.toJSONString(new LoginReq(userName, password,0));
        Log.d(TAG, "userLogin: "+loginJson);
        //用户登陆
        presenter.login("userLogin", loginJson);
    }

}
