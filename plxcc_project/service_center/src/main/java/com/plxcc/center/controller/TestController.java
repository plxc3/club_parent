package com.plxcc.center.controller;

import com.plxcc.servicebase.common.Result;
import com.plxcc.servicebase.config.PermissionVerify;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @PackgeName: com.plxcc.center.controller
 * @ClassName: TestController
 * @Author: plxc
 * Date: 2020/8/7 19:43
 * project name: club_parent
 * @Version:
 * @Description:
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @PermissionVerify
    @GetMapping("/hello")
    public Result getTest(){
        return Result.success().setMsg("hello 我是plxcc");
    }
}
