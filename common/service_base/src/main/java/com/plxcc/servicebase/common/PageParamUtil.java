package com.plxcc.servicebase.common;

import java.util.HashMap;

public class PageParamUtil
{
    public static HashMap<String,Object> toMap(PageParam param)
    {
        if (param == null){
            param = new PageParam();
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("limit",param.getLimit());
        map.put("page",param.getPage());
        return map;
    }
}
