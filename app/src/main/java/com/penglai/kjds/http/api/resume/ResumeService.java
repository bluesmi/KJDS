package com.penglai.kjds.http.api.resume;

import android.util.Log;

import com.penglai.kjds.http.RequestCallback;
import com.penglai.kjds.http.api.ResumeApi;
import com.penglai.kjds.model.BaseRes;
import com.penglai.kjds.model.resume.PersionInfoRes;
import com.penglai.kjds.utils.JSONUtil;
import com.penglai.kjds.utils.LogUtils;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.penglai.kjds.http.api.BaseService.retrofit;

/**
 * Created by m199 on 2017/6/16.
 */

public class ResumeService {
    public static ResumeApi apiStr = retrofit.create(ResumeApi.class);

    /**
     * 获取个人基本信息
     * @param opSign 操作
     * @param strJson
     * @param callback
     */
    public static void getPersionInfo(String opSign,String strJson, final RequestCallback<PersionInfoRes> callback) {
        HashMap<String, String> params = new HashMap<>();
        params.put("op", opSign);
//        strJson = "["+strJson+"]";
        //转成Json字符串
        params.put("data", strJson);
        LogUtils.error("getPersionInfo","传入参数"+strJson);
        Log.d("ResumeService", "getPersionInfo: "+params);
        Call<BaseRes> call = apiStr.getPersionInfo(params);
        call.enqueue(new Callback<BaseRes>() {
            @Override
            public void onResponse(Call<BaseRes> call, Response<BaseRes> response) {
                LogUtils.error("loginResp","is success  "+response.body());
                if(null != response){
                    PersionInfoRes loginRes = new PersionInfoRes();
                    loginRes.setCode(response.body().getCode());
                    loginRes.setMsg(response.body().getMsg());
                    if("".equals(response.body().getData())){
                        loginRes.setPersionInfo(null);
                    }else {
//                        JSON.parseObject(js, new TypeReference<Result<User>>(){});
//                        UserData userData = JSON.parseObject(response.body().getData(),new TypeReference<UserData>());
                        System.out.println(response.body().getData());
                        loginRes.setPersionInfo(JSONUtil.getPersionInfo((Map) response.body().getData()));
                    }
                    callback.onSuccess(loginRes);
                }
            }

            @Override
            public void onFailure(Call<BaseRes> call, Throwable t) {
                LogUtils.error("PersionInfoRes","is error"+t.getMessage());
                t.printStackTrace();
//                Log.d("UserService", "onFailure: "+);
                callback.onFailure(t.getMessage());
            }
        });

    }
}
