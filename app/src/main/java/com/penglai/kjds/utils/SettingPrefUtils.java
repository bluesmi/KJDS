package com.penglai.kjds.utils;

/**
 *  * 作者：朋来-GZQ on 2017/2/8 10:39
 *  * 邮箱：gongzhiqing@xiyundata.com
 *   所有設置的
 */
public class SettingPrefUtils {

    public static String getUid() {
        return new PrefUtils().get("uid", "");
    }

    public static void saveUid(String uid) {
        new PrefUtils().put("uid", uid);
    }

    public static String getUserName() {
        return new PrefUtils().get("userName", "");
    }

    public static void saveUserName(String userName) {
        new PrefUtils().put("userName", userName);
    }


}
