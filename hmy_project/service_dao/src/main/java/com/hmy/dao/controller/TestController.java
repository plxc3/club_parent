package com.hmy.dao.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * dao服务接口不对外网暴露
 */
@RestController
public class TestController
{
    @GetMapping("/test")
    @ApiOperation(value = "test")
    public String test()
    {
        return "success";
    }
}
