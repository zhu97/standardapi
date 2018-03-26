package com.zyl.standardapi.common.entity;

import lombok.Data;

/**
 * 请求码对应实体
 * zhuyili
 * 2018/3/23  11:39
 **/
@Data
public class RequestCodeEntity{

    /**
     * 对应classCode
     */
    private String ACode;

    /**
     * 对应方法code
     */
    private String MCode;

}
