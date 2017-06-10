package com.penglai.kjds.http.api;

import com.penglai.kjds.model.BaseRes;
import com.penglai.kjds.model.user.LoginRes;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 *  * 作者：朋来-GZQ on 2017/2/4 11:19
 *  * 邮箱：gongzhiqing@xiyundata.com
 *  
 */
public interface BaseApi {
    /**
     * 登陆
     * @param params
     * @return
     */
    @GET("Common.ashx")
    Call<BaseRes> login(@QueryMap Map<String, String> params);

    /**
     * 修改密码
     * @param params
     * @return
     */
    @GET("Common.ashx")
    Call<BaseRes> modifyPwd(@QueryMap Map<String, String> params);


}
