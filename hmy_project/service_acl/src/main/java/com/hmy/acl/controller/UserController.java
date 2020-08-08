package com.hmy.acl.controller;


import com.hmy.acl.feign.UserFeignService;
import com.hmy.acl.vo.LoginVo;
import com.hmy.acl.vo.RegisterVo;
import com.plxcc.servicebase.common.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author plxcc
 * @since 2020-08-07
 */
@RestController
@RequestMapping("/acl/user")
public class UserController
{

    @Autowired
    private UserFeignService userService;

    /**
     * Login
     */
    @ApiOperation(tags = {"user"},value = "登陆接口")
    @PostMapping("/login")
    public Result Login(@RequestBody LoginVo loginVo){
        return userService.login(loginVo);
    }
    /**
     * Register
     */
    @ApiOperation(tags = "user",value = "注册接口")
    @PostMapping("/register")
    public Result register(@RequestBody RegisterVo registerVo){
        return userService.register(registerVo);
    }

}

