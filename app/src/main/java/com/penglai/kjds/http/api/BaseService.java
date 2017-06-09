package com.penglai.kjds.http.api;

import com.penglai.kjds.http.okhttp.OkHttpHelper;
import com.penglai.kjds.utils.BuildConfig;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *  * 作者：朋来-GZQ on 2017/2/4 10:58
 *  * 邮箱：gongzhiqing@xiyundata.com
 *  
 */
public class BaseService {

    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BuildConfig.KJDS_BASE_SERVER)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpHelper.getHupuClient())
            .build();
}
