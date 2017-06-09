package com.penglai.kjds.http.okhttp;

import com.penglai.kjds.utils.LogUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 *  * 作者：朋来-GZQ on 2017/2/4 11:01
 *  * 邮箱：gongzhiqing@xiyundata.com
 *  
 */
public class OkHttpHelper {

    /**
     * 自定义日志输出
     */
    static class MyLog implements HttpLoggingInterceptor.Logger {
        @Override
        public void log(String message) {
            LogUtils.verbose("oklog: " + message);
        }
    }

    /**
     * 配置 OKHTTP 拦截器
     *                        对输出网络请求和结果的 Log
     * @return
     */
    public static OkHttpClient getHupuClient() {
        HttpLoggingInterceptor mInterceptor = new HttpLoggingInterceptor();
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(new MyLog());
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .connectTimeout(20 * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(20 * 1000, TimeUnit.MILLISECONDS)
                .addInterceptor(mInterceptor)
                .addInterceptor(logging);
        return builder.build();
    }

}
