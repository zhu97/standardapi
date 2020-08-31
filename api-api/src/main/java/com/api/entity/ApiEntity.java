package com.api.entity;

import lombok.Data;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * 接口通用实体
 * zhuyili
 * 2018/3/23  10:23
 **/
@Data
@Slf4j
@ToString
public class ApiEntity implements Serializable{

    /**
     * 账号
     */
    private String account;

    /**
     * token
     */
    private String token;

    /**
     * id
     */
    private Integer[] ids;
}
