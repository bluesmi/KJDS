package com.penglai.kjds.http.api.resume;

import android.util.Log;

import com.penglai.kjds.http.RequestCallback;
import com.penglai.kjds.http.api.ResumeApi;
import com.penglai.kjds.model.BaseRes;
import com.penglai.kjds.model.BaseResArray;
import com.penglai.kjds.model.resume.AssessInfoRes;
import com.penglai.kjds.model.resume.EduBgInfo;
import com.penglai.kjds.model.resume.PersionInfoRes;
import com.penglai.kjds.model.resume.WorkExpInfoReq;
import com.penglai.kjds.utils.JSONUtil;
import com.penglai.kjds.utils.LogUtils;

import java.util.ArrayList;
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
                LogUtils.error("getPersionInfo","is success  "+response.body());
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

    /**
     * 修改简历中个人基本信息
     * @param opSign
     * @param strJson
     * @param callback
     */
    public static void modifyPersionInfo(String opSign,String strJson, final RequestCallback<BaseRes<String>> callback){
        HashMap<String, String> params = new HashMap<>();
        params.put("op", opSign);
//        strJson = "["+strJson+"]";
        //转成Json字符串
        params.put("data", strJson);
        LogUtils.error("modifyPersionInfo","传入参数"+strJson);
        Log.d("ResumeService", "getPersionInfo: "+params);
        Call<BaseRes<String>> call = apiStr.modifyPersionInfo(params);
        call.enqueue(new Callback<BaseRes<String>>() {
            @Override
            public void onResponse(Call<BaseRes<String>> call, Response<BaseRes<String>> response) {
                LogUtils.error("modifyPersionInfo","is success  "+response.body());
                    callback.onSuccess(null != response ? response.body() : null);

            }

            @Override
            public void onFailure(Call<BaseRes<String>> call, Throwable t) {
                LogUtils.error("modifyPersionInfo","is error"+t.getMessage());
                t.printStackTrace();
//                Log.d("UserService", "onFailure: "+);
                callback.onFailure(t.getMessage());
            }
        });
    }

    public static void getEduBgList(String opSign,String strJson, final RequestCallback<BaseResArray<EduBgInfo>> callback){
        HashMap<String, String> params = new HashMap<>();
        params.put("op", opSign);
//        strJson = "["+strJson+"]";
        //转成Json字符串
        params.put("data", strJson);
        LogUtils.error("getEduBgList","传入参数"+strJson);
        Log.d("ResumeService", "getEduBgList: "+params);
        Call<BaseResArray> call = apiStr.getEduBgList(params);
        call.enqueue(new Callback<BaseResArray>() {
            @Override
            public void onResponse(Call<BaseResArray> call, Response<BaseResArray> response) {
                LogUtils.error("getEduBgList", "is success  " + response.body());
                if (null != response) {
                    BaseResArray<EduBgInfo> eduBgInfoRes = new BaseResArray<EduBgInfo>();
                    eduBgInfoRes.setCode(response.body().getCode());
                    eduBgInfoRes.setMsg(response.body().getMsg());
                    if (response.body().getData().isEmpty()) {
                        eduBgInfoRes.setData(new ArrayList<EduBgInfo>());
                    } else {
//                        JSON.parseObject(js, new TypeReference<Result<User>>(){});
//                        UserData userData = JSON.parseObject(response.body().getData(),new TypeReference<UserData>());
                        System.out.println(response.body().getData());
                        eduBgInfoRes.setData(JSONUtil.getEduBgInfoList(response.body().getData()));
                    }
                    callback.onSuccess(eduBgInfoRes);
                }
            }

            @Override
            public void onFailure(Call<BaseResArray> call, Throwable t) {
                LogUtils.error("getEduBgList","is error"+t.getMessage());
                t.printStackTrace();
//                Log.d("UserService", "onFailure: "+);
                callback.onFailure(t.getMessage());
            }
        });
    }


    public static void modifyEduBgInfo(String opSign,String strJson, final RequestCallback<BaseRes<String>> callback){
        HashMap<String, String> params = new HashMap<>();
        params.put("op", opSign);
//        strJson = "["+strJson+"]";
        //转成Json字符串
        params.put("data", strJson);
        LogUtils.error("modifyEduBgInfo","传入参数"+strJson);
        Log.d("ResumeService", "modifyEduBgInfo: "+params);
        Call<BaseRes> call = apiStr.modifyEduBgInfo(params);
        call.enqueue(new Callback<BaseRes>() {
            @Override
            public void onResponse(Call<BaseRes> call, Response<BaseRes> response) {
                LogUtils.error("modifyEduBgInfo","is success  "+response.body());
                    callback.onSuccess(null != response ? response.body() : null);

            }

            @Override
            public void onFailure(Call<BaseRes> call, Throwable t) {
                LogUtils.error("modifyEduBgInfo","is error"+t.getMessage());
                t.printStackTrace();
//                Log.d("UserService", "onFailure: "+);
                callback.onFailure(t.getMessage());
            }
        });
    }

    public static void delEduBgInfo(String opSign,String strJson, final RequestCallback<BaseRes<String>> callback){
        HashMap<String, String> params = new HashMap<>();
        params.put("op", opSign);
//        strJson = "["+strJson+"]";
        //转成Json字符串
        params.put("data", strJson);
        LogUtils.error("delEduBgInfo","传入参数"+strJson);
        Log.d("ResumeService", "delEduBgInfo: "+params);
        Call<BaseRes> call =apiStr.delEduBgInfo(params);
        call.enqueue(new Callback<BaseRes>() {
            @Override
            public void onResponse(Call<BaseRes> call, Response<BaseRes> response) {
                LogUtils.error("delEduBgInfo","is success  "+response.body());
                callback.onSuccess(null != response ? response.body() : null);
            }

            @Override
            public void onFailure(Call<BaseRes> call, Throwable t) {
                LogUtils.error("delEduBgInfo","is error"+t.getMessage());
                t.printStackTrace();
//                Log.d("UserService", "onFailure: "+);
                callback.onFailure(t.getMessage());
            }
        });
    }

    public static void getAssessInfo(String opSign,String strJson, final RequestCallback<BaseRes<AssessInfoRes>> callback){
        HashMap<String, String> params = new HashMap<>();
        params.put("op", opSign);
//        strJson = "["+strJson+"]";
        //转成Json字符串
        params.put("data", strJson);
        LogUtils.error("getAssessInfo","传入参数"+strJson);
        Log.d("ResumeService", "getAssessInfo: "+params);
        Call<BaseRes> call = apiStr.getAssessInfo(params);
        call.enqueue(new Callback<BaseRes>() {
            @Override
            public void onResponse(Call<BaseRes> call, Response<BaseRes> response) {
                LogUtils.error("getAssessInfo", "is success  " + response.body());
                if (null != response) {
                    BaseRes<AssessInfoRes> infoResBaseRes = new BaseRes<AssessInfoRes>();
                    infoResBaseRes.setCode(response.body().getCode());
                    infoResBaseRes.setMsg(response.body().getMsg());
                    if("".equals(response.body().getData())){
                        infoResBaseRes.setData(null);
                    }else {
                        infoResBaseRes.setData(JSONUtil.getAssessInfoRes((Map)response.body().getData()));
                    }
                    callback.onSuccess(infoResBaseRes);
                }
            }

            @Override
            public void onFailure(Call<BaseRes> call, Throwable t) {
                LogUtils.error("getAssessInfo","is error"+t.getMessage());
                t.printStackTrace();
//                Log.d("UserService", "onFailure: "+);
                callback.onFailure(t.getMessage());
            }
        });
    }

    public static void modifyAssessInfo(String opSign,String strJson, final RequestCallback<BaseRes<String>> callback){
        HashMap<String, String> params = new HashMap<>();
        params.put("op", opSign);
        //转成Json字符串
        params.put("data", strJson);
        LogUtils.error("modifyAssessInfo","传入参数"+strJson);
        Log.d("ResumeService", "modifyAssessInfo: "+params);
        Call<BaseRes> call = apiStr.modifyAssessInfo(params);
        call.enqueue(new Callback<BaseRes>() {
            @Override
            public void onResponse(Call<BaseRes> call, Response<BaseRes> response) {
                LogUtils.error("modifyAssessInfo","is success  "+response.body());
                callback.onSuccess(null != response ? response.body() : null);
            }

            @Override
            public void onFailure(Call<BaseRes> call, Throwable t) {
                LogUtils.error("modifyAssessInfo","is error"+t.getMessage());
                t.printStackTrace();
//                Log.d("UserService", "onFailure: "+);
                callback.onFailure(t.getMessage());
            }
        });
    }


    public static void modifyWorkExpInfo(String opSign,String strJson, final RequestCallback<BaseRes<String>> callback){
        HashMap<String, String> params = new HashMap<>();
        params.put("op", opSign);
        //转成Json字符串
        params.put("data", strJson);
        LogUtils.error("modifyWorkExpInfo","传入参数"+strJson);
        Log.d("ResumeService", "modifyWorkExpInfo: "+params);
        Call<BaseRes> call = apiStr.modifyWorkExpInfo(params);
        call.enqueue(new Callback<BaseRes>() {
            @Override
            public void onResponse(Call<BaseRes> call, Response<BaseRes> response) {
                LogUtils.error("modifyWorkExpInfo","is success  "+response.body());
                callback.onSuccess(null != response ? response.body() : null);
            }

            @Override
            public void onFailure(Call<BaseRes> call, Throwable t) {
                LogUtils.error("modifyWorkExpInfo","is error"+t.getMessage());
                t.printStackTrace();
//                Log.d("UserService", "onFailure: "+);
                callback.onFailure(t.getMessage());
            }
        });
    }

    public static void getWorkExpList(String opSign,String strJson, final RequestCallback<BaseResArray<WorkExpInfoReq>> callback){
        HashMap<String, String> params = new HashMap<>();
        params.put("op", opSign);
        //转成Json字符串
        params.put("data", strJson);
        LogUtils.error("getWorkExpList","传入参数"+strJson);
        Log.d("ResumeService", "getWorkExpList: "+params);
        Call<BaseResArray> call = apiStr.getWorkExpList(params);
        call.enqueue(new Callback<BaseResArray>() {
            @Override
            public void onResponse(Call<BaseResArray> call, Response<BaseResArray> response) {
                LogUtils.error("getEduBgList", "is success  " + response.body());
                if (null != response) {
                    BaseResArray<WorkExpInfoReq> workExpInfoReqBaseResArray = new BaseResArray<WorkExpInfoReq>();
                    workExpInfoReqBaseResArray.setCode(response.body().getCode());
                    workExpInfoReqBaseResArray.setMsg(response.body().getMsg());
                    if (response.body().getData().isEmpty()) {
                        workExpInfoReqBaseResArray.setData(new ArrayList<WorkExpInfoReq>());
                    } else {
//                        JSON.parseObject(js, new TypeReference<Result<User>>(){});
//                        UserData userData = JSON.parseObject(response.body().getData(),new TypeReference<UserData>());
                        System.out.println(response.body().getData());

                        workExpInfoReqBaseResArray.setData(JSONUtil.getWorkExpInfoList(response.body().getData()));
                    }
                    callback.onSuccess(workExpInfoReqBaseResArray);
                }
            }

            @Override
            public void onFailure(Call<BaseResArray> call, Throwable t) {
                LogUtils.error("getWorkExpList","is error"+t.getMessage());
                t.printStackTrace();
//                Log.d("UserService", "onFailure: "+);
                callback.onFailure(t.getMessage());
            }
        });
    }

    public static void delWorkExpInfo(String opSign,String strJson, final RequestCallback<BaseRes<String>> callback){
        HashMap<String, String> params = new HashMap<>();
        params.put("op", opSign);
        //转成Json字符串
        params.put("data", strJson);
        LogUtils.error("delWorkExpInfo","传入参数"+strJson);
        Log.d("ResumeService", "delWorkExpInfo: "+params);
        Call<BaseRes> call = apiStr.delWorkExpInfo(params);
        call.enqueue(new Callback<BaseRes>() {
            @Override
            public void onResponse(Call<BaseRes> call, Response<BaseRes> response) {
                LogUtils.error("delWorkExpInfo","is success  "+response.body());
                callback.onSuccess(null != response ? response.body() : null);
            }

            @Override
            public void onFailure(Call<BaseRes> call, Throwable t) {
                LogUtils.error("delWorkExpInfo","is error"+t.getMessage());
                t.printStackTrace();
//                Log.d("UserService", "onFailure: "+);
                callback.onFailure(t.getMessage());
            }
        });
    }

    public static void setResumeInfo(String opSign,String strJson, final RequestCallback<BaseRes<String>> callback){
        HashMap<String, String> params = new HashMap<>();
        params.put("op", opSign);
        //转成Json字符串
        params.put("data", strJson);
        LogUtils.error("setResumeInfo","传入参数"+strJson);
        Log.d("ResumeService", "setResumeInfo: "+params);
        Call<BaseRes> call = apiStr.setResumeInfo(params);
        call.enqueue(new Callback<BaseRes>() {
            @Override
            public void onResponse(Call<BaseRes> call, Response<BaseRes> response) {
                LogUtils.error("setResumeInfo","is success  "+response.body());
                callback.onSuccess(null != response ? response.body() : null);
            }

            @Override
            public void onFailure(Call<BaseRes> call, Throwable t) {
                LogUtils.error("setResumeInfo","is error"+t.getMessage());
                t.printStackTrace();
//                Log.d("UserService", "onFailure: "+);
                callback.onFailure(t.getMessage());
            }
        });
    }

    public static void jobFavorite(String opSign,String strJson, final RequestCallback<BaseRes<String>> callback){
        HashMap<String, String> params = new HashMap<>();
        params.put("op", opSign);
        //转成Json字符串
        params.put("data", strJson);
        LogUtils.error("JobFavorite","传入参数"+strJson);
        Log.d("ResumeService", "JobFavorite: "+params);
        Call<BaseRes> call = apiStr.jobFavorite(params);
        call.enqueue(new Callback<BaseRes>() {
            @Override
            public void onResponse(Call<BaseRes> call, Response<BaseRes> response) {
                LogUtils.error("JobFavorite","is success  "+response.body());
                callback.onSuccess(null != response ? response.body() : null);
            }

            @Override
            public void onFailure(Call<BaseRes> call, Throwable t) {
                LogUtils.error("JobFavorite","is error"+t.getMessage());
                t.printStackTrace();
//                Log.d("UserService", "onFailure: "+);
                callback.onFailure(t.getMessage());
            }
        });
    }
}
