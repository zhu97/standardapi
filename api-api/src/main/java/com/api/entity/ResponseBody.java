package com.api.entity;

import lombok.Data;

import java.util.Date;

/**
 * 返回对象
 * zhuyili
 * 2018/3/26  14:33
 **/
@Data
public class ResponseBody {

    private Status status;

    private Object Data;

    private Date date = new Date();

}
