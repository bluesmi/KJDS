package com.penglai.kjds.utils.safe;

import android.util.Base64;

/**
 *  * 作者：朋来-GZQ on 2017/2/4 14:31
 *  * 邮箱：gongzhiqing@xiyundata.com
 *  
 */
public class Base64Cipher extends Cipher {
    private Cipher cipher;

    public Base64Cipher() {
    }

    public Base64Cipher(Cipher cipher) {
        this.cipher = cipher;
    }

    @Override
    public byte[] decrypt(byte[] res) {
        if (cipher != null) res = cipher.decrypt(res);
        return Base64.decode(res, Base64.DEFAULT);
    }

    @Override
    public byte[] encrypt(byte[] res) {
        if (cipher != null) res = cipher.encrypt(res);
        return Base64.encode(res, Base64.DEFAULT);
    }
}