package com.penglai.kjds.utils;

import com.penglai.kjds.model.resume.PersionInfo;
import com.penglai.kjds.model.user.UserData;
import com.penglai.kjds.model.user.UserImagePath;
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

    public static UserImagePath getUserImagePath(Map data) {
        UserImagePath userImage = new UserImagePath();
        userImage.setPath((String) data.get("path"));
        return userImage;
    }

    public static PersionInfo getPersionInfo(Map data) {
        PersionInfo persionInfo = new PersionInfo();
        persionInfo.setUserID((String) data.get("UserID"));
        persionInfo.setHeadPicID((String) data.get("HeadPicID"));
        persionInfo.setTrueName((String) data.get("TrueName"));
        persionInfo.setEducation((String) data.get("Education"));
        persionInfo.setAddress((String) data.get("Address"));
        persionInfo.setBirthDate((String) data.get("BirthDate"));
        persionInfo.setGender((String) data.get("Gender"));
        persionInfo.setPhone((String) data.get("Phone"));
        persionInfo.setEmail((String) data.get("Email"));
        return persionInfo;
    }
}
