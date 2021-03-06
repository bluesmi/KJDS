package com.penglai.kjds.ui.my;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.View;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.penglai.kjds.R;
import com.penglai.kjds.model.user.CollectInfo;
import com.penglai.kjds.model.user.DeliverInfo;
import com.penglai.kjds.model.user.DeliverInfoReq;
import com.penglai.kjds.model.user.MyMessage;
import com.penglai.kjds.model.user.UserInfo;
import com.penglai.kjds.model.user.UserInfoReq;
import com.penglai.kjds.presenter.impl.GetDeliverListPresenterImpl;
import com.penglai.kjds.presenter.impl.GetFavoriteListPresenterImpl;
import com.penglai.kjds.presenter.impl.GetMyMessagePresenterImpl;
import com.penglai.kjds.presenter.impl.GetUserInfoPresenterImpl;
import com.penglai.kjds.presenter.implView.GetDeliverListView;
import com.penglai.kjds.presenter.implView.GetFavoriteListView;
import com.penglai.kjds.presenter.implView.GetMyMessageView;
import com.penglai.kjds.presenter.implView.GetUserInfoView;
import com.penglai.kjds.ui.base.BaseFragment;
import com.penglai.kjds.ui.view.widget.CircleImageView;
import com.penglai.kjds.utils.SettingPrefUtils;

import java.io.Serializable;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.app.Activity.RESULT_OK;
import static com.penglai.kjds.R.id.imageView;

/**
 * 我的
 * <p>
 *  * 作者：朋来-GZQ on 2017/1/6 15:27
 *  * 邮箱：gongzhiqing@xiyundata.com
 *  
 */
public class MyFragment extends BaseFragment implements GetUserInfoView,GetDeliverListView,GetFavoriteListView,GetMyMessageView {

    public final static  String TAG = MyFragment.class.getSimpleName();
    private static final int MODIFY_USER_INFO = 0 ;
    private static final int GET_FAVORITE_JOB = 1;
    private View contentView;
    private GetUserInfoPresenterImpl userInfoPresenter;
    private static MyFragment instance;
    @BindView(R.id.iv_user_img)
    CircleImageView ivUserImg;
    @BindView(R.id.tv_username)
    TextView tvUsername;

    private GetUserInfoPresenterImpl presenter;
    private GetDeliverListPresenterImpl deliverListPresenter;
    private GetFavoriteListPresenterImpl favoriteListPresenter;
    private GetMyMessagePresenterImpl myMessagePresenter;

    private UserInfo userInfo;
    private List<DeliverInfo> deliverInfoList;
    private List<CollectInfo> collectInfoList;

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
        favoriteListPresenter = new GetFavoriteListPresenterImpl(mContext,this);
        myMessagePresenter = new GetMyMessagePresenterImpl(mContext,this);
        String userId = SettingPrefUtils.getUid();
        if(null != userId && !"".equals(userId)){
            presenter.getUserInfo("getUserInfo", JSON.toJSONString(new UserInfoReq(userId)));
            deliverListPresenter.getDeliverList("getDeliverList",JSON.toJSONString(new DeliverInfoReq(userId,0)));
            favoriteListPresenter.getFavoriteList("getFavoriteList", JSON.toJSONString(new UserInfoReq(userId)));
        }
    }


    @OnClick({R.id.edit_layout,R.id.my_deliver_layout,R.id.my_favorite_layout,
            R.id.my_msg_layout,R.id.my_settting_layout})
    public void onClick(View v){
        String userId = SettingPrefUtils.getUid();
        switch (v.getId()) {
            case R.id.edit_layout://编辑用户资料

          /*      if(null != userId && !"".equals(userId)){
                    presenter.getUserInfo("getUserInfo", JSON.toJSONString(new UserInfoReq(userId)));
                }*/
                Intent intent = new Intent(mContext,PersonInfoActivity.class);
                intent.putExtra("userInfo",userInfo);
                startActivityForResult(intent,MODIFY_USER_INFO);

                break;

            case R.id.my_deliver_layout:           //我的投递
                Intent deliverIntent = new Intent(mContext,MyDeliverActivity.class);
                deliverIntent.putExtra("deliverInfoList", (Serializable) deliverInfoList);
                startActivity(deliverIntent);
                break;

            case R.id.my_favorite_layout:           //我的收藏
                Intent favoriteIntent =  new Intent(mContext,MyFavoriteActivity.class);
                favoriteIntent.putExtra("collectInfoList", (Serializable) collectInfoList);
                startActivityForResult(favoriteIntent,GET_FAVORITE_JOB);
                break;

            case R.id.my_msg_layout:                //我的消息
                if(null != userId && !"".equals(userId)){
                    myMessagePresenter.getMessage("getMessage",JSON.toJSONString(new UserInfoReq(userId)));
                }
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
    public void getMyMessageSuccess(List<MyMessage> myMessageList) {
        Intent intent = new Intent(mContext,MyMsgActivity.class);
        intent.putExtra("myMessageList", (Serializable) myMessageList);
        startActivity(intent);
    }

    @Override
    public void getFavoriteListSuccess(List<CollectInfo> collectInfoList) {
        this.collectInfoList = collectInfoList;
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
      /*  Glide.with(mContext)
                .load(userInfo.getUserImage())
                .placeholder(R.drawable.icon_user_img)
                .error(R.drawable.icon_user_img)
                .into(ivUserImg);*/

        Glide.with(mContext)
                .load(userInfo.getUserImage())
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
            case GET_FAVORITE_JOB://我的收藏
                if (resultCode == RESULT_OK) {
                    String userId = SettingPrefUtils.getUid();
                    if (null != userId && !"".equals(userId)) {
                        favoriteListPresenter.getFavoriteList("getUserInfo", JSON.toJSONString(new UserInfoReq(userId)));
                    }
                }
                break;

        }
    }
}
