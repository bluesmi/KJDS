package com.penglai.kjds.presenter.implView;

import com.penglai.kjds.model.index.Course;

import java.util.List;

/**
 * Created by m199 on 2017/7/7.
 */

public interface GetCourseListView {
    /**
     * 显示错误信息
     * @param message
     */
    void showError(String message);

    /**
     * 获取数据成功
     * @param courseList
     */
    void getCourseListSuccess(List<Course> courseList);
}
