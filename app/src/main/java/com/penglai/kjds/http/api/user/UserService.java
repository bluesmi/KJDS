package com.penglai.kjds.http.api.user;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.penglai.kjds.http.RequestCallback;
import com.penglai.kjds.http.api.BaseService;
import com.penglai.kjds.http.api.BaseApi;
import com.penglai.kjds.model.BaseRes;
import com.penglai.kjds.model.BaseResArray;
import com.penglai.kjds.model.user.CollectInfo;
import com.penglai.kjds.model.user.DeliverInfo;
import com.penglai.kjds.model.user.EmptyEntity;
import com.penglai.kjds.model.user.LoginRes;
import com.penglai.kjds.model.user.MyMessage;
import com.penglai.kjds.model.user.UserImagePath;
import com.penglai.kjds.model.user.UserInfoRes;
import com.penglai.kjds.utils.JSONUtil;
import com.penglai.kjds.utils.LogUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    /**
     * 上传头像
     * @param opSign
     * @param imgPath
     * @param callback
     */
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

    /**
     * 修改用户个人信息
     * @param opSign
     * @param strJson
     * @param callback
     */
    public static void modifyUserInfo(String opSign, String strJson, final RequestCallback<BaseRes<String>> callback){
        HashMap<String, String> params = new HashMap<>();
        params.put("data",strJson);
        params.put("op",opSign);
        Call<BaseRes> call = apiStr.modifyUserInfo(params);
        call.enqueue(new Callback<BaseRes>() {
            @Override
            public void onResponse(Call<BaseRes> call, Response<BaseRes> response) {
                //得到返回的数据
                LogUtils.error("modifyUserInfo","is success  "+response.body());

                if(null != response){
                    BaseRes<String> modifyUserInfoRes = new BaseRes<String>();
                    modifyUserInfoRes.setCode(response.body().getCode());
                    modifyUserInfoRes.setMsg(response.body().getMsg());
                    modifyUserInfoRes.setData((String) response.body().getData());
                    callback.onSuccess(modifyUserInfoRes);
                }

            }

            @Override
            public void onFailure(Call<BaseRes> call, Throwable t) {
                t.printStackTrace();
                LogUtils.error("modifyUserInfo","is error  "+t.getMessage());
                callback.onFailure(t.getMessage());
            }
        });
    }

    public static void getDeliverList(String opSign, String strJson, final RequestCallback<BaseResArray<DeliverInfo>> callback){
        HashMap<String, String> params = new HashMap<>();
        params.put("data",strJson);
        params.put("op",opSign);
        Call<BaseResArray> call = apiStr.getDeliverList(params);
        call.enqueue(new Callback<BaseResArray>() {
            @Override
            public void onResponse(Call<BaseResArray> call, Response<BaseResArray> response) {
                LogUtils.error("getDeliverList", "is success  " + response.body());
                if (null != response) {
                    BaseResArray<DeliverInfo> deliverInfoBaseRes = new BaseResArray<DeliverInfo>();
                    deliverInfoBaseRes.setCode(response.body().getCode());
                    deliverInfoBaseRes.setMsg(response.body().getMsg());

                    if (response.body().getData().isEmpty()) {
                        deliverInfoBaseRes.setData(new ArrayList<DeliverInfo>());
                    } else {
//                        JSON.parseObject(js, new TypeReference<Result<User>>(){});
//                        UserData userData = JSON.parseObject(response.body().getData(),new TypeReference<UserData>());
                        System.out.println(response.body().getData());
                        List<Map> deliverInfo =  response.body().getData();
                        deliverInfoBaseRes.setData(JSONUtil.getDeliverInfoList(deliverInfo));
                    }
                    callback.onSuccess(deliverInfoBaseRes);
                }
            }

            @Override
            public void onFailure(Call<BaseResArray> call, Throwable t) {
                t.printStackTrace();
                LogUtils.error("getDeliverList","is error  "+t.getMessage());
                callback.onFailure(t.getMessage());
            }
        });
    }

    /**
     * 获取收藏
     * @param opSign
     * @param strJson
     * @param callback
     */
    public static void getFavoriteList(String opSign, String strJson, final RequestCallback<BaseResArray<CollectInfo>> callback){
        HashMap<String, String> params = new HashMap<>();
        params.put("data",strJson);
        params.put("op",opSign);
        Call<BaseResArray> call = apiStr.getDeliverList(params);
        call.enqueue(new Callback<BaseResArray>() {
            @Override
            public void onResponse(Call<BaseResArray> call, Response<BaseResArray> response) {
                LogUtils.error("getFavoriteList", "is success  " + response.body());
                if (null != response) {
                    BaseResArray<CollectInfo> collectInfoBaseRes = new BaseResArray<CollectInfo>();
                    collectInfoBaseRes.setCode(response.body().getCode());
                    collectInfoBaseRes.setMsg(response.body().getMsg());

                    if (response.body().getData().isEmpty()) {
                        collectInfoBaseRes.setData(new ArrayList<CollectInfo>());
                    } else {
//                        JSON.parseObject(js, new TypeReference<Result<User>>(){});
//                        UserData userData = JSON.parseObject(response.body().getData(),new TypeReference<UserData>());
                        System.out.println(response.body().getData());
                        List<Map> collectInfo =  response.body().getData();
                        collectInfoBaseRes.setData(JSONUtil.getCollectInfoList(collectInfo));
                    }
                    callback.onSuccess(collectInfoBaseRes);
                }
            }

            @Override
            public void onFailure(Call<BaseResArray> call, Throwable t) {
                t.printStackTrace();
                LogUtils.error("getFavoriteList","is error  "+t.getMessage());
                callback.onFailure(t.getMessage());
            }
        });
    }

    public static void getMessage(String opSign, String strJson, final RequestCallback<BaseResArray<MyMessage>> callback){
        HashMap<String, String> params = new HashMap<>();
        params.put("op",opSign);
        params.put("data",strJson);
        Call<BaseResArray> call = apiStr.getMessage(params);
        call.enqueue(new Callback<BaseResArray>() {
            @Override
            public void onResponse(Call<BaseResArray> call, Response<BaseResArray> response) {
                LogUtils.error("getFavoriteList", "is success  " + response.body());
                if (null != response) {
                    BaseResArray<MyMessage> myMessageBaseResArray = new BaseResArray<MyMessage>();
                    myMessageBaseResArray.setCode(response.body().getCode());
                    myMessageBaseResArray.setMsg(response.body().getMsg());

                    if (response.body().getData().isEmpty()) {
                        myMessageBaseResArray.setData(new ArrayList<MyMessage>());
                    } else {
//                        JSON.parseObject(js, new TypeReference<Result<User>>(){});
//                        UserData userData = JSON.parseObject(response.body().getData(),new TypeReference<UserData>());
                        System.out.println(response.body().getData());
                        List<Map> messageInfoList =  response.body().getData();
                        myMessageBaseResArray.setData(JSONUtil.getMessagenfoList(messageInfoList));
                    }
                    callback.onSuccess(myMessageBaseResArray);
                }
            }

            @Override
            public void onFailure(Call<BaseResArray> call, Throwable t) {
                t.printStackTrace();
                LogUtils.error("getMessage","is error  "+t.getMessage());
                callback.onFailure(t.getMessage());
            }
        });
    }
}
