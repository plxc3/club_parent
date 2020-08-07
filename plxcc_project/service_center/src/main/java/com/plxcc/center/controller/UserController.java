package com.plxcc.center.controller;


import com.plxcc.center.entity.vo.LoginInfoVo;
import com.plxcc.center.entity.vo.LoginVo;
import com.plxcc.center.entity.vo.RegisterVo;
import com.plxcc.center.service.UserService;
import com.plxcc.servicebase.common.Result;
import com.plxcc.servicebase.utils.JwtUtils;
import com.plxcc.servicebase.utils.ZTException;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
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
    @GetMapping("auth/getUserInfo")
    @ApiOperation(tags = "center",value = "通过token进行信息获取的接口")
    public Result getUserInfoByToken(HttpServletRequest request){
        //调用JWT工具类的方法，根据request对象获取头信息，返回用户id
        try {
            String id = JwtUtils.getMemberIdByJwtToken(request);
            LoginInfoVo infoVo=userService.getUserInfo(id);
            return Result.success().setData("loginInfo",infoVo);
        }catch (Exception e){
            e.printStackTrace();
            throw new ZTException(20001,"error");
        }
    }

}

