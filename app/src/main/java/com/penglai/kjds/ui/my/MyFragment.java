package com.penglai.kjds.ui.my;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.penglai.kjds.R;
import com.penglai.kjds.model.user.DeliverInfo;
import com.penglai.kjds.model.user.DeliverInfoReq;
import com.penglai.kjds.model.user.UserInfo;
import com.penglai.kjds.model.user.UserInfoReq;
import com.penglai.kjds.presenter.impl.GetDeliverListPresenterImpl;
import com.penglai.kjds.presenter.impl.GetUserInfoPresenterImpl;
import com.penglai.kjds.presenter.implView.GetDeliverListView;
import com.penglai.kjds.presenter.implView.GetUserInfoView;
import com.penglai.kjds.ui.base.BaseFragment;
import com.penglai.kjds.ui.view.widget.CircleImageView;
import com.penglai.kjds.utils.SettingPrefUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.app.Activity.RESULT_OK;

/**
 * 我的
 * <p>
 *  * 作者：朋来-GZQ on 2017/1/6 15:27
 *  * 邮箱：gongzhiqing@xiyundata.com
 *  
 */
public class MyFragment extends BaseFragment implements GetUserInfoView,GetDeliverListView {

    public final static  String TAG = MyFragment.class.getSimpleName();
    private static final int MODIFY_USER_INFO = 0 ;
    private View contentView;
    private GetUserInfoPresenterImpl userInfoPresenter;
    private static MyFragment instance;
    @BindView(R.id.iv_user_img)
    CircleImageView ivUserImg;
    @BindView(R.id.tv_username)
    TextView tvUsername;

    private GetUserInfoPresenterImpl presenter;
    private GetDeliverListPresenterImpl deliverListPresenter;

    private UserInfo userInfo;
    private List<DeliverInfo> deliverInfoList;

    public MyFragment() {
        super();
    }

    public static MyFragment getInstance() {
        if (instance == null) {
            instance = new MyFragment();
        }
        return instance;
    }

    @Override
    public View initViews() {
        // 防止多次new出片段对象，造成图片错乱问题
        if (contentView == null) {
            contentView = mInflater.inflate(R.layout.fragment_my, container,false);
        }
        //绑定view
        unbinder = ButterKnife.bind(MyFragment.this, contentView);
        return contentView;
    }


    @Override
    public void initData() {
        presenter = new GetUserInfoPresenterImpl(mContext,this);
        deliverListPresenter = new GetDeliverListPresenterImpl(mContext,this);
        String userId = SettingPrefUtils.getUid();
        if(null != userId && !"".equals(userId)){
            presenter.getUserInfo("getUserInfo", JSON.toJSONString(new UserInfoReq(userId)));
            deliverListPresenter.getDeliverList("getDeliverList",JSON.toJSONString(new DeliverInfoReq(userId,0)));
        }
    }


    @OnClick({R.id.edit_layout,R.id.my_deliver_layout,R.id.my_favorite_layout,
            R.id.my_msg_layout,R.id.my_settting_layout})
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.edit_layout://编辑用户资料
                Intent intent = new Intent(mContext,PersonInfoActivity.class);
                intent.putExtra("userInfo",userInfo);
                startActivityForResult(intent,MODIFY_USER_INFO);
                break;

            case R.id.my_deliver_layout:           //我的投递
                startActivity(new Intent(mContext,MyDeliverActivity.class));
                break;

            case R.id.my_favorite_layout:           //我的收藏
                startActivity(new Intent(mContext,MyFavoriteActivity.class));
                break;

            case R.id.my_msg_layout:                //我的消息
                startActivity(new Intent(mContext,MyMsgActivity.class));
                break;

            case R.id.my_settting_layout:           //设置
                startActivity(new Intent(mContext,SettingActivity.class));
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError(String error) {

    }

    @Override
    public void getDeliverListSuccess(List<DeliverInfo> deliverInfoList) {
        this.deliverInfoList = deliverInfoList;
    }

    @Override
    public void showUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
        String nickName = userInfo.getNickName();
        if(null != nickName && !"".equals(nickName)) {
            tvUsername.setText(nickName);
        }
        Glide.with(mContext)
                .load(userInfo.getUserImage())
                .placeholder(R.drawable.icon_user_img)
                .error(R.drawable.icon_user_img)
                .into(ivUserImg);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case MODIFY_USER_INFO: //修改信息返回
                if (resultCode == RESULT_OK) {
                    String userId = SettingPrefUtils.getUid();
                    if (null != userId && !"".equals(userId)) {
                        presenter.getUserInfo("getUserInfo", JSON.toJSONString(new UserInfoReq(userId)));
                    }
                }
                break;
        }
    }
}
