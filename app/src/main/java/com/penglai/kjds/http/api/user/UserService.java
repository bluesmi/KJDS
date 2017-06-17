package com.penglai.kjds.http.api.user;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.penglai.kjds.http.RequestCallback;
import com.penglai.kjds.http.api.BaseService;
import com.penglai.kjds.http.api.BaseApi;
import com.penglai.kjds.model.BaseRes;
import com.penglai.kjds.model.user.EmptyEntity;
import com.penglai.kjds.model.user.LoginRes;
import com.penglai.kjds.model.user.UserData;
import com.penglai.kjds.model.user.UserImagePath;
import com.penglai.kjds.model.user.UserInfo;
import com.penglai.kjds.model.user.UserInfoRes;
import com.penglai.kjds.utils.JSONUtil;
import com.penglai.kjds.utils.LogUtils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
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
        Call<BaseRes> call = apiStr.login(params);
        call.enqueue(new Callback<BaseRes>() {
            @Override
            public void onResponse(Call<BaseRes> call, Response<BaseRes> response) {
                //得到返回的数据
                LogUtils.error("loginResp","is success  "+response.body());
                if(null != response){
                    LoginRes loginRes = new LoginRes();
                    loginRes.setCode(response.body().getCode());
                    loginRes.setMsg(response.body().getMsg());
                    if("".equals(response.body().getData())){
                        loginRes.setData(null);
                    }else {
//                        JSON.parseObject(js, new TypeReference<Result<User>>(){});
//                        UserData userData = JSON.parseObject(response.body().getData(),new TypeReference<UserData>());
                        System.out.println(response.body().getData());
                        loginRes.setData(JSONUtil.getUserData((Map) response.body().getData()));
                    }
                    callback.onSuccess(loginRes);
                }

            }

            @Override
            public void onFailure(Call<BaseRes> call, Throwable t) {
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
                LogUtils.error("modifyResp","is success  "+response.body());
                callback.onSuccess(response != null ? response.body() : null);
            }

            @Override
            public void onFailure(Call<BaseRes> call, Throwable t) {
                LogUtils.error("modifyResp","is error"+t.getMessage());
                callback.onFailure(t.getMessage());
            }
        });
    }

    public static void getUserInfo(String opSign, String strJson, final RequestCallback<UserInfoRes> callback){
        HashMap<String, String> params = new HashMap<>();
        params.put("data",strJson);
        params.put("op",opSign);

        LogUtils.error("UserInfo","传入参数"+strJson);
        Call<BaseRes> call = apiStr.getUserInfo(params);
        call.enqueue(new Callback<BaseRes>() {
            @Override
            public void onResponse(Call<BaseRes> call, Response<BaseRes> response) {
                //得到返回的数据
                LogUtils.error("UserInfo","is success  "+response.body());
                if(null != response){
                    UserInfoRes userInfoRes = new UserInfoRes();
                    userInfoRes.setCode(response.body().getCode());
                    userInfoRes.setMsg(response.body().getMsg());
                    if("".equals(response.body().getData())){
                        userInfoRes.setData(null);
                    }else {
//                        JSON.parseObject(js, new TypeReference<Result<User>>(){});
//                        UserData userData = JSON.parseObject(response.body().getData(),new TypeReference<UserData>());
                        System.out.println(response.body().getData());
                        userInfoRes.setData(JSONUtil.getUserInfo((Map) response.body().getData()));
                    }
                    callback.onSuccess(userInfoRes);
                }

            }

            @Override
            public void onFailure(Call<BaseRes> call, Throwable t) {
                t.printStackTrace();
                LogUtils.error("UserInfo","is error  "+t.getMessage());
                callback.onFailure(t.getMessage());
            }
        });
    }

    public static void uploadUserImg(String opSign, String imgPath, final RequestCallback<BaseRes<UserImagePath>> callback){
        HashMap<String, String> params = new HashMap<>();
        params.put("data",JSON.toJSONString(new EmptyEntity()));
        params.put("op",opSign);
        File file = new File(imgPath);
        final RequestBody requestBody = RequestBody.create(MediaType.parse("image/jpg"),file);
        MultipartBody.Part body = MultipartBody.Part.createFormData("picture",file.getName(),requestBody);
        Call<BaseRes> call = apiStr.uploadUserImg(params,body);
        call.enqueue(new Callback<BaseRes>() {
            @Override
            public void onResponse(Call<BaseRes> call, Response<BaseRes> response) {
                //得到返回的数据
                LogUtils.error("uploadUserImg","is success  "+response.body());

                if(null != response){
                    BaseRes<UserImagePath> userImagePathBaseRes = new BaseRes<UserImagePath>();
                    userImagePathBaseRes.setCode(response.body().getCode());
                    userImagePathBaseRes.setMsg(response.body().getMsg());

                    if("".equals(response.body().getData())){
                        userImagePathBaseRes.setData(null);
                    }else {
//                        JSON.parseObject(js, new TypeReference<Result<User>>(){});
//                        UserData userData = JSON.parseObject(response.body().getData(),new TypeReference<UserData>());
                        System.out.println(response.body().getData());
                        userImagePathBaseRes.setData(JSONUtil.getUserImagePath((Map) response.body().getData()));
                    }
                    callback.onSuccess(userImagePathBaseRes);
                }

            }

            @Override
            public void onFailure(Call<BaseRes> call, Throwable t) {
                t.printStackTrace();
                LogUtils.error("uploadUserImg","is error  "+t.getMessage());
                callback.onFailure(t.getMessage());
            }
        });
    }

}
