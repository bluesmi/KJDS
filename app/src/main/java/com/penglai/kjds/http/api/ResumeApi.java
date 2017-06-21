package com.penglai.kjds.http.api;

import com.penglai.kjds.model.BaseRes;
import com.penglai.kjds.model.BaseResArray;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * Created by m199 on 2017/6/16.
 */

public interface ResumeApi {
    /**
     * 获取用户的基本信息
     * @param params
     * @return
     */
    @POST("Common.ashx")
    Call<BaseRes> getPersionInfo(@QueryMap Map<String,String> params);

    /**
     * 修改用户的基本信息
     * @param params
     * @return
     */
    @POST("Common.ashx")
    Call<BaseRes<String>> modifyPersionInfo(@QueryMap Map<String,String> params);

     /**
     * 获取教育背景
     * @param params
     * @return
     */
     @POST("Common.ashx")
    Call<BaseResArray> getEduBgList(@QueryMap Map<String,String> params);

    /**
     * 获取教育背景
     * @param params
     * @return
     */
    @POST("Common.ashx")
    Call<BaseRes> modifyEduBgInfo(@QueryMap Map<String,String> params);


}
