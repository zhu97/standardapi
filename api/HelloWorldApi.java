package com.zyl.standardapi.api;

import com.zyl.standardapi.common.annotation.RequestCode;
import com.zyl.standardapi.common.entity.RequestBody;
import com.zyl.standardapi.common.handler.http.HttpHandler;

/**
 * zhuyili
 * 2018/3/26  10:31
 **/
@RequestCode(code = "A001")
public class HelloWorldApi implements HttpHandler<RequestBody>{

}
