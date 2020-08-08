package com.plxcc.gateway.controller;


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
@RequestMapping("/gateTest")
public class TestController {
    @GetMapping("/hello")
    public String getTest(){
        return "hello";
    }
}
