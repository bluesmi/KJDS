package com.penglai.kjds.http.api;

import com.penglai.kjds.model.BaseRes;
import com.penglai.kjds.model.BaseResArray;
import com.penglai.kjds.model.user.LoginRes;

import java.util.Map;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
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

    /**
     * 获取用户信息
     * @param params
     * @return
     */
    @POST("Common.ashx")
    Call<BaseRes>  getUserInfo(@QueryMap Map<String,String> params);

    /**
     * 上传用户头像
     */
    @Multipart
    @POST("Common.ashx")
    Call<BaseRes>  uploadUserImg(@QueryMap Map<String, String> params, @Part MultipartBody.Part data);

    /**
     * 修改用户基本信息
     * @param params
     * @return
     */
    @POST("Common.ashx")
    Call<BaseRes> modifyUserInfo(@QueryMap Map<String, String> params);

    /**
     * 获取我的投递
     * @param params
     * @return
     */
    @POST("Common.ashx")
    Call<BaseResArray> getDeliverList(@QueryMap Map<String, String> params);

    /**
     * 获取我的收藏
     * @param params
     * @return
     */
    @POST("Common.ashx")
    Call<BaseResArray> getFavoriteList(@QueryMap Map<String, String> params);

    /**
     * 获取我的消息
     * @param params
     * @return
     */
    @POST("Common.ashx")
    Call<BaseResArray> getMessage(@QueryMap Map<String, String> params);

    /**
     * 意见反馈
     * @param params
     * @return
     */
    @GET("Common.ashx")
    Call<BaseRes> feedBack(@QueryMap Map<String, String> params);
}
