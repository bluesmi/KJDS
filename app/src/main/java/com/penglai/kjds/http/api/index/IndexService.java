package com.penglai.kjds.http.api.index;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.penglai.kjds.http.RequestCallback;
import com.penglai.kjds.http.api.IndexApi;
import com.penglai.kjds.model.BaseResArray;
import com.penglai.kjds.model.index.CompanyInfo;
import com.penglai.kjds.utils.JSONUtil;
import com.penglai.kjds.utils.LogUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.penglai.kjds.http.api.BaseService.retrofit;

/**
 * Created by m199 on 2017/6/17.
 */

public class IndexService {
    public static IndexApi apiStr = retrofit.create(IndexApi.class);
    private static final String TAG = IndexService.class.getSimpleName();

    /**
     * 获取热门推荐
     * @param opSign 操作方法
     * @param strJson json字符
     * @param callback 回调函数
     */
    public static void getHotRecommend(String opSign,String strJson, final RequestCallback<BaseResArray<CompanyInfo>> callback){
        HashMap<String, String> params = new HashMap<>();
        params.put("op", opSign);
//        strJson = "["+strJson+"]";
        //转成Json字符串
        params.put("data", strJson);
        LogUtils.error("getHotRecommend","传入参数"+strJson);
        Log.d("TAG", "getHotRecommend: "+params);
        Call<BaseResArray> call = apiStr.getHotRecommend(params);
        call.enqueue(new Callback<BaseResArray>() {
            @Override
            public void onResponse(Call<BaseResArray> call, Response<BaseResArray> response) {
                LogUtils.error("loginResp", "is success  " + response.body());
                if (null != response) {
                    BaseResArray<CompanyInfo> baseResArray = new BaseResArray<CompanyInfo>();
                    baseResArray.setCode(response.body().getCode());
                    baseResArray.setMsg(response.body().getMsg());

                    if (response.body().getData().isEmpty()) {
                        baseResArray.setData(new ArrayList<CompanyInfo>());
                    } else {
//                        JSON.parseObject(js, new TypeReference<Result<User>>(){});
//                        UserData userData = JSON.parseObject(response.body().getData(),new TypeReference<UserData>());
                        System.out.println(response.body().getData());
                        List<Map> list = response.body().getData();
                        baseResArray.setData(JSONUtil.getCompanyInfoList(list));
                    }
                    callback.onSuccess(baseResArray);
                }
            }

            @Override
            public void onFailure(Call<BaseResArray> call, Throwable t) {
                LogUtils.error("getHotRecommend","is error"+t.getMessage());
                t.printStackTrace();
//                Log.d("UserService", "onFailure: "+);
                callback.onFailure(t.getMessage());
            }
        });
    }


}
