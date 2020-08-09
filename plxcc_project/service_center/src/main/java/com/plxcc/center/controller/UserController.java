package com.plxcc.center.controller;


import com.plxcc.center.entity.vo.LoginInfoVo;
import com.plxcc.center.entity.vo.LoginVo;
import com.plxcc.center.entity.vo.RegisterVo;
import com.plxcc.center.service.UserService;
import com.plxcc.servicebase.common.Result;
import com.plxcc.servicebase.config.PermissionVerify;
import com.plxcc.servicebase.utils.JwtUtils;
import com.plxcc.servicebase.exception.ZTException;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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
     * Login 
     */
    @ApiOperation(tags = {"center"},value = "登陆接口")
    @PostMapping("/login")
    public Result Login(@RequestBody LoginVo loginVo){
        return userService.login(loginVo);
    }
    /**
     * Register
     */
    @ApiOperation(tags = "center",value = "注册接口")
    @PostMapping("/register")
    public Result register(@RequestBody RegisterVo registerVo){
        return userService.register(registerVo);
    }

    /**
     * 根据token获取用户信息
     */
    @PermissionVerify
    @GetMapping("auth/getUserInfo")
    @ApiOperation(tags = "center",value = "通过token进行信息获取的接口")
    public Result getUserInfoByToken(HttpServletRequest request){
        //调用JWT工具类的方法，根据request对象获取头信息，返回用户id
        if(!JwtUtils.checkToken(request)){
            return Result.fail().setMsg("无效的token");
        }
        try {
            String id = JwtUtils.getMemberIdByJwtToken(request);
            LoginInfoVo infoVo=userService.getUserInfo(id);
            System.out.println(id);
            return Result.success().setData("loginInfo",infoVo);
        }catch (Exception e){
            e.printStackTrace();
            throw new ZTException(20001,"error");
        }
    }
    /**
     * 根据手机号查询用户是否存在
     */
    @GetMapping("/exitByPhone/{phone}")
    @ApiOperation(tags = {"feign"},value = "根据手机号查询用户是否存在")
    public Boolean getByPhone(@PathVariable String phone){
        return userService.selectByPhone(phone);
    }
    /**
     * 根据邮箱号查询用户是否存在
     */
    @GetMapping("/exitByEmail/{email}")
    @ApiOperation(tags = {"feign"},value = "根据邮箱号查询用户是否存在")
    public Boolean getByEmail(@PathVariable String email){
        return userService.selectByEmail(email);
    }




}

