package com.hmy.user.controller;

import com.hmy.user.entity.User;
import com.hmy.user.feign.UserFeignService;
import com.plxcc.servicebase.common.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController
{

    @Autowired
    UserFeignService userFeignService;

    @GetMapping("getUserPage")
    @ApiOperation(value = "分页查询用户列表",tags = {"user"})
    public Result userList(@RequestParam Map<String, Object> params)
    {
        return userFeignService.userList(params);
    }

    @GetMapping("/getUserById")
    @ApiOperation(value = "获取一个用户",tags = {"user"})
    public Result getUserById(@RequestParam String id)
    {
        User user = userFeignService.getUserById(id).getData().get("user");
        if (user!=null){
            user.setPassword(null);
            return Result.success().setData("user",user);
        }
        return Result.fail().setMsg("没有此用户");
    }

    @GetMapping("/getUserInfoByToken")
    @ApiOperation(tags = "user",value = "通过token进行信息获取的接口")
    public Result getUserInfoByToken(HttpServletRequest request)
    {
        return userFeignService.getUserInfoByToken();
    }
}
