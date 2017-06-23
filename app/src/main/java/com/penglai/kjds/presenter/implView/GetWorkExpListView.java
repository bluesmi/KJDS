package com.penglai.kjds.presenter.implView;

import com.penglai.kjds.model.resume.WorkExpInfoReq;

import java.util.List;

/**
 * Created by m199 on 2017/6/22.
 */

public interface GetWorkExpListView {

    //显示错误信息
    void showError(String error);

    /**
     * 获取工作经验成功
     * @param workExpInfoReqList
     */
    void getWorkExpListSucces(List<WorkExpInfoReq> workExpInfoReqList);
}
