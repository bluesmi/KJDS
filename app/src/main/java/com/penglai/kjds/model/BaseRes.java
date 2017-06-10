package com.penglai.kjds.model;

/**
 *  * 作者：朋来-GZQ on 2017/2/8 15:07
 *  * 邮箱：gongzhiqing@xiyundata.com
 *  
 */
public class BaseRes<T> extends BaseResRoot {

    public T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
