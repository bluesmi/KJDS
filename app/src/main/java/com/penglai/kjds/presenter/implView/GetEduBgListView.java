package com.penglai.kjds.presenter.implView;

import com.penglai.kjds.model.resume.EduBgInfo;

import java.util.List;

/**
 * Created by m199 on 2017/6/20.
 */

public interface GetEduBgListView {

    /**
     * 显示错误信息
     * @param message
     */
    void showError(String message);

    /**
     * 成功
     */
    void getEduViewSuccess(List<EduBgInfo> eduBgInfoList);
}
