package com.penglai.kjds.presenter.impl;

import android.content.Context;

import com.penglai.kjds.http.RequestCallback;
import com.penglai.kjds.http.api.index.IndexService;
import com.penglai.kjds.model.BaseResArray;
import com.penglai.kjds.model.index.Course;
import com.penglai.kjds.presenter.Presenter;
import com.penglai.kjds.presenter.implView.GetCourseListView;
import com.penglai.kjds.utils.LogUtils;
import com.penglai.kjds.utils.UiUtils;

import java.util.List;

/**
 * Created by m199 on 2017/7/7.
 */

public class GetCourseListPresenterImpl implements Presenter {
    private Context mContext;
    private GetCourseListView courseListView;

    public GetCourseListPresenterImpl(Context mContext, GetCourseListView courseListView) {
        this.mContext = mContext;
        this.courseListView = courseListView;
    }

    @Override
    public void initialized() {

    }

    public void getCourseList(String opSign, String strJson){
        IndexService.getCourseList(opSign, strJson, new RequestCallback<BaseResArray<Course>>() {
            @Override
            public void onSuccess(BaseResArray<Course> courseBaseResArray) {
                if(courseBaseResArray ==null){
                    return;
                }
                int code = courseBaseResArray.getCode();
                String msg = courseBaseResArray.getMsg();
                List<Course> courseList = courseBaseResArray.getData();
                if(code == 0){        //是否成功登陆
                    LogUtils.error("data 中的数值"+courseList.toString());
                    //存储用户id和用户名
                    courseListView.getCourseListSuccess(courseList);
                }else{
                    UiUtils.showToast(mContext,msg);
                }
            }

            @Override
            public void onFailure(String message) {
                courseListView.showError(message);
            }
        });

    }
}
