package com.api.handler;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.api.constant.ExceptionDesc;
import com.api.entity.RequestBody;
import com.api.entity.RequestCodeEntity;
import com.api.entity.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 * 数据处理器
 * 此层只管抛出异常
 * 如果还要其他处理
 * 还是在此层完成处理
 * zhuyili
 * 2018/3/23  10:29
 **/
public class HttpDataHandler {

    private static final Logger logger = LoggerFactory.getLogger(HttpDataHandler.class);

    public static ResponseBody handle(String $data) throws Exception {
        if (StringUtils.isEmpty($data)) {
            logger.error(ExceptionDesc.NULL_JSON);
            throw new NullPointerException();
        }
        ResponseBody responseBody = new ResponseBody();
        try {

            RequestBody requestBody = JSON.parseObject($data, RequestBody.class);
            RequestCodeEntity code = requestBody.getRequestCodeEntity();
            responseBody = MappingHandler.handle(code);//找到相关的处理器处理
        } catch (JSONException e) {
            e.printStackTrace();
            throw new JSONException("转换对象失败");
        }

        return responseBody;
    }
}
