package com.zyl.standardapi.common.handler;

import com.zyl.standardapi.common.entity.RequestCodeEntity;
import com.zyl.standardapi.common.entity.ResponseBody;

/**
 * zhuyili
 * 2018/3/26  15:12
 **/
public class MappingHandler {

    public static ResponseBody handle(RequestCodeEntity code){
        String Acode = code.getACode();
        String Mcode = code.getMCode();
        //stop here

        return null;
    }
}
