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
}
