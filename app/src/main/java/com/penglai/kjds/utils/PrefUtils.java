package com.penglai.kjds.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.penglai.kjds.utils.safe.Base64Cipher;
import com.penglai.kjds.utils.safe.Cipher;

/**
 *  * 作者：朋来-GZQ on 2017/2/4 14:30
 *  * 邮箱：gongzhiqing@xiyundata.com
 *  
 */
public class PrefUtils {

    private static SharedPreferences sp;
    private static String fileName = "KJDS";

    public PrefUtils() {
        this(fileName);
    }

    public PrefUtils(String fileName) {
        sp = AppUtils.getAppContext().getSharedPreferences(fileName, Context.MODE_PRIVATE);
    }

    /**
     * *************** get ******************
     */

    public static String get(String key, String defValue) {
        return sp.getString(key, defValue);
    }

    public static boolean get(String key, boolean defValue) {
        return sp.getBoolean(key, defValue);
    }

    public static float get(String key, float defValue) {
        return sp.getFloat(key, defValue);
    }

    public static  int getInt(String key, int defValue) {
        return sp.getInt(key, defValue);
    }

    public static long get(String key, long defValue) {
        return sp.getLong(key, defValue);
    }

    public static Object get(String key) {
        return get(key, (Cipher) null);
    }

    public static Object get(String key, Cipher cipher) {
        try {
            String hex = get(key, (String) null);
            if (hex == null)
                return null;
            byte[] bytes = HexUtils.decodeHex(hex.toCharArray());
            if (cipher != null)
                bytes = cipher.decrypt(bytes);
            Object obj = ByteUtils.byteToObject(bytes);
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * *************** put ******************
     */
    public static  void put(String key, Object ser) {
        put(key, ser, null);
        put("", "", new Base64Cipher());
    }

    public static void put(String key, Object obj, Cipher cipher) {
        try {
            if (obj == null) {
                sp.edit().remove(key).commit();
            } else {
                byte[] bytes = ByteUtils.objectToByte(obj);
                if (cipher != null)
                    bytes = cipher.encrypt(bytes);
                put(key, HexUtils.encodeHexStr(bytes));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void put(String key, String value) {
        if (value == null) {
            sp.edit().remove(key).commit();
        } else {
            sp.edit().putString(key, value).commit();
        }
    }

    public static void put(String key, boolean value) {
        sp.edit().putBoolean(key, value).commit();
    }

    public static void put(String key, float value) {
        sp.edit().putFloat(key, value).commit();
    }

    public static void put(String key, long value) {
        sp.edit().putLong(key, value).commit();
    }

    public static void putInt(String key, int value) {
        sp.edit().putInt(key, value).commit();
    }

    public static  void clearAll() {
        sp.edit().clear().commit();
    }

    public static void remove(String key){
        sp.edit().remove(key);
    }

}
