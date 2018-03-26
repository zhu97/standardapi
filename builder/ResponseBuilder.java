package com.zyl.standardapi.builder;

import com.zyl.standardapi.common.constant.ResponseCode;
import com.zyl.standardapi.common.constant.ResponseDesc;
import com.zyl.standardapi.common.entity.ResponseBody;
import com.zyl.standardapi.common.entity.Status;

import java.util.Date;

/**
 * 返回状态status建造器
 * zhuyili
 * 2018/3/26  13:53
 **/
public class ResponseBuilder {

    public static Status buildStatus(String responseCode, String responseDesc){
        Status status = new Status();
        status.setCode(responseCode);
        status.setMsg(responseDesc);
        return status;
    }

    public static ResponseBody nullResponseBody(){
        Status status = buildStatus(ResponseCode.NULL, ResponseDesc.NULL_DESC);
        return buildResponseBody(status);
    }

    public static ResponseBody buildResponseBody(Status status, Object object, Date date){
        ResponseBody body = new ResponseBody();
        body.setData(object);
        body.setDate(date);
        body.setStatus(status);
        return body;
    }
    public static ResponseBody buildResponseBody(Status status, Object object){
        ResponseBody body = new ResponseBody();
        body.setData(object);
        body.setStatus(status);
        return body;
    }
    public static ResponseBody buildResponseBody(Status status){
        ResponseBody body = new ResponseBody();
        body.setStatus(status);
        return body;
    }

    public static Object jsonErrorResponseBody() {
        Status status = buildStatus(ResponseCode.JSON_ERROR, ResponseDesc.JSON_ERROR_DESC);
        return buildResponseBody(status);
    }
    public static Object failResponseBody() {
        Status status = buildStatus(ResponseCode.FAIL, ResponseDesc.FAIL_DESC);
        return buildResponseBody(status);
    }
}
