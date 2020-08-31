package com.api.entity;

import lombok.Data;

/**
 * 请求json对象
 * zhuyili
 * 2018/3/23  11:46
 **/
@Data
public class RequestBody{

    private String data;

    private RequestCodeEntity requestCodeEntity;

}
