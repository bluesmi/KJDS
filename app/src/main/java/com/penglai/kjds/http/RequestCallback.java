package com.penglai.kjds.http;

/**
 *  * 作者：朋来-GZQ on 2017/2/4 11:50
 *  * 邮箱：gongzhiqing@xiyundata.com
 *     回调接口
 */
public interface RequestCallback<T> {

    void onSuccess(T t);

    void onFailure(String message);

}
