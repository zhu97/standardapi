package com.zyl.standardapi.common.handler.http;

import com.alibaba.fastjson.JSON;
import com.zyl.standardapi.common.entity.RequestBody;
import com.zyl.standardapi.common.entity.ResponseBody;
import com.zyl.standardapi.common.handler.ExceptionHandler;
import com.zyl.standardapi.common.handler.HttpDataHandler;
import com.zyl.standardapi.common.util.IpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 通用http 处理器
 * zhuyili
 * 2018/3/23  10:11
 **/
@RestController
public class CommonHttpHandler {

    private static final Logger logger = LoggerFactory.getLogger(CommonHttpHandler.class);

    /**
     * 做查询使用的时候调用的方法
     * @param $data
     * @return
     */
    @RequestMapping("/api")
    public String doQuery(HttpServletRequest request, String $data) {
        String ip = IpUtil.getIp(request);
        logger.info("\n远程请求地址："+ip);
        logger.info("\n远程请求参数：\n"+$data);
        try {
           ResponseBody responseBody = HttpDataHandler.handle($data);
           return JSON.toJSONString(responseBody);
        }catch (Throwable throwable) {
            throwable.printStackTrace();
           return ExceptionHandler.handleException(throwable);
        }
    }

}
