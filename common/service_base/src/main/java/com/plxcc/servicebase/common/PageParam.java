package com.plxcc.servicebase.common;

import lombok.Data;

@Data
public class PageParam
{
    //每页限制
    private Integer limit = 10;

    //第几页
    private Integer page = 1;

}
