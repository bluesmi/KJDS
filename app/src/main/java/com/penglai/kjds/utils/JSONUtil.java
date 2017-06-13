package com.penglai.kjds.utils;

import com.penglai.kjds.model.user.UserData;
import com.penglai.kjds.model.user.UserInfo;

import java.util.Map;

/**
 * Created by m199 on 2017/6/10.
 */

public class JSONUtil {
    public static UserData getUserData(Map map){
        UserData userData = new UserData();
        userData.setUserId((String) map.get("userId"));
        userData.setUserName((String) map.get("userName"));
        userData.setToken((String) map.get("token"));
        return userData;
    }

    public static UserInfo getUserInfo(Map data) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId((String) data.get("userId"));
        userInfo.setNickName((String) data.get("nickName"));
        userInfo.setUserImage((String) data.get("userImage"));
        userInfo.setSchool((String) data.get("school"));
        userInfo.setBirthday((String) data.get("birthday"));
        userInfo.setSex((String) data.get("sex"));
        return userInfo;
    }
}
