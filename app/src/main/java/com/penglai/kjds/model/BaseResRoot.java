package com.penglai.kjds.model;

/**
 *  * 作者：朋来-GZQ on 2017/2/4 11:24
 *  * 邮箱：gongzhiqing@xiyundata.com
 *    数据响应的基类
 */
public class BaseResRoot {

    public int code;        //0表示接口调用成功
    public String msg;   //返回的信息码

    public BaseResRoot(){

    }

    public BaseResRoot(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
