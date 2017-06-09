package com.penglai.kjds.ui.my;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.penglai.kjds.R;
import com.penglai.kjds.ui.base.BaseFragment;
import com.penglai.kjds.ui.view.widget.CircleImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 我的
 * <p>
 *  * 作者：朋来-GZQ on 2017/1/6 15:27
 *  * 邮箱：gongzhiqing@xiyundata.com
 *  
 */
public class MyFragment extends BaseFragment {

    public final static  String TAG = MyFragment.class.getSimpleName();
    private View contentView;

    private static MyFragment instance;
    @BindView(R.id.iv_user_img)
    CircleImageView ivUserImg;
    @BindView(R.id.tv_username)
    TextView tvUsername;

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

    }


    @OnClick({R.id.edit_layout,R.id.my_deliver_layout,R.id.my_favorite_layout,
            R.id.my_msg_layout,R.id.my_settting_layout})
    public void onClick(View v){
        switch (v.getId()) {
            case R.id.edit_layout:                       //编辑用户资料
                startActivity(new Intent(mContext,PersonInfoActivity.class));
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
}
