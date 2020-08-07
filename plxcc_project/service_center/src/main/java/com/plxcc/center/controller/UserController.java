package com.plxcc.center.controller;


import com.plxcc.center.entity.vo.LoginVo;
import com.plxcc.center.service.UserService;
import com.plxcc.servicebase.common.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author plxcc
 * @since 2020-08-07
 */
@RestController
@RequestMapping("/center/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Login TODO
     */
    @ApiOperation(tags = {"center"},value = "登陆接口")
    @PostMapping("/login")
    public Result Login(@RequestBody LoginVo loginVo){
        return userService.login(loginVo);
    }

}

