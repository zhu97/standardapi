package com.api.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.api.builder.ResponseBuilder;

/**
 * 所有的异常放在这个处理
 * 异常处理器
 * zhuyili
 * 2018/3/23  10:41
 **/
public class ExceptionHandler {

    public static String handleException(Throwable throwable){
        if(throwable instanceof NullPointerException){
            return JSON.toJSONString(ResponseBuilder.nullResponseBody());
        }else if (throwable instanceof JSONException) {
            return JSON.toJSONString(ResponseBuilder.jsonErrorResponseBody());
        }else{
            return JSON.toJSONString(ResponseBuilder.failResponseBody());
        }
    }
}
