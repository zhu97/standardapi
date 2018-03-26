package com.zyl.standardapi.common.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 接口类注解使用
 * zhuyili
 * 2018/3/26  10:25
 **/
@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface RequestCode{
    /**
     * 标志代码位
     * @return
     */
    String code() default "";
}
