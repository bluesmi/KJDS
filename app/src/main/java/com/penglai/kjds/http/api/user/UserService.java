package com.penglai.kjds.http.api.user;

import android.util.Log;

import com.penglai.kjds.http.RequestCallback;
import com.penglai.kjds.http.api.BaseService;
import com.penglai.kjds.http.api.BaseApi;
import com.penglai.kjds.model.BaseRes;
import com.penglai.kjds.model.user.LoginRes;
import com.penglai.kjds.utils.LogUtils;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 *  * 作者：朋来-GZQ on 2017/2/4 10:56
 *  * 邮箱：gongzhiqing@xiyundata.com
 *  
 */
public class UserService extends BaseService {

    public static BaseApi apiStr = retrofit.create(BaseApi.class);

    /**
     * 登陆
     * @param opSign
     *                                op参数
     * @param strJson
     *                               json字符串
     * @param callback
     *                               回调接口
     */
    public static void login(String opSign,String strJson, final RequestCallback<LoginRes> callback) {
        HashMap<String, String> params = new HashMap<>();
        params.put("op", opSign);
//        strJson = "["+strJson+"]";
        //转成Json字符串
        params.put("data", strJson);
        LogUtils.error("loginResp","传入参数"+strJson);
        Log.d("UserService", "login: "+params);
        Call<LoginRes> call = apiStr.login(params);
        call.enqueue(new Callback<LoginRes>() {
            @Override
            public void onResponse(Call<LoginRes> call, Response<LoginRes> response) {
                //得到返回的数据
                LogUtils.error("loginResp","is success  "+response.body());
                callback.onSuccess(response != null ? response.body() : null);
            }

            @Override
            public void onFailure(Call<LoginRes> call, Throwable t) {
                LogUtils.error("loginResp","is error"+t.getMessage());
                t.printStackTrace();
//                Log.d("UserService", "onFailure: "+);
                callback.onFailure(t.getMessage());
            }
        });
    }

    /**
     * 修改密码
     * @param opSign
     * @param strJson
     * @param callback
     */
    public static void modifyPwd(String opSign,String strJson, final RequestCallback<BaseRes> callback) {
        HashMap<String, String> params = new HashMap<>();
        params.put("op", opSign);
        //转成Json字符串
        params.put("data", strJson);
        LogUtils.error("modifyResp","传入参数"+strJson);
        Call<BaseRes> call = apiStr.modifyPwd(params);
        call.enqueue(new Callback<BaseRes>() {
            @Override
            public void onResponse(Call<BaseRes> call, Response<BaseRes> response) {
                //得到返回的数据
                LogUtils.error("loginResp","is success  "+response.body());
                callback.onSuccess(response != null ? response.body() : null);
            }

            @Override
            public void onFailure(Call<BaseRes> call, Throwable t) {
                LogUtils.error("loginResp","is error"+t.getMessage());
                callback.onFailure(t.getMessage());
            }
        });
    }

}
