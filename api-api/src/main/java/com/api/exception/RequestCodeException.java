package com.api.exception;

/**
 * zhuyili
 * 自定义错误注解
 * 2018/3/26  11:27
 **/
public class RequestCodeException extends Exception {

    public RequestCodeException(String msg) {
        super(msg);
    }
}
