package com.penglai.kjds.http.api;

import com.penglai.kjds.model.BaseRes;
import com.penglai.kjds.model.BaseResArray;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * Created by m199 on 2017/6/17.
 */

public interface IndexApi {
    /**
     * 获取热门推荐
     * @param map
     * @return
     */
    @POST("Common.ashx")
    Call<BaseResArray> getHotRecommend(@QueryMap Map<String,String> map);

    /**
     * 获取职位、岗位详情
     * @param params
     * @return
     */
    @POST("Common.ashx")
    Call<BaseRes> getJobDetail(@QueryMap Map<String, String> params);

    /**
     * 获取公司信息
     * @param params
     * @return
     */
    @POST("Common.ashx")
    Call<BaseRes> getCompanyInfo(@QueryMap Map<String, String> params);

    /**
     * 获取岗位列表
     * @param map
     * @return
     */
    @POST("Common.ashx")
    Call<BaseResArray> getJobList(@QueryMap Map<String,String> map);

    /**
     * 搜索工作
     * @param map
     * @return
     */
    @POST("Common.ashx")
    Call<BaseResArray> searchJobList(@QueryMap Map<String,String> map);

    /**
     * 获取轮播图
     * @param map
     * @return
     */
    @POST("Common.ashx")
    Call<BaseResArray> carouselImage(@QueryMap Map<String,String> map);

    /**
     * 获取课程列表
     * @param map
     * @return
     */
    @POST("Common.ashx")
    Call<BaseResArray> getCourseList(@QueryMap Map<String,String> map);

    /**
     * 获取培训列表
     * @param map
     * @return
     */
    @POST("Common.ashx")
    Call<BaseResArray> getTrainList(@QueryMap Map<String,String> map);
}
