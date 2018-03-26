package com.zyl.standardapi.common.processor;

import com.zyl.standardapi.common.annotation.RequestCode;
import com.zyl.standardapi.common.exception.RequestCodeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 自定义注解扫描进程器
 * zhuyili
 * 2018/3/26  10:49
 **/
//@Component//会导致重复扫描
public class RequestCodeProcessor implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger logger = LoggerFactory.getLogger(RequestCodeProcessor.class);

    /**
     * 初始化spring容器调用方法
     * 扫描所有注解类并加入spring容器
     * @param contextRefreshedEvent
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        //get all Beans with customer annotation
        logger.info("初始化自定义注解");
        Map<String, Object> requestCodeMap = contextRefreshedEvent.getApplicationContext().getBeansWithAnnotation(RequestCode.class);
        requestCodeMap.forEach((k,v) -> {
            logger.info("spring container initial bean name "+k);
            logger.info("mapping class " + v.getClass().getName());
            RequestCode requestCode = (RequestCode) Arrays.asList(v.getClass().getDeclaredAnnotations()).stream().filter(e ->{
                return e.annotationType().equals(RequestCode.class);
            }).toArray()[0];
            if(StringUtils.isEmpty(requestCode.code())){
                try {
                    throw new RequestCodeException("api代码code不能为空");
                } catch (RequestCodeException e) {
                    logger.error("api代码code不能为空");
                    e.printStackTrace();
                }
            }
        });
        logger.info("初始化自定义注解结束");
    }
}
