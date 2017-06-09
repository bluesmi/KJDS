package com.penglai.kjds.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.penglai.kjds.R;
import com.penglai.kjds.ui.base.BaseFragment;
import com.penglai.kjds.ui.index.IndexFragment;
import com.penglai.kjds.ui.my.MyFragment;
import com.penglai.kjds.ui.resume.ResumeFragment;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *     管理Fragment
 *
 *  * 作者：朋来-GZQ on 2017/1/6 15:19
 *  * 邮箱：gongzhiqing@xiyundata.com
 *  
 */
public class FragmentTabAdapter   implements  RadioGroup.OnCheckedChangeListener {

    private FragmentWraper fragmentWraper;
    private RadioGroup rgs;
    private FragmentActivity fragmentActivity;
    private int fragmentContentId;
    private int currentTabRid;

    private OnRgsExtraCheckedChangedListener onRgsExtraCheckedChangedListener; // 用于让调用者在切换tab时候增加新的功能

    public static class FragmentWraper {
        private IndexFragment  indexFrg;
        private ResumeFragment resumeFrg;
        private MyFragment myFrg;
        private boolean isAuthorization;

        private Map<Integer, BaseFragment> fragment = new HashMap<>();

        public boolean isAuthorization() {
            return isAuthorization;
        }

        public IndexFragment  getIndexFrg() {
            return indexFrg;
        }

        public Map<Integer, BaseFragment> getFragment() {
            return fragment;
        }

        public void setFragment(Map<Integer, BaseFragment> fragment) {
            this.fragment = fragment;
        }


        public ResumeFragment getResumeFrg() {
            return resumeFrg;
        }


        public MyFragment getMyFrg() {
            return myFrg;
        }


        public void setAuthorization(boolean isAuthorization) {
            this.isAuthorization = isAuthorization;
        }

        public void setHealthFrg(IndexFragment indexFrg) {
            this.indexFrg = indexFrg;
            fragment.put(R.id.index_tab_rb, indexFrg);
        }

        public void setRelativeFrg(ResumeFragment  resumeFrg) {
            this.resumeFrg = resumeFrg;
            fragment.put(R.id.resume_tab_rb, resumeFrg);
        }

        public void setMyFrg(MyFragment myFrg) {
            this.myFrg = myFrg;
            fragment.put(R.id.my_tab_rb, myFrg);
        }
    }

    public FragmentWraper getFragmentWraper() {

        return fragmentWraper;
    }

    public void setFragmentWraper(FragmentWraper fragmentWraper) {
        this.fragmentWraper = fragmentWraper;
    }

    public FragmentTabAdapter(FragmentWraper fragmentWraper, FragmentActivity fragmentActivity, int fragmentContentId, RadioGroup rgs) {

        this.fragmentWraper = fragmentWraper;
        this.rgs = rgs;
        this.fragmentActivity = fragmentActivity;
        this.fragmentContentId = fragmentContentId;

        Fragment firstFragment = fragmentWraper.getIndexFrg();
        if (!firstFragment.isAdded()) {
            FragmentTransaction ft = fragmentActivity.getSupportFragmentManager().beginTransaction();
            ft.add(fragmentContentId, firstFragment);
            ft.commitAllowingStateLoss();  //允许状态丢失。
        }

        showTab(R.id.index_tab_rb);

        rgs.setOnCheckedChangeListener(this);

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        getCurrentFragment().onPause();

        FragmentTransaction ft = obtainFragmentTransaction(checkedId);

        if (fragmentWraper.getFragment().get(checkedId).isAdded()) {
            fragmentWraper.getFragment().get(checkedId).onResume();
        } else {
            ft.add(fragmentContentId, fragmentWraper.getFragment().get(checkedId));
        }

        if (null != onRgsExtraCheckedChangedListener) {
            onRgsExtraCheckedChangedListener.OnRgsExtraCheckedChanged(radioGroup, checkedId);
        }

        showTab(checkedId); // 显示目标tab

        ft.commitAllowingStateLoss();
    }

    /**
     * 切换tab
     *
     * @param
     *
     */
    public void showTab(int Rid) {
        FragmentTransaction ft = obtainFragmentTransaction(Rid);

        if (fragmentWraper.getFragment().get(Rid).isAdded())
            ft.show(fragmentWraper.getFragment().get(Rid));

        Iterator<Integer> iterator = fragmentWraper.getFragment().keySet().iterator();
        while (iterator.hasNext()) {
            int nextid = iterator.next();
            if (Rid != nextid) {
                if (fragmentWraper.getFragment().get(nextid).isAdded())
                    ft.hide(fragmentWraper.getFragment().get(nextid));
            }
        }
        ft.commitAllowingStateLoss();
        currentTabRid = Rid; // 更新目标tab为当前tab
    }

    /**
     * 获取一个带动画的FragmentTransaction
     *
     * @param index
     * @return
     */

    final int[] _tabRidArray = new int[]{
            R.id.index_tab_rb,
            R.id.resume_tab_rb,
            R.id.my_tab_rb,
    };

    private FragmentTransaction obtainFragmentTransaction(int clickTabRid) {
        FragmentTransaction ft = fragmentActivity.getSupportFragmentManager().beginTransaction();

        int clickTabPos = 0;
        int currentTabPos = 0;

        for (int i = 0; i < _tabRidArray.length; i++) {
            if (_tabRidArray[i] == clickTabRid) {
                clickTabPos = i;
            }
            if (_tabRidArray[i] == currentTabRid) {
                currentTabPos = i;
            }
        }

        // 设置切换动画
        if (clickTabPos > currentTabPos) {
            ft.setCustomAnimations(R.anim.slide_left_in, R.anim.slide_left_out);
        } else {
            ft.setCustomAnimations(R.anim.slide_right_in, R.anim.slide_right_out);
        }
        return ft;
    }

    public int getCurrentTabRid() {
        return currentTabRid;
    }

    public BaseFragment getCurrentFragment() {
        return fragmentWraper.getFragment().get(currentTabRid);
    }

    public OnRgsExtraCheckedChangedListener getOnRgsExtraCheckedChangedListener() {
        return onRgsExtraCheckedChangedListener;
    }

    public void setOnRgsExtraCheckedChangedListener(OnRgsExtraCheckedChangedListener onRgsExtraCheckedChangedListener) {
        this.onRgsExtraCheckedChangedListener = onRgsExtraCheckedChangedListener;
    }

    /**
     * 切换tab额外功能功能接口
     */
    public static class OnRgsExtraCheckedChangedListener {
        public void OnRgsExtraCheckedChanged(RadioGroup radioGroup, int checkedId) {

        }
    }

}
