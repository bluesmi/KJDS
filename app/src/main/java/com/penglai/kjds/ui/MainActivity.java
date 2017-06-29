package com.penglai.kjds.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.penglai.kjds.R;
import com.penglai.kjds.ui.activity.LoginActivity;
import com.penglai.kjds.ui.adapter.FragmentTabAdapter;
import com.penglai.kjds.ui.index.IndexFragment;
import com.penglai.kjds.ui.my.MyFragment;
import com.penglai.kjds.ui.resume.ResumeFragment;
import com.penglai.kjds.utils.SettingPrefUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 *     主界面
 *
 *  * 作者：朋来-GZQ on 2017/1/6 11:53
 *  * 邮箱：gongzhiqing@xiyundata.com
 *  
 */
public class MainActivity extends AppCompatActivity {

    public final static  String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.tab_content)
    public FrameLayout contentView;         //内容区域
    @BindView(R.id.layout_bottom)
    public RelativeLayout tabView;               //底部Tab
    @BindView(R.id.tabs_rg)
    public RadioGroup mRadioGroup;
    @BindView(R.id.index_tab_rb)
    public RadioButton mIndexTab;             //首页
    @BindView(R.id.resume_tab_rb)
    public RadioButton mResumeTab;        //简历
    @BindView(R.id.my_tab_rb)
    public RadioButton mMyTab;                 //我的
    private int currentTab;             // 当前Tab页面索引
    private boolean isBack;             // 是否连续点击返回键

    private Unbinder unbinder;

    private MainActivity mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //去掉标题栏
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        //初始化对象及数据
        initData();
    }

    private void initData() {
        //绑定view
        unbinder= ButterKnife.bind(MainActivity.this);
        mContext = this;

        //设置背景颜色
        contentView.setBackgroundColor(getResources().getColor(R.color.app_bg));
        tabView.setBackgroundColor(getResources().getColor(R.color.white));

        //初始化tab菜单
        setTab();
        String userId = SettingPrefUtils.getUid();
        if(null == userId || "".equals(userId)) {
            Intent intent = new Intent(mContext, LoginActivity.class);
            startActivity(intent);
            finish();
        }
    }

    /**
     * 初始化tab菜单
     */
    private void setTab() {
        //默认选中的菜单
        rgsChange(R.id.index_tab_rb, true);
        //设置菜单切换
        FragmentTabAdapter.FragmentWraper wraper = new FragmentTabAdapter.FragmentWraper();
        wraper.setHealthFrg( IndexFragment.getInstance());
        wraper.setRelativeFrg(ResumeFragment.getInstance());
        wraper.setMyFrg(MyFragment.getInstance());

        FragmentTabAdapter tabAdapter = new FragmentTabAdapter(wraper,MainActivity.this, R.id.tab_content, mRadioGroup);
        //设置菜单切换通知
        tabAdapter.setOnRgsExtraCheckedChangedListener(new FragmentTabAdapter.OnRgsExtraCheckedChangedListener(){
            @Override
            public void OnRgsExtraCheckedChanged(RadioGroup radioGroup, int checkedId) {
                currentTab = checkedId;
            }
        });
    }

    public int getCurrentTab() {
        return currentTab;
    }

    public void rgsChange(int radioButtonId, boolean isChecked){
        switch (radioButtonId) {
            case R.id.index_tab_rb:
                if (mIndexTab != null) mIndexTab.setChecked(isChecked);
                break;

            case R.id.resume_tab_rb:
                if (mResumeTab != null) mResumeTab.setChecked(isChecked);
                break;

            case R.id.my_tab_rb:
                if (mMyTab != null) mMyTab.setChecked(isChecked);
                break;
            default:
                break;
        }
    }

    /**
     * 程序退出
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                if(this.getCurrentTab() != 0 && this.getCurrentTab() != R.id.index_tab_rb){
                    rgsChange(R.id.index_tab_rb, true);
                    return false;
                }
                // 双击返回桌面，默认返回true，调用finish()
                if (!isBack) {
                    isBack = true;
                    Toast.makeText(this, "再按一次返回键回到桌面", Toast.LENGTH_SHORT).show();
                    return false;
                }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //释放
        unbinder.unbind();
    }
}
