package com.penglai.kjds.http.api.index;

import android.util.Log;

import com.penglai.kjds.http.RequestCallback;
import com.penglai.kjds.http.api.IndexApi;
import com.penglai.kjds.model.BaseRes;
import com.penglai.kjds.model.BaseResArray;
import com.penglai.kjds.model.index.CarouselRes;
import com.penglai.kjds.model.index.Company;
import com.penglai.kjds.model.index.CompanyInfo;
import com.penglai.kjds.model.index.JobDetail;
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
                LogUtils.error("getHotRecommend", "is success  " + response.body());
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


    public static void getJobDetail(String opSign, String strJson, final RequestCallback<BaseRes<JobDetail>> callback){
        HashMap<String, String> params = new HashMap<>();
        params.put("op", opSign);
//        strJson = "["+strJson+"]";
        //转成Json字符串
        params.put("data", strJson);
        LogUtils.error("getJobDetail","传入参数"+strJson);
        Log.d(TAG, "getJobDetail: "+params);
        Call<BaseRes> call = apiStr.getJobDetail(params);
        call.enqueue(new Callback<BaseRes>() {
            @Override
            public void onResponse(Call<BaseRes> call, Response<BaseRes> response) {
                LogUtils.error("getJobDetail", "is success  " + response.body());
                if (null != response) {
                    BaseRes<JobDetail> jobDetailBaseRes = new BaseRes<JobDetail>();
                    jobDetailBaseRes.setCode(response.body().getCode());
                    jobDetailBaseRes.setMsg(response.body().getMsg());

                    if ("".equals(response.body().getData())) {
                        jobDetailBaseRes.setData(null);
                    } else {
//                        JSON.parseObject(js, new TypeReference<Result<User>>(){});
//                        UserData userData = JSON.parseObject(response.body().getData(),new TypeReference<UserData>());
                        System.out.println(response.body().getData());
                        jobDetailBaseRes.setData(JSONUtil.getJobDetailInfo((Map)response.body().getData()));
                    }
                    callback.onSuccess(jobDetailBaseRes);
                }
            }

            @Override
            public void onFailure(Call<BaseRes> call, Throwable t) {
                LogUtils.error("getJobDetail","is error"+t.getMessage());
                t.printStackTrace();
//                Log.d("UserService", "onFailure: "+);
                callback.onFailure(t.getMessage());
            }
        });
    }

    public static void getCompanyInfo(String opSign, String strJson, final RequestCallback<BaseRes<Company>> callback){
        HashMap<String, String> params = new HashMap<>();
        params.put("op", opSign);
//        strJson = "["+strJson+"]";
        //转成Json字符串
        params.put("data", strJson);
        LogUtils.error("getCompanyInfo","传入参数"+strJson);
        Log.d(TAG, "getCompanyInfo: "+params);
        Call<BaseRes> call = apiStr.getCompanyInfo(params);
        call.enqueue(new Callback<BaseRes>() {
            @Override
            public void onResponse(Call<BaseRes> call, Response<BaseRes> response) {
                LogUtils.error("getCompanyInfo", "is success  " + response.body());
                if (null != response) {
                    BaseRes<Company> jobDetailBaseRes = new BaseRes<Company>();
                    jobDetailBaseRes.setCode(response.body().getCode());
                    jobDetailBaseRes.setMsg(response.body().getMsg());

                    if ("".equals(response.body().getData())) {
                        jobDetailBaseRes.setData(null);
                    } else {
//                        JSON.parseObject(js, new TypeReference<Result<User>>(){});
//                        UserData userData = JSON.parseObject(response.body().getData(),new TypeReference<UserData>());
                        System.out.println(response.body().getData());
                        //这里转换出错
                        jobDetailBaseRes.setData(JSONUtil.getCompany((Map)response.body().getData()));
                    }
                    callback.onSuccess(jobDetailBaseRes);
                }
            }

            @Override
            public void onFailure(Call<BaseRes> call, Throwable t) {
                LogUtils.error("getCompanyInfo","is error"+t.getMessage());
                t.printStackTrace();
//                Log.d("UserService", "onFailure: "+);
                callback.onFailure(t.getMessage());
            }
        });
    }


    public static void getJobList(String opSign,String strJson, final RequestCallback<BaseResArray<CompanyInfo>> callback){
        HashMap<String, String> params = new HashMap<>();
        params.put("op", opSign);
//        strJson = "["+strJson+"]";
        //转成Json字符串
        params.put("data", strJson);
        LogUtils.error("getJobList","传入参数"+strJson);
        Log.d("TAG", "getJobList: "+params);
        Call<BaseResArray> call = apiStr.getJobList(params);
        call.enqueue(new Callback<BaseResArray>() {
            @Override
            public void onResponse(Call<BaseResArray> call, Response<BaseResArray> response) {
                LogUtils.error("getHotRecommend", "is success  " + response.body());
                if (null != response) {
                    BaseResArray<CompanyInfo> baseResArray = new BaseResArray<CompanyInfo>();
                    baseResArray.setCode(response.body().getCode());
                    baseResArray.setMsg(response.body().getMsg());

                    if (response.body().getData().isEmpty()) {
                        baseResArray.setData(new ArrayList<CompanyInfo>());
                    } else {
                        System.out.println(response.body().getData());
                        List<Map> list = response.body().getData();
                        baseResArray.setData(JSONUtil.getCompanyInfoList(list));
                    }
                    callback.onSuccess(baseResArray);
                }
            }

            @Override
            public void onFailure(Call<BaseResArray> call, Throwable t) {
                LogUtils.error("getJobList","is error"+t.getMessage());
                t.printStackTrace();
//                Log.d("UserService", "onFailure: "+);
                callback.onFailure(t.getMessage());
            }
        });
    }

    public static void searchJobList(String opSign,String strJson, final RequestCallback<BaseResArray<CompanyInfo>> callback){
        HashMap<String, String> params = new HashMap<>();
        params.put("op", opSign);
//        strJson = "["+strJson+"]";
        //转成Json字符串
        params.put("data", strJson);
        LogUtils.error("searchJobList","传入参数"+strJson);
        Log.d(TAG, "searchJobList: "+params);
        Call<BaseResArray> call = apiStr.getJobList(params);
        call.enqueue(new Callback<BaseResArray>() {
            @Override
            public void onResponse(Call<BaseResArray> call, Response<BaseResArray> response) {
                LogUtils.error("searchJobList", "is success  " + response.body());
                if (null != response) {
                    BaseResArray<CompanyInfo> baseResArray = new BaseResArray<CompanyInfo>();
                    baseResArray.setCode(response.body().getCode());
                    baseResArray.setMsg(response.body().getMsg());

                    if (response.body().getData().isEmpty()) {
                        baseResArray.setData(new ArrayList<CompanyInfo>());
                    } else {
                        System.out.println(response.body().getData());
                        List<Map> list = response.body().getData();
                        baseResArray.setData(JSONUtil.getCompanyInfoList(list));
                    }
                    callback.onSuccess(baseResArray);
                }
            }

            @Override
            public void onFailure(Call<BaseResArray> call, Throwable t) {
                LogUtils.error("searchJobList","is error"+t.getMessage());
                t.printStackTrace();
//                Log.d("UserService", "onFailure: "+);
                callback.onFailure(t.getMessage());
            }
        });
    }

    public static void carouselImage(String opSign,String strJson, final RequestCallback<BaseResArray<CarouselRes>> callback){
        HashMap<String, String> params = new HashMap<>();
        params.put("op", opSign);
//        strJson = "["+strJson+"]";
        //转成Json字符串
        params.put("data", strJson);
        LogUtils.error("carouselImage","传入参数"+strJson);
        Log.d(TAG, "carouselImage: "+params);
        Call<BaseResArray> call = apiStr.carouselImage(params);
        call.enqueue(new Callback<BaseResArray>() {
            @Override
            public void onResponse(Call<BaseResArray> call, Response<BaseResArray> response) {
                LogUtils.error("carouselImage", "is success  " + response.body());
                if (null != response) {
                    BaseResArray<CarouselRes> baseResArray = new BaseResArray<CarouselRes>();
                    baseResArray.setCode(response.body().getCode());
                    baseResArray.setMsg(response.body().getMsg());

                    if (response.body().getData().isEmpty()) {
                        baseResArray.setData(null);
                    } else {
                        System.out.println(response.body().getData());
                        List<Map> list = response.body().getData();
                        baseResArray.setData(JSONUtil.getCarouselList(list));
                    }
                    callback.onSuccess(baseResArray);
                }
            }

            @Override
            public void onFailure(Call<BaseResArray> call, Throwable t) {
                LogUtils.error("carouselImage","is error"+t.getMessage());
                t.printStackTrace();
//                Log.d("UserService", "onFailure: "+);
                callback.onFailure(t.getMessage());
            }
        });
    }
}
