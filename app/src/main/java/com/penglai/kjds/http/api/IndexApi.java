package com.penglai.kjds.http.api;

import com.penglai.kjds.model.BaseResArray;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

/**
 * Created by m199 on 2017/6/17.
 */

public interface IndexApi {

    @POST("Common.ashx")
    Call<BaseResArray> getHotRecommend(@QueryMap Map<String,String> map);
}
